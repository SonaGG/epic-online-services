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
package gg.sona.eos.common

import gg.sona.eos.internal.Native
import gg.sona.eos.internal.withCallArena
import gg.sona.eos.internal.foreign.FunctionDescriptor
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout
import kotlin.jvm.JvmInline

/**
 * An opaque handle to a continuance token returned by some EOS Connect APIs.
 * Use [stringify] to serialize for later use.
 */
@JvmInline
value class ContinuanceToken(val raw: Long) {
    fun isValid(): Boolean = raw != 0L

    fun stringify(): String {
        if (raw == 0L) return ""
        return withCallArena { arena ->
            val sizePtr = arena.allocate(ValueLayout.JAVA_INT)
            val fn = Native.downcall(
                "EOS_ContinuanceToken_ToString",
                FunctionDescriptor.of(
                    ValueLayout.JAVA_INT,
                    ValueLayout.JAVA_LONG,
                    ValueLayout.ADDRESS,
                    ValueLayout.ADDRESS,
                )
            )
            fn.invokeExact(raw, MemorySegment.NULL, sizePtr) as Int
            val size = sizePtr.get(ValueLayout.JAVA_INT, 0)
            val buf = arena.allocate(size.toLong())
            sizePtr.set(ValueLayout.JAVA_INT, 0, size)
            fn.invokeExact(raw, buf, sizePtr) as Int
            buf.getString(0)
        }
    }
}
