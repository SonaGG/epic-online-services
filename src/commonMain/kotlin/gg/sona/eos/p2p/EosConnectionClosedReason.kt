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
package gg.sona.eos.p2p

/** Reason a P2P connection was closed. */
enum class EosConnectionClosedReason(val value: Int) {
    Unknown(0),
    ClosedByLocalUser(1),
    ClosedByPeer(2),
    TimedOut(3),
    TooManyConnections(4),
    InvalidMessage(5),
    InvalidData(6),
    ConnectionFailed(7),
    ConnectionClosed(8),
    NegotiationFailed(9),
    UnexpectedError(10),
    ConnectionIgnored(11);

    companion object {
        fun fromValue(v: Int): EosConnectionClosedReason = entries.firstOrNull { it.value == v } ?: Unknown
    }
}
