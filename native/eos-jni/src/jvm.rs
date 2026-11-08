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
