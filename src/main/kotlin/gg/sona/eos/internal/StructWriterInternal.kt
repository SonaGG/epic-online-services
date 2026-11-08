package gg.sona.eos.internal

import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemorySegment

@PublishedApi
internal interface StructWriterInternal {
    fun writeTo(arena: Arena): MemorySegment
}
