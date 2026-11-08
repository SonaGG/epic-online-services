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
package gg.sona.eos.p2p

import gg.sona.eos.internal.setInt32
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

/**
 * P2P Socket ID. Socket names must be 1-32 alphanumeric characters (A-Z, a-z,
 * 0-9, '-', '_', ' ', '+', '=', '.') and may be used as a secret to gate
 * which connections are accepted.
 */
class EosP2PSocketId(val name: String) {
    init {
        require(name.length in 0..32) { "P2P socket name must be 0-32 characters" }
    }

    internal fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, 1)
        val bytes = name.encodeToByteArray()
        val count = minOf(bytes.size, 32)
        for (i in 0 until count) {
            seg.set(ValueLayout.JAVA_BYTE, 4L + i, bytes[i])
        }
        seg.set(ValueLayout.JAVA_BYTE, 4L + count, 0)
        return seg
    }

    companion object {
        internal val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("ApiVersion"),
            MemoryLayout.sequenceLayout(33, ValueLayout.JAVA_BYTE).withName("SocketName"),
            MemoryLayout.paddingLayout(3),
        ).withName("EOS_P2P_SocketId")
    }
}
