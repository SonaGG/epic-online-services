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

import gg.sona.eos.common.ProductUserId
import gg.sona.eos.internal.StructWriter
import gg.sona.eos.internal.setInt32
import gg.sona.eos.internal.setInt64
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

internal class P2PSendPacketOptions(
    var localUserId: ProductUserId,
    var remoteUserId: ProductUserId,
    var socketId: MemorySegment,
    var channel: Byte,
    var data: MemorySegment,
    var dataLengthBytes: Int,
    var allowDelayedDelivery: Boolean,
    var reliability: EosPacketReliability,
    var disableAutoAcceptConnection: Boolean,
) : StructWriter {
    override fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, 3)
        seg.setInt64(8, localUserId.raw)
        seg.setInt64(16, remoteUserId.raw)
        seg.setInt64(24, socketId.address())
        seg.set(ValueLayout.JAVA_BYTE, 32, channel)
        seg.setInt32(36, dataLengthBytes)
        seg.setInt64(40, data.address())
        seg.setInt32(48, if (allowDelayedDelivery) 1 else 0)
        seg.setInt32(52, reliability.value)
        seg.setInt32(56, if (disableAutoAcceptConnection) 1 else 0)
        return seg
    }

    companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS,
            ValueLayout.JAVA_BYTE, MemoryLayout.paddingLayout(3),
            ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
        )
    }
}
