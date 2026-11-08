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
@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Byte
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class LobbyJoinRTCRoomOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var localRTCOptions: LobbyLocalRTCOptions
    get() = LobbyLocalRTCOptions(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyJoinRTCRoomOptions = LobbyJoinRTCRoomOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinRTCRoomOptions {
      val struct = LobbyJoinRTCRoomOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinRTCRoomOptions(block: LobbyJoinRTCRoomOptions.() -> Unit = {}): LobbyJoinRTCRoomOptions = LobbyJoinRTCRoomOptions.allocate().apply(block)

@JvmInline
public value class LobbyJoinRTCRoomCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyJoinRTCRoomCallbackInfo = LobbyJoinRTCRoomCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinRTCRoomCallbackInfo {
      val struct = LobbyJoinRTCRoomCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinRTCRoomCallbackInfo(block: LobbyJoinRTCRoomCallbackInfo.() -> Unit = {}): LobbyJoinRTCRoomCallbackInfo = LobbyJoinRTCRoomCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyLeaveRTCRoomOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyLeaveRTCRoomOptions = LobbyLeaveRTCRoomOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyLeaveRTCRoomOptions {
      val struct = LobbyLeaveRTCRoomOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLeaveRTCRoomOptions(block: LobbyLeaveRTCRoomOptions.() -> Unit = {}): LobbyLeaveRTCRoomOptions = LobbyLeaveRTCRoomOptions.allocate().apply(block)

@JvmInline
public value class LobbyLeaveRTCRoomCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyLeaveRTCRoomCallbackInfo = LobbyLeaveRTCRoomCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLeaveRTCRoomCallbackInfo {
      val struct = LobbyLeaveRTCRoomCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLeaveRTCRoomCallbackInfo(block: LobbyLeaveRTCRoomCallbackInfo.() -> Unit = {}): LobbyLeaveRTCRoomCallbackInfo = LobbyLeaveRTCRoomCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyPromoteMemberOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyPromoteMemberOptions = LobbyPromoteMemberOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyPromoteMemberOptions {
      val struct = LobbyPromoteMemberOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyPromoteMemberOptions(block: LobbyPromoteMemberOptions.() -> Unit = {}): LobbyPromoteMemberOptions = LobbyPromoteMemberOptions.allocate().apply(block)

@JvmInline
public value class LobbyPromoteMemberCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyPromoteMemberCallbackInfo = LobbyPromoteMemberCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyPromoteMemberCallbackInfo {
      val struct = LobbyPromoteMemberCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyPromoteMemberCallbackInfo(block: LobbyPromoteMemberCallbackInfo.() -> Unit = {}): LobbyPromoteMemberCallbackInfo = LobbyPromoteMemberCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyKickMemberOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyKickMemberOptions = LobbyKickMemberOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyKickMemberOptions {
      val struct = LobbyKickMemberOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyKickMemberOptions(block: LobbyKickMemberOptions.() -> Unit = {}): LobbyKickMemberOptions = LobbyKickMemberOptions.allocate().apply(block)

@JvmInline
public value class LobbyKickMemberCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyKickMemberCallbackInfo = LobbyKickMemberCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyKickMemberCallbackInfo {
      val struct = LobbyKickMemberCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyKickMemberCallbackInfo(block: LobbyKickMemberCallbackInfo.() -> Unit = {}): LobbyKickMemberCallbackInfo = LobbyKickMemberCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyHardMuteMemberOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var hardMute: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: LobbyHardMuteMemberOptions = LobbyHardMuteMemberOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyHardMuteMemberOptions {
      val struct = LobbyHardMuteMemberOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyHardMuteMemberOptions(block: LobbyHardMuteMemberOptions.() -> Unit = {}): LobbyHardMuteMemberOptions = LobbyHardMuteMemberOptions.allocate().apply(block)

@JvmInline
public value class LobbyHardMuteMemberCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyHardMuteMemberCallbackInfo = LobbyHardMuteMemberCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyHardMuteMemberCallbackInfo {
      val struct = LobbyHardMuteMemberCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyHardMuteMemberCallbackInfo(block: LobbyHardMuteMemberCallbackInfo.() -> Unit = {}): LobbyHardMuteMemberCallbackInfo = LobbyHardMuteMemberCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyUpdateReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyUpdateReceivedOptions =
        LobbyAddNotifyLobbyUpdateReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyUpdateReceivedOptions {
      val struct = LobbyAddNotifyLobbyUpdateReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyUpdateReceivedOptions(block: LobbyAddNotifyLobbyUpdateReceivedOptions.() -> Unit = {}): LobbyAddNotifyLobbyUpdateReceivedOptions = LobbyAddNotifyLobbyUpdateReceivedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyUpdateReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyLobbyUpdateReceivedCallbackInfo = LobbyLobbyUpdateReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyUpdateReceivedCallbackInfo {
      val struct = LobbyLobbyUpdateReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyUpdateReceivedCallbackInfo(block: LobbyLobbyUpdateReceivedCallbackInfo.() -> Unit = {}): LobbyLobbyUpdateReceivedCallbackInfo = LobbyLobbyUpdateReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyMemberUpdateReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyMemberUpdateReceivedOptions =
        LobbyAddNotifyLobbyMemberUpdateReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyMemberUpdateReceivedOptions {
      val struct = LobbyAddNotifyLobbyMemberUpdateReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyMemberUpdateReceivedOptions(block: LobbyAddNotifyLobbyMemberUpdateReceivedOptions.() -> Unit = {}): LobbyAddNotifyLobbyMemberUpdateReceivedOptions = LobbyAddNotifyLobbyMemberUpdateReceivedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyMemberUpdateReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyLobbyMemberUpdateReceivedCallbackInfo =
        LobbyLobbyMemberUpdateReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyMemberUpdateReceivedCallbackInfo {
      val struct = LobbyLobbyMemberUpdateReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyMemberUpdateReceivedCallbackInfo(block: LobbyLobbyMemberUpdateReceivedCallbackInfo.() -> Unit = {}): LobbyLobbyMemberUpdateReceivedCallbackInfo = LobbyLobbyMemberUpdateReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyMemberStatusReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyMemberStatusReceivedOptions =
        LobbyAddNotifyLobbyMemberStatusReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyMemberStatusReceivedOptions {
      val struct = LobbyAddNotifyLobbyMemberStatusReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyMemberStatusReceivedOptions(block: LobbyAddNotifyLobbyMemberStatusReceivedOptions.() -> Unit = {}): LobbyAddNotifyLobbyMemberStatusReceivedOptions = LobbyAddNotifyLobbyMemberStatusReceivedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyMemberStatusReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var currentStatus: ELobbyMemberStatus
    get() = ELobbyMemberStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyLobbyMemberStatusReceivedCallbackInfo =
        LobbyLobbyMemberStatusReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyMemberStatusReceivedCallbackInfo {
      val struct = LobbyLobbyMemberStatusReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyMemberStatusReceivedCallbackInfo(block: LobbyLobbyMemberStatusReceivedCallbackInfo.() -> Unit = {}): LobbyLobbyMemberStatusReceivedCallbackInfo = LobbyLobbyMemberStatusReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyInviteReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyInviteReceivedOptions =
        LobbyAddNotifyLobbyInviteReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyInviteReceivedOptions {
      val struct = LobbyAddNotifyLobbyInviteReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyInviteReceivedOptions(block: LobbyAddNotifyLobbyInviteReceivedOptions.() -> Unit = {}): LobbyAddNotifyLobbyInviteReceivedOptions = LobbyAddNotifyLobbyInviteReceivedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyInviteReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyLobbyInviteReceivedCallbackInfo = LobbyLobbyInviteReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyInviteReceivedCallbackInfo {
      val struct = LobbyLobbyInviteReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyInviteReceivedCallbackInfo(block: LobbyLobbyInviteReceivedCallbackInfo.() -> Unit = {}): LobbyLobbyInviteReceivedCallbackInfo = LobbyLobbyInviteReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyInviteAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyInviteAcceptedOptions =
        LobbyAddNotifyLobbyInviteAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyInviteAcceptedOptions {
      val struct = LobbyAddNotifyLobbyInviteAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyInviteAcceptedOptions(block: LobbyAddNotifyLobbyInviteAcceptedOptions.() -> Unit = {}): LobbyAddNotifyLobbyInviteAcceptedOptions = LobbyAddNotifyLobbyInviteAcceptedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyInviteAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: LobbyLobbyInviteAcceptedCallbackInfo = LobbyLobbyInviteAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyInviteAcceptedCallbackInfo {
      val struct = LobbyLobbyInviteAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyInviteAcceptedCallbackInfo(block: LobbyLobbyInviteAcceptedCallbackInfo.() -> Unit = {}): LobbyLobbyInviteAcceptedCallbackInfo = LobbyLobbyInviteAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyJoinLobbyAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyJoinLobbyAcceptedOptions =
        LobbyAddNotifyJoinLobbyAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyJoinLobbyAcceptedOptions {
      val struct = LobbyAddNotifyJoinLobbyAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyJoinLobbyAcceptedOptions(block: LobbyAddNotifyJoinLobbyAcceptedOptions.() -> Unit = {}): LobbyAddNotifyJoinLobbyAcceptedOptions = LobbyAddNotifyJoinLobbyAcceptedOptions.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLobbyInviteRejectedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLobbyInviteRejectedOptions =
        LobbyAddNotifyLobbyInviteRejectedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLobbyInviteRejectedOptions {
      val struct = LobbyAddNotifyLobbyInviteRejectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLobbyInviteRejectedOptions(block: LobbyAddNotifyLobbyInviteRejectedOptions.() -> Unit = {}): LobbyAddNotifyLobbyInviteRejectedOptions = LobbyAddNotifyLobbyInviteRejectedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLobbyInviteRejectedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: LobbyLobbyInviteRejectedCallbackInfo = LobbyLobbyInviteRejectedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLobbyInviteRejectedCallbackInfo {
      val struct = LobbyLobbyInviteRejectedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLobbyInviteRejectedCallbackInfo(block: LobbyLobbyInviteRejectedCallbackInfo.() -> Unit = {}): LobbyLobbyInviteRejectedCallbackInfo = LobbyLobbyInviteRejectedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyJoinLobbyAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var uiEventId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyJoinLobbyAcceptedCallbackInfo = LobbyJoinLobbyAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinLobbyAcceptedCallbackInfo {
      val struct = LobbyJoinLobbyAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinLobbyAcceptedCallbackInfo(block: LobbyJoinLobbyAcceptedCallbackInfo.() -> Unit = {}): LobbyJoinLobbyAcceptedCallbackInfo = LobbyJoinLobbyAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifySendLobbyNativeInviteRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifySendLobbyNativeInviteRequestedOptions =
        LobbyAddNotifySendLobbyNativeInviteRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifySendLobbyNativeInviteRequestedOptions {
      val struct = LobbyAddNotifySendLobbyNativeInviteRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifySendLobbyNativeInviteRequestedOptions(block: LobbyAddNotifySendLobbyNativeInviteRequestedOptions.() -> Unit = {}): LobbyAddNotifySendLobbyNativeInviteRequestedOptions = LobbyAddNotifySendLobbyNativeInviteRequestedOptions.allocate().apply(block)

@JvmInline
public value class LobbySendLobbyNativeInviteRequestedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var uiEventId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetNativeAccountType: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  context(arena: Arena)
  public var targetUserNativeAccountId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: LobbySendLobbyNativeInviteRequestedCallbackInfo =
        LobbySendLobbyNativeInviteRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbySendLobbyNativeInviteRequestedCallbackInfo {
      val struct = LobbySendLobbyNativeInviteRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySendLobbyNativeInviteRequestedCallbackInfo(block: LobbySendLobbyNativeInviteRequestedCallbackInfo.() -> Unit = {}): LobbySendLobbyNativeInviteRequestedCallbackInfo = LobbySendLobbyNativeInviteRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyCopyLobbyDetailsHandleByInviteIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyCopyLobbyDetailsHandleByInviteIdOptions =
        LobbyCopyLobbyDetailsHandleByInviteIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyCopyLobbyDetailsHandleByInviteIdOptions {
      val struct = LobbyCopyLobbyDetailsHandleByInviteIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCopyLobbyDetailsHandleByInviteIdOptions(block: LobbyCopyLobbyDetailsHandleByInviteIdOptions.() -> Unit = {}): LobbyCopyLobbyDetailsHandleByInviteIdOptions = LobbyCopyLobbyDetailsHandleByInviteIdOptions.allocate().apply(block)

@JvmInline
public value class LobbyCopyLobbyDetailsHandleByUiEventIdOptions(
  public val address: Long,
) {
  public var uiEventId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyCopyLobbyDetailsHandleByUiEventIdOptions =
        LobbyCopyLobbyDetailsHandleByUiEventIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyCopyLobbyDetailsHandleByUiEventIdOptions {
      val struct = LobbyCopyLobbyDetailsHandleByUiEventIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCopyLobbyDetailsHandleByUiEventIdOptions(block: LobbyCopyLobbyDetailsHandleByUiEventIdOptions.() -> Unit = {}): LobbyCopyLobbyDetailsHandleByUiEventIdOptions = LobbyCopyLobbyDetailsHandleByUiEventIdOptions.allocate().apply(block)

@JvmInline
public value class LobbyCreateLobbySearchOptions(
  public val address: Long,
) {
  public var maxResults: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyCreateLobbySearchOptions = LobbyCreateLobbySearchOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyCreateLobbySearchOptions {
      val struct = LobbyCreateLobbySearchOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCreateLobbySearchOptions(block: LobbyCreateLobbySearchOptions.() -> Unit = {}): LobbyCreateLobbySearchOptions = LobbyCreateLobbySearchOptions.allocate().apply(block)

@JvmInline
public value class LobbySendInviteOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbySendInviteOptions = LobbySendInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySendInviteOptions {
      val struct = LobbySendInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySendInviteOptions(block: LobbySendInviteOptions.() -> Unit = {}): LobbySendInviteOptions = LobbySendInviteOptions.allocate().apply(block)

@JvmInline
public value class LobbySendInviteCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbySendInviteCallbackInfo = LobbySendInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbySendInviteCallbackInfo {
      val struct = LobbySendInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySendInviteCallbackInfo(block: LobbySendInviteCallbackInfo.() -> Unit = {}): LobbySendInviteCallbackInfo = LobbySendInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyRejectInviteOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyRejectInviteOptions = LobbyRejectInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyRejectInviteOptions {
      val struct = LobbyRejectInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyRejectInviteOptions(block: LobbyRejectInviteOptions.() -> Unit = {}): LobbyRejectInviteOptions = LobbyRejectInviteOptions.allocate().apply(block)

@JvmInline
public value class LobbyRejectInviteCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyRejectInviteCallbackInfo = LobbyRejectInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyRejectInviteCallbackInfo {
      val struct = LobbyRejectInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyRejectInviteCallbackInfo(block: LobbyRejectInviteCallbackInfo.() -> Unit = {}): LobbyRejectInviteCallbackInfo = LobbyRejectInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyQueryInvitesOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyQueryInvitesOptions = LobbyQueryInvitesOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyQueryInvitesOptions {
      val struct = LobbyQueryInvitesOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyQueryInvitesOptions(block: LobbyQueryInvitesOptions.() -> Unit = {}): LobbyQueryInvitesOptions = LobbyQueryInvitesOptions.allocate().apply(block)

@JvmInline
public value class LobbyQueryInvitesCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyQueryInvitesCallbackInfo = LobbyQueryInvitesCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyQueryInvitesCallbackInfo {
      val struct = LobbyQueryInvitesCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyQueryInvitesCallbackInfo(block: LobbyQueryInvitesCallbackInfo.() -> Unit = {}): LobbyQueryInvitesCallbackInfo = LobbyQueryInvitesCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyGetInviteCountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyGetInviteCountOptions = LobbyGetInviteCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyGetInviteCountOptions {
      val struct = LobbyGetInviteCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyGetInviteCountOptions(block: LobbyGetInviteCountOptions.() -> Unit = {}): LobbyGetInviteCountOptions = LobbyGetInviteCountOptions.allocate().apply(block)

@JvmInline
public value class LobbyGetInviteIdByIndexOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var index: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyGetInviteIdByIndexOptions = LobbyGetInviteIdByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyGetInviteIdByIndexOptions {
      val struct = LobbyGetInviteIdByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyGetInviteIdByIndexOptions(block: LobbyGetInviteIdByIndexOptions.() -> Unit = {}): LobbyGetInviteIdByIndexOptions = LobbyGetInviteIdByIndexOptions.allocate().apply(block)

@JvmInline
public value class LobbyCopyLobbyDetailsHandleOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyCopyLobbyDetailsHandleOptions = LobbyCopyLobbyDetailsHandleOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyCopyLobbyDetailsHandleOptions {
      val struct = LobbyCopyLobbyDetailsHandleOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCopyLobbyDetailsHandleOptions(block: LobbyCopyLobbyDetailsHandleOptions.() -> Unit = {}): LobbyCopyLobbyDetailsHandleOptions = LobbyCopyLobbyDetailsHandleOptions.allocate().apply(block)

@JvmInline
public value class LobbyGetRTCRoomNameOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyGetRTCRoomNameOptions = LobbyGetRTCRoomNameOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyGetRTCRoomNameOptions {
      val struct = LobbyGetRTCRoomNameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyGetRTCRoomNameOptions(block: LobbyGetRTCRoomNameOptions.() -> Unit = {}): LobbyGetRTCRoomNameOptions = LobbyGetRTCRoomNameOptions.allocate().apply(block)

@JvmInline
public value class LobbyIsRTCRoomConnectedOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyIsRTCRoomConnectedOptions = LobbyIsRTCRoomConnectedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyIsRTCRoomConnectedOptions {
      val struct = LobbyIsRTCRoomConnectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyIsRTCRoomConnectedOptions(block: LobbyIsRTCRoomConnectedOptions.() -> Unit = {}): LobbyIsRTCRoomConnectedOptions = LobbyIsRTCRoomConnectedOptions.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyRTCRoomConnectionChangedOptions(
  public val address: Long,
) {
  public var lobbyId_DEPRECATED: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId_DEPRECATED: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyAddNotifyRTCRoomConnectionChangedOptions =
        LobbyAddNotifyRTCRoomConnectionChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyRTCRoomConnectionChangedOptions {
      val struct = LobbyAddNotifyRTCRoomConnectionChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyRTCRoomConnectionChangedOptions(block: LobbyAddNotifyRTCRoomConnectionChangedOptions.() -> Unit = {}): LobbyAddNotifyRTCRoomConnectionChangedOptions = LobbyAddNotifyRTCRoomConnectionChangedOptions.allocate().apply(block)

@JvmInline
public value class LobbyRTCRoomConnectionChangedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var isConnected: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var disconnectReason: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address + 28))
    set(`value`) {
      RawMemory.putInt(address + 28, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyRTCRoomConnectionChangedCallbackInfo =
        LobbyRTCRoomConnectionChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyRTCRoomConnectionChangedCallbackInfo {
      val struct = LobbyRTCRoomConnectionChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyRTCRoomConnectionChangedCallbackInfo(block: LobbyRTCRoomConnectionChangedCallbackInfo.() -> Unit = {}): LobbyRTCRoomConnectionChangedCallbackInfo = LobbyRTCRoomConnectionChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyAttributeData(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var asInt64: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var asDouble: Double
    get() = RawMemory.getDouble(address + 16)
    set(`value`) {
      RawMemory.putDouble(address + 16, value)
    }

  public var asBool: Boolean
    get() = RawMemory.getInt(address + 16) != 0
    set(`value`) {
      RawMemory.putInt(address + 16, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var asUtf8: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var valueType: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyAttributeData = LobbyAttributeData(0)

    context(arena: Arena)
    public fun allocate(): LobbyAttributeData {
      val struct = LobbyAttributeData(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAttributeData(block: LobbyAttributeData.() -> Unit = {}): LobbyAttributeData = LobbyAttributeData.allocate().apply(block)

@JvmInline
public value class LobbyAttribute(
  public val address: Long,
) {
  public var `data`: LobbyAttributeData
    get() = LobbyAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var visibility: ELobbyAttributeVisibility
    get() = ELobbyAttributeVisibility(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyAttribute = LobbyAttribute(0)

    context(arena: Arena)
    public fun allocate(): LobbyAttribute {
      val struct = LobbyAttribute(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAttribute(block: LobbyAttribute.() -> Unit = {}): LobbyAttribute = LobbyAttribute.allocate().apply(block)

@JvmInline
public value class LobbyGetConnectStringOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyGetConnectStringOptions = LobbyGetConnectStringOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyGetConnectStringOptions {
      val struct = LobbyGetConnectStringOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyGetConnectStringOptions(block: LobbyGetConnectStringOptions.() -> Unit = {}): LobbyGetConnectStringOptions = LobbyGetConnectStringOptions.allocate().apply(block)

@JvmInline
public value class LobbyParseConnectStringOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var connectString: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyParseConnectStringOptions = LobbyParseConnectStringOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyParseConnectStringOptions {
      val struct = LobbyParseConnectStringOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyParseConnectStringOptions(block: LobbyParseConnectStringOptions.() -> Unit = {}): LobbyParseConnectStringOptions = LobbyParseConnectStringOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationSetBucketIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var bucketId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyModificationSetBucketIdOptions = LobbyModificationSetBucketIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationSetBucketIdOptions {
      val struct = LobbyModificationSetBucketIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationSetBucketIdOptions(block: LobbyModificationSetBucketIdOptions.() -> Unit = {}): LobbyModificationSetBucketIdOptions = LobbyModificationSetBucketIdOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationSetPermissionLevelOptions(
  public val address: Long,
) {
  public var permissionLevel: ELobbyPermissionLevel
    get() = ELobbyPermissionLevel(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyModificationSetPermissionLevelOptions =
        LobbyModificationSetPermissionLevelOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationSetPermissionLevelOptions {
      val struct = LobbyModificationSetPermissionLevelOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationSetPermissionLevelOptions(block: LobbyModificationSetPermissionLevelOptions.() -> Unit = {}): LobbyModificationSetPermissionLevelOptions = LobbyModificationSetPermissionLevelOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationSetMaxMembersOptions(
  public val address: Long,
) {
  public var maxMembers: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyModificationSetMaxMembersOptions =
        LobbyModificationSetMaxMembersOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationSetMaxMembersOptions {
      val struct = LobbyModificationSetMaxMembersOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationSetMaxMembersOptions(block: LobbyModificationSetMaxMembersOptions.() -> Unit = {}): LobbyModificationSetMaxMembersOptions = LobbyModificationSetMaxMembersOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationSetInvitesAllowedOptions(
  public val address: Long,
) {
  public var invitesAllowed: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyModificationSetInvitesAllowedOptions =
        LobbyModificationSetInvitesAllowedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationSetInvitesAllowedOptions {
      val struct = LobbyModificationSetInvitesAllowedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationSetInvitesAllowedOptions(block: LobbyModificationSetInvitesAllowedOptions.() -> Unit = {}): LobbyModificationSetInvitesAllowedOptions = LobbyModificationSetInvitesAllowedOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationAddAttributeOptions(
  public val address: Long,
) {
  public var attribute: LobbyAttributeData
    get() = LobbyAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var visibility: ELobbyAttributeVisibility
    get() = ELobbyAttributeVisibility(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyModificationAddAttributeOptions = LobbyModificationAddAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationAddAttributeOptions {
      val struct = LobbyModificationAddAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationAddAttributeOptions(block: LobbyModificationAddAttributeOptions.() -> Unit = {}): LobbyModificationAddAttributeOptions = LobbyModificationAddAttributeOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationRemoveAttributeOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyModificationRemoveAttributeOptions =
        LobbyModificationRemoveAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationRemoveAttributeOptions {
      val struct = LobbyModificationRemoveAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationRemoveAttributeOptions(block: LobbyModificationRemoveAttributeOptions.() -> Unit = {}): LobbyModificationRemoveAttributeOptions = LobbyModificationRemoveAttributeOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationAddMemberAttributeOptions(
  public val address: Long,
) {
  public var attribute: LobbyAttributeData
    get() = LobbyAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var visibility: ELobbyAttributeVisibility
    get() = ELobbyAttributeVisibility(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyModificationAddMemberAttributeOptions =
        LobbyModificationAddMemberAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationAddMemberAttributeOptions {
      val struct = LobbyModificationAddMemberAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationAddMemberAttributeOptions(block: LobbyModificationAddMemberAttributeOptions.() -> Unit = {}): LobbyModificationAddMemberAttributeOptions = LobbyModificationAddMemberAttributeOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationRemoveMemberAttributeOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyModificationRemoveMemberAttributeOptions =
        LobbyModificationRemoveMemberAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationRemoveMemberAttributeOptions {
      val struct = LobbyModificationRemoveMemberAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationRemoveMemberAttributeOptions(block: LobbyModificationRemoveMemberAttributeOptions.() -> Unit = {}): LobbyModificationRemoveMemberAttributeOptions = LobbyModificationRemoveMemberAttributeOptions.allocate().apply(block)

@JvmInline
public value class LobbyModificationSetAllowedPlatformIdsOptions(
  public val address: Long,
) {
  public var allowedPlatformIds: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var allowedPlatformIdsCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyModificationSetAllowedPlatformIdsOptions =
        LobbyModificationSetAllowedPlatformIdsOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyModificationSetAllowedPlatformIdsOptions {
      val struct = LobbyModificationSetAllowedPlatformIdsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyModificationSetAllowedPlatformIdsOptions(block: LobbyModificationSetAllowedPlatformIdsOptions.() -> Unit = {}): LobbyModificationSetAllowedPlatformIdsOptions = LobbyModificationSetAllowedPlatformIdsOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsGetLobbyOwnerOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyDetailsGetLobbyOwnerOptions = LobbyDetailsGetLobbyOwnerOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsGetLobbyOwnerOptions {
      val struct = LobbyDetailsGetLobbyOwnerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsGetLobbyOwnerOptions(block: LobbyDetailsGetLobbyOwnerOptions.() -> Unit = {}): LobbyDetailsGetLobbyOwnerOptions = LobbyDetailsGetLobbyOwnerOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyInfoOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyDetailsCopyInfoOptions = LobbyDetailsCopyInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyInfoOptions {
      val struct = LobbyDetailsCopyInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyInfoOptions(block: LobbyDetailsCopyInfoOptions.() -> Unit = {}): LobbyDetailsCopyInfoOptions = LobbyDetailsCopyInfoOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsGetAttributeCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyDetailsGetAttributeCountOptions = LobbyDetailsGetAttributeCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsGetAttributeCountOptions {
      val struct = LobbyDetailsGetAttributeCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsGetAttributeCountOptions(block: LobbyDetailsGetAttributeCountOptions.() -> Unit = {}): LobbyDetailsGetAttributeCountOptions = LobbyDetailsGetAttributeCountOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyAttributeByIndexOptions(
  public val address: Long,
) {
  public var attrIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyDetailsCopyAttributeByIndexOptions =
        LobbyDetailsCopyAttributeByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyAttributeByIndexOptions {
      val struct = LobbyDetailsCopyAttributeByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyAttributeByIndexOptions(block: LobbyDetailsCopyAttributeByIndexOptions.() -> Unit = {}): LobbyDetailsCopyAttributeByIndexOptions = LobbyDetailsCopyAttributeByIndexOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyAttributeByKeyOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var attrKey: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyDetailsCopyAttributeByKeyOptions =
        LobbyDetailsCopyAttributeByKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyAttributeByKeyOptions {
      val struct = LobbyDetailsCopyAttributeByKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyAttributeByKeyOptions(block: LobbyDetailsCopyAttributeByKeyOptions.() -> Unit = {}): LobbyDetailsCopyAttributeByKeyOptions = LobbyDetailsCopyAttributeByKeyOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsGetMemberAttributeCountOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyDetailsGetMemberAttributeCountOptions =
        LobbyDetailsGetMemberAttributeCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsGetMemberAttributeCountOptions {
      val struct = LobbyDetailsGetMemberAttributeCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsGetMemberAttributeCountOptions(block: LobbyDetailsGetMemberAttributeCountOptions.() -> Unit = {}): LobbyDetailsGetMemberAttributeCountOptions = LobbyDetailsGetMemberAttributeCountOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyMemberAttributeByIndexOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var attrIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyDetailsCopyMemberAttributeByIndexOptions =
        LobbyDetailsCopyMemberAttributeByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyMemberAttributeByIndexOptions {
      val struct = LobbyDetailsCopyMemberAttributeByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyMemberAttributeByIndexOptions(block: LobbyDetailsCopyMemberAttributeByIndexOptions.() -> Unit = {}): LobbyDetailsCopyMemberAttributeByIndexOptions = LobbyDetailsCopyMemberAttributeByIndexOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyMemberAttributeByKeyOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var attrKey: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyDetailsCopyMemberAttributeByKeyOptions =
        LobbyDetailsCopyMemberAttributeByKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyMemberAttributeByKeyOptions {
      val struct = LobbyDetailsCopyMemberAttributeByKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyMemberAttributeByKeyOptions(block: LobbyDetailsCopyMemberAttributeByKeyOptions.() -> Unit = {}): LobbyDetailsCopyMemberAttributeByKeyOptions = LobbyDetailsCopyMemberAttributeByKeyOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsGetMemberCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyDetailsGetMemberCountOptions = LobbyDetailsGetMemberCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsGetMemberCountOptions {
      val struct = LobbyDetailsGetMemberCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsGetMemberCountOptions(block: LobbyDetailsGetMemberCountOptions.() -> Unit = {}): LobbyDetailsGetMemberCountOptions = LobbyDetailsGetMemberCountOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsGetMemberByIndexOptions(
  public val address: Long,
) {
  public var memberIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbyDetailsGetMemberByIndexOptions = LobbyDetailsGetMemberByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsGetMemberByIndexOptions {
      val struct = LobbyDetailsGetMemberByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsGetMemberByIndexOptions(block: LobbyDetailsGetMemberByIndexOptions.() -> Unit = {}): LobbyDetailsGetMemberByIndexOptions = LobbyDetailsGetMemberByIndexOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchFindOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbySearchFindOptions = LobbySearchFindOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchFindOptions {
      val struct = LobbySearchFindOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchFindOptions(block: LobbySearchFindOptions.() -> Unit = {}): LobbySearchFindOptions = LobbySearchFindOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchFindCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbySearchFindCallbackInfo = LobbySearchFindCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchFindCallbackInfo {
      val struct = LobbySearchFindCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchFindCallbackInfo(block: LobbySearchFindCallbackInfo.() -> Unit = {}): LobbySearchFindCallbackInfo = LobbySearchFindCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbySearchSetLobbyIdOptions(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbySearchSetLobbyIdOptions = LobbySearchSetLobbyIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchSetLobbyIdOptions {
      val struct = LobbySearchSetLobbyIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchSetLobbyIdOptions(block: LobbySearchSetLobbyIdOptions.() -> Unit = {}): LobbySearchSetLobbyIdOptions = LobbySearchSetLobbyIdOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchSetTargetUserIdOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbySearchSetTargetUserIdOptions = LobbySearchSetTargetUserIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchSetTargetUserIdOptions {
      val struct = LobbySearchSetTargetUserIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchSetTargetUserIdOptions(block: LobbySearchSetTargetUserIdOptions.() -> Unit = {}): LobbySearchSetTargetUserIdOptions = LobbySearchSetTargetUserIdOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchSetParameterOptions(
  public val address: Long,
) {
  public var parameter: LobbyAttributeData
    get() = LobbyAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var comparisonOp: EComparisonOp
    get() = EComparisonOp(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbySearchSetParameterOptions = LobbySearchSetParameterOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchSetParameterOptions {
      val struct = LobbySearchSetParameterOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchSetParameterOptions(block: LobbySearchSetParameterOptions.() -> Unit = {}): LobbySearchSetParameterOptions = LobbySearchSetParameterOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchRemoveParameterOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var comparisonOp: EComparisonOp
    get() = EComparisonOp(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbySearchRemoveParameterOptions = LobbySearchRemoveParameterOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchRemoveParameterOptions {
      val struct = LobbySearchRemoveParameterOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchRemoveParameterOptions(block: LobbySearchRemoveParameterOptions.() -> Unit = {}): LobbySearchRemoveParameterOptions = LobbySearchRemoveParameterOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchSetMaxResultsOptions(
  public val address: Long,
) {
  public var maxResults: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbySearchSetMaxResultsOptions = LobbySearchSetMaxResultsOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchSetMaxResultsOptions {
      val struct = LobbySearchSetMaxResultsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchSetMaxResultsOptions(block: LobbySearchSetMaxResultsOptions.() -> Unit = {}): LobbySearchSetMaxResultsOptions = LobbySearchSetMaxResultsOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchGetSearchResultCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbySearchGetSearchResultCountOptions =
        LobbySearchGetSearchResultCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchGetSearchResultCountOptions {
      val struct = LobbySearchGetSearchResultCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchGetSearchResultCountOptions(block: LobbySearchGetSearchResultCountOptions.() -> Unit = {}): LobbySearchGetSearchResultCountOptions = LobbySearchGetSearchResultCountOptions.allocate().apply(block)

@JvmInline
public value class LobbySearchCopySearchResultByIndexOptions(
  public val address: Long,
) {
  public var lobbyIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LobbySearchCopySearchResultByIndexOptions =
        LobbySearchCopySearchResultByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbySearchCopySearchResultByIndexOptions {
      val struct = LobbySearchCopySearchResultByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbySearchCopySearchResultByIndexOptions(block: LobbySearchCopySearchResultByIndexOptions.() -> Unit = {}): LobbySearchCopySearchResultByIndexOptions = LobbySearchCopySearchResultByIndexOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsCopyMemberInfoOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyDetailsCopyMemberInfoOptions = LobbyDetailsCopyMemberInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsCopyMemberInfoOptions {
      val struct = LobbyDetailsCopyMemberInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsCopyMemberInfoOptions(block: LobbyDetailsCopyMemberInfoOptions.() -> Unit = {}): LobbyDetailsCopyMemberInfoOptions = LobbyDetailsCopyMemberInfoOptions.allocate().apply(block)

@JvmInline
public value class LobbyDetailsMemberInfo(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var platform: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var allowsCrossplay: Boolean
    get() = RawMemory.getInt(address + 20) != 0
    set(`value`) {
      RawMemory.putInt(address + 20, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyDetailsMemberInfo = LobbyDetailsMemberInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsMemberInfo {
      val struct = LobbyDetailsMemberInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsMemberInfo(block: LobbyDetailsMemberInfo.() -> Unit = {}): LobbyDetailsMemberInfo = LobbyDetailsMemberInfo.allocate().apply(block)

@JvmInline
public value class LobbyAddNotifyLeaveLobbyRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LobbyAddNotifyLeaveLobbyRequestedOptions =
        LobbyAddNotifyLeaveLobbyRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyAddNotifyLeaveLobbyRequestedOptions {
      val struct = LobbyAddNotifyLeaveLobbyRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyAddNotifyLeaveLobbyRequestedOptions(block: LobbyAddNotifyLeaveLobbyRequestedOptions.() -> Unit = {}): LobbyAddNotifyLeaveLobbyRequestedOptions = LobbyAddNotifyLeaveLobbyRequestedOptions.allocate().apply(block)

@JvmInline
public value class LobbyLeaveLobbyRequestedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LobbyLeaveLobbyRequestedCallbackInfo = LobbyLeaveLobbyRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLeaveLobbyRequestedCallbackInfo {
      val struct = LobbyLeaveLobbyRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLeaveLobbyRequestedCallbackInfo(block: LobbyLeaveLobbyRequestedCallbackInfo.() -> Unit = {}): LobbyLeaveLobbyRequestedCallbackInfo = LobbyLeaveLobbyRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LogMessage(
  public val address: Long,
) {
  context(arena: Arena)
  public var category: String?
    get() = RawMemory.getLong(address).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var message: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var level: ELogLevel
    get() = ELogLevel(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LogMessage = LogMessage(0)

    context(arena: Arena)
    public fun allocate(): LogMessage {
      val struct = LogMessage(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LogMessage(block: LogMessage.() -> Unit = {}): LogMessage = LogMessage.allocate().apply(block)

@JvmInline
public value class MetricsBeginPlayerSessionOptions(
  public val address: Long,
) {
  public var accountIdType: EMetricsAccountIdType
    get() = EMetricsAccountIdType(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var epic: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var `external`: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var controllerType: EUserControllerType
    get() = EUserControllerType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  context(arena: Arena)
  public var serverIp: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var gameSessionId: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: MetricsBeginPlayerSessionOptions = MetricsBeginPlayerSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): MetricsBeginPlayerSessionOptions {
      val struct = MetricsBeginPlayerSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun MetricsBeginPlayerSessionOptions(block: MetricsBeginPlayerSessionOptions.() -> Unit = {}): MetricsBeginPlayerSessionOptions = MetricsBeginPlayerSessionOptions.allocate().apply(block)

@JvmInline
public value class MetricsEndPlayerSessionOptions(
  public val address: Long,
) {
  public var accountIdType: EMetricsAccountIdType
    get() = EMetricsAccountIdType(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var epic: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var `external`: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: MetricsEndPlayerSessionOptions = MetricsEndPlayerSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): MetricsEndPlayerSessionOptions {
      val struct = MetricsEndPlayerSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun MetricsEndPlayerSessionOptions(block: MetricsEndPlayerSessionOptions.() -> Unit = {}): MetricsEndPlayerSessionOptions = MetricsEndPlayerSessionOptions.allocate().apply(block)

@JvmInline
public value class ModIdentifier(
  public val address: Long,
) {
  context(arena: Arena)
  public var namespaceId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var itemId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var artifactId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var title: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var version: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: ModIdentifier = ModIdentifier(0)

    context(arena: Arena)
    public fun allocate(): ModIdentifier {
      val struct = ModIdentifier(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModIdentifier(block: ModIdentifier.() -> Unit = {}): ModIdentifier = ModIdentifier.allocate().apply(block)

@JvmInline
public value class ModsInstallModOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public var removeAfterExit: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ModsInstallModOptions = ModsInstallModOptions(0)

    context(arena: Arena)
    public fun allocate(): ModsInstallModOptions {
      val struct = ModsInstallModOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsInstallModOptions(block: ModsInstallModOptions.() -> Unit = {}): ModsInstallModOptions = ModsInstallModOptions.allocate().apply(block)

@JvmInline
public value class ModsInstallModCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ModsInstallModCallbackInfo = ModsInstallModCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ModsInstallModCallbackInfo {
      val struct = ModsInstallModCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsInstallModCallbackInfo(block: ModsInstallModCallbackInfo.() -> Unit = {}): ModsInstallModCallbackInfo = ModsInstallModCallbackInfo.allocate().apply(block)

@JvmInline
public value class ModsUninstallModOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ModsUninstallModOptions = ModsUninstallModOptions(0)

    context(arena: Arena)
    public fun allocate(): ModsUninstallModOptions {
      val struct = ModsUninstallModOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsUninstallModOptions(block: ModsUninstallModOptions.() -> Unit = {}): ModsUninstallModOptions = ModsUninstallModOptions.allocate().apply(block)

@JvmInline
public value class ModsUninstallModCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ModsUninstallModCallbackInfo = ModsUninstallModCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ModsUninstallModCallbackInfo {
      val struct = ModsUninstallModCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsUninstallModCallbackInfo(block: ModsUninstallModCallbackInfo.() -> Unit = {}): ModsUninstallModCallbackInfo = ModsUninstallModCallbackInfo.allocate().apply(block)

@JvmInline
public value class ModsEnumerateModsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var type: EModEnumerationType
    get() = EModEnumerationType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ModsEnumerateModsOptions = ModsEnumerateModsOptions(0)

    context(arena: Arena)
    public fun allocate(): ModsEnumerateModsOptions {
      val struct = ModsEnumerateModsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsEnumerateModsOptions(block: ModsEnumerateModsOptions.() -> Unit = {}): ModsEnumerateModsOptions = ModsEnumerateModsOptions.allocate().apply(block)

@JvmInline
public value class ModsEnumerateModsCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var type: EModEnumerationType
    get() = EModEnumerationType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ModsEnumerateModsCallbackInfo = ModsEnumerateModsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ModsEnumerateModsCallbackInfo {
      val struct = ModsEnumerateModsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsEnumerateModsCallbackInfo(block: ModsEnumerateModsCallbackInfo.() -> Unit = {}): ModsEnumerateModsCallbackInfo = ModsEnumerateModsCallbackInfo.allocate().apply(block)

@JvmInline
public value class ModsCopyModInfoOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var type: EModEnumerationType
    get() = EModEnumerationType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ModsCopyModInfoOptions = ModsCopyModInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): ModsCopyModInfoOptions {
      val struct = ModsCopyModInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsCopyModInfoOptions(block: ModsCopyModInfoOptions.() -> Unit = {}): ModsCopyModInfoOptions = ModsCopyModInfoOptions.allocate().apply(block)

@JvmInline
public value class ModsModInfo(
  public val address: Long,
) {
  public var modsCount: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var mods: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var type: EModEnumerationType
    get() = EModEnumerationType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ModsModInfo = ModsModInfo(0)

    context(arena: Arena)
    public fun allocate(): ModsModInfo {
      val struct = ModsModInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsModInfo(block: ModsModInfo.() -> Unit = {}): ModsModInfo = ModsModInfo.allocate().apply(block)

@JvmInline
public value class ModsUpdateModOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ModsUpdateModOptions = ModsUpdateModOptions(0)

    context(arena: Arena)
    public fun allocate(): ModsUpdateModOptions {
      val struct = ModsUpdateModOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsUpdateModOptions(block: ModsUpdateModOptions.() -> Unit = {}): ModsUpdateModOptions = ModsUpdateModOptions.allocate().apply(block)

@JvmInline
public value class ModsUpdateModCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var mod: ModIdentifier
    get() = ModIdentifier(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ModsUpdateModCallbackInfo = ModsUpdateModCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ModsUpdateModCallbackInfo {
      val struct = ModsUpdateModCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ModsUpdateModCallbackInfo(block: ModsUpdateModCallbackInfo.() -> Unit = {}): ModsUpdateModCallbackInfo = ModsUpdateModCallbackInfo.allocate().apply(block)

@JvmInline
public value class P2PSocketId(
  public val address: Long,
) {
  public val socketName: String
    get() = MemorySegment.ofAddress(address + 4).reinterpret(33).getString(0)

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: P2PSocketId = P2PSocketId(0)

    context(arena: Arena)
    public fun allocate(): P2PSocketId {
      val struct = P2PSocketId(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PSocketId(block: P2PSocketId.() -> Unit = {}): P2PSocketId = P2PSocketId.allocate().apply(block)

@JvmInline
public value class P2PSendPacketOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var remoteUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var socketId: P2PSocketId
    get() = P2PSocketId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var channel: Byte
    get() = RawMemory.getByte(address + 32)
    set(`value`) {
      RawMemory.putByte(address + 32, value)
    }

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 36)
    set(`value`) {
      RawMemory.putInt(address + 36, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public var allowDelayedDelivery: Boolean
    get() = RawMemory.getInt(address + 48) != 0
    set(`value`) {
      RawMemory.putInt(address + 48, if (value) 1 else 0)
    }

  public var reliability: EPacketReliability
    get() = EPacketReliability(RawMemory.getInt(address + 52))
    set(`value`) {
      RawMemory.putInt(address + 52, value.value)
    }

  public var disableAutoAcceptConnection: Boolean
    get() = RawMemory.getInt(address + 56) != 0
    set(`value`) {
      RawMemory.putInt(address + 56, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 64

    public val NULL: P2PSendPacketOptions = P2PSendPacketOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PSendPacketOptions {
      val struct = P2PSendPacketOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PSendPacketOptions(block: P2PSendPacketOptions.() -> Unit = {}): P2PSendPacketOptions = P2PSendPacketOptions.allocate().apply(block)

@JvmInline
public value class P2PGetNextReceivedPacketSizeOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var requestedChannel: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: P2PGetNextReceivedPacketSizeOptions = P2PGetNextReceivedPacketSizeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PGetNextReceivedPacketSizeOptions {
      val struct = P2PGetNextReceivedPacketSizeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PGetNextReceivedPacketSizeOptions(block: P2PGetNextReceivedPacketSizeOptions.() -> Unit = {}): P2PGetNextReceivedPacketSizeOptions = P2PGetNextReceivedPacketSizeOptions.allocate().apply(block)

@JvmInline
public value class P2PReceivePacketOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var maxDataSizeBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var requestedChannel: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: P2PReceivePacketOptions = P2PReceivePacketOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PReceivePacketOptions {
      val struct = P2PReceivePacketOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PReceivePacketOptions(block: P2PReceivePacketOptions.() -> Unit = {}): P2PReceivePacketOptions = P2PReceivePacketOptions.allocate().apply(block)

@JvmInline
public value class P2PAddNotifyPeerConnectionRequestOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var socketId: P2PSocketId
    get() = P2PSocketId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: P2PAddNotifyPeerConnectionRequestOptions =
        P2PAddNotifyPeerConnectionRequestOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAddNotifyPeerConnectionRequestOptions {
      val struct = P2PAddNotifyPeerConnectionRequestOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAddNotifyPeerConnectionRequestOptions(block: P2PAddNotifyPeerConnectionRequestOptions.() -> Unit = {}): P2PAddNotifyPeerConnectionRequestOptions = P2PAddNotifyPeerConnectionRequestOptions.allocate().apply(block)

@JvmInline
public value class P2POnIncomingConnectionRequestInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var remoteUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var socketId: P2PSocketId
    get() = P2PSocketId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: P2POnIncomingConnectionRequestInfo = P2POnIncomingConnectionRequestInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnIncomingConnectionRequestInfo {
      val struct = P2POnIncomingConnectionRequestInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnIncomingConnectionRequestInfo(block: P2POnIncomingConnectionRequestInfo.() -> Unit = {}): P2POnIncomingConnectionRequestInfo = P2POnIncomingConnectionRequestInfo.allocate().apply(block)

@JvmInline
public value class P2PAddNotifyPeerConnectionEstablishedOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var socketId: P2PSocketId
    get() = P2PSocketId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: P2PAddNotifyPeerConnectionEstablishedOptions =
        P2PAddNotifyPeerConnectionEstablishedOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAddNotifyPeerConnectionEstablishedOptions {
      val struct = P2PAddNotifyPeerConnectionEstablishedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAddNotifyPeerConnectionEstablishedOptions(block: P2PAddNotifyPeerConnectionEstablishedOptions.() -> Unit = {}): P2PAddNotifyPeerConnectionEstablishedOptions = P2PAddNotifyPeerConnectionEstablishedOptions.allocate().apply(block)

@JvmInline
public value class P2POnPeerConnectionEstablishedInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var remoteUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var socketId: P2PSocketId
    get() = P2PSocketId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var connectionType: EConnectionEstablishedType
    get() = EConnectionEstablishedType(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public var networkType: ENetworkConnectionType
    get() = ENetworkConnectionType(RawMemory.getInt(address + 36))
    set(`value`) {
      RawMemory.putInt(address + 36, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: P2POnPeerConnectionEstablishedInfo = P2POnPeerConnectionEstablishedInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnPeerConnectionEstablishedInfo {
      val struct = P2POnPeerConnectionEstablishedInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnPeerConnectionEstablishedInfo(block: P2POnPeerConnectionEstablishedInfo.() -> Unit = {}): P2POnPeerConnectionEstablishedInfo = P2POnPeerConnectionEstablishedInfo.allocate().apply(block)
