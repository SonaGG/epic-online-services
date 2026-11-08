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

/** Platform creation flags. */
object EosPlatformFlags {
    /** The SDK is being loaded in a game editor (Unity/Unreal play-in-editor). */
    const val LoadingInEditor: Int = 0x00001

    /** Skip initialization of the overlay used by the in-app purchase flow. */
    const val DisableOverlay: Int = 0x00002

    /** Skip initialization of the social overlay. */
    const val DisableSocialOverlay: Int = 0x00004

    /** Reserved. */
    const val Reserved1: Int = 0x00008

    /** Enable experimental D3D9 overlay support on Windows. */
    const val WindowsEnableOverlayD3D9: Int = 0x00010

    /** Enable experimental D3D10 overlay support on Windows. */
    const val WindowsEnableOverlayD3D10: Int = 0x00020

    /** Enable experimental OpenGL overlay support on Windows. */
    const val WindowsEnableOverlayOpenGL: Int = 0x00040

    /** Enable automatic unloading of the overlay module on consoles. */
    const val ConsoleEnableOverlayAutomaticUnloading: Int = 0x00080

    /** Enable verbose debug logging related to the overlay on consoles. */
    const val EnableOverlayDebugLogging: Int = 0x00100
}
