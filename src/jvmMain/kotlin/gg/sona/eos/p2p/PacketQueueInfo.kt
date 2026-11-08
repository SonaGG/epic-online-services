package gg.sona.eos.p2p

import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.ValueLayout

class PacketQueueInfo(
    val incomingMaxSizeBytes: Long,
    val incomingCurrentSizeBytes: Long,
    val incomingCurrentPacketCount: Long,
    val outgoingMaxSizeBytes: Long,
    val outgoingCurrentSizeBytes: Long,
    val outgoingCurrentPacketCount: Long,
) {
    internal companion object {
        val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG,
        )
    }
}
