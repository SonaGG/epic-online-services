/*
 * Copyright 2026 Sona Softworks LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gg.sona.eos.internal.foreign.jni

import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

/**
 * Wire-format type codes shared with the `eos-jni` Rust crate's
 * `types::TypeCode` enum - do not renumber without updating both sides.
 */
internal object NativeTypeCode {
    const val BOOL: Byte = 0
    const val BYTE: Byte = 1
    const val SHORT: Byte = 2
    const val INT: Byte = 3
    const val LONG: Byte = 4
    const val FLOAT: Byte = 5
    const val DOUBLE: Byte = 6
    const val POINTER: Byte = 7
    const val VOID: Byte = 8

    /** EOS's `EOS_Bool` is `int32_t`-carried, matching [gg.sona.eos.internal.setBool]/`getBool`. */
    fun of(layout: ValueLayout): Byte = when (layout.carrier) {
        java.lang.Byte.TYPE -> BYTE
        java.lang.Short.TYPE -> SHORT
        Integer.TYPE -> INT
        java.lang.Long.TYPE -> LONG
        java.lang.Float.TYPE -> FLOAT
        java.lang.Double.TYPE -> DOUBLE
        java.lang.Boolean.TYPE -> BOOL
        MemorySegment::class.java -> POINTER
        else -> POINTER
    }
}
