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
package gg.sona.eos.rtc

import gg.sona.eos.internal.Native
import gg.sona.eos.internal.getInt32
import gg.sona.eos.internal.foreign.FunctionDescriptor
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout

private const val DEVICE_INFORMATION_SIZE = 24L

internal fun invokeHandle(platformHandle: Long): Long {
    val fn = Native.downcall(
        "EOS_Platform_GetRTCInterface",
        FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    )
    return fn.invokeExact(platformHandle) as Long
}

internal fun readCString(data: MemorySegment, offset: Long): String? {
    val ptr = data.get(ValueLayout.ADDRESS, offset)
    if (ptr.address() == 0L) return null
    return ptr.reinterpret(Long.MAX_VALUE).getString(0)
}

/**
 * Reads an EOS_RTCAudio_InputDeviceInformation / EOS_RTCAudio_OutputDeviceInformation.
 * Both share the layout ApiVersion@0, bDefaultDevice@4, DeviceId@8, DeviceName@16.
 */
internal fun readDeviceInformation(seg: MemorySegment): EosRtcAudioDeviceInfo {
    val view = seg.reinterpret(DEVICE_INFORMATION_SIZE)
    return EosRtcAudioDeviceInfo(
        deviceId = readCString(view, 8) ?: "",
        deviceName = readCString(view, 16) ?: "",
        isDefault = view.getInt32(4) != 0,
    )
}
