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
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class P2PAddNotifyPeerConnectionInterruptedOptions(
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

    public val NULL: P2PAddNotifyPeerConnectionInterruptedOptions =
        P2PAddNotifyPeerConnectionInterruptedOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAddNotifyPeerConnectionInterruptedOptions {
      val struct = P2PAddNotifyPeerConnectionInterruptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAddNotifyPeerConnectionInterruptedOptions(block: P2PAddNotifyPeerConnectionInterruptedOptions.() -> Unit = {}): P2PAddNotifyPeerConnectionInterruptedOptions = P2PAddNotifyPeerConnectionInterruptedOptions.allocate().apply(block)

@JvmInline
public value class P2POnPeerConnectionInterruptedInfo(
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

    public val NULL: P2POnPeerConnectionInterruptedInfo = P2POnPeerConnectionInterruptedInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnPeerConnectionInterruptedInfo {
      val struct = P2POnPeerConnectionInterruptedInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnPeerConnectionInterruptedInfo(block: P2POnPeerConnectionInterruptedInfo.() -> Unit = {}): P2POnPeerConnectionInterruptedInfo = P2POnPeerConnectionInterruptedInfo.allocate().apply(block)

@JvmInline
public value class P2PAddNotifyPeerConnectionClosedOptions(
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

    public val NULL: P2PAddNotifyPeerConnectionClosedOptions =
        P2PAddNotifyPeerConnectionClosedOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAddNotifyPeerConnectionClosedOptions {
      val struct = P2PAddNotifyPeerConnectionClosedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAddNotifyPeerConnectionClosedOptions(block: P2PAddNotifyPeerConnectionClosedOptions.() -> Unit = {}): P2PAddNotifyPeerConnectionClosedOptions = P2PAddNotifyPeerConnectionClosedOptions.allocate().apply(block)

@JvmInline
public value class P2POnRemoteConnectionClosedInfo(
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

  public var reason: EConnectionClosedReason
    get() = EConnectionClosedReason(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: P2POnRemoteConnectionClosedInfo = P2POnRemoteConnectionClosedInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnRemoteConnectionClosedInfo {
      val struct = P2POnRemoteConnectionClosedInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnRemoteConnectionClosedInfo(block: P2POnRemoteConnectionClosedInfo.() -> Unit = {}): P2POnRemoteConnectionClosedInfo = P2POnRemoteConnectionClosedInfo.allocate().apply(block)

@JvmInline
public value class P2PAcceptConnectionOptions(
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

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: P2PAcceptConnectionOptions = P2PAcceptConnectionOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAcceptConnectionOptions {
      val struct = P2PAcceptConnectionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAcceptConnectionOptions(block: P2PAcceptConnectionOptions.() -> Unit = {}): P2PAcceptConnectionOptions = P2PAcceptConnectionOptions.allocate().apply(block)

@JvmInline
public value class P2PCloseConnectionOptions(
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

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: P2PCloseConnectionOptions = P2PCloseConnectionOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PCloseConnectionOptions {
      val struct = P2PCloseConnectionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PCloseConnectionOptions(block: P2PCloseConnectionOptions.() -> Unit = {}): P2PCloseConnectionOptions = P2PCloseConnectionOptions.allocate().apply(block)

@JvmInline
public value class P2PCloseConnectionsOptions(
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

    public val NULL: P2PCloseConnectionsOptions = P2PCloseConnectionsOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PCloseConnectionsOptions {
      val struct = P2PCloseConnectionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PCloseConnectionsOptions(block: P2PCloseConnectionsOptions.() -> Unit = {}): P2PCloseConnectionsOptions = P2PCloseConnectionsOptions.allocate().apply(block)

@JvmInline
public value class P2PQueryNATTypeOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PQueryNATTypeOptions = P2PQueryNATTypeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PQueryNATTypeOptions {
      val struct = P2PQueryNATTypeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PQueryNATTypeOptions(block: P2PQueryNATTypeOptions.() -> Unit = {}): P2PQueryNATTypeOptions = P2PQueryNATTypeOptions.allocate().apply(block)

@JvmInline
public value class P2POnQueryNATTypeCompleteInfo(
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

  public var nATType: ENATType
    get() = ENATType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: P2POnQueryNATTypeCompleteInfo = P2POnQueryNATTypeCompleteInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnQueryNATTypeCompleteInfo {
      val struct = P2POnQueryNATTypeCompleteInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnQueryNATTypeCompleteInfo(block: P2POnQueryNATTypeCompleteInfo.() -> Unit = {}): P2POnQueryNATTypeCompleteInfo = P2POnQueryNATTypeCompleteInfo.allocate().apply(block)

@JvmInline
public value class P2PGetNATTypeOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PGetNATTypeOptions = P2PGetNATTypeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PGetNATTypeOptions {
      val struct = P2PGetNATTypeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PGetNATTypeOptions(block: P2PGetNATTypeOptions.() -> Unit = {}): P2PGetNATTypeOptions = P2PGetNATTypeOptions.allocate().apply(block)

@JvmInline
public value class P2PSetRelayControlOptions(
  public val address: Long,
) {
  public var relayControl: ERelayControl
    get() = ERelayControl(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: P2PSetRelayControlOptions = P2PSetRelayControlOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PSetRelayControlOptions {
      val struct = P2PSetRelayControlOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PSetRelayControlOptions(block: P2PSetRelayControlOptions.() -> Unit = {}): P2PSetRelayControlOptions = P2PSetRelayControlOptions.allocate().apply(block)

@JvmInline
public value class P2PGetRelayControlOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PGetRelayControlOptions = P2PGetRelayControlOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PGetRelayControlOptions {
      val struct = P2PGetRelayControlOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PGetRelayControlOptions(block: P2PGetRelayControlOptions.() -> Unit = {}): P2PGetRelayControlOptions = P2PGetRelayControlOptions.allocate().apply(block)

@JvmInline
public value class P2PSetPortRangeOptions(
  public val address: Long,
) {
  public var port: Short
    get() = RawMemory.getShort(address + 4)
    set(`value`) {
      RawMemory.putShort(address + 4, value)
    }

  public var maxAdditionalPortsToTry: Short
    get() = RawMemory.getShort(address + 6)
    set(`value`) {
      RawMemory.putShort(address + 6, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: P2PSetPortRangeOptions = P2PSetPortRangeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PSetPortRangeOptions {
      val struct = P2PSetPortRangeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PSetPortRangeOptions(block: P2PSetPortRangeOptions.() -> Unit = {}): P2PSetPortRangeOptions = P2PSetPortRangeOptions.allocate().apply(block)

@JvmInline
public value class P2PGetPortRangeOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PGetPortRangeOptions = P2PGetPortRangeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PGetPortRangeOptions {
      val struct = P2PGetPortRangeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PGetPortRangeOptions(block: P2PGetPortRangeOptions.() -> Unit = {}): P2PGetPortRangeOptions = P2PGetPortRangeOptions.allocate().apply(block)

@JvmInline
public value class P2PSetPacketQueueSizeOptions(
  public val address: Long,
) {
  public var incomingPacketQueueMaxSizeBytes: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var outgoingPacketQueueMaxSizeBytes: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: P2PSetPacketQueueSizeOptions = P2PSetPacketQueueSizeOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PSetPacketQueueSizeOptions {
      val struct = P2PSetPacketQueueSizeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PSetPacketQueueSizeOptions(block: P2PSetPacketQueueSizeOptions.() -> Unit = {}): P2PSetPacketQueueSizeOptions = P2PSetPacketQueueSizeOptions.allocate().apply(block)

@JvmInline
public value class P2PGetPacketQueueInfoOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PGetPacketQueueInfoOptions = P2PGetPacketQueueInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PGetPacketQueueInfoOptions {
      val struct = P2PGetPacketQueueInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PGetPacketQueueInfoOptions(block: P2PGetPacketQueueInfoOptions.() -> Unit = {}): P2PGetPacketQueueInfoOptions = P2PGetPacketQueueInfoOptions.allocate().apply(block)

@JvmInline
public value class P2PPacketQueueInfo(
  public val address: Long,
) {
  public var incomingPacketQueueMaxSizeBytes: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var incomingPacketQueueCurrentSizeBytes: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var incomingPacketQueueCurrentPacketCount: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var outgoingPacketQueueMaxSizeBytes: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var outgoingPacketQueueCurrentSizeBytes: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var outgoingPacketQueueCurrentPacketCount: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: P2PPacketQueueInfo = P2PPacketQueueInfo(0)

    context(arena: Arena)
    public fun allocate(): P2PPacketQueueInfo {
      val struct = P2PPacketQueueInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PPacketQueueInfo(block: P2PPacketQueueInfo.() -> Unit = {}): P2PPacketQueueInfo = P2PPacketQueueInfo.allocate().apply(block)

@JvmInline
public value class P2PAddNotifyIncomingPacketQueueFullOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: P2PAddNotifyIncomingPacketQueueFullOptions =
        P2PAddNotifyIncomingPacketQueueFullOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PAddNotifyIncomingPacketQueueFullOptions {
      val struct = P2PAddNotifyIncomingPacketQueueFullOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PAddNotifyIncomingPacketQueueFullOptions(block: P2PAddNotifyIncomingPacketQueueFullOptions.() -> Unit = {}): P2PAddNotifyIncomingPacketQueueFullOptions = P2PAddNotifyIncomingPacketQueueFullOptions.allocate().apply(block)

@JvmInline
public value class P2POnIncomingPacketQueueFullInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var packetQueueMaxSizeBytes: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var packetQueueCurrentSizeBytes: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var overflowPacketLocalUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var overflowPacketChannel: Byte
    get() = RawMemory.getByte(address + 32)
    set(`value`) {
      RawMemory.putByte(address + 32, value)
    }

  public var overflowPacketSizeBytes: Int
    get() = RawMemory.getInt(address + 36)
    set(`value`) {
      RawMemory.putInt(address + 36, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: P2POnIncomingPacketQueueFullInfo = P2POnIncomingPacketQueueFullInfo(0)

    context(arena: Arena)
    public fun allocate(): P2POnIncomingPacketQueueFullInfo {
      val struct = P2POnIncomingPacketQueueFullInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2POnIncomingPacketQueueFullInfo(block: P2POnIncomingPacketQueueFullInfo.() -> Unit = {}): P2POnIncomingPacketQueueFullInfo = P2POnIncomingPacketQueueFullInfo.allocate().apply(block)

@JvmInline
public value class P2PClearPacketQueueOptions(
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

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: P2PClearPacketQueueOptions = P2PClearPacketQueueOptions(0)

    context(arena: Arena)
    public fun allocate(): P2PClearPacketQueueOptions {
      val struct = P2PClearPacketQueueOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun P2PClearPacketQueueOptions(block: P2PClearPacketQueueOptions.() -> Unit = {}): P2PClearPacketQueueOptions = P2PClearPacketQueueOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageFileMetadata(
  public val address: Long,
) {
  public var fileSizeBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var mD5Hash: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var lastModifiedTime: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var unencryptedDataSizeBytes: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: PlayerDataStorageFileMetadata = PlayerDataStorageFileMetadata(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageFileMetadata {
      val struct = PlayerDataStorageFileMetadata(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageFileMetadata(block: PlayerDataStorageFileMetadata.() -> Unit = {}): PlayerDataStorageFileMetadata = PlayerDataStorageFileMetadata.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageQueryFileOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PlayerDataStorageQueryFileOptions = PlayerDataStorageQueryFileOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageQueryFileOptions {
      val struct = PlayerDataStorageQueryFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageQueryFileOptions(block: PlayerDataStorageQueryFileOptions.() -> Unit = {}): PlayerDataStorageQueryFileOptions = PlayerDataStorageQueryFileOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageQueryFileCallbackInfo(
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

    public val NULL: PlayerDataStorageQueryFileCallbackInfo =
        PlayerDataStorageQueryFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageQueryFileCallbackInfo {
      val struct = PlayerDataStorageQueryFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageQueryFileCallbackInfo(block: PlayerDataStorageQueryFileCallbackInfo.() -> Unit = {}): PlayerDataStorageQueryFileCallbackInfo = PlayerDataStorageQueryFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageQueryFileListOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PlayerDataStorageQueryFileListOptions =
        PlayerDataStorageQueryFileListOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageQueryFileListOptions {
      val struct = PlayerDataStorageQueryFileListOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageQueryFileListOptions(block: PlayerDataStorageQueryFileListOptions.() -> Unit = {}): PlayerDataStorageQueryFileListOptions = PlayerDataStorageQueryFileListOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageQueryFileListCallbackInfo(
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

  public var fileCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageQueryFileListCallbackInfo =
        PlayerDataStorageQueryFileListCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageQueryFileListCallbackInfo {
      val struct = PlayerDataStorageQueryFileListCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageQueryFileListCallbackInfo(block: PlayerDataStorageQueryFileListCallbackInfo.() -> Unit = {}): PlayerDataStorageQueryFileListCallbackInfo = PlayerDataStorageQueryFileListCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageGetFileMetadataCountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PlayerDataStorageGetFileMetadataCountOptions =
        PlayerDataStorageGetFileMetadataCountOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageGetFileMetadataCountOptions {
      val struct = PlayerDataStorageGetFileMetadataCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageGetFileMetadataCountOptions(block: PlayerDataStorageGetFileMetadataCountOptions.() -> Unit = {}): PlayerDataStorageGetFileMetadataCountOptions = PlayerDataStorageGetFileMetadataCountOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageCopyFileMetadataAtIndexOptions(
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

    public val NULL: PlayerDataStorageCopyFileMetadataAtIndexOptions =
        PlayerDataStorageCopyFileMetadataAtIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageCopyFileMetadataAtIndexOptions {
      val struct = PlayerDataStorageCopyFileMetadataAtIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageCopyFileMetadataAtIndexOptions(block: PlayerDataStorageCopyFileMetadataAtIndexOptions.() -> Unit = {}): PlayerDataStorageCopyFileMetadataAtIndexOptions = PlayerDataStorageCopyFileMetadataAtIndexOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageCopyFileMetadataByFilenameOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PlayerDataStorageCopyFileMetadataByFilenameOptions =
        PlayerDataStorageCopyFileMetadataByFilenameOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageCopyFileMetadataByFilenameOptions {
      val struct = PlayerDataStorageCopyFileMetadataByFilenameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageCopyFileMetadataByFilenameOptions(block: PlayerDataStorageCopyFileMetadataByFilenameOptions.() -> Unit = {}): PlayerDataStorageCopyFileMetadataByFilenameOptions = PlayerDataStorageCopyFileMetadataByFilenameOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDuplicateFileOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var sourceFilename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var destinationFilename: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageDuplicateFileOptions =
        PlayerDataStorageDuplicateFileOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDuplicateFileOptions {
      val struct = PlayerDataStorageDuplicateFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDuplicateFileOptions(block: PlayerDataStorageDuplicateFileOptions.() -> Unit = {}): PlayerDataStorageDuplicateFileOptions = PlayerDataStorageDuplicateFileOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDuplicateFileCallbackInfo(
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

    public val NULL: PlayerDataStorageDuplicateFileCallbackInfo =
        PlayerDataStorageDuplicateFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDuplicateFileCallbackInfo {
      val struct = PlayerDataStorageDuplicateFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDuplicateFileCallbackInfo(block: PlayerDataStorageDuplicateFileCallbackInfo.() -> Unit = {}): PlayerDataStorageDuplicateFileCallbackInfo = PlayerDataStorageDuplicateFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDeleteFileOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PlayerDataStorageDeleteFileOptions = PlayerDataStorageDeleteFileOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDeleteFileOptions {
      val struct = PlayerDataStorageDeleteFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDeleteFileOptions(block: PlayerDataStorageDeleteFileOptions.() -> Unit = {}): PlayerDataStorageDeleteFileOptions = PlayerDataStorageDeleteFileOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDeleteFileCallbackInfo(
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

    public val NULL: PlayerDataStorageDeleteFileCallbackInfo =
        PlayerDataStorageDeleteFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDeleteFileCallbackInfo {
      val struct = PlayerDataStorageDeleteFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDeleteFileCallbackInfo(block: PlayerDataStorageDeleteFileCallbackInfo.() -> Unit = {}): PlayerDataStorageDeleteFileCallbackInfo = PlayerDataStorageDeleteFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageFileTransferProgressCallbackInfo(
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

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var bytesTransferred: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var totalFileSizeBytes: Int
    get() = RawMemory.getInt(address + 28)
    set(`value`) {
      RawMemory.putInt(address + 28, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageFileTransferProgressCallbackInfo =
        PlayerDataStorageFileTransferProgressCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageFileTransferProgressCallbackInfo {
      val struct = PlayerDataStorageFileTransferProgressCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageFileTransferProgressCallbackInfo(block: PlayerDataStorageFileTransferProgressCallbackInfo.() -> Unit = {}): PlayerDataStorageFileTransferProgressCallbackInfo = PlayerDataStorageFileTransferProgressCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageReadFileDataCallbackInfo(
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

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var totalFileSizeBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var isLastChunk: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  public var dataChunkLengthBytes: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var dataChunk: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: PlayerDataStorageReadFileDataCallbackInfo =
        PlayerDataStorageReadFileDataCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageReadFileDataCallbackInfo {
      val struct = PlayerDataStorageReadFileDataCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageReadFileDataCallbackInfo(block: PlayerDataStorageReadFileDataCallbackInfo.() -> Unit = {}): PlayerDataStorageReadFileDataCallbackInfo = PlayerDataStorageReadFileDataCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageReadFileOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var readChunkLengthBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var readFileDataCallback: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var fileTransferProgressCallback: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: PlayerDataStorageReadFileOptions = PlayerDataStorageReadFileOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageReadFileOptions {
      val struct = PlayerDataStorageReadFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageReadFileOptions(block: PlayerDataStorageReadFileOptions.() -> Unit = {}): PlayerDataStorageReadFileOptions = PlayerDataStorageReadFileOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageReadFileCallbackInfo(
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

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageReadFileCallbackInfo =
        PlayerDataStorageReadFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageReadFileCallbackInfo {
      val struct = PlayerDataStorageReadFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageReadFileCallbackInfo(block: PlayerDataStorageReadFileCallbackInfo.() -> Unit = {}): PlayerDataStorageReadFileCallbackInfo = PlayerDataStorageReadFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageWriteFileDataCallbackInfo(
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

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var dataBufferLengthBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageWriteFileDataCallbackInfo =
        PlayerDataStorageWriteFileDataCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageWriteFileDataCallbackInfo {
      val struct = PlayerDataStorageWriteFileDataCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageWriteFileDataCallbackInfo(block: PlayerDataStorageWriteFileDataCallbackInfo.() -> Unit = {}): PlayerDataStorageWriteFileDataCallbackInfo = PlayerDataStorageWriteFileDataCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageWriteFileOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var chunkLengthBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var writeFileDataCallback: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var fileTransferProgressCallback: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: PlayerDataStorageWriteFileOptions = PlayerDataStorageWriteFileOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageWriteFileOptions {
      val struct = PlayerDataStorageWriteFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageWriteFileOptions(block: PlayerDataStorageWriteFileOptions.() -> Unit = {}): PlayerDataStorageWriteFileOptions = PlayerDataStorageWriteFileOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageWriteFileCallbackInfo(
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

  context(arena: Arena)
  public var filename: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlayerDataStorageWriteFileCallbackInfo =
        PlayerDataStorageWriteFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageWriteFileCallbackInfo {
      val struct = PlayerDataStorageWriteFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageWriteFileCallbackInfo(block: PlayerDataStorageWriteFileCallbackInfo.() -> Unit = {}): PlayerDataStorageWriteFileCallbackInfo = PlayerDataStorageWriteFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDeleteCacheOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PlayerDataStorageDeleteCacheOptions = PlayerDataStorageDeleteCacheOptions(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDeleteCacheOptions {
      val struct = PlayerDataStorageDeleteCacheOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDeleteCacheOptions(block: PlayerDataStorageDeleteCacheOptions.() -> Unit = {}): PlayerDataStorageDeleteCacheOptions = PlayerDataStorageDeleteCacheOptions.allocate().apply(block)

@JvmInline
public value class PlayerDataStorageDeleteCacheCallbackInfo(
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

    public val NULL: PlayerDataStorageDeleteCacheCallbackInfo =
        PlayerDataStorageDeleteCacheCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PlayerDataStorageDeleteCacheCallbackInfo {
      val struct = PlayerDataStorageDeleteCacheCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlayerDataStorageDeleteCacheCallbackInfo(block: PlayerDataStorageDeleteCacheCallbackInfo.() -> Unit = {}): PlayerDataStorageDeleteCacheCallbackInfo = PlayerDataStorageDeleteCacheCallbackInfo.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetTemplateIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var templateId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceModificationSetTemplateIdOptions =
        PresenceModificationSetTemplateIdOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetTemplateIdOptions {
      val struct = PresenceModificationSetTemplateIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetTemplateIdOptions(block: PresenceModificationSetTemplateIdOptions.() -> Unit = {}): PresenceModificationSetTemplateIdOptions = PresenceModificationSetTemplateIdOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetTemplateDataOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var asInt32: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  context(arena: Arena)
  public var asStringId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var valueType: EPresenceModificationTemplateType
    get() = EPresenceModificationTemplateType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PresenceModificationSetTemplateDataOptions =
        PresenceModificationSetTemplateDataOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetTemplateDataOptions {
      val struct = PresenceModificationSetTemplateDataOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetTemplateDataOptions(block: PresenceModificationSetTemplateDataOptions.() -> Unit = {}): PresenceModificationSetTemplateDataOptions = PresenceModificationSetTemplateDataOptions.allocate().apply(block)

@JvmInline
public value class PresenceDataRecord(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var `value`: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceDataRecord = PresenceDataRecord(0)

    context(arena: Arena)
    public fun allocate(): PresenceDataRecord {
      val struct = PresenceDataRecord(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceDataRecord(block: PresenceDataRecord.() -> Unit = {}): PresenceDataRecord = PresenceDataRecord.allocate().apply(block)

@JvmInline
public value class PresenceInfo(
  public val address: Long,
) {
  public var status: PresenceEStatus
    get() = PresenceEStatus(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var userId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var productId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var productVersion: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var platform: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var richText: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var recordsCount: Int
    get() = RawMemory.getInt(address + 48)
    set(`value`) {
      RawMemory.putInt(address + 48, value)
    }

  public var records: PresenceDataRecord
    get() = PresenceDataRecord(RawMemory.getLong(address + 56))
    set(`value`) {
      RawMemory.putLong(address + 56, value.address)
    }

  context(arena: Arena)
  public var productName: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var integratedPlatform: String?
    get() = RawMemory.getLong(address + 72).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 72, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 80

    public val NULL: PresenceInfo = PresenceInfo(0)

    context(arena: Arena)
    public fun allocate(): PresenceInfo {
      val struct = PresenceInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceInfo(block: PresenceInfo.() -> Unit = {}): PresenceInfo = PresenceInfo.allocate().apply(block)

@JvmInline
public value class PresenceQueryPresenceOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceQueryPresenceOptions = PresenceQueryPresenceOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceQueryPresenceOptions {
      val struct = PresenceQueryPresenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceQueryPresenceOptions(block: PresenceQueryPresenceOptions.() -> Unit = {}): PresenceQueryPresenceOptions = PresenceQueryPresenceOptions.allocate().apply(block)

@JvmInline
public value class PresenceQueryPresenceCallbackInfo(
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

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PresenceQueryPresenceCallbackInfo = PresenceQueryPresenceCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PresenceQueryPresenceCallbackInfo {
      val struct = PresenceQueryPresenceCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceQueryPresenceCallbackInfo(block: PresenceQueryPresenceCallbackInfo.() -> Unit = {}): PresenceQueryPresenceCallbackInfo = PresenceQueryPresenceCallbackInfo.allocate().apply(block)

@JvmInline
public value class PresenceHasPresenceOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceHasPresenceOptions = PresenceHasPresenceOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceHasPresenceOptions {
      val struct = PresenceHasPresenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceHasPresenceOptions(block: PresenceHasPresenceOptions.() -> Unit = {}): PresenceHasPresenceOptions = PresenceHasPresenceOptions.allocate().apply(block)

@JvmInline
public value class PresenceCopyPresenceOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceCopyPresenceOptions = PresenceCopyPresenceOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceCopyPresenceOptions {
      val struct = PresenceCopyPresenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceCopyPresenceOptions(block: PresenceCopyPresenceOptions.() -> Unit = {}): PresenceCopyPresenceOptions = PresenceCopyPresenceOptions.allocate().apply(block)

@JvmInline
public value class PresenceCreatePresenceModificationOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceCreatePresenceModificationOptions =
        PresenceCreatePresenceModificationOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceCreatePresenceModificationOptions {
      val struct = PresenceCreatePresenceModificationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceCreatePresenceModificationOptions(block: PresenceCreatePresenceModificationOptions.() -> Unit = {}): PresenceCreatePresenceModificationOptions = PresenceCreatePresenceModificationOptions.allocate().apply(block)

@JvmInline
public value class PresenceSetPresenceOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var presenceModificationHandle: HPresenceModification
    get() = HPresenceModification(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.handle)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceSetPresenceOptions = PresenceSetPresenceOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceSetPresenceOptions {
      val struct = PresenceSetPresenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceSetPresenceOptions(block: PresenceSetPresenceOptions.() -> Unit = {}): PresenceSetPresenceOptions = PresenceSetPresenceOptions.allocate().apply(block)

@JvmInline
public value class PresenceSetPresenceCallbackInfo(
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

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var richPresenceResultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PresenceSetPresenceCallbackInfo = PresenceSetPresenceCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PresenceSetPresenceCallbackInfo {
      val struct = PresenceSetPresenceCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceSetPresenceCallbackInfo(block: PresenceSetPresenceCallbackInfo.() -> Unit = {}): PresenceSetPresenceCallbackInfo = PresenceSetPresenceCallbackInfo.allocate().apply(block)

@JvmInline
public value class PresenceAddNotifyOnPresenceChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: PresenceAddNotifyOnPresenceChangedOptions =
        PresenceAddNotifyOnPresenceChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceAddNotifyOnPresenceChangedOptions {
      val struct = PresenceAddNotifyOnPresenceChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceAddNotifyOnPresenceChangedOptions(block: PresenceAddNotifyOnPresenceChangedOptions.() -> Unit = {}): PresenceAddNotifyOnPresenceChangedOptions = PresenceAddNotifyOnPresenceChangedOptions.allocate().apply(block)

@JvmInline
public value class PresencePresenceChangedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var presenceUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresencePresenceChangedCallbackInfo = PresencePresenceChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PresencePresenceChangedCallbackInfo {
      val struct = PresencePresenceChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresencePresenceChangedCallbackInfo(block: PresencePresenceChangedCallbackInfo.() -> Unit = {}): PresencePresenceChangedCallbackInfo = PresencePresenceChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class PresenceAddNotifyJoinGameAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: PresenceAddNotifyJoinGameAcceptedOptions =
        PresenceAddNotifyJoinGameAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceAddNotifyJoinGameAcceptedOptions {
      val struct = PresenceAddNotifyJoinGameAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceAddNotifyJoinGameAcceptedOptions(block: PresenceAddNotifyJoinGameAcceptedOptions.() -> Unit = {}): PresenceAddNotifyJoinGameAcceptedOptions = PresenceAddNotifyJoinGameAcceptedOptions.allocate().apply(block)

@JvmInline
public value class PresenceJoinGameAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  context(arena: Arena)
  public var joinInfo: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var uiEventId: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: PresenceJoinGameAcceptedCallbackInfo = PresenceJoinGameAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): PresenceJoinGameAcceptedCallbackInfo {
      val struct = PresenceJoinGameAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceJoinGameAcceptedCallbackInfo(block: PresenceJoinGameAcceptedCallbackInfo.() -> Unit = {}): PresenceJoinGameAcceptedCallbackInfo = PresenceJoinGameAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class PresenceGetJoinInfoOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: PresenceGetJoinInfoOptions = PresenceGetJoinInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceGetJoinInfoOptions {
      val struct = PresenceGetJoinInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceGetJoinInfoOptions(block: PresenceGetJoinInfoOptions.() -> Unit = {}): PresenceGetJoinInfoOptions = PresenceGetJoinInfoOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetJoinInfoOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var joinInfo: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceModificationSetJoinInfoOptions =
        PresenceModificationSetJoinInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetJoinInfoOptions {
      val struct = PresenceModificationSetJoinInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetJoinInfoOptions(block: PresenceModificationSetJoinInfoOptions.() -> Unit = {}): PresenceModificationSetJoinInfoOptions = PresenceModificationSetJoinInfoOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetStatusOptions(
  public val address: Long,
) {
  public var status: PresenceEStatus
    get() = PresenceEStatus(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: PresenceModificationSetStatusOptions = PresenceModificationSetStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetStatusOptions {
      val struct = PresenceModificationSetStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetStatusOptions(block: PresenceModificationSetStatusOptions.() -> Unit = {}): PresenceModificationSetStatusOptions = PresenceModificationSetStatusOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetRawRichTextOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var richText: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceModificationSetRawRichTextOptions =
        PresenceModificationSetRawRichTextOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetRawRichTextOptions {
      val struct = PresenceModificationSetRawRichTextOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetRawRichTextOptions(block: PresenceModificationSetRawRichTextOptions.() -> Unit = {}): PresenceModificationSetRawRichTextOptions = PresenceModificationSetRawRichTextOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationSetDataOptions(
  public val address: Long,
) {
  public var recordsCount: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var records: PresenceDataRecord
    get() = PresenceDataRecord(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceModificationSetDataOptions = PresenceModificationSetDataOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationSetDataOptions {
      val struct = PresenceModificationSetDataOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationSetDataOptions(block: PresenceModificationSetDataOptions.() -> Unit = {}): PresenceModificationSetDataOptions = PresenceModificationSetDataOptions.allocate().apply(block)

@JvmInline
public value class PresenceModificationDataRecordId(
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

    public val NULL: PresenceModificationDataRecordId = PresenceModificationDataRecordId(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationDataRecordId {
      val struct = PresenceModificationDataRecordId(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationDataRecordId(block: PresenceModificationDataRecordId.() -> Unit = {}): PresenceModificationDataRecordId = PresenceModificationDataRecordId.allocate().apply(block)

@JvmInline
public value class PresenceModificationDeleteDataOptions(
  public val address: Long,
) {
  public var recordsCount: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var records: PresenceModificationDataRecordId
    get() = PresenceModificationDataRecordId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PresenceModificationDeleteDataOptions =
        PresenceModificationDeleteDataOptions(0)

    context(arena: Arena)
    public fun allocate(): PresenceModificationDeleteDataOptions {
      val struct = PresenceModificationDeleteDataOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PresenceModificationDeleteDataOptions(block: PresenceModificationDeleteDataOptions.() -> Unit = {}): PresenceModificationDeleteDataOptions = PresenceModificationDeleteDataOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotBeginSnapshotOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ProgressionSnapshotBeginSnapshotOptions =
        ProgressionSnapshotBeginSnapshotOptions(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotBeginSnapshotOptions {
      val struct = ProgressionSnapshotBeginSnapshotOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotBeginSnapshotOptions(block: ProgressionSnapshotBeginSnapshotOptions.() -> Unit = {}): ProgressionSnapshotBeginSnapshotOptions = ProgressionSnapshotBeginSnapshotOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotAddProgressionOptions(
  public val address: Long,
) {
  public var snapshotId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var `value`: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ProgressionSnapshotAddProgressionOptions =
        ProgressionSnapshotAddProgressionOptions(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotAddProgressionOptions {
      val struct = ProgressionSnapshotAddProgressionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotAddProgressionOptions(block: ProgressionSnapshotAddProgressionOptions.() -> Unit = {}): ProgressionSnapshotAddProgressionOptions = ProgressionSnapshotAddProgressionOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotSubmitSnapshotOptions(
  public val address: Long,
) {
  public var snapshotId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: ProgressionSnapshotSubmitSnapshotOptions =
        ProgressionSnapshotSubmitSnapshotOptions(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotSubmitSnapshotOptions {
      val struct = ProgressionSnapshotSubmitSnapshotOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotSubmitSnapshotOptions(block: ProgressionSnapshotSubmitSnapshotOptions.() -> Unit = {}): ProgressionSnapshotSubmitSnapshotOptions = ProgressionSnapshotSubmitSnapshotOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotEndSnapshotOptions(
  public val address: Long,
) {
  public var snapshotId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: ProgressionSnapshotEndSnapshotOptions =
        ProgressionSnapshotEndSnapshotOptions(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotEndSnapshotOptions {
      val struct = ProgressionSnapshotEndSnapshotOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotEndSnapshotOptions(block: ProgressionSnapshotEndSnapshotOptions.() -> Unit = {}): ProgressionSnapshotEndSnapshotOptions = ProgressionSnapshotEndSnapshotOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotSubmitSnapshotCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var snapshotId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ProgressionSnapshotSubmitSnapshotCallbackInfo =
        ProgressionSnapshotSubmitSnapshotCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotSubmitSnapshotCallbackInfo {
      val struct = ProgressionSnapshotSubmitSnapshotCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotSubmitSnapshotCallbackInfo(block: ProgressionSnapshotSubmitSnapshotCallbackInfo.() -> Unit = {}): ProgressionSnapshotSubmitSnapshotCallbackInfo = ProgressionSnapshotSubmitSnapshotCallbackInfo.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotDeleteSnapshotOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ProgressionSnapshotDeleteSnapshotOptions =
        ProgressionSnapshotDeleteSnapshotOptions(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotDeleteSnapshotOptions {
      val struct = ProgressionSnapshotDeleteSnapshotOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotDeleteSnapshotOptions(block: ProgressionSnapshotDeleteSnapshotOptions.() -> Unit = {}): ProgressionSnapshotDeleteSnapshotOptions = ProgressionSnapshotDeleteSnapshotOptions.allocate().apply(block)

@JvmInline
public value class ProgressionSnapshotDeleteSnapshotCallbackInfo(
  public val address: Long,
) {
  public var resultCode: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var clientData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ProgressionSnapshotDeleteSnapshotCallbackInfo =
        ProgressionSnapshotDeleteSnapshotCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ProgressionSnapshotDeleteSnapshotCallbackInfo {
      val struct = ProgressionSnapshotDeleteSnapshotCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ProgressionSnapshotDeleteSnapshotCallbackInfo(block: ProgressionSnapshotDeleteSnapshotCallbackInfo.() -> Unit = {}): ProgressionSnapshotDeleteSnapshotCallbackInfo = ProgressionSnapshotDeleteSnapshotCallbackInfo.allocate().apply(block)

@JvmInline
public value class ReportsSendPlayerBehaviorReportOptions(
  public val address: Long,
) {
  public var reporterUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var reportedUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var category: EPlayerReportsCategory
    get() = EPlayerReportsCategory(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  context(arena: Arena)
  public var message: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var context: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: ReportsSendPlayerBehaviorReportOptions =
        ReportsSendPlayerBehaviorReportOptions(0)

    context(arena: Arena)
    public fun allocate(): ReportsSendPlayerBehaviorReportOptions {
      val struct = ReportsSendPlayerBehaviorReportOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ReportsSendPlayerBehaviorReportOptions(block: ReportsSendPlayerBehaviorReportOptions.() -> Unit = {}): ReportsSendPlayerBehaviorReportOptions = ReportsSendPlayerBehaviorReportOptions.allocate().apply(block)

@JvmInline
public value class ReportsSendPlayerBehaviorReportCompleteCallbackInfo(
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

    public val NULL: ReportsSendPlayerBehaviorReportCompleteCallbackInfo =
        ReportsSendPlayerBehaviorReportCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ReportsSendPlayerBehaviorReportCompleteCallbackInfo {
      val struct = ReportsSendPlayerBehaviorReportCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ReportsSendPlayerBehaviorReportCompleteCallbackInfo(block: ReportsSendPlayerBehaviorReportCompleteCallbackInfo.() -> Unit = {}): ReportsSendPlayerBehaviorReportCompleteCallbackInfo = ReportsSendPlayerBehaviorReportCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAdminQueryJoinRoomTokenOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var targetUserIds: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var targetUserIdsCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var targetUserIpAddresses: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCAdminQueryJoinRoomTokenOptions = RTCAdminQueryJoinRoomTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminQueryJoinRoomTokenOptions {
      val struct = RTCAdminQueryJoinRoomTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminQueryJoinRoomTokenOptions(block: RTCAdminQueryJoinRoomTokenOptions.() -> Unit = {}): RTCAdminQueryJoinRoomTokenOptions = RTCAdminQueryJoinRoomTokenOptions.allocate().apply(block)

@JvmInline
public value class RTCAdminQueryJoinRoomTokenCompleteCallbackInfo(
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
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var clientBaseUrl: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var queryId: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var tokenCount: Int
    get() = RawMemory.getInt(address + 36)
    set(`value`) {
      RawMemory.putInt(address + 36, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAdminQueryJoinRoomTokenCompleteCallbackInfo =
        RTCAdminQueryJoinRoomTokenCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminQueryJoinRoomTokenCompleteCallbackInfo {
      val struct = RTCAdminQueryJoinRoomTokenCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminQueryJoinRoomTokenCompleteCallbackInfo(block: RTCAdminQueryJoinRoomTokenCompleteCallbackInfo.() -> Unit = {}): RTCAdminQueryJoinRoomTokenCompleteCallbackInfo = RTCAdminQueryJoinRoomTokenCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAdminUserToken(
  public val address: Long,
) {
  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var token: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAdminUserToken = RTCAdminUserToken(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminUserToken {
      val struct = RTCAdminUserToken(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminUserToken(block: RTCAdminUserToken.() -> Unit = {}): RTCAdminUserToken = RTCAdminUserToken.allocate().apply(block)

@JvmInline
public value class RTCAdminCopyUserTokenByIndexOptions(
  public val address: Long,
) {
  public var userTokenIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var queryId: Int
    get() = RawMemory.getInt(address + 8)
    set(`value`) {
      RawMemory.putInt(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 12

    public val NULL: RTCAdminCopyUserTokenByIndexOptions = RTCAdminCopyUserTokenByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminCopyUserTokenByIndexOptions {
      val struct = RTCAdminCopyUserTokenByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminCopyUserTokenByIndexOptions(block: RTCAdminCopyUserTokenByIndexOptions.() -> Unit = {}): RTCAdminCopyUserTokenByIndexOptions = RTCAdminCopyUserTokenByIndexOptions.allocate().apply(block)

@JvmInline
public value class RTCAdminCopyUserTokenByUserIdOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var queryId: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAdminCopyUserTokenByUserIdOptions = RTCAdminCopyUserTokenByUserIdOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminCopyUserTokenByUserIdOptions {
      val struct = RTCAdminCopyUserTokenByUserIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminCopyUserTokenByUserIdOptions(block: RTCAdminCopyUserTokenByUserIdOptions.() -> Unit = {}): RTCAdminCopyUserTokenByUserIdOptions = RTCAdminCopyUserTokenByUserIdOptions.allocate().apply(block)

@JvmInline
public value class RTCAdminKickOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAdminKickOptions = RTCAdminKickOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminKickOptions {
      val struct = RTCAdminKickOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminKickOptions(block: RTCAdminKickOptions.() -> Unit = {}): RTCAdminKickOptions = RTCAdminKickOptions.allocate().apply(block)

@JvmInline
public value class RTCAdminKickCompleteCallbackInfo(
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

    public val NULL: RTCAdminKickCompleteCallbackInfo = RTCAdminKickCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminKickCompleteCallbackInfo {
      val struct = RTCAdminKickCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminKickCompleteCallbackInfo(block: RTCAdminKickCompleteCallbackInfo.() -> Unit = {}): RTCAdminKickCompleteCallbackInfo = RTCAdminKickCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAdminSetParticipantHardMuteOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var mute: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAdminSetParticipantHardMuteOptions =
        RTCAdminSetParticipantHardMuteOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminSetParticipantHardMuteOptions {
      val struct = RTCAdminSetParticipantHardMuteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminSetParticipantHardMuteOptions(block: RTCAdminSetParticipantHardMuteOptions.() -> Unit = {}): RTCAdminSetParticipantHardMuteOptions = RTCAdminSetParticipantHardMuteOptions.allocate().apply(block)

@JvmInline
public value class RTCAdminSetParticipantHardMuteCompleteCallbackInfo(
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

    public val NULL: RTCAdminSetParticipantHardMuteCompleteCallbackInfo =
        RTCAdminSetParticipantHardMuteCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAdminSetParticipantHardMuteCompleteCallbackInfo {
      val struct = RTCAdminSetParticipantHardMuteCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAdminSetParticipantHardMuteCompleteCallbackInfo(block: RTCAdminSetParticipantHardMuteCompleteCallbackInfo.() -> Unit = {}): RTCAdminSetParticipantHardMuteCompleteCallbackInfo = RTCAdminSetParticipantHardMuteCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyParticipantUpdatedOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAddNotifyParticipantUpdatedOptions =
        RTCAudioAddNotifyParticipantUpdatedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyParticipantUpdatedOptions {
      val struct = RTCAudioAddNotifyParticipantUpdatedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyParticipantUpdatedOptions(block: RTCAudioAddNotifyParticipantUpdatedOptions.() -> Unit = {}): RTCAudioAddNotifyParticipantUpdatedOptions = RTCAudioAddNotifyParticipantUpdatedOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioParticipantUpdatedCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var speaking: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public var audioStatus: ERTCAudioStatus
    get() = ERTCAudioStatus(RawMemory.getInt(address + 36))
    set(`value`) {
      RawMemory.putInt(address + 36, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioParticipantUpdatedCallbackInfo =
        RTCAudioParticipantUpdatedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioParticipantUpdatedCallbackInfo {
      val struct = RTCAudioParticipantUpdatedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioParticipantUpdatedCallbackInfo(block: RTCAudioParticipantUpdatedCallbackInfo.() -> Unit = {}): RTCAudioParticipantUpdatedCallbackInfo = RTCAudioParticipantUpdatedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyAudioDevicesChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioAddNotifyAudioDevicesChangedOptions =
        RTCAudioAddNotifyAudioDevicesChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyAudioDevicesChangedOptions {
      val struct = RTCAudioAddNotifyAudioDevicesChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyAudioDevicesChangedOptions(block: RTCAudioAddNotifyAudioDevicesChangedOptions.() -> Unit = {}): RTCAudioAddNotifyAudioDevicesChangedOptions = RTCAudioAddNotifyAudioDevicesChangedOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioDevicesChangedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: RTCAudioAudioDevicesChangedCallbackInfo =
        RTCAudioAudioDevicesChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioDevicesChangedCallbackInfo {
      val struct = RTCAudioAudioDevicesChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioDevicesChangedCallbackInfo(block: RTCAudioAudioDevicesChangedCallbackInfo.() -> Unit = {}): RTCAudioAudioDevicesChangedCallbackInfo = RTCAudioAudioDevicesChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyAudioInputStateOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAddNotifyAudioInputStateOptions =
        RTCAudioAddNotifyAudioInputStateOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyAudioInputStateOptions {
      val struct = RTCAudioAddNotifyAudioInputStateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyAudioInputStateOptions(block: RTCAudioAddNotifyAudioInputStateOptions.() -> Unit = {}): RTCAudioAddNotifyAudioInputStateOptions = RTCAudioAddNotifyAudioInputStateOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioInputStateCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var status: ERTCAudioInputStatus
    get() = ERTCAudioInputStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioAudioInputStateCallbackInfo = RTCAudioAudioInputStateCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioInputStateCallbackInfo {
      val struct = RTCAudioAudioInputStateCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioInputStateCallbackInfo(block: RTCAudioAudioInputStateCallbackInfo.() -> Unit = {}): RTCAudioAudioInputStateCallbackInfo = RTCAudioAudioInputStateCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyAudioOutputStateOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAddNotifyAudioOutputStateOptions =
        RTCAudioAddNotifyAudioOutputStateOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyAudioOutputStateOptions {
      val struct = RTCAudioAddNotifyAudioOutputStateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyAudioOutputStateOptions(block: RTCAudioAddNotifyAudioOutputStateOptions.() -> Unit = {}): RTCAudioAddNotifyAudioOutputStateOptions = RTCAudioAddNotifyAudioOutputStateOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioOutputStateCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var status: ERTCAudioOutputStatus
    get() = ERTCAudioOutputStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioAudioOutputStateCallbackInfo = RTCAudioAudioOutputStateCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioOutputStateCallbackInfo {
      val struct = RTCAudioAudioOutputStateCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioOutputStateCallbackInfo(block: RTCAudioAudioOutputStateCallbackInfo.() -> Unit = {}): RTCAudioAudioOutputStateCallbackInfo = RTCAudioAudioOutputStateCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyAudioBeforeSendOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAddNotifyAudioBeforeSendOptions =
        RTCAudioAddNotifyAudioBeforeSendOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyAudioBeforeSendOptions {
      val struct = RTCAudioAddNotifyAudioBeforeSendOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyAudioBeforeSendOptions(block: RTCAudioAddNotifyAudioBeforeSendOptions.() -> Unit = {}): RTCAudioAddNotifyAudioBeforeSendOptions = RTCAudioAddNotifyAudioBeforeSendOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioBuffer(
  public val address: Long,
) {
  public var frames: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var framesCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var sampleRate: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var channels: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioAudioBuffer = RTCAudioAudioBuffer(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioBuffer {
      val struct = RTCAudioAudioBuffer(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioBuffer(block: RTCAudioAudioBuffer.() -> Unit = {}): RTCAudioAudioBuffer = RTCAudioAudioBuffer.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioBeforeSendCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var buffer: RTCAudioAudioBuffer
    get() = RTCAudioAudioBuffer(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioAudioBeforeSendCallbackInfo = RTCAudioAudioBeforeSendCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioBeforeSendCallbackInfo {
      val struct = RTCAudioAudioBeforeSendCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioBeforeSendCallbackInfo(block: RTCAudioAudioBeforeSendCallbackInfo.() -> Unit = {}): RTCAudioAudioBeforeSendCallbackInfo = RTCAudioAudioBeforeSendCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioAddNotifyAudioBeforeRenderOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var unmixedAudio: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioAddNotifyAudioBeforeRenderOptions =
        RTCAudioAddNotifyAudioBeforeRenderOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAddNotifyAudioBeforeRenderOptions {
      val struct = RTCAudioAddNotifyAudioBeforeRenderOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAddNotifyAudioBeforeRenderOptions(block: RTCAudioAddNotifyAudioBeforeRenderOptions.() -> Unit = {}): RTCAudioAddNotifyAudioBeforeRenderOptions = RTCAudioAddNotifyAudioBeforeRenderOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioBeforeRenderCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var buffer: RTCAudioAudioBuffer
    get() = RTCAudioAudioBuffer(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioAudioBeforeRenderCallbackInfo =
        RTCAudioAudioBeforeRenderCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioBeforeRenderCallbackInfo {
      val struct = RTCAudioAudioBeforeRenderCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioBeforeRenderCallbackInfo(block: RTCAudioAudioBeforeRenderCallbackInfo.() -> Unit = {}): RTCAudioAudioBeforeRenderCallbackInfo = RTCAudioAudioBeforeRenderCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioSendAudioOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var buffer: RTCAudioAudioBuffer
    get() = RTCAudioAudioBuffer(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioSendAudioOptions = RTCAudioSendAudioOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioSendAudioOptions {
      val struct = RTCAudioSendAudioOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioSendAudioOptions(block: RTCAudioSendAudioOptions.() -> Unit = {}): RTCAudioSendAudioOptions = RTCAudioSendAudioOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateSendingOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var audioStatus: ERTCAudioStatus
    get() = ERTCAudioStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioUpdateSendingOptions = RTCAudioUpdateSendingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateSendingOptions {
      val struct = RTCAudioUpdateSendingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateSendingOptions(block: RTCAudioUpdateSendingOptions.() -> Unit = {}): RTCAudioUpdateSendingOptions = RTCAudioUpdateSendingOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateSendingCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var audioStatus: ERTCAudioStatus
    get() = ERTCAudioStatus(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioUpdateSendingCallbackInfo = RTCAudioUpdateSendingCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateSendingCallbackInfo {
      val struct = RTCAudioUpdateSendingCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateSendingCallbackInfo(block: RTCAudioUpdateSendingCallbackInfo.() -> Unit = {}): RTCAudioUpdateSendingCallbackInfo = RTCAudioUpdateSendingCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateReceivingOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var audioEnabled: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioUpdateReceivingOptions = RTCAudioUpdateReceivingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateReceivingOptions {
      val struct = RTCAudioUpdateReceivingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateReceivingOptions(block: RTCAudioUpdateReceivingOptions.() -> Unit = {}): RTCAudioUpdateReceivingOptions = RTCAudioUpdateReceivingOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateReceivingCallbackInfo(
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

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public var audioEnabled: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCAudioUpdateReceivingCallbackInfo = RTCAudioUpdateReceivingCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateReceivingCallbackInfo {
      val struct = RTCAudioUpdateReceivingCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateReceivingCallbackInfo(block: RTCAudioUpdateReceivingCallbackInfo.() -> Unit = {}): RTCAudioUpdateReceivingCallbackInfo = RTCAudioUpdateReceivingCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateSendingVolumeOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var roomName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var volume: Float
    get() = RawMemory.getFloat(address + 24)
    set(`value`) {
      RawMemory.putFloat(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioUpdateSendingVolumeOptions = RTCAudioUpdateSendingVolumeOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateSendingVolumeOptions {
      val struct = RTCAudioUpdateSendingVolumeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateSendingVolumeOptions(block: RTCAudioUpdateSendingVolumeOptions.() -> Unit = {}): RTCAudioUpdateSendingVolumeOptions = RTCAudioUpdateSendingVolumeOptions.allocate().apply(block)
