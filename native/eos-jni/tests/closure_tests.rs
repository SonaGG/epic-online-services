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

//! Verifies closure creation/destruction and panic-containment in the
//! trampoline in isolation from a real JVM (no `JavaVM` is attached in a
//! plain `cargo test` process, so `dispatch` takes its "no cached JavaVM"
//! early-return path here - that's expected and exercises the same
//! defensive code path a misuse bug would hit). The "does this actually
//! reach Kotlin and invoke the registered callback" path is verified
//! separately by the Kotlin-side `CallbackStubsTest`, which runs inside a
//! real JVM with this shim loaded.

#[path = "../src/jvm.rs"]
mod jvm;
#[path = "../src/panic.rs"]
mod panic;
#[path = "../src/closure.rs"]
mod closure;

use std::os::raw::c_void;

type Trampoline = unsafe extern "C" fn(*const c_void);

#[test]
fn create_returns_a_nonzero_code_pointer() {
    let ptr = closure::create(1);
    assert_ne!(ptr, 0);
    closure::destroy(1);
}

#[test]
fn distinct_closure_ids_get_distinct_code_pointers() {
    let a = closure::create(100);
    let b = closure::create(101);
    assert_ne!(a, b);
    closure::destroy(100);
    closure::destroy(101);
}

#[test]
fn invoking_the_raw_trampoline_without_a_cached_jvm_does_not_crash() {
    // No JavaVM has been registered in this test process (JNI_OnLoad never
    // ran), so this exercises `dispatch`'s "no cached JavaVM" early-return
    // - the real assertion is that the process survives and returns
    // normally rather than crashing or hanging.
    let ptr = closure::create(42);
    let f: Trampoline = unsafe { std::mem::transmute(ptr) };
    let dummy_callback_info = 0xdead_beef_u64 as *const c_void;
    unsafe { f(dummy_callback_info) };
    closure::destroy(42);
}

#[test]
fn destroy_is_idempotent_for_unknown_ids() {
    // Destroying an id that was never created (or already destroyed) must
    // not panic - `register`/`release` call sites on the Kotlin side rely
    // on this for defense-in-depth against double-release bugs.
    closure::destroy(999999);
    closure::destroy(999999);
}
