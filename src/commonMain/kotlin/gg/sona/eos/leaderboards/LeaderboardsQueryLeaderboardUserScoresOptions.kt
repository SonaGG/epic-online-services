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
package gg.sona.eos.leaderboards

import gg.sona.eos.common.ProductUserId
import gg.sona.eos.internal.*
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

internal class LeaderboardsQueryLeaderboardUserScoresOptions(
    var userIds: List<ProductUserId>,
    var statInfo: List<UserScoresQueryStatInfo>,
    var startTime: Long,
    var endTime: Long,
    var localUserId: ProductUserId,
) : StructWriter {
    override fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, API_LATEST)
        val userArr = arena.allocHandleArray(userIds.map { it.raw })
        seg.setInt64(8, userArr.address())
        seg.setInt32(16, userIds.size)
        val statArr = arena.allocate(LAYOUT_STAT, statInfo.size.toLong())
        statInfo.forEachIndexed { i, s ->
            val item = statArr.asSlice(i.toLong() * LAYOUT_STAT.byteSize(), LAYOUT_STAT.byteSize())
            item.setInt32(0, 1) // API
            item.setInt64(8, arena.allocCString(s.statName).address())
            item.setInt32(16, s.aggregation.value)
        }
        seg.setInt64(24, statArr.address())
        seg.setInt32(32, statInfo.size)
        seg.setInt64(40, startTime)
        seg.setInt64(48, endTime)
        seg.setInt64(56, localUserId.raw)
        return seg
    }

    companion object {
        const val API_LATEST = 2
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG,
        )
        val LAYOUT_STAT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT,
        )
    }
}
