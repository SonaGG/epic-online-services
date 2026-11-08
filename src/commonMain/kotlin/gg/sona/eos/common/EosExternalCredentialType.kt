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
 * Identity provider used to authenticate a user.
 */
enum class EosExternalCredentialType(val value: Int) {
    Epic(0),
    SteamAppTicket(1),
    PsnIdToken(2),
    XboxXstsToken(3),
    DiscordAccessToken(4),
    GogSessionTicket(5),
    NintendoIdToken(6),
    NintendoNsaIdToken(7),
    UplayAccessToken(8),
    OpenIdAccessToken(9),
    DeviceIdAccessToken(10),
    AppleIdToken(11),
    GoogleIdToken(12),
    OculusUserIdNonce(13),
    ItchioJwt(14),
    ItchioKey(15),
    EpicIdToken(16),
    AmazonAccessToken(17),
    SteamSessionTicket(18),
    ViveportUserToken(19);

    companion object {
        internal fun fromValue(v: Int): EosExternalCredentialType = entries.firstOrNull { it.value == v } ?: Epic
    }
}