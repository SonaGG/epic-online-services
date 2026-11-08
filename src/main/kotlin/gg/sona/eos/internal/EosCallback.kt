package gg.sona.eos.internal

import gg.sona.eos.internal.foreign.MemorySegment

/**
 * The shape of a typical EOS callback: one argument which is a pointer to a
 * callback-info struct, no return value. Implementations extract the relevant
 * fields from the supplied [MemorySegment] and call the user's lambda.
 */
fun interface EosCallback {
    fun invoke(data: MemorySegment)
}
