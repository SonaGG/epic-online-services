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

/**
 * Status of desktop crossplay functionality on Windows.
 */
enum class EosDesktopCrossplayStatus(val value: Int) {
    /** Desktop crossplay is ready to use. */
    Ok(0),

    /** The application was not launched through the Bootstrapper. */
    ApplicationNotBootstrapped(1),

    /** The redistributable service is not installed. */
    ServiceNotInstalled(2),

    /** The service failed to start. */
    ServiceStartFailed(3),

    /** The service is no longer running. */
    ServiceNotRunning(4),

    /** The overlay is disabled. */
    OverlayDisabled(5),

    /** The overlay is not installed. */
    OverlayNotInstalled(6),

    /** The overlay failed trust check. */
    OverlayTrustCheckFailed(7),

    /** The overlay failed to load. */
    OverlayLoadFailed(8);

    companion object {
        fun fromValue(v: Int): EosDesktopCrossplayStatus =
            entries.firstOrNull { it.value == v } ?: Ok
    }
}
