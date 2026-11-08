// Copyright 2026 Sona Interactive, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//! `eos-jni`: a small, generic JNI/libffi bridge used by "EOS for Kotlin" to
//! call into the EOS SDK's native library on Java 8+ (replacing the JDK 22+
//! Foreign Function & Memory API this project used previously).
//!
//! This crate contains no EOS code and no Epic IP - it is a general-purpose
//! "load a library, resolve a symbol, call it dynamically, and (in a later
//! stage) create a callback trampoline" bridge, mirroring what
//! `java.lang.foreign.Linker` does. The actual EOS SDK binary is always
//! resolved dynamically at runtime by the Kotlin side and is never bundled
//! by this crate or by "EOS for Kotlin" itself.

mod call;
mod closure;
mod error;
mod jvm;
mod library;
mod panic;
mod types;

use std::os::raw::c_void;

use jni::objects::{JByteArray, JClass, JLongArray, JString};
use jni::sys::{jint, jlong, JNI_VERSION_1_6};
use jni::sys::jbyte;
use jni::JNIEnv;

use panic::catch_unwind_to_string;
use types::TypeCode;

/// Caches the `JavaVM*` so [`closure`] trampolines (invoked later, from
/// arbitrary EOS-owned native threads) can attach to the JVM.
#[no_mangle]
pub extern "system" fn JNI_OnLoad(vm: jni::JavaVM, _reserved: *mut c_void) -> jint {
    jvm::set(vm);
    JNI_VERSION_1_6
}

/// Opens a native library by name (searched via the OS's standard library
/// search path, matching `System.loadLibrary` semantics) or absolute path,
/// and returns an opaque handle (0 on failure, with a Java exception
/// thrown). Mirrors `dlopen`/`LoadLibraryW`.
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nOpenLibrary<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    name: JString<'local>,
) -> jlong {
    let result = catch_unwind_to_string(|| {
        let name: String = env.get_string(&name).map_err(|e| e.to_string())?.into();
        library::open(&name).map_err(|e| e.0)
    });

    match result {
        Ok(Ok(handle)) => handle as jlong,
        Ok(Err(message)) => {
            error::throw_unsatisfied_link_error(&mut env, &message);
            0
        }
        Err(panic_message) => {
            error::throw_runtime_exception(&mut env, &panic_message);
            0
        }
    }
}

/// Closes a library handle previously returned by `nOpenLibrary`.
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nCloseLibrary<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    handle: jlong,
) {
    if let Err(panic_message) = catch_unwind_to_string(|| library::close(handle as usize)) {
        error::throw_runtime_exception(&mut env, &panic_message);
    }
}

/// Resolves a symbol by name against a library handle from `nOpenLibrary`.
/// Returns the function's address (0 on failure, with a Java exception
/// thrown). Mirrors `SymbolLookup.find`.
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nFindSymbol<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    handle: jlong,
    name: JString<'local>,
) -> jlong {
    let result = catch_unwind_to_string(|| {
        let name: String = env.get_string(&name).map_err(|e| e.to_string())?.into();
        library::find_symbol(handle as usize, &name).map_err(|e| e.0)
    });

    match result {
        Ok(Ok(addr)) => addr as jlong,
        Ok(Err(message)) => {
            error::throw_unsatisfied_link_error(&mut env, &message);
            0
        }
        Err(panic_message) => {
            error::throw_runtime_exception(&mut env, &panic_message);
            0
        }
    }
}

/// Generic dynamic downcall - the JNI/libffi equivalent of
/// `Linker.downcallHandle(...).invokeWithArguments(...)`.
///
/// `argTypeCodes`/`retTypeCode` describe the C signature (see
/// [`types::TypeCode`]); `argBits` holds one raw 8-byte value per argument
/// (see `call.rs` for the packing convention). Returns the raw 8-byte
/// result bit pattern (0 for `Void`).
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nCall<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    fn_ptr: jlong,
    arg_type_codes: JByteArray<'local>,
    ret_type_code: jbyte,
    arg_bits: JLongArray<'local>,
) -> jlong {
    let result = catch_unwind_to_string(|| -> Result<i64, String> {
        let type_len = env.get_array_length(&arg_type_codes).map_err(|e| e.to_string())? as usize;
        let mut raw_codes = vec![0i8; type_len];
        env.get_byte_array_region(&arg_type_codes, 0, &mut raw_codes)
            .map_err(|e| e.to_string())?;

        let bits_len = env.get_array_length(&arg_bits).map_err(|e| e.to_string())? as usize;
        if bits_len != type_len {
            return Err(format!(
                "argTypeCodes.length ({type_len}) != argBits.length ({bits_len})"
            ));
        }
        let mut bits = vec![0i64; bits_len];
        env.get_long_array_region(&arg_bits, 0, &mut bits).map_err(|e| e.to_string())?;

        let arg_codes: Vec<TypeCode> = raw_codes
            .iter()
            .map(|&b| TypeCode::from_byte(b as u8).ok_or_else(|| format!("unknown argument type code {b}")))
            .collect::<Result<_, _>>()?;
        let ret_code = TypeCode::from_byte(ret_type_code as u8)
            .ok_or_else(|| format!("unknown return type code {ret_type_code}"))?;

        if fn_ptr == 0 {
            return Err("nCall: fnPtr is null".to_string());
        }

        Ok(unsafe { call::ffi_call(fn_ptr as usize, &arg_codes, ret_code, &bits) })
    });

    match result {
        Ok(Ok(value)) => value,
        Ok(Err(message)) => {
            error::throw_illegal_argument(&mut env, &message);
            0
        }
        Err(panic_message) => {
            error::throw_runtime_exception(&mut env, &panic_message);
            0
        }
    }
}

/// Creates a native `void(*)(void*)` callback trampoline for `closureId`
/// (see `closure.rs`) and returns its callable C function pointer. Mirrors
/// `Linker.upcallStub`.
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nCreateClosure<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    closure_id: jlong,
) -> jlong {
    match catch_unwind_to_string(|| closure::create(closure_id)) {
        Ok(ptr) => ptr as jlong,
        Err(panic_message) => {
            error::throw_runtime_exception(&mut env, &panic_message);
            0
        }
    }
}

/// Frees a closure previously created by `nCreateClosure`. Must not be
/// called while EOS might still invoke the closure's function pointer.
#[no_mangle]
pub extern "system" fn Java_gg_sona_eos_internal_foreign_jni_NativeBridge_nDestroyClosure<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    closure_id: jlong,
) {
    if let Err(panic_message) = catch_unwind_to_string(|| closure::destroy(closure_id)) {
        error::throw_runtime_exception(&mut env, &panic_message);
    }
}
