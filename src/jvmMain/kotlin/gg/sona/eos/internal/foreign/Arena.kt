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
import java.util.concurrent.CopyOnWriteArrayList

/**
 * `java.lang.foreign.Arena`-compatible allocation scope, backed by
 * [UnsafeAccess] rather than the JDK's real off-heap arena.
 *
 * Real FFM enforces thread-confinement for [ofConfined] arenas as a safety
 * mechanism; this shim intentionally does not replicate that enforcement
 * (Unsafe has no equivalent concept) since no call site in this codebase
 * relies on cross-thread access actually throwing - both [ofConfined] and
 * [ofShared] behave identically here: an allocation scope with a
 * `close()`/`use {}` lifecycle.
 */
class Arena private constructor() : AutoCloseable {
    private val allocations = CopyOnWriteArrayList<Long>()

    fun allocate(byteSize: Long): MemorySegment {
        val u = UnsafeAccess.unsafe
        val size = maxOf(byteSize, 1L)
        val addr = u.allocateMemory(size)
        u.setMemory(addr, size, 0)
        allocations.add(addr)
        return MemorySegment.nativeAt(addr, byteSize)
    }

    fun allocate(layout: MemoryLayout): MemorySegment = allocate(layout.byteSize())

    fun allocate(layout: MemoryLayout, count: Long): MemorySegment = allocate(layout.byteSize() * count)

    fun allocateFrom(value: String): MemorySegment {
        val bytes = value.toByteArray(StandardCharsets.UTF_8)
        val seg = allocate((bytes.size + 1).toLong())
        for (i in bytes.indices) seg.set(ValueLayout.JAVA_BYTE, i.toLong(), bytes[i])
        seg.set(ValueLayout.JAVA_BYTE, bytes.size.toLong(), 0.toByte())
        return seg
    }

    override fun close() {
        val u = UnsafeAccess.unsafe
        val toFree = allocations.toList()
        allocations.clear()
        for (addr in toFree) u.freeMemory(addr)
    }

    companion object {
        fun ofConfined(): Arena = Arena()
        fun ofShared(): Arena = Arena()
    }
}
