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
package gg.sona.eos.integratedplatform

/** Login status on an integrated platform. */
enum class EosIntegratedPlatformLoginStatus(val value: Int) {
    NotLoggedIn(0),
    LoggedIn(1);

    companion object {
        internal fun fromValue(v: Int): EosIntegratedPlatformLoginStatus =
            entries.firstOrNull { it.value == v } ?: NotLoggedIn
    }
}