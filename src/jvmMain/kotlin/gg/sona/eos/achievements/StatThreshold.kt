package gg.sona.eos.achievements

import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.ValueLayout

/** A single stat threshold within an achievement definition. */
class StatThreshold(val name: String, val threshold: Int) {
    internal companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT, MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT,
        )
    }
}