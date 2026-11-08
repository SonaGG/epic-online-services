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
package gg.sona.eos.internal.foreign

/**
 * `java.lang.foreign.ValueLayout`-compatible scalar layout.
 *
 * Real FFM distinguishes carrier types via distinct nominal subtypes
 * (`OfByte`, `OfInt`, `AddressLayout`, ...) rather than a single generic
 * class, specifically so [MemorySegment.get]/[MemorySegment.set] can be
 * *overloaded* per carrier and have their return/parameter type inferred
 * at the call site without an explicit type argument - generated struct
 * writer code relies on exactly that (`seg.get(ValueLayout.JAVA_LONG, 0)`
 * with no `<Long>`), so this shim reproduces the same subtype hierarchy
 * rather than a simpler single-class-plus-generic design.
 *
 * This binding only ever targets 64-bit platforms (matches the doc comment
 * historically on `Native.kt`: "The C ABI is little-endian and 64-bit"), so
 * [ADDRESS] is hardcoded to 8 bytes.
 */
sealed class ValueLayout(val carrier: Class<*>, private val size: Long) : MemoryLayout() {
    override fun byteSize(): Long = size
    override fun byteAlignment(): Long = size

    /** Method form, matching the real API's `carrier()` accessor shape. */
    fun carrier(): Class<*> = carrier

    class OfByte internal constructor() : ValueLayout(java.lang.Byte.TYPE, 1)
    class OfShort internal constructor() : ValueLayout(java.lang.Short.TYPE, 2)
    class OfChar internal constructor() : ValueLayout(Character.TYPE, 2)
    class OfInt internal constructor() : ValueLayout(Integer.TYPE, 4)
    class OfLong internal constructor() : ValueLayout(java.lang.Long.TYPE, 8)
    class OfFloat internal constructor() : ValueLayout(java.lang.Float.TYPE, 4)
    class OfDouble internal constructor() : ValueLayout(java.lang.Double.TYPE, 8)
    class OfBoolean internal constructor() : ValueLayout(java.lang.Boolean.TYPE, 4)

    class AddressLayout internal constructor() : ValueLayout(MemorySegment::class.java, 8) {
        /**
         * Real FFM's `.unsized()` produces an unbounded-size variant of an
         * `ADDRESS` layout. This shim's [ValueLayout] carries no
         * per-instance FFM safety metadata, so this is an identity no-op;
         * the actual "unbounded" behavior lives on the [MemorySegment]
         * returned from a `get(ADDRESS, ...)` read (see
         * [MemorySegment.reinterpret]).
         */
        fun unsized(): AddressLayout = this
    }

    companion object {
        val JAVA_BYTE = OfByte()
        val JAVA_SHORT = OfShort()
        val JAVA_CHAR = OfChar()
        val JAVA_INT = OfInt()
        val JAVA_LONG = OfLong()
        val JAVA_FLOAT = OfFloat()
        val JAVA_DOUBLE = OfDouble()
        val JAVA_BOOLEAN = OfBoolean()
        val ADDRESS = AddressLayout()
    }
}
