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
