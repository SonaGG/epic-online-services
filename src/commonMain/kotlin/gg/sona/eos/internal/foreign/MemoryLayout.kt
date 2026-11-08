/*
 * Copyright 2026 Sona Interactive, Inc.
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
 * Minimal `java.lang.foreign.MemoryLayout`-compatible layout algebra, used
 * only for size/alignment bookkeeping (no automatic padding insertion:
 * generated struct writers already emit explicit [PaddingLayout] members
 * matching `#pragma pack(8)`, so composition here is just a byte-size sum).
 */
sealed class MemoryLayout {
    abstract fun byteSize(): Long
    abstract fun byteAlignment(): Long

    /**
     * Real FFM's `.withName(...)` attaches a debug-only descriptive name to
     * a layout; this shim has no use for it beyond API compatibility, so it
     * is an identity no-op.
     */
    open fun withName(name: String): MemoryLayout = this

    companion object {
        fun paddingLayout(byteSize: Long): MemoryLayout = PaddingLayout(byteSize)

        fun structLayout(vararg members: MemoryLayout): GroupLayout = GroupLayout(members.toList())

        fun sequenceLayout(count: Long, element: MemoryLayout): MemoryLayout = SequenceLayout(count, element)
    }
}

private class PaddingLayout(private val size: Long) : MemoryLayout() {
    override fun byteSize(): Long = size
    override fun byteAlignment(): Long = 1L
}

class GroupLayout internal constructor(val members: List<MemoryLayout>) : MemoryLayout() {
    private val size = members.sumOf { it.byteSize() }
    private val align = members.maxOfOrNull { it.byteAlignment() } ?: 1L

    override fun byteSize(): Long = size
    override fun byteAlignment(): Long = align
    override fun withName(name: String): GroupLayout = this
}

private class SequenceLayout(private val count: Long, private val element: MemoryLayout) : MemoryLayout() {
    override fun byteSize(): Long = count * element.byteSize()
    override fun byteAlignment(): Long = element.byteAlignment()
}
