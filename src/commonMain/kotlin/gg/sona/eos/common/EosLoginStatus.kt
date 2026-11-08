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
 * Local user login status reported by EOS.
 */
enum class EosLoginStatus {
    /** No user has logged in or chosen a local profile. */
    NotLoggedIn,

    /** The user is using a local profile but is not logged in. */
    UsingLocalProfile,

    /** The user has been validated by the platform-specific authentication service. */
    LoggedIn;

    companion object {
        internal fun fromValue(v: Int): EosLoginStatus = when (v) {
            0 -> NotLoggedIn
            1 -> UsingLocalProfile
            2 -> LoggedIn
            else -> NotLoggedIn
        }
    }
}
