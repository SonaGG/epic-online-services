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
 * The application state that the platform should treat the process as being in.
 */
enum class EosApplicationStatus(val value: Int) {
    /** Xbox only: the application has entered constrained mode. */
    BackgroundConstrained(0),

    /** Xbox only: the application has returned from constrained mode. */
    BackgroundUnconstrained(1),

    /** The application has been suspended. */
    BackgroundSuspended(2),

    /** The application is in the foreground. */
    Foreground(3);

    companion object {
        fun fromValue(v: Int): EosApplicationStatus = entries.firstOrNull { it.value == v } ?: Foreground
    }
}
