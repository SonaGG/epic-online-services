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
package gg.sona.eos

import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout
import kotlinx.cinterop.toKString
import platform.posix.getenv
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NativeSdkTest {
    private val available = getenv("EOS_SDK_LIBRARY")?.toKString() != null

    @Test
    fun readsTheSdkVersion() {
        if (!available) return
        val version = Eos.version
        println("EOS SDK $version")
        assertTrue(version.isNotEmpty())
        assertEquals(version, gg.sona.eos.sdk.EosSdk.getVersion())
        assertEquals("EOS_Success", gg.sona.eos.sdk.EosSdk.eResultToString(EosResult.Success))
    }

    @Test
    fun copiesMemoryThroughSegments() {
        Arena.ofConfined().use { arena ->
            val segment = arena.allocate(16)
            segment.set(ValueLayout.JAVA_INT, 4, 0x12345678)
            val bytes = ByteArray(16)
            MemorySegment.copy(segment, ValueLayout.JAVA_BYTE, 0, bytes, 0, 16)
            assertEquals(0x78.toByte(), bytes[4])
            assertEquals(0x12345678, segment.get(ValueLayout.JAVA_INT, 4))
        }
    }
}
