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

import gg.sona.eos.internal.RawMemory
import kotlin.jvm.JvmStatic

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
        var len = 0
        while (RawMemory.getByte(addr + offset + len) != 0.toByte()) len++
        val bytes = ByteArray(len)
        RawMemory.getBytes(addr + offset, bytes, 0, len)
        return bytes.decodeToString()
    }

    // region get/set - overloaded per carrier (not a single generic method) so the return/parameter
    // type is resolved by the compiler at the call site, matching real FFM's ValueLayout.OfXxx design.

    fun get(layout: ValueLayout.OfByte, offset: Long): Byte = requireNative().let { RawMemory.getByte(addr + offset) }
    fun get(layout: ValueLayout.OfShort, offset: Long): Short = requireNative().let { RawMemory.getShort(addr + offset) }
    fun get(layout: ValueLayout.OfChar, offset: Long): Char = requireNative().let { RawMemory.getChar(addr + offset) }
    fun get(layout: ValueLayout.OfInt, offset: Long): Int = requireNative().let { RawMemory.getInt(addr + offset) }
    fun get(layout: ValueLayout.OfLong, offset: Long): Long = requireNative().let { RawMemory.getLong(addr + offset) }
    fun get(layout: ValueLayout.OfFloat, offset: Long): Float = requireNative().let { RawMemory.getFloat(addr + offset) }
    fun get(layout: ValueLayout.OfDouble, offset: Long): Double = requireNative().let { RawMemory.getDouble(addr + offset) }
    fun get(layout: ValueLayout.OfBoolean, offset: Long): Boolean = requireNative().let { RawMemory.getInt(addr + offset) != 0 }
    fun get(layout: ValueLayout.AddressLayout, offset: Long): MemorySegment =
        requireNative().let { ofAddress(RawMemory.getLong(addr + offset)) }

    fun set(layout: ValueLayout.OfByte, offset: Long, value: Byte) = requireNative().let { RawMemory.putByte(addr + offset, value) }
    fun set(layout: ValueLayout.OfShort, offset: Long, value: Short) = requireNative().let { RawMemory.putShort(addr + offset, value) }
    fun set(layout: ValueLayout.OfChar, offset: Long, value: Char) = requireNative().let { RawMemory.putChar(addr + offset, value) }
    fun set(layout: ValueLayout.OfInt, offset: Long, value: Int) = requireNative().let { RawMemory.putInt(addr + offset, value) }
    fun set(layout: ValueLayout.OfLong, offset: Long, value: Long) = requireNative().let { RawMemory.putLong(addr + offset, value) }
    fun set(layout: ValueLayout.OfFloat, offset: Long, value: Float) = requireNative().let { RawMemory.putFloat(addr + offset, value) }
    fun set(layout: ValueLayout.OfDouble, offset: Long, value: Double) = requireNative().let { RawMemory.putDouble(addr + offset, value) }
    fun set(layout: ValueLayout.OfBoolean, offset: Long, value: Boolean) =
        requireNative().let { RawMemory.putInt(addr + offset, if (value) 1 else 0) }
    fun set(layout: ValueLayout.AddressLayout, offset: Long, value: MemorySegment) =
        requireNative().let { RawMemory.putLong(addr + offset, value.address()) }

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
        rawCopy(src, 0, this, 0, minOf(this.size, src.size))
        return this
    }

    private fun heapByte(position: Long): Byte = when (val array = heap) {
        is ByteArray -> array[heapOffset + position.toInt()]
        is ShortArray -> {
            val byte = heapOffset * 2 + position.toInt()
            (array[byte / 2].toInt() shr (8 * (byte % 2))).toByte()
        }
        else -> error("Unsupported heap segment")
    }

    private fun setHeapByte(position: Long, value: Byte) {
        when (val array = heap) {
            is ByteArray -> array[heapOffset + position.toInt()] = value
            is ShortArray -> {
                val byte = heapOffset * 2 + position.toInt()
                val shift = 8 * (byte % 2)
                val current = array[byte / 2].toInt() and (0xFF shl shift).inv()
                array[byte / 2] = (current or ((value.toInt() and 0xFF) shl shift)).toShort()
            }
            else -> error("Unsupported heap segment")
        }
    }

    override fun equals(other: Any?): Boolean =
        other is MemorySegment && other.addr == addr && other.size == size && other.heap === heap && other.heapOffset == heapOffset

    override fun hashCode(): Int = addr.hashCode() * 31 + size.hashCode()

    companion object {

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
            rawCopy(srcSegment, srcOffset, dstSegment, dstOffset, count)
        }

        fun copy(
            srcSegment: MemorySegment,
            srcElementLayout: ValueLayout.OfByte,
            srcOffset: Long,
            dstArray: ByteArray,
            dstIndex: Int,
            elementCount: Int,
        ) {
            rawCopy(srcSegment, srcOffset, MemorySegment(0L, dstArray.size.toLong(), dstArray, 0), dstIndex.toLong(), elementCount.toLong())
        }

        private fun rawCopy(src: MemorySegment, srcOffset: Long, dst: MemorySegment, dstOffset: Long, count: Long) {
            if (count <= 0) return
            val srcBytes = src.heap as? ByteArray
            val dstBytes = dst.heap as? ByteArray
            when {
                src.heap == null && dst.heap == null -> RawMemory.copy(src.addr + srcOffset, dst.addr + dstOffset, count)
                srcBytes != null && dst.heap == null -> RawMemory.putBytes(dst.addr + dstOffset, srcBytes, src.heapOffset + srcOffset.toInt(), count.toInt())
                src.heap == null && dstBytes != null -> RawMemory.getBytes(src.addr + srcOffset, dstBytes, dst.heapOffset + dstOffset.toInt(), count.toInt())
                else -> for (i in 0 until count) {
                    val byte = if (src.heap == null) RawMemory.getByte(src.addr + srcOffset + i) else src.heapByte(srcOffset + i)
                    if (dst.heap == null) RawMemory.putByte(dst.addr + dstOffset + i, byte) else dst.setHeapByte(dstOffset + i, byte)
                }
            }
        }
    }
}
