//! Caches the `JavaVM*` handed to us in `JNI_OnLoad`, so closure trampolines
//! (invoked later, from arbitrary EOS-owned native threads) can attach to
//! the JVM and call back into Kotlin.

use jni::JavaVM;
use once_cell::sync::OnceCell;

static JVM: OnceCell<JavaVM> = OnceCell::new();

pub fn set(vm: JavaVM) {
    // JNI_OnLoad only ever runs once per loaded library; ignore a second set.
    let _ = JVM.set(vm);
}

pub fn get() -> Option<&'static JavaVM> {
    JVM.get()
}
