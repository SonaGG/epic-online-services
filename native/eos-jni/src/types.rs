//! The wire-format type-code enum shared with the Kotlin side
//! (`gg.sona.eos.internal.foreign.jni.NativeTypeCode`). Mirrors the small
//! set of C ABI scalar/pointer kinds the EOS SDK ever uses - no struct
//! types, since every EOS function passes scalars, opaque handles (also
//! scalars), or pointers, never a struct by value.

use libffi::middle::Type;

#[repr(u8)]
#[derive(Copy, Clone, Debug, PartialEq, Eq)]
pub enum TypeCode {
    Bool = 0,
    Byte = 1,
    Short = 2,
    Int = 3,
    Long = 4,
    Float = 5,
    Double = 6,
    Pointer = 7,
    Void = 8,
}

impl TypeCode {
    pub fn from_byte(b: u8) -> Option<TypeCode> {
        match b {
            0 => Some(TypeCode::Bool),
            1 => Some(TypeCode::Byte),
            2 => Some(TypeCode::Short),
            3 => Some(TypeCode::Int),
            4 => Some(TypeCode::Long),
            5 => Some(TypeCode::Float),
            6 => Some(TypeCode::Double),
            7 => Some(TypeCode::Pointer),
            8 => Some(TypeCode::Void),
            _ => None,
        }
    }

    /// The libffi type used to build the [`libffi::middle::Cif`]. EOS's
    /// `EOS_Bool` is `int32_t`-carried (already how the Kotlin-side
    /// `StructWriter.setBool`/`getBool` treats it), so `Bool` maps to a
    /// 4-byte `i32`, matching that convention.
    pub fn ffi_type(self) -> Type {
        match self {
            TypeCode::Bool => Type::i32(),
            TypeCode::Byte => Type::i8(),
            TypeCode::Short => Type::i16(),
            TypeCode::Int => Type::i32(),
            TypeCode::Long => Type::i64(),
            TypeCode::Float => Type::f32(),
            TypeCode::Double => Type::f64(),
            TypeCode::Pointer => Type::pointer(),
            TypeCode::Void => Type::void(),
        }
    }
}
