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

//! Verifies the generic downcall path (`call::ffi_call`) against synthetic
//! `extern "C"` fixture functions defined right here in the test binary -
//! no separate C compiler/fixture library needed, since a Rust function
//! pointer is just as valid a "native function" for libffi to call as one
//! resolved via `dlsym`/`GetProcAddress`. `library::open`/`find_symbol`
//! (the actual OS-loader wiring) is exercised separately against
//! already-loaded process symbols (e.g. `libc`) where the platform makes
//! that straightforward.

// The crate is built as a cdylib only; pull the modules in directly for
// `cargo test` (integration tests compile against the crate as a library,
// which requires `crate-type` to include "lib" - simplest to just re-declare
// the modules under test via `#[path]` instead of changing the crate type).
#[path = "../src/types.rs"]
mod types;
#[path = "../src/call.rs"]
mod call;

use types::TypeCode;

extern "C" fn add_i32(a: i32, b: i32) -> i32 {
    a + b
}

extern "C" fn negate_i64(a: i64) -> i64 {
    -a
}

extern "C" fn add_f32(a: f32, b: f32) -> f32 {
    a + b
}

extern "C" fn add_f64(a: f64, b: f64) -> f64 {
    a + b
}

extern "C" fn identity_bool(a: i32) -> i32 {
    a
}

extern "C" fn byte_plus_one(a: i8) -> i8 {
    a + 1
}

extern "C" fn short_double(a: i16) -> i16 {
    a * 2
}

extern "C" fn identity_pointer(p: i64) -> i64 {
    p
}

static mut VOID_CALL_COUNT: i32 = 0;

extern "C" fn bump_counter() {
    unsafe {
        VOID_CALL_COUNT += 1;
    }
}

#[test]
fn calls_i32_function() {
    let result = unsafe {
        call::ffi_call(
            add_i32 as *const () as usize,
            &[TypeCode::Int, TypeCode::Int],
            TypeCode::Int,
            &[7, 35],
        )
    };
    assert_eq!(result, 42);
}

#[test]
fn calls_i64_function() {
    let result = unsafe { call::ffi_call(negate_i64 as *const () as usize, &[TypeCode::Long], TypeCode::Long, &[100]) };
    assert_eq!(result, -100);
}

#[test]
fn calls_f32_function_via_bit_pattern() {
    let a = 1.5f32.to_bits() as i64;
    let b = 2.25f32.to_bits() as i64;
    let raw = unsafe { call::ffi_call(add_f32 as *const () as usize, &[TypeCode::Float, TypeCode::Float], TypeCode::Float, &[a, b]) };
    let result = f32::from_bits(raw as u32);
    assert_eq!(result, 3.75f32);
}

#[test]
fn calls_f64_function_via_bit_pattern() {
    let a = 10.5f64.to_bits() as i64;
    let b = 0.25f64.to_bits() as i64;
    let raw = unsafe {
        call::ffi_call(add_f64 as *const () as usize, &[TypeCode::Double, TypeCode::Double], TypeCode::Double, &[a, b])
    };
    let result = f64::from_bits(raw as u64);
    assert_eq!(result, 10.75f64);
}

#[test]
fn calls_bool_function() {
    let result = unsafe { call::ffi_call(identity_bool as *const () as usize, &[TypeCode::Bool], TypeCode::Bool, &[1]) };
    assert_eq!(result, 1);
}

#[test]
fn calls_byte_function() {
    let result = unsafe { call::ffi_call(byte_plus_one as *const () as usize, &[TypeCode::Byte], TypeCode::Byte, &[41]) };
    assert_eq!(result, 42);
}

#[test]
fn calls_short_function() {
    let result = unsafe { call::ffi_call(short_double as *const () as usize, &[TypeCode::Short], TypeCode::Short, &[21]) };
    assert_eq!(result, 42);
}

#[test]
fn calls_pointer_function() {
    let addr = 0xDEAD_BEEF_i64;
    let result =
        unsafe { call::ffi_call(identity_pointer as *const () as usize, &[TypeCode::Pointer], TypeCode::Pointer, &[addr]) };
    assert_eq!(result, addr);
}

#[test]
fn calls_void_function() {
    let before = unsafe { std::ptr::read_volatile(&raw const VOID_CALL_COUNT) };
    let result = unsafe { call::ffi_call(bump_counter as *const () as usize, &[], TypeCode::Void, &[]) };
    assert_eq!(result, 0);
    let after = unsafe { std::ptr::read_volatile(&raw const VOID_CALL_COUNT) };
    assert_eq!(after, before + 1);
}

#[test]
fn type_code_round_trips_through_byte() {
    for code in [
        TypeCode::Bool,
        TypeCode::Byte,
        TypeCode::Short,
        TypeCode::Int,
        TypeCode::Long,
        TypeCode::Float,
        TypeCode::Double,
        TypeCode::Pointer,
        TypeCode::Void,
    ] {
        let byte = code as u8;
        assert_eq!(TypeCode::from_byte(byte).map(|c| c as u8), Some(byte));
    }
    assert!(TypeCode::from_byte(255).is_none());
}
