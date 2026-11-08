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
package gg.sona.eos.kws

/** Status of a KWS permission grant. */
enum class EosKwsPermissionStatus(val value: Int) {
    Granted(0),
    Rejected(1),
    Pending(2);

    companion object {
        internal fun fromValue(v: Int): EosKwsPermissionStatus =
            entries.firstOrNull { it.value == v } ?: Granted
    }
}
