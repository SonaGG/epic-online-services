package gg.sona.eos.internal

import gg.sona.eos.internal.foreign.MemorySegment
import kotlin.jvm.JvmField

/** A handle to a registered callback. */
internal class StubHandle internal constructor(
    @JvmField internal val id: Long,
    @JvmField internal val segment: MemorySegment,
)
