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

import java.nio.charset.StandardCharsets

/**
 * `java.lang.foreign.MemorySegment`-compatible handle to either a raw
 * off-heap address (backed by [UnsafeAccess], see [Arena]) or a Java
 * primitive array (see [ofArray], used only as a copy source/destination -
 * never read/written via [get]/[set]).
 *
 * A segment created via [ofAddress] has `byteSize() == 0` (a "bare pointer,
 * size unknown" sentinel, matching real FFM's behavior for a plain ADDRESS
 * read) until [reinterpret] is used to declare an actual size.
 */
class MemorySegment private constructor(
    private val addr: Long,
    private val size: Long,
    private val heap: Any?,
    private val heapOffset: Int,
) {
    fun address(): Long = addr

    fun byteSize(): Long = size

    /** Returns a new view over the same memory with a different declared size. */
    fun reinterpret(newByteSize: Long): MemorySegment =
        if (heap != null) MemorySegment(0L, newByteSize, heap, heapOffset)
        else MemorySegment(addr, newByteSize, null, 0)

    fun asSlice(offset: Long, newSize: Long): MemorySegment =
        if (heap != null) MemorySegment(0L, newSize, heap, heapOffset + offset.toInt())
        else MemorySegment(addr + offset, newSize, null, 0)

    fun getString(offset: Long): String {
        require(heap == null) { "getString is not supported on heap-backed segments" }
        val u = UnsafeAccess.unsafe
        var len = 0
        while (u.getByte(addr + offset + len) != 0.toByte()) len++
        val bytes = ByteArray(len)
        for (i in 0 until len) bytes[i] = u.getByte(addr + offset + i)
        return String(bytes, StandardCharsets.UTF_8)
    }

    // region get/set - overloaded per carrier (not a single generic method) so the return/parameter
    // type is resolved by the compiler at the call site, matching real FFM's ValueLayout.OfXxx design.

    fun get(layout: ValueLayout.OfByte, offset: Long): Byte = requireNative().let { UnsafeAccess.unsafe.getByte(addr + offset) }
    fun get(layout: ValueLayout.OfShort, offset: Long): Short = requireNative().let { UnsafeAccess.unsafe.getShort(addr + offset) }
    fun get(layout: ValueLayout.OfChar, offset: Long): Char = requireNative().let { UnsafeAccess.unsafe.getChar(addr + offset) }
    fun get(layout: ValueLayout.OfInt, offset: Long): Int = requireNative().let { UnsafeAccess.unsafe.getInt(addr + offset) }
    fun get(layout: ValueLayout.OfLong, offset: Long): Long = requireNative().let { UnsafeAccess.unsafe.getLong(addr + offset) }
    fun get(layout: ValueLayout.OfFloat, offset: Long): Float = requireNative().let { UnsafeAccess.unsafe.getFloat(addr + offset) }
    fun get(layout: ValueLayout.OfDouble, offset: Long): Double = requireNative().let { UnsafeAccess.unsafe.getDouble(addr + offset) }
    fun get(layout: ValueLayout.OfBoolean, offset: Long): Boolean = requireNative().let { UnsafeAccess.unsafe.getInt(addr + offset) != 0 }
    fun get(layout: ValueLayout.AddressLayout, offset: Long): MemorySegment =
        requireNative().let { ofAddress(UnsafeAccess.unsafe.getLong(addr + offset)) }

    fun set(layout: ValueLayout.OfByte, offset: Long, value: Byte) = requireNative().let { UnsafeAccess.unsafe.putByte(addr + offset, value) }
    fun set(layout: ValueLayout.OfShort, offset: Long, value: Short) = requireNative().let { UnsafeAccess.unsafe.putShort(addr + offset, value) }
    fun set(layout: ValueLayout.OfChar, offset: Long, value: Char) = requireNative().let { UnsafeAccess.unsafe.putChar(addr + offset, value) }
    fun set(layout: ValueLayout.OfInt, offset: Long, value: Int) = requireNative().let { UnsafeAccess.unsafe.putInt(addr + offset, value) }
    fun set(layout: ValueLayout.OfLong, offset: Long, value: Long) = requireNative().let { UnsafeAccess.unsafe.putLong(addr + offset, value) }
    fun set(layout: ValueLayout.OfFloat, offset: Long, value: Float) = requireNative().let { UnsafeAccess.unsafe.putFloat(addr + offset, value) }
    fun set(layout: ValueLayout.OfDouble, offset: Long, value: Double) = requireNative().let { UnsafeAccess.unsafe.putDouble(addr + offset, value) }
    fun set(layout: ValueLayout.OfBoolean, offset: Long, value: Boolean) =
        requireNative().let { UnsafeAccess.unsafe.putInt(addr + offset, if (value) 1 else 0) }
    fun set(layout: ValueLayout.AddressLayout, offset: Long, value: MemorySegment) =
        requireNative().let { UnsafeAccess.unsafe.putLong(addr + offset, value.address()) }

    fun getAtIndex(layout: ValueLayout.OfByte, index: Long): Byte = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.OfShort, index: Long): Short = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.OfInt, index: Long): Int = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.OfLong, index: Long): Long = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.OfFloat, index: Long): Float = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.OfDouble, index: Long): Double = get(layout, index * layout.byteSize())
    fun getAtIndex(layout: ValueLayout.AddressLayout, index: Long): MemorySegment = get(layout, index * layout.byteSize())

    fun setAtIndex(layout: ValueLayout.OfByte, index: Long, value: Byte) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.OfShort, index: Long, value: Short) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.OfInt, index: Long, value: Int) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.OfLong, index: Long, value: Long) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.OfFloat, index: Long, value: Float) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.OfDouble, index: Long, value: Double) = set(layout, index * layout.byteSize(), value)
    fun setAtIndex(layout: ValueLayout.AddressLayout, index: Long, value: MemorySegment) = set(layout, index * layout.byteSize(), value)

    private fun requireNative() {
        require(heap == null) { "get/set is not supported on heap-backed segments" }
    }

    // endregion

    /** Copies `min(this.byteSize(), src.byteSize())` bytes from [src] into this segment. Returns `this`. */
    fun copyFrom(src: MemorySegment): MemorySegment {
        val count = minOf(this.size, src.size)
        rawCopy(src.base(), src.baseOffset(), this.base(), this.baseOffset(), count)
        return this
    }

    private fun base(): Any? = heap
    private fun baseOffset(): Long = when (heap) {
        null -> addr
        is ByteArray -> (BYTE_ARRAY_BASE_OFFSET + heapOffset).toLong()
        is ShortArray -> (SHORT_ARRAY_BASE_OFFSET + heapOffset * 2).toLong()
        else -> error("unsupported heap array type ${heap.javaClass}")
    }

    override fun equals(other: Any?): Boolean =
        other is MemorySegment && other.addr == addr && other.size == size && other.heap === heap && other.heapOffset == heapOffset

    override fun hashCode(): Int = addr.hashCode() * 31 + size.hashCode()

    companion object {
        private val BYTE_ARRAY_BASE_OFFSET = UnsafeAccess.unsafe.arrayBaseOffset(ByteArray::class.java)
        private val SHORT_ARRAY_BASE_OFFSET = UnsafeAccess.unsafe.arrayBaseOffset(ShortArray::class.java)

        val NULL: MemorySegment = MemorySegment(0L, 0L, null, 0)

        // @JvmStatic is required, not just idiomatic: Native.kt looks this up via
        // MethodHandles.Lookup.findStatic to adapt a downcall's ADDRESS-typed return value, which
        // needs a genuine static method on MemorySegment itself, not an instance method on
        // MemorySegment.Companion (Kotlin's default shape for a companion object function).
        @JvmStatic
        fun ofAddress(address: Long): MemorySegment = MemorySegment(address, 0L, null, 0)

        /** Wraps a `byte[]` directly (no copy) - a "heap segment" usable only as a [copy]/[copyFrom] endpoint. */
        fun ofArray(bytes: ByteArray): MemorySegment = MemorySegment(0L, bytes.size.toLong(), bytes, 0)

        /** Wraps a `short[]` directly (no copy), byte-sized as `shorts.size * 2`. */
        fun ofArray(shorts: ShortArray): MemorySegment = MemorySegment(0L, shorts.size.toLong() * 2, shorts, 0)

        /** Allocates a native segment at a raw address with an explicit size (used by [Arena]). */
        internal fun nativeAt(address: Long, byteSize: Long): MemorySegment = MemorySegment(address, byteSize, null, 0)

        fun copy(srcSegment: MemorySegment, srcOffset: Long, dstSegment: MemorySegment, dstOffset: Long, count: Long) {
            rawCopy(
                srcSegment.base(), srcSegment.baseOffset() + srcOffset,
                dstSegment.base(), dstSegment.baseOffset() + dstOffset,
                count,
            )
        }

        fun copy(
            srcSegment: MemorySegment,
            srcElementLayout: ValueLayout.OfByte,
            srcOffset: Long,
            dstArray: ByteArray,
            dstIndex: Int,
            elementCount: Int,
        ) {
            rawCopy(
                srcSegment.base(), srcSegment.baseOffset() + srcOffset,
                dstArray, (BYTE_ARRAY_BASE_OFFSET + dstIndex).toLong(),
                elementCount.toLong(),
            )
        }

        private fun rawCopy(srcBase: Any?, srcOffset: Long, dstBase: Any?, dstOffset: Long, count: Long) {
            UnsafeAccess.unsafe.copyMemory(srcBase, srcOffset, dstBase, dstOffset, count)
        }
    }
}
