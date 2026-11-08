//! Panic containment: a Rust panic must never unwind across an `extern "C"`
//! frame owned by the JVM's JNI trampoline, EOS, or libffi - that is
//! undefined behavior. Every `Java_...` entry point and every closure
//! callback body (added in a later stage) is wrapped with
//! [`catch_unwind_to_string`].

use std::panic::{catch_unwind, AssertUnwindSafe};

/// Runs `f`, catching any panic and turning it into an `Err(message)`
/// instead of letting it unwind further.
pub fn catch_unwind_to_string<R>(f: impl FnOnce() -> R) -> Result<R, String> {
    catch_unwind(AssertUnwindSafe(f)).map_err(|payload| {
        if let Some(s) = payload.downcast_ref::<&str>() {
            (*s).to_string()
        } else if let Some(s) = payload.downcast_ref::<String>() {
            s.clone()
        } else {
            "unknown panic payload".to_string()
        }
    })
}
