package gg.sona.eos.achievements

import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.ValueLayout

/** A single player stat-info record within a player achievement. */
class PlayerStatInfo(val name: String, val currentValue: Int, val thresholdValue: Int) {
    internal companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT,
        )
    }
}