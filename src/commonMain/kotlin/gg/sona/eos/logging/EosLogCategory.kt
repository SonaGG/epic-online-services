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

/** Category of an EOS log message. */
enum class EosLogCategory(val value: Int) {
    AllCategories(0x7fffffff),
    Core(0),
    Auth(1),
    Friends(2),
    Presence(3),
    UserInfo(4),
    HttpSerialization(5),
    Ecom(6),
    P2P(7),
    Sessions(8),
    RateLimiter(9),
    PlayerDataStorage(10),
    Analytics(11),
    Messaging(12),
    Connect(13),
    Overlay(14),
    Achievements(15),
    Stats(16),
    UI(17),
    Lobby(18),
    Leaderboards(19),
    Keychain(20),
    IntegratedPlatform(21),
    TitleStorage(22),
    Mods(23),
    AntiCheat(24),
    Reports(25),
    Sanctions(26),
    ProgressionSnapshots(27),
    KWS(28),
    RTC(29),
    RTCAdmin(30),
    CustomInvites(31),
    HTTP(41);

    companion object {
        fun fromValue(v: Int): EosLogCategory = entries.firstOrNull { it.value == v } ?: AllCategories
    }
}
