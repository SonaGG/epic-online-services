//! Upcall/callback trampolines - the JNI/libffi equivalent of
//! `Linker.upcallStub`.
//!
//! Every callback this binding ever registers has the same C shape: `void
//! (*)(void* callbackInfo)` (EOS's uniform "one pointer to a
//! `..._CallbackInfo` struct, no return value" convention, matching
//! `EosCallback`'s single `FunctionDescriptor` in the Kotlin codebase - see
//! `EosCallback.kt`). Rather than building a fully generic
//! any-signature-closure mechanism that nothing in this codebase would ever
//! exercise, this module deliberately narrows to that one shape.
//!
//! EOS invokes these callbacks from arbitrary native threads (its own tick
//! thread, IO threads, etc.), so every invocation attaches the calling
//! thread to the JVM before calling back into Kotlin. Attaching an
//! already-attached thread is cheap (the JVM just returns the existing
//! `JNIEnv`), so no manual thread-local caching is done here; if this turns
//! out to be a measurable cost under high-frequency callbacks (e.g. RTC
//! audio), that's a follow-up performance investigation, not a correctness
//! concern.

use std::collections::HashMap;
use std::os::raw::c_void;

use jni::objects::JValue;
use libffi::low::ffi_cif;
use libffi::middle::{Cif, Closure, Type};
use once_cell::sync::Lazy;
use parking_lot::Mutex;

use crate::jvm;
use crate::panic::catch_unwind_to_string;

struct ClosureEntry {
    // Kept alive only to keep the executable trampoline page (and the cif
    // it was built from) alive for as long as EOS might call it - dropped
    // (and the trampoline memory freed) by `destroy`.
    _closure: Closure<'static>,
}

// `Closure` holds raw pointers (the executable trampoline page, the cif's
// type-table pointers) that libffi never mutates concurrently in a way that
// would make cross-thread access unsafe here: entries are only read (to
// keep them alive) or removed (dropped) while holding `CLOSURES`'s lock,
// and the closure's *code pointer* itself is immutable C-executable memory
// safely callable from any thread by design (that's the whole point of a
// libffi closure).
unsafe impl Send for ClosureEntry {}
unsafe impl Sync for ClosureEntry {}

static CLOSURES: Lazy<Mutex<HashMap<i64, ClosureEntry>>> = Lazy::new(|| Mutex::new(HashMap::new()));

/// Trampoline invoked by libffi when EOS calls the closure's C function
/// pointer. Must never let a panic or a Java exception cross back into
/// EOS/libffi's C frame - both are contained here.
unsafe extern "C" fn trampoline(_cif: &ffi_cif, _result: &mut (), args: *const *const c_void, userdata: &i64) {
    let closure_id = *userdata;
    let arg_slot = unsafe { *args };
    let callback_info_ptr = unsafe { *(arg_slot as *const *const c_void) } as i64;

    if let Err(message) = catch_unwind_to_string(|| dispatch(closure_id, callback_info_ptr)) {
        eprintln!("[eos-jni] panic in native callback trampoline (closure {closure_id}): {message}");
    }
}

fn dispatch(closure_id: i64, callback_info_ptr: i64) {
    let vm = match jvm::get() {
        Some(vm) => vm,
        None => {
            eprintln!("[eos-jni] callback fired before JNI_OnLoad populated the cached JavaVM");
            return;
        }
    };

    let mut env = match vm.attach_current_thread_as_daemon() {
        Ok(env) => env,
        Err(e) => {
            eprintln!("[eos-jni] failed to attach the calling thread to the JVM: {e}");
            return;
        }
    };

    let class = match env.find_class("gg/sona/eos/internal/foreign/jni/NativeBridge") {
        Ok(c) => c,
        Err(e) => {
            eprintln!("[eos-jni] failed to find NativeBridge: {e}");
            return;
        }
    };

    let result = env.call_static_method(
        class,
        "dispatchCallback",
        "(JJ)V",
        &[JValue::Long(closure_id), JValue::Long(callback_info_ptr)],
    );

    if result.is_err() || env.exception_check().unwrap_or(false) {
        let _ = env.exception_describe();
        let _ = env.exception_clear();
    }
}

/// Creates a new `void(*)(void*)` closure for `closure_id` and returns its
/// callable C function pointer (as an address). The closure stays alive
/// (and callable) until [`destroy`] is called with the same id.
pub fn create(closure_id: i64) -> usize {
    let cif = Cif::new([Type::pointer()], Type::void());
    let userdata: &'static i64 = Box::leak(Box::new(closure_id));
    let closure = Closure::new(cif, trampoline, userdata);
    let code_ptr = *closure.code_ptr() as usize;

    CLOSURES.lock().insert(closure_id, ClosureEntry { _closure: closure });
    code_ptr
}

/// Frees the closure's executable trampoline memory. The `i64` userdata
/// leaked in [`create`] is intentionally not reclaimed - closure ids are
/// never reused within a process lifetime by this codebase's usage
/// pattern, so this is a bounded, documented small leak (8 bytes per
/// distinct callback ever registered), not an unbounded one.
pub fn destroy(closure_id: i64) {
    CLOSURES.lock().remove(&closure_id);
}
