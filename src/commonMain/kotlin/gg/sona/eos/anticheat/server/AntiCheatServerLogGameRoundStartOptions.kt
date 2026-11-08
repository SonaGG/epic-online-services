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
import gg.sona.eos.internal.StructWriter
import gg.sona.eos.internal.allocCString
import gg.sona.eos.internal.setInt32
import gg.sona.eos.internal.setInt64
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

internal class AntiCheatServerLogGameRoundStartOptions(
    var sessionIdentifier: String?,
    var levelName: String?,
    var modeName: String?,
    var roundTimeSeconds: UInt,
    var competitionType: EosAntiCheatCommon.GameRoundCompetitionType,
) : StructWriter {
    override fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, 2)
        seg.setInt64(8, arena.allocCString(sessionIdentifier).address())
        seg.setInt64(16, arena.allocCString(levelName).address())
        seg.setInt64(24, arena.allocCString(modeName).address())
        seg.setInt32(32, roundTimeSeconds.toInt())
        seg.setInt32(36, competitionType.value)
        return seg
    }

    companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT, ValueLayout.JAVA_INT,
        )
    }
}
