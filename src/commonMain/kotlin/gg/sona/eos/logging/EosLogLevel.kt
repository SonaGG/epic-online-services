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
package gg.sona.eos.logging

/** Verbosity of log messages. Higher values mean more chatty logs. */
enum class EosLogLevel(val value: Int) {
    Off(0),
    Fatal(100),
    Error(200),
    Warning(300),
    Info(400),
    Verbose(500),
    VeryVerbose(600);

    companion object {
        fun fromValue(v: Int): EosLogLevel = entries.firstOrNull { it.value == v } ?: Off
    }
}