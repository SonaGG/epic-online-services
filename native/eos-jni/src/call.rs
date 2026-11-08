//! Generic dynamic downcall, the JNI-side equivalent of
//! `Linker.downcallHandle` + `MethodHandle.invokeWithArguments`.
//!
//! Every argument (and the return value) crosses the JNI boundary as a raw
//! 8-byte bit pattern packed into a `long`: integers are sign/zero-extended,
//! floats/doubles are their IEEE-754 bit pattern in the low bytes, and
//! pointers are the raw address. This binding only targets 64-bit
//! little-endian platforms (matches the historical doc comment on the
//! Kotlin `Native.kt`), so reading the correctly-sized prefix of an 8-byte
//! little-endian buffer always yields the true narrower value - no
//! per-argument repacking is needed on the Rust side, the raw bytes are
//! already in the right place.

use std::ffi::c_void;

use libffi::middle::{Arg, Cif, CodePtr};

use crate::types::TypeCode;

/// Calls the native function at `fn_ptr` with `arg_bits` (one raw 8-byte
/// value per argument, in `arg_codes` order) and returns the raw 8-byte
/// bit pattern of the result (0 for a `Void`-returning call).
///
/// # Safety
/// `fn_ptr` must be a valid, currently-loaded native function pointer whose
/// real signature matches `arg_codes`/`ret_code`. This is exactly as
/// unchecked as `Linker.downcallHandle` was - the caller (ultimately, the
/// Kotlin `FunctionDescriptor` used to build the call) is responsible for
/// getting the signature right.
pub unsafe fn ffi_call(fn_ptr: usize, arg_codes: &[TypeCode], ret_code: TypeCode, arg_bits: &[i64]) -> i64 {
    assert_eq!(arg_codes.len(), arg_bits.len(), "arg_codes/arg_bits length mismatch");

    let arg_types: Vec<_> = arg_codes.iter().map(|c| c.ffi_type()).collect();
    let cif = Cif::new(arg_types, ret_code.ffi_type());
    let args: Vec<Arg> = arg_bits.iter().map(Arg::new).collect();
    let code_ptr = CodePtr::from_ptr(fn_ptr as *const c_void);

    unsafe {
        match ret_code {
            TypeCode::Void => {
                cif.call::<()>(code_ptr, &args);
                0
            }
            TypeCode::Bool | TypeCode::Int => cif.call::<i32>(code_ptr, &args) as i64,
            TypeCode::Byte => cif.call::<i8>(code_ptr, &args) as i64,
            TypeCode::Short => cif.call::<i16>(code_ptr, &args) as i64,
            TypeCode::Long | TypeCode::Pointer => cif.call::<i64>(code_ptr, &args),
            TypeCode::Float => cif.call::<f32>(code_ptr, &args).to_bits() as i64,
            TypeCode::Double => cif.call::<f64>(code_ptr, &args).to_bits() as i64,
        }
    }
}
