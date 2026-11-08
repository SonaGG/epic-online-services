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

//! Verifies that a panic inside `catch_unwind_to_string` is contained and
//! turned into an `Err`, rather than aborting the process - this is the
//! safety net every `Java_...` entry point and (in a later stage) every
//! closure callback body relies on.

#[path = "../src/panic.rs"]
mod panic_mod;

use panic_mod::catch_unwind_to_string;

#[test]
fn contains_a_str_panic() {
    let result = catch_unwind_to_string(|| -> i32 {
        panic!("boom");
    });
    assert_eq!(result, Err("boom".to_string()));
}

#[test]
fn contains_a_string_panic() {
    let message = format!("failure code {}", 42);
    let result = catch_unwind_to_string(move || -> i32 {
        panic!("{}", message);
    });
    assert_eq!(result, Err("failure code 42".to_string()));
}

#[test]
fn returns_ok_when_no_panic_occurs() {
    let result = catch_unwind_to_string(|| 7 + 35);
    assert_eq!(result, Ok(42));
}

#[test]
fn process_survives_a_panic_inside_the_guard() {
    // The real assertion here is that this test process does not abort -
    // if catch_unwind_to_string let the panic propagate, the whole test
    // binary would crash instead of reporting a normal failure/pass.
    for _ in 0..1000 {
        let _ = catch_unwind_to_string(|| -> i32 { panic!("repeated panic") });
    }
}
