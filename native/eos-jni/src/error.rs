//! Helpers to convert Rust-side failures (panics, symbol resolution
//! failures) into a thrown Java exception rather than letting them abort the
//! process or return silently-wrong values.

use jni::JNIEnv;

/// Throws `java.lang.UnsatisfiedLinkError` with `message`, swallowing any
/// secondary failure from the throw itself (there is nothing more useful
/// to do if even throwing fails).
pub fn throw_unsatisfied_link_error(env: &mut JNIEnv, message: &str) {
    let _ = env.throw_new("java/lang/UnsatisfiedLinkError", message);
}

/// Throws `java.lang.RuntimeException` with `message` - used for panics
/// caught at the JNI boundary (see `panic::catch_unwind_to_string`) and
/// other unexpected native-side failures.
pub fn throw_runtime_exception(env: &mut JNIEnv, message: &str) {
    let _ = env.throw_new("java/lang/RuntimeException", message);
}

/// Throws `java.lang.IllegalArgumentException` with `message`.
pub fn throw_illegal_argument(env: &mut JNIEnv, message: &str) {
    let _ = env.throw_new("java/lang/IllegalArgumentException", message);
}
