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
package gg.sona.eos.anticheat.client

/** Type of a client-side integrity violation. */
enum class EosAntiCheatClientViolationType(val value: Int) {
    Invalid(0),
    IntegrityCatalogNotFound(1),
    IntegrityCatalogError(2),
    IntegrityCatalogCertificateRevoked(3),
    IntegrityCatalogMissingMainExecutable(4),
    GameFileMismatch(5),
    RequiredGameFileNotFound(6),
    UnknownGameFileForbidden(7),
    SystemFileUntrusted(8),
    ForbiddenModuleLoaded(9),
    CorruptedMemory(10),
    ForbiddenToolDetected(11),
    InternalAntiCheatViolation(12),
    CorruptedNetworkMessageFlow(13),
    VirtualMachineNotAllowed(14),
    ForbiddenSystemConfiguration(15);

    companion object {
        fun fromValue(v: Int): EosAntiCheatClientViolationType =
            entries.firstOrNull { it.value == v } ?: Invalid
    }
}