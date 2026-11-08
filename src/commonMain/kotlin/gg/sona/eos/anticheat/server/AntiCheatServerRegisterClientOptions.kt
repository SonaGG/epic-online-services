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
package gg.sona.eos.anticheat.server

import gg.sona.eos.anticheat.common.EosAntiCheatCommon
import gg.sona.eos.common.ProductUserId
import gg.sona.eos.internal.StructWriter
import gg.sona.eos.internal.allocCString
import gg.sona.eos.internal.setInt32
import gg.sona.eos.internal.setInt64
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

internal class AntiCheatServerRegisterClientOptions(
    var clientHandle: EosAntiCheatCommon.ClientHandle,
    var clientType: EosAntiCheatCommon.ClientType,
    var clientPlatform: EosAntiCheatCommon.ClientPlatform,
    var ipAddress: String?,
    var userId: ProductUserId,
) : StructWriter {
    override fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, 3)
        seg.setInt64(8, clientHandle.raw)
        seg.setInt32(16, clientType.value)
        seg.setInt32(20, clientPlatform.value)
        seg.setInt64(24, 0L) // deprecated
        seg.setInt64(32, arena.allocCString(ipAddress).address())
        seg.setInt64(40, userId.raw)
        seg.setInt32(48, 0)
        return seg
    }

    companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT,
            MemoryLayout.paddingLayout(4), ValueLayout.JAVA_LONG, ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
        )
    }
}