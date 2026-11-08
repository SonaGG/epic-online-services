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
