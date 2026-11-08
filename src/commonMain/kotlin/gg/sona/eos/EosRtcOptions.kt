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

import gg.sona.eos.internal.*
import gg.sona.eos.internal.foreign.Arena
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

/** RTC options for the platform. */
class EosRtcOptions : StructWriter {
    var backgroundMode: EosRtcBackgroundMode = EosRtcBackgroundMode.LeaveRooms

    /**
     * Absolute path to `xaudio2_9redist.dll`.
     *
     * Windows refuses to create a platform with RTC enabled unless this is supplied, and the
     * failure surfaces as a null handle out of `EOS_Platform_Create` rather than an error code.
     * Defaults to the copy bundled by the embedding application under `natives/`, so it only
     * needs setting to override that.
     */
    var xAudio29DllPath: String? = null

    override fun writeTo(arena: Arena): MemorySegment {
        val seg = arena.allocate(LAYOUT)
        seg.setInt32(0, API_LATEST)
        seg.setInt64(8, windowsOptions(arena)?.address() ?: 0L)
        seg.setInt32(16, backgroundMode.value)
        seg.setInt64(24, 0L) // Reserved
        return seg
    }

    private fun windowsOptions(arena: Arena): MemorySegment? {
        if (!IS_WINDOWS) return null

        val path = xAudio29DllPath ?: Native.extractBundledFile(XAUDIO_DLL) ?: return null

        val seg = arena.allocate(WINDOWS_LAYOUT)
        seg.setInt32(0, WINDOWS_API_LATEST)
        seg.setInt64(8, arena.allocCString(path).address())
        return seg
    }

    companion object {
        const val API_LATEST: Int = 3

        internal const val WINDOWS_API_LATEST: Int = 1
        internal const val XAUDIO_DLL: String = "xaudio2_9redist.dll"

        internal val IS_WINDOWS: Boolean = gg.sona.eos.internal.NativeBackend.isWindows

        internal val LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("ApiVersion"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS.withName("PlatformSpecificOptions"),
            ValueLayout.JAVA_INT.withName("BackgroundMode"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS.withName("Reserved"),
        )

        internal val WINDOWS_LAYOUT: MemoryLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("ApiVersion"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.ADDRESS.withName("XAudio29DllPath"),
        )
    }
}
