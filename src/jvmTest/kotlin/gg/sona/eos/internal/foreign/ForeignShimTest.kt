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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Standalone verification of the Unsafe-backed `internal.foreign` shim, in
 * isolation from the rest of the codebase (which still depends on real
 * `java.lang.foreign` until [gg.sona.eos.internal.Native] and
 * `CallbackStubs` are converted in later stages of the JNI migration).
 */
class ForeignShimTest {

    @Test
    fun `arena allocates zeroed memory and frees on close`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocate(16)
            for (i in 0 until 16) assertEquals(0, seg.get(ValueLayout.JAVA_BYTE, i.toLong()))
        }
    }

    @Test
    fun `primitive get set round trip`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocate(64)
            seg.set(ValueLayout.JAVA_INT, 0, 0x12345678)
            seg.set(ValueLayout.JAVA_LONG, 8, 0x7FFF_FFFF_FFFF_FFL)
            seg.set(ValueLayout.JAVA_FLOAT, 16, 1.5f)
            seg.set(ValueLayout.JAVA_DOUBLE, 24, 2.5)
            seg.set(ValueLayout.JAVA_SHORT, 32, 42.toShort())
            seg.set(ValueLayout.JAVA_BYTE, 34, 7.toByte())

            assertEquals(0x12345678, seg.get(ValueLayout.JAVA_INT, 0))
            assertEquals(0x7FFF_FFFF_FFFF_FFL, seg.get(ValueLayout.JAVA_LONG, 8))
            assertEquals(1.5f, seg.get(ValueLayout.JAVA_FLOAT, 16))
            assertEquals(2.5, seg.get(ValueLayout.JAVA_DOUBLE, 24))
            assertEquals(42.toShort(), seg.get(ValueLayout.JAVA_SHORT, 32))
            assertEquals(7.toByte(), seg.get(ValueLayout.JAVA_BYTE, 34))
        }
    }

    @Test
    fun `address round trip through ADDRESS layout`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocate(8)
            val ptr = MemorySegment.ofAddress(0xDEADBEEFL)
            seg.set(ValueLayout.ADDRESS, 0, ptr)
            val readBack = seg.get(ValueLayout.ADDRESS, 0)
            assertEquals(0xDEADBEEFL, readBack.address())
        }
    }

    @Test
    fun `getAtIndex and setAtIndex use element stride`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocate(ValueLayout.JAVA_LONG, 4)
            for (i in 0 until 4) seg.setAtIndex(ValueLayout.JAVA_LONG, i.toLong(), (i * 100).toLong())
            for (i in 0 until 4) assertEquals((i * 100).toLong(), seg.getAtIndex(ValueLayout.JAVA_LONG, i.toLong()))
        }
    }

    @Test
    fun `allocateFrom writes null-terminated UTF-8`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocateFrom("hello world")
            assertEquals("hello world", seg.getString(0))
            assertEquals(0.toByte(), seg.get(ValueLayout.JAVA_BYTE, 11))
        }
    }

    @Test
    fun `NULL segment has zero address`() {
        assertEquals(0L, MemorySegment.NULL.address())
    }

    @Test
    fun `reinterpret changes declared size without moving the address`() {
        val ptr = MemorySegment.ofAddress(0x1000L)
        assertEquals(0L, ptr.byteSize())
        val wide = ptr.reinterpret(Long.MAX_VALUE)
        assertEquals(0x1000L, wide.address())
        assertEquals(Long.MAX_VALUE, wide.byteSize())
    }

    @Test
    fun `asSlice offsets the address and sets a new size`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocate(32)
            seg.set(ValueLayout.JAVA_INT, 8, 99)
            val slice = seg.asSlice(8, 8)
            assertEquals(seg.address() + 8, slice.address())
            assertEquals(8L, slice.byteSize())
            assertEquals(99, slice.get(ValueLayout.JAVA_INT, 0))
        }
    }

    @Test
    fun `copyFrom copies bytes between native segments`() {
        Arena.ofConfined().use { arena ->
            val src = arena.allocate(8)
            src.set(ValueLayout.JAVA_LONG, 0, 0x1122334455667788L)
            val dst = arena.allocate(8)
            dst.copyFrom(src)
            assertEquals(0x1122334455667788L, dst.get(ValueLayout.JAVA_LONG, 0))
        }
    }

    @Test
    fun `copyFrom copies from a heap array into a native segment`() {
        Arena.ofConfined().use { arena ->
            val bytes = byteArrayOf(1, 2, 3, 4)
            val seg = arena.allocate(4)
            seg.copyFrom(MemorySegment.ofArray(bytes))
            for (i in bytes.indices) assertEquals(bytes[i], seg.get(ValueLayout.JAVA_BYTE, i.toLong()))
        }
    }

    @Test
    fun `MemorySegment copy static overload copies between segments at offsets`() {
        Arena.ofConfined().use { arena ->
            val src = arena.allocate(16)
            src.set(ValueLayout.JAVA_INT, 4, 777)
            val dst = arena.allocate(16)
            MemorySegment.copy(src, 4, dst, 0, 4)
            assertEquals(777, dst.get(ValueLayout.JAVA_INT, 0))
        }
    }

    @Test
    fun `MemorySegment copy byte-element overload reads into a ByteArray`() {
        Arena.ofConfined().use { arena ->
            val seg = arena.allocateFrom("abc")
            val out = ByteArray(3)
            MemorySegment.copy(seg, ValueLayout.JAVA_BYTE, 0, out, 0, 3)
            assertEquals("abc", String(out))
        }
    }

    @Test
    fun `structLayout sums member sizes including explicit padding`() {
        val layout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG, ValueLayout.ADDRESS,
        )
        assertEquals(24L, layout.byteSize())
    }

    @Test
    fun `sequenceLayout multiplies element size by count`() {
        val layout = MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_LONG)
        assertEquals(40L, layout.byteSize())
    }

    @Test
    fun `FunctionDescriptor has value equality for cache keys`() {
        val a = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
        val b = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
        val c = FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        assertEquals(a, b)
        assertEquals(a.hashCode(), b.hashCode())
        assertFalse(a == c)
        assertFalse(c.returnLayout().isPresent)
        assertEquals(ValueLayout.JAVA_INT, a.returnLayout().get())
        assertEquals(listOf(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS), a.argumentLayouts())
    }

    @Test
    fun `arena handles multiple allocations independently`() {
        Arena.ofConfined().use { arena ->
            val first = arena.allocate(16)
            first.set(ValueLayout.JAVA_INT, 0, 1)
            val second = arena.allocate(32)
            second.set(ValueLayout.JAVA_INT, 0, 2)
            assertEquals(1, first.get(ValueLayout.JAVA_INT, 0))
            assertEquals(2, second.get(ValueLayout.JAVA_INT, 0))
        }
    }
}
