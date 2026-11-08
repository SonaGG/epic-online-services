@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class ActiveSessionCopyInfoOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: ActiveSessionCopyInfoOptions = ActiveSessionCopyInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): ActiveSessionCopyInfoOptions {
      val struct = ActiveSessionCopyInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ActiveSessionCopyInfoOptions(block: ActiveSessionCopyInfoOptions.() -> Unit = {}): ActiveSessionCopyInfoOptions = ActiveSessionCopyInfoOptions.allocate().apply(block)

@JvmInline
public value class ActiveSessionGetRegisteredPlayerCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: ActiveSessionGetRegisteredPlayerCountOptions =
        ActiveSessionGetRegisteredPlayerCountOptions(0)

    context(arena: Arena)
    public fun allocate(): ActiveSessionGetRegisteredPlayerCountOptions {
      val struct = ActiveSessionGetRegisteredPlayerCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ActiveSessionGetRegisteredPlayerCountOptions(block: ActiveSessionGetRegisteredPlayerCountOptions.() -> Unit = {}): ActiveSessionGetRegisteredPlayerCountOptions = ActiveSessionGetRegisteredPlayerCountOptions.allocate().apply(block)

@JvmInline
public value class ActiveSessionGetRegisteredPlayerByIndexOptions(
  public val address: Long,
) {
  public var playerIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: ActiveSessionGetRegisteredPlayerByIndexOptions =
        ActiveSessionGetRegisteredPlayerByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): ActiveSessionGetRegisteredPlayerByIndexOptions {
      val struct = ActiveSessionGetRegisteredPlayerByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ActiveSessionGetRegisteredPlayerByIndexOptions(block: ActiveSessionGetRegisteredPlayerByIndexOptions.() -> Unit = {}): ActiveSessionGetRegisteredPlayerByIndexOptions = ActiveSessionGetRegisteredPlayerByIndexOptions.allocate().apply(block)

@JvmInline
public value class SessionDetailsAttribute(
  public val address: Long,
) {
  public var `data`: SessionsAttributeData
    get() = SessionsAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var advertisementType: ESessionAttributeAdvertisementType
    get() = ESessionAttributeAdvertisementType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionDetailsAttribute = SessionDetailsAttribute(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsAttribute {
      val struct = SessionDetailsAttribute(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsAttribute(block: SessionDetailsAttribute.() -> Unit = {}): SessionDetailsAttribute = SessionDetailsAttribute.allocate().apply(block)

@JvmInline
public value class SessionModificationAddAttributeOptions(
  public val address: Long,
) {
  public var sessionAttribute: SessionsAttributeData
    get() = SessionsAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var advertisementType: ESessionAttributeAdvertisementType
    get() = ESessionAttributeAdvertisementType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionModificationAddAttributeOptions =
        SessionModificationAddAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationAddAttributeOptions {
      val struct = SessionModificationAddAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationAddAttributeOptions(block: SessionModificationAddAttributeOptions.() -> Unit = {}): SessionModificationAddAttributeOptions = SessionModificationAddAttributeOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationRemoveAttributeOptions(
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

    public val NULL: SessionModificationRemoveAttributeOptions =
        SessionModificationRemoveAttributeOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationRemoveAttributeOptions {
      val struct = SessionModificationRemoveAttributeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationRemoveAttributeOptions(block: SessionModificationRemoveAttributeOptions.() -> Unit = {}): SessionModificationRemoveAttributeOptions = SessionModificationRemoveAttributeOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchSetMaxResultsOptions(
  public val address: Long,
) {
  public var maxSearchResults: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionSearchSetMaxResultsOptions = SessionSearchSetMaxResultsOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchSetMaxResultsOptions {
      val struct = SessionSearchSetMaxResultsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchSetMaxResultsOptions(block: SessionSearchSetMaxResultsOptions.() -> Unit = {}): SessionSearchSetMaxResultsOptions = SessionSearchSetMaxResultsOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchFindOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionSearchFindOptions = SessionSearchFindOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchFindOptions {
      val struct = SessionSearchFindOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchFindOptions(block: SessionSearchFindOptions.() -> Unit = {}): SessionSearchFindOptions = SessionSearchFindOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchFindCallbackInfo(
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

    public val NULL: SessionSearchFindCallbackInfo = SessionSearchFindCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchFindCallbackInfo {
      val struct = SessionSearchFindCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchFindCallbackInfo(block: SessionSearchFindCallbackInfo.() -> Unit = {}): SessionSearchFindCallbackInfo = SessionSearchFindCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionSearchGetSearchResultCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionSearchGetSearchResultCountOptions =
        SessionSearchGetSearchResultCountOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchGetSearchResultCountOptions {
      val struct = SessionSearchGetSearchResultCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchGetSearchResultCountOptions(block: SessionSearchGetSearchResultCountOptions.() -> Unit = {}): SessionSearchGetSearchResultCountOptions = SessionSearchGetSearchResultCountOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchCopySearchResultByIndexOptions(
  public val address: Long,
) {
  public var sessionIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionSearchCopySearchResultByIndexOptions =
        SessionSearchCopySearchResultByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchCopySearchResultByIndexOptions {
      val struct = SessionSearchCopySearchResultByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchCopySearchResultByIndexOptions(block: SessionSearchCopySearchResultByIndexOptions.() -> Unit = {}): SessionSearchCopySearchResultByIndexOptions = SessionSearchCopySearchResultByIndexOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchSetSessionIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionSearchSetSessionIdOptions = SessionSearchSetSessionIdOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchSetSessionIdOptions {
      val struct = SessionSearchSetSessionIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchSetSessionIdOptions(block: SessionSearchSetSessionIdOptions.() -> Unit = {}): SessionSearchSetSessionIdOptions = SessionSearchSetSessionIdOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchSetTargetUserIdOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionSearchSetTargetUserIdOptions = SessionSearchSetTargetUserIdOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchSetTargetUserIdOptions {
      val struct = SessionSearchSetTargetUserIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchSetTargetUserIdOptions(block: SessionSearchSetTargetUserIdOptions.() -> Unit = {}): SessionSearchSetTargetUserIdOptions = SessionSearchSetTargetUserIdOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchSetParameterOptions(
  public val address: Long,
) {
  public var parameter: SessionsAttributeData
    get() = SessionsAttributeData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var comparisonOp: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionSearchSetParameterOptions = SessionSearchSetParameterOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchSetParameterOptions {
      val struct = SessionSearchSetParameterOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchSetParameterOptions(block: SessionSearchSetParameterOptions.() -> Unit = {}): SessionSearchSetParameterOptions = SessionSearchSetParameterOptions.allocate().apply(block)

@JvmInline
public value class SessionSearchRemoveParameterOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var comparisonOp: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionSearchRemoveParameterOptions = SessionSearchRemoveParameterOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionSearchRemoveParameterOptions {
      val struct = SessionSearchRemoveParameterOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionSearchRemoveParameterOptions(block: SessionSearchRemoveParameterOptions.() -> Unit = {}): SessionSearchRemoveParameterOptions = SessionSearchRemoveParameterOptions.allocate().apply(block)

@JvmInline
public value class SessionDetailsSettings(
  public val address: Long,
) {
  context(arena: Arena)
  public var bucketId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var numPublicConnections: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var allowJoinInProgress: Boolean
    get() = RawMemory.getInt(address + 20) != 0
    set(`value`) {
      RawMemory.putInt(address + 20, if (value) 1 else 0)
    }

  public var permissionLevel: EOnlineSessionPermissionLevel
    get() = EOnlineSessionPermissionLevel(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var invitesAllowed: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  public var sanctionsEnabled: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public var allowedPlatformIds: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public var allowedPlatformIdsCount: Int
    get() = RawMemory.getInt(address + 48)
    set(`value`) {
      RawMemory.putInt(address + 48, value)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: SessionDetailsSettings = SessionDetailsSettings(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsSettings {
      val struct = SessionDetailsSettings(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 4)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsSettings(block: SessionDetailsSettings.() -> Unit = {}): SessionDetailsSettings = SessionDetailsSettings.allocate().apply(block)

@JvmInline
public value class SessionDetailsInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var hostAddress: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var numOpenPublicConnections: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var settings: SessionDetailsSettings
    get() = SessionDetailsSettings(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.address)
    }

  public var ownerUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.raw)
    }

  context(arena: Arena)
  public var ownerServerClientId: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: SessionDetailsInfo = SessionDetailsInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsInfo {
      val struct = SessionDetailsInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsInfo(block: SessionDetailsInfo.() -> Unit = {}): SessionDetailsInfo = SessionDetailsInfo.allocate().apply(block)

@JvmInline
public value class SessionDetailsCopyInfoOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionDetailsCopyInfoOptions = SessionDetailsCopyInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsCopyInfoOptions {
      val struct = SessionDetailsCopyInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsCopyInfoOptions(block: SessionDetailsCopyInfoOptions.() -> Unit = {}): SessionDetailsCopyInfoOptions = SessionDetailsCopyInfoOptions.allocate().apply(block)

@JvmInline
public value class SessionDetailsGetSessionAttributeCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionDetailsGetSessionAttributeCountOptions =
        SessionDetailsGetSessionAttributeCountOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsGetSessionAttributeCountOptions {
      val struct = SessionDetailsGetSessionAttributeCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsGetSessionAttributeCountOptions(block: SessionDetailsGetSessionAttributeCountOptions.() -> Unit = {}): SessionDetailsGetSessionAttributeCountOptions = SessionDetailsGetSessionAttributeCountOptions.allocate().apply(block)

@JvmInline
public value class SessionDetailsCopySessionAttributeByIndexOptions(
  public val address: Long,
) {
  public var attrIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionDetailsCopySessionAttributeByIndexOptions =
        SessionDetailsCopySessionAttributeByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsCopySessionAttributeByIndexOptions {
      val struct = SessionDetailsCopySessionAttributeByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsCopySessionAttributeByIndexOptions(block: SessionDetailsCopySessionAttributeByIndexOptions.() -> Unit = {}): SessionDetailsCopySessionAttributeByIndexOptions = SessionDetailsCopySessionAttributeByIndexOptions.allocate().apply(block)

@JvmInline
public value class SessionDetailsCopySessionAttributeByKeyOptions(
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

    public val NULL: SessionDetailsCopySessionAttributeByKeyOptions =
        SessionDetailsCopySessionAttributeByKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionDetailsCopySessionAttributeByKeyOptions {
      val struct = SessionDetailsCopySessionAttributeByKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionDetailsCopySessionAttributeByKeyOptions(block: SessionDetailsCopySessionAttributeByKeyOptions.() -> Unit = {}): SessionDetailsCopySessionAttributeByKeyOptions = SessionDetailsCopySessionAttributeByKeyOptions.allocate().apply(block)

@JvmInline
public value class ActiveSessionInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var state: EOnlineSessionState
    get() = EOnlineSessionState(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var sessionDetails: SessionDetailsInfo
    get() = SessionDetailsInfo(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.address)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: ActiveSessionInfo = ActiveSessionInfo(0)

    context(arena: Arena)
    public fun allocate(): ActiveSessionInfo {
      val struct = ActiveSessionInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ActiveSessionInfo(block: ActiveSessionInfo.() -> Unit = {}): ActiveSessionInfo = ActiveSessionInfo.allocate().apply(block)

@JvmInline
public value class SessionsCopyActiveSessionHandleOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsCopyActiveSessionHandleOptions =
        SessionsCopyActiveSessionHandleOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCopyActiveSessionHandleOptions {
      val struct = SessionsCopyActiveSessionHandleOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCopyActiveSessionHandleOptions(block: SessionsCopyActiveSessionHandleOptions.() -> Unit = {}): SessionsCopyActiveSessionHandleOptions = SessionsCopyActiveSessionHandleOptions.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifySessionInviteReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifySessionInviteReceivedOptions =
        SessionsAddNotifySessionInviteReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifySessionInviteReceivedOptions {
      val struct = SessionsAddNotifySessionInviteReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifySessionInviteReceivedOptions(block: SessionsAddNotifySessionInviteReceivedOptions.() -> Unit = {}): SessionsAddNotifySessionInviteReceivedOptions = SessionsAddNotifySessionInviteReceivedOptions.allocate().apply(block)

@JvmInline
public value class SessionsSessionInviteReceivedCallbackInfo(
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

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsSessionInviteReceivedCallbackInfo =
        SessionsSessionInviteReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsSessionInviteReceivedCallbackInfo {
      val struct = SessionsSessionInviteReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSessionInviteReceivedCallbackInfo(block: SessionsSessionInviteReceivedCallbackInfo.() -> Unit = {}): SessionsSessionInviteReceivedCallbackInfo = SessionsSessionInviteReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifySessionInviteAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifySessionInviteAcceptedOptions =
        SessionsAddNotifySessionInviteAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifySessionInviteAcceptedOptions {
      val struct = SessionsAddNotifySessionInviteAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifySessionInviteAcceptedOptions(block: SessionsAddNotifySessionInviteAcceptedOptions.() -> Unit = {}): SessionsAddNotifySessionInviteAcceptedOptions = SessionsAddNotifySessionInviteAcceptedOptions.allocate().apply(block)

@JvmInline
public value class SessionsSessionInviteAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  context(arena: Arena)
  public var sessionId: String?
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

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: SessionsSessionInviteAcceptedCallbackInfo =
        SessionsSessionInviteAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsSessionInviteAcceptedCallbackInfo {
      val struct = SessionsSessionInviteAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSessionInviteAcceptedCallbackInfo(block: SessionsSessionInviteAcceptedCallbackInfo.() -> Unit = {}): SessionsSessionInviteAcceptedCallbackInfo = SessionsSessionInviteAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifySessionInviteRejectedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifySessionInviteRejectedOptions =
        SessionsAddNotifySessionInviteRejectedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifySessionInviteRejectedOptions {
      val struct = SessionsAddNotifySessionInviteRejectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifySessionInviteRejectedOptions(block: SessionsAddNotifySessionInviteRejectedOptions.() -> Unit = {}): SessionsAddNotifySessionInviteRejectedOptions = SessionsAddNotifySessionInviteRejectedOptions.allocate().apply(block)

@JvmInline
public value class SessionsSessionInviteRejectedCallbackInfo(
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

  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: SessionsSessionInviteRejectedCallbackInfo =
        SessionsSessionInviteRejectedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsSessionInviteRejectedCallbackInfo {
      val struct = SessionsSessionInviteRejectedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSessionInviteRejectedCallbackInfo(block: SessionsSessionInviteRejectedCallbackInfo.() -> Unit = {}): SessionsSessionInviteRejectedCallbackInfo = SessionsSessionInviteRejectedCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifyJoinSessionAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifyJoinSessionAcceptedOptions =
        SessionsAddNotifyJoinSessionAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifyJoinSessionAcceptedOptions {
      val struct = SessionsAddNotifyJoinSessionAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifyJoinSessionAcceptedOptions(block: SessionsAddNotifyJoinSessionAcceptedOptions.() -> Unit = {}): SessionsAddNotifyJoinSessionAcceptedOptions = SessionsAddNotifyJoinSessionAcceptedOptions.allocate().apply(block)

@JvmInline
public value class SessionsJoinSessionAcceptedCallbackInfo(
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

    public val NULL: SessionsJoinSessionAcceptedCallbackInfo =
        SessionsJoinSessionAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsJoinSessionAcceptedCallbackInfo {
      val struct = SessionsJoinSessionAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsJoinSessionAcceptedCallbackInfo(block: SessionsJoinSessionAcceptedCallbackInfo.() -> Unit = {}): SessionsJoinSessionAcceptedCallbackInfo = SessionsJoinSessionAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsCopySessionHandleByInviteIdOptions(
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

    public val NULL: SessionsCopySessionHandleByInviteIdOptions =
        SessionsCopySessionHandleByInviteIdOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCopySessionHandleByInviteIdOptions {
      val struct = SessionsCopySessionHandleByInviteIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCopySessionHandleByInviteIdOptions(block: SessionsCopySessionHandleByInviteIdOptions.() -> Unit = {}): SessionsCopySessionHandleByInviteIdOptions = SessionsCopySessionHandleByInviteIdOptions.allocate().apply(block)

@JvmInline
public value class SessionsCopySessionHandleByUiEventIdOptions(
  public val address: Long,
) {
  public var uiEventId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsCopySessionHandleByUiEventIdOptions =
        SessionsCopySessionHandleByUiEventIdOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCopySessionHandleByUiEventIdOptions {
      val struct = SessionsCopySessionHandleByUiEventIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCopySessionHandleByUiEventIdOptions(block: SessionsCopySessionHandleByUiEventIdOptions.() -> Unit = {}): SessionsCopySessionHandleByUiEventIdOptions = SessionsCopySessionHandleByUiEventIdOptions.allocate().apply(block)

@JvmInline
public value class SessionsCopySessionHandleForPresenceOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsCopySessionHandleForPresenceOptions =
        SessionsCopySessionHandleForPresenceOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCopySessionHandleForPresenceOptions {
      val struct = SessionsCopySessionHandleForPresenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCopySessionHandleForPresenceOptions(block: SessionsCopySessionHandleForPresenceOptions.() -> Unit = {}): SessionsCopySessionHandleForPresenceOptions = SessionsCopySessionHandleForPresenceOptions.allocate().apply(block)

@JvmInline
public value class SessionsIsUserInSessionOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
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

    public val NULL: SessionsIsUserInSessionOptions = SessionsIsUserInSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsIsUserInSessionOptions {
      val struct = SessionsIsUserInSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsIsUserInSessionOptions(block: SessionsIsUserInSessionOptions.() -> Unit = {}): SessionsIsUserInSessionOptions = SessionsIsUserInSessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsDumpSessionStateOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsDumpSessionStateOptions = SessionsDumpSessionStateOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsDumpSessionStateOptions {
      val struct = SessionsDumpSessionStateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsDumpSessionStateOptions(block: SessionsDumpSessionStateOptions.() -> Unit = {}): SessionsDumpSessionStateOptions = SessionsDumpSessionStateOptions.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifyLeaveSessionRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifyLeaveSessionRequestedOptions =
        SessionsAddNotifyLeaveSessionRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifyLeaveSessionRequestedOptions {
      val struct = SessionsAddNotifyLeaveSessionRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifyLeaveSessionRequestedOptions(block: SessionsAddNotifyLeaveSessionRequestedOptions.() -> Unit = {}): SessionsAddNotifyLeaveSessionRequestedOptions = SessionsAddNotifyLeaveSessionRequestedOptions.allocate().apply(block)

@JvmInline
public value class SessionsLeaveSessionRequestedCallbackInfo(
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
  public var sessionName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionsLeaveSessionRequestedCallbackInfo =
        SessionsLeaveSessionRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsLeaveSessionRequestedCallbackInfo {
      val struct = SessionsLeaveSessionRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsLeaveSessionRequestedCallbackInfo(block: SessionsLeaveSessionRequestedCallbackInfo.() -> Unit = {}): SessionsLeaveSessionRequestedCallbackInfo = SessionsLeaveSessionRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsAddNotifySendSessionNativeInviteRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: SessionsAddNotifySendSessionNativeInviteRequestedOptions =
        SessionsAddNotifySendSessionNativeInviteRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsAddNotifySendSessionNativeInviteRequestedOptions {
      val struct = SessionsAddNotifySendSessionNativeInviteRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAddNotifySendSessionNativeInviteRequestedOptions(block: SessionsAddNotifySendSessionNativeInviteRequestedOptions.() -> Unit = {}): SessionsAddNotifySendSessionNativeInviteRequestedOptions = SessionsAddNotifySendSessionNativeInviteRequestedOptions.allocate().apply(block)

@JvmInline
public value class SessionsSendSessionNativeInviteRequestedCallbackInfo(
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

  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: SessionsSendSessionNativeInviteRequestedCallbackInfo =
        SessionsSendSessionNativeInviteRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsSendSessionNativeInviteRequestedCallbackInfo {
      val struct = SessionsSendSessionNativeInviteRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSendSessionNativeInviteRequestedCallbackInfo(block: SessionsSendSessionNativeInviteRequestedCallbackInfo.() -> Unit = {}): SessionsSendSessionNativeInviteRequestedCallbackInfo = SessionsSendSessionNativeInviteRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class StatsIngestData(
  public val address: Long,
) {
  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var ingestAmount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: StatsIngestData = StatsIngestData(0)

    context(arena: Arena)
    public fun allocate(): StatsIngestData {
      val struct = StatsIngestData(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsIngestData(block: StatsIngestData.() -> Unit = {}): StatsIngestData = StatsIngestData.allocate().apply(block)

@JvmInline
public value class StatsIngestStatOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var stats: StatsIngestData
    get() = StatsIngestData(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public var statsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: StatsIngestStatOptions = StatsIngestStatOptions(0)

    context(arena: Arena)
    public fun allocate(): StatsIngestStatOptions {
      val struct = StatsIngestStatOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsIngestStatOptions(block: StatsIngestStatOptions.() -> Unit = {}): StatsIngestStatOptions = StatsIngestStatOptions.allocate().apply(block)

@JvmInline
public value class StatsIngestStatCompleteCallbackInfo(
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

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: StatsIngestStatCompleteCallbackInfo = StatsIngestStatCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): StatsIngestStatCompleteCallbackInfo {
      val struct = StatsIngestStatCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsIngestStatCompleteCallbackInfo(block: StatsIngestStatCompleteCallbackInfo.() -> Unit = {}): StatsIngestStatCompleteCallbackInfo = StatsIngestStatCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class StatsQueryStatsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var startTime: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var endTime: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var statNames: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var statNamesCount: Int
    get() = RawMemory.getInt(address + 40)
    set(`value`) {
      RawMemory.putInt(address + 40, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: StatsQueryStatsOptions = StatsQueryStatsOptions(0)

    context(arena: Arena)
    public fun allocate(): StatsQueryStatsOptions {
      val struct = StatsQueryStatsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsQueryStatsOptions(block: StatsQueryStatsOptions.() -> Unit = {}): StatsQueryStatsOptions = StatsQueryStatsOptions.allocate().apply(block)

@JvmInline
public value class StatsStat(
  public val address: Long,
) {
  context(arena: Arena)
  public var name: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var startTime: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var endTime: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var `value`: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: StatsStat = StatsStat(0)

    context(arena: Arena)
    public fun allocate(): StatsStat {
      val struct = StatsStat(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsStat(block: StatsStat.() -> Unit = {}): StatsStat = StatsStat.allocate().apply(block)

@JvmInline
public value class StatsGetStatCountOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: StatsGetStatCountOptions = StatsGetStatCountOptions(0)

    context(arena: Arena)
    public fun allocate(): StatsGetStatCountOptions {
      val struct = StatsGetStatCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsGetStatCountOptions(block: StatsGetStatCountOptions.() -> Unit = {}): StatsGetStatCountOptions = StatsGetStatCountOptions.allocate().apply(block)

@JvmInline
public value class StatsCopyStatByIndexOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var statIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: StatsCopyStatByIndexOptions = StatsCopyStatByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): StatsCopyStatByIndexOptions {
      val struct = StatsCopyStatByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsCopyStatByIndexOptions(block: StatsCopyStatByIndexOptions.() -> Unit = {}): StatsCopyStatByIndexOptions = StatsCopyStatByIndexOptions.allocate().apply(block)

@JvmInline
public value class StatsCopyStatByNameOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var name: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: StatsCopyStatByNameOptions = StatsCopyStatByNameOptions(0)

    context(arena: Arena)
    public fun allocate(): StatsCopyStatByNameOptions {
      val struct = StatsCopyStatByNameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsCopyStatByNameOptions(block: StatsCopyStatByNameOptions.() -> Unit = {}): StatsCopyStatByNameOptions = StatsCopyStatByNameOptions.allocate().apply(block)

@JvmInline
public value class StatsOnQueryStatsCompleteCallbackInfo(
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

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: StatsOnQueryStatsCompleteCallbackInfo =
        StatsOnQueryStatsCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): StatsOnQueryStatsCompleteCallbackInfo {
      val struct = StatsOnQueryStatsCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun StatsOnQueryStatsCompleteCallbackInfo(block: StatsOnQueryStatsCompleteCallbackInfo.() -> Unit = {}): StatsOnQueryStatsCompleteCallbackInfo = StatsOnQueryStatsCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageFileMetadata(
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

  public var unencryptedDataSizeBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: TitleStorageFileMetadata = TitleStorageFileMetadata(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageFileMetadata {
      val struct = TitleStorageFileMetadata(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageFileMetadata(block: TitleStorageFileMetadata.() -> Unit = {}): TitleStorageFileMetadata = TitleStorageFileMetadata.allocate().apply(block)

@JvmInline
public value class TitleStorageQueryFileOptions(
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

    public val NULL: TitleStorageQueryFileOptions = TitleStorageQueryFileOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageQueryFileOptions {
      val struct = TitleStorageQueryFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageQueryFileOptions(block: TitleStorageQueryFileOptions.() -> Unit = {}): TitleStorageQueryFileOptions = TitleStorageQueryFileOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageQueryFileCallbackInfo(
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

    public val NULL: TitleStorageQueryFileCallbackInfo = TitleStorageQueryFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageQueryFileCallbackInfo {
      val struct = TitleStorageQueryFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageQueryFileCallbackInfo(block: TitleStorageQueryFileCallbackInfo.() -> Unit = {}): TitleStorageQueryFileCallbackInfo = TitleStorageQueryFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageQueryFileListOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var listOfTags: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var listOfTagsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: TitleStorageQueryFileListOptions = TitleStorageQueryFileListOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageQueryFileListOptions {
      val struct = TitleStorageQueryFileListOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageQueryFileListOptions(block: TitleStorageQueryFileListOptions.() -> Unit = {}): TitleStorageQueryFileListOptions = TitleStorageQueryFileListOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageQueryFileListCallbackInfo(
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

    public val NULL: TitleStorageQueryFileListCallbackInfo =
        TitleStorageQueryFileListCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageQueryFileListCallbackInfo {
      val struct = TitleStorageQueryFileListCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageQueryFileListCallbackInfo(block: TitleStorageQueryFileListCallbackInfo.() -> Unit = {}): TitleStorageQueryFileListCallbackInfo = TitleStorageQueryFileListCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageGetFileMetadataCountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: TitleStorageGetFileMetadataCountOptions =
        TitleStorageGetFileMetadataCountOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageGetFileMetadataCountOptions {
      val struct = TitleStorageGetFileMetadataCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageGetFileMetadataCountOptions(block: TitleStorageGetFileMetadataCountOptions.() -> Unit = {}): TitleStorageGetFileMetadataCountOptions = TitleStorageGetFileMetadataCountOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageCopyFileMetadataAtIndexOptions(
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

    public val NULL: TitleStorageCopyFileMetadataAtIndexOptions =
        TitleStorageCopyFileMetadataAtIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageCopyFileMetadataAtIndexOptions {
      val struct = TitleStorageCopyFileMetadataAtIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageCopyFileMetadataAtIndexOptions(block: TitleStorageCopyFileMetadataAtIndexOptions.() -> Unit = {}): TitleStorageCopyFileMetadataAtIndexOptions = TitleStorageCopyFileMetadataAtIndexOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageCopyFileMetadataByFilenameOptions(
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

    public val NULL: TitleStorageCopyFileMetadataByFilenameOptions =
        TitleStorageCopyFileMetadataByFilenameOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageCopyFileMetadataByFilenameOptions {
      val struct = TitleStorageCopyFileMetadataByFilenameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageCopyFileMetadataByFilenameOptions(block: TitleStorageCopyFileMetadataByFilenameOptions.() -> Unit = {}): TitleStorageCopyFileMetadataByFilenameOptions = TitleStorageCopyFileMetadataByFilenameOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageFileTransferProgressCallbackInfo(
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

    public val NULL: TitleStorageFileTransferProgressCallbackInfo =
        TitleStorageFileTransferProgressCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageFileTransferProgressCallbackInfo {
      val struct = TitleStorageFileTransferProgressCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageFileTransferProgressCallbackInfo(block: TitleStorageFileTransferProgressCallbackInfo.() -> Unit = {}): TitleStorageFileTransferProgressCallbackInfo = TitleStorageFileTransferProgressCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageReadFileDataCallbackInfo(
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

    public val NULL: TitleStorageReadFileDataCallbackInfo = TitleStorageReadFileDataCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageReadFileDataCallbackInfo {
      val struct = TitleStorageReadFileDataCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageReadFileDataCallbackInfo(block: TitleStorageReadFileDataCallbackInfo.() -> Unit = {}): TitleStorageReadFileDataCallbackInfo = TitleStorageReadFileDataCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageReadFileOptions(
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

    public val NULL: TitleStorageReadFileOptions = TitleStorageReadFileOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageReadFileOptions {
      val struct = TitleStorageReadFileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageReadFileOptions(block: TitleStorageReadFileOptions.() -> Unit = {}): TitleStorageReadFileOptions = TitleStorageReadFileOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageReadFileCallbackInfo(
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

    public val NULL: TitleStorageReadFileCallbackInfo = TitleStorageReadFileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageReadFileCallbackInfo {
      val struct = TitleStorageReadFileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageReadFileCallbackInfo(block: TitleStorageReadFileCallbackInfo.() -> Unit = {}): TitleStorageReadFileCallbackInfo = TitleStorageReadFileCallbackInfo.allocate().apply(block)

@JvmInline
public value class TitleStorageDeleteCacheOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: TitleStorageDeleteCacheOptions = TitleStorageDeleteCacheOptions(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageDeleteCacheOptions {
      val struct = TitleStorageDeleteCacheOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageDeleteCacheOptions(block: TitleStorageDeleteCacheOptions.() -> Unit = {}): TitleStorageDeleteCacheOptions = TitleStorageDeleteCacheOptions.allocate().apply(block)

@JvmInline
public value class TitleStorageDeleteCacheCallbackInfo(
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

    public val NULL: TitleStorageDeleteCacheCallbackInfo = TitleStorageDeleteCacheCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): TitleStorageDeleteCacheCallbackInfo {
      val struct = TitleStorageDeleteCacheCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun TitleStorageDeleteCacheCallbackInfo(block: TitleStorageDeleteCacheCallbackInfo.() -> Unit = {}): TitleStorageDeleteCacheCallbackInfo = TitleStorageDeleteCacheCallbackInfo.allocate().apply(block)

@JvmInline
public value class PlatformClientCredentials(
  public val address: Long,
) {
  context(arena: Arena)
  public var clientId: String?
    get() = RawMemory.getLong(address).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var clientSecret: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: PlatformClientCredentials = PlatformClientCredentials(0)

    context(arena: Arena)
    public fun allocate(): PlatformClientCredentials {
      val struct = PlatformClientCredentials(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlatformClientCredentials(block: PlatformClientCredentials.() -> Unit = {}): PlatformClientCredentials = PlatformClientCredentials.allocate().apply(block)

@JvmInline
public value class PlatformRTCOptions(
  public val address: Long,
) {
  public var platformSpecificOptions: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var backgroundMode: ERTCBackgroundMode
    get() = ERTCBackgroundMode(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var reserved: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: PlatformRTCOptions = PlatformRTCOptions(0)

    context(arena: Arena)
    public fun allocate(): PlatformRTCOptions {
      val struct = PlatformRTCOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlatformRTCOptions(block: PlatformRTCOptions.() -> Unit = {}): PlatformRTCOptions = PlatformRTCOptions.allocate().apply(block)

@JvmInline
public value class PlatformOptions(
  public val address: Long,
) {
  public var reserved: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var productId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var sandboxId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public val clientCredentials: PlatformClientCredentials
    get() = PlatformClientCredentials(address + 32)

  public var isServer: Boolean
    get() = RawMemory.getInt(address + 48) != 0
    set(`value`) {
      RawMemory.putInt(address + 48, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var encryptionKey: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var overrideCountryCode: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var overrideLocaleCode: String?
    get() = RawMemory.getLong(address + 72).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 72, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deploymentId: String?
    get() = RawMemory.getLong(address + 80).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 80, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var flags: Long
    get() = RawMemory.getLong(address + 88)
    set(`value`) {
      RawMemory.putLong(address + 88, value)
    }

  context(arena: Arena)
  public var cacheDirectory: String?
    get() = RawMemory.getLong(address + 96).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 96, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var tickBudgetInMilliseconds: Int
    get() = RawMemory.getInt(address + 104)
    set(`value`) {
      RawMemory.putInt(address + 104, value)
    }

  public var rTCOptions: PlatformRTCOptions
    get() = PlatformRTCOptions(RawMemory.getLong(address + 112))
    set(`value`) {
      RawMemory.putLong(address + 112, value.address)
    }

  public var integratedPlatformOptionsContainerHandle: HIntegratedPlatformOptionsContainer
    get() = HIntegratedPlatformOptionsContainer(RawMemory.getLong(address + 120))
    set(`value`) {
      RawMemory.putLong(address + 120, value.handle)
    }

  public var systemSpecificOptions: Long
    get() = RawMemory.getLong(address + 128)
    set(`value`) {
      RawMemory.putLong(address + 128, value)
    }

  public var taskNetworkTimeoutSeconds: Long
    get() = RawMemory.getLong(address + 136)
    set(`value`) {
      RawMemory.putLong(address + 136, value)
    }

  public companion object {
    public const val SIZE: Long = 144

    public val NULL: PlatformOptions = PlatformOptions(0)

    context(arena: Arena)
    public fun allocate(): PlatformOptions {
      val struct = PlatformOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 15)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlatformOptions(block: PlatformOptions.() -> Unit = {}): PlatformOptions = PlatformOptions.allocate().apply(block)

@JvmInline
public value class PlatformGetDesktopCrossplayStatusOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: PlatformGetDesktopCrossplayStatusOptions =
        PlatformGetDesktopCrossplayStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): PlatformGetDesktopCrossplayStatusOptions {
      val struct = PlatformGetDesktopCrossplayStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlatformGetDesktopCrossplayStatusOptions(block: PlatformGetDesktopCrossplayStatusOptions.() -> Unit = {}): PlatformGetDesktopCrossplayStatusOptions = PlatformGetDesktopCrossplayStatusOptions.allocate().apply(block)

@JvmInline
public value class PlatformDesktopCrossplayStatusInfo(
  public val address: Long,
) {
  public var status: EDesktopCrossplayStatus
    get() = EDesktopCrossplayStatus(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var serviceInitResult: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: PlatformDesktopCrossplayStatusInfo = PlatformDesktopCrossplayStatusInfo(0)

    context(arena: Arena)
    public fun allocate(): PlatformDesktopCrossplayStatusInfo {
      val struct = PlatformDesktopCrossplayStatusInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun PlatformDesktopCrossplayStatusInfo(block: PlatformDesktopCrossplayStatusInfo.() -> Unit = {}): PlatformDesktopCrossplayStatusInfo = PlatformDesktopCrossplayStatusInfo.allocate().apply(block)

@JvmInline
public value class UIShowFriendsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIShowFriendsOptions = UIShowFriendsOptions(0)

    context(arena: Arena)
    public fun allocate(): UIShowFriendsOptions {
      val struct = UIShowFriendsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowFriendsOptions(block: UIShowFriendsOptions.() -> Unit = {}): UIShowFriendsOptions = UIShowFriendsOptions.allocate().apply(block)

@JvmInline
public value class UIShowFriendsCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: UIShowFriendsCallbackInfo = UIShowFriendsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIShowFriendsCallbackInfo {
      val struct = UIShowFriendsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowFriendsCallbackInfo(block: UIShowFriendsCallbackInfo.() -> Unit = {}): UIShowFriendsCallbackInfo = UIShowFriendsCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIHideFriendsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIHideFriendsOptions = UIHideFriendsOptions(0)

    context(arena: Arena)
    public fun allocate(): UIHideFriendsOptions {
      val struct = UIHideFriendsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIHideFriendsOptions(block: UIHideFriendsOptions.() -> Unit = {}): UIHideFriendsOptions = UIHideFriendsOptions.allocate().apply(block)

@JvmInline
public value class UIHideFriendsCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: UIHideFriendsCallbackInfo = UIHideFriendsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIHideFriendsCallbackInfo {
      val struct = UIHideFriendsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIHideFriendsCallbackInfo(block: UIHideFriendsCallbackInfo.() -> Unit = {}): UIHideFriendsCallbackInfo = UIHideFriendsCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIGetFriendsVisibleOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIGetFriendsVisibleOptions = UIGetFriendsVisibleOptions(0)

    context(arena: Arena)
    public fun allocate(): UIGetFriendsVisibleOptions {
      val struct = UIGetFriendsVisibleOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIGetFriendsVisibleOptions(block: UIGetFriendsVisibleOptions.() -> Unit = {}): UIGetFriendsVisibleOptions = UIGetFriendsVisibleOptions.allocate().apply(block)

@JvmInline
public value class UIGetFriendsExclusiveInputOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIGetFriendsExclusiveInputOptions = UIGetFriendsExclusiveInputOptions(0)

    context(arena: Arena)
    public fun allocate(): UIGetFriendsExclusiveInputOptions {
      val struct = UIGetFriendsExclusiveInputOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIGetFriendsExclusiveInputOptions(block: UIGetFriendsExclusiveInputOptions.() -> Unit = {}): UIGetFriendsExclusiveInputOptions = UIGetFriendsExclusiveInputOptions.allocate().apply(block)

@JvmInline
public value class UIAddNotifyDisplaySettingsUpdatedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIAddNotifyDisplaySettingsUpdatedOptions =
        UIAddNotifyDisplaySettingsUpdatedOptions(0)

    context(arena: Arena)
    public fun allocate(): UIAddNotifyDisplaySettingsUpdatedOptions {
      val struct = UIAddNotifyDisplaySettingsUpdatedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIAddNotifyDisplaySettingsUpdatedOptions(block: UIAddNotifyDisplaySettingsUpdatedOptions.() -> Unit = {}): UIAddNotifyDisplaySettingsUpdatedOptions = UIAddNotifyDisplaySettingsUpdatedOptions.allocate().apply(block)

@JvmInline
public value class UIOnDisplaySettingsUpdatedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var isVisible: Boolean
    get() = RawMemory.getInt(address + 8) != 0
    set(`value`) {
      RawMemory.putInt(address + 8, if (value) 1 else 0)
    }

  public var isExclusiveInput: Boolean
    get() = RawMemory.getInt(address + 12) != 0
    set(`value`) {
      RawMemory.putInt(address + 12, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIOnDisplaySettingsUpdatedCallbackInfo =
        UIOnDisplaySettingsUpdatedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIOnDisplaySettingsUpdatedCallbackInfo {
      val struct = UIOnDisplaySettingsUpdatedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIOnDisplaySettingsUpdatedCallbackInfo(block: UIOnDisplaySettingsUpdatedCallbackInfo.() -> Unit = {}): UIOnDisplaySettingsUpdatedCallbackInfo = UIOnDisplaySettingsUpdatedCallbackInfo.allocate().apply(block)

@JvmInline
public value class UISetToggleFriendsKeyOptions(
  public val address: Long,
) {
  public var keyCombination: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: UISetToggleFriendsKeyOptions = UISetToggleFriendsKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): UISetToggleFriendsKeyOptions {
      val struct = UISetToggleFriendsKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UISetToggleFriendsKeyOptions(block: UISetToggleFriendsKeyOptions.() -> Unit = {}): UISetToggleFriendsKeyOptions = UISetToggleFriendsKeyOptions.allocate().apply(block)

@JvmInline
public value class UIGetToggleFriendsKeyOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIGetToggleFriendsKeyOptions = UIGetToggleFriendsKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): UIGetToggleFriendsKeyOptions {
      val struct = UIGetToggleFriendsKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIGetToggleFriendsKeyOptions(block: UIGetToggleFriendsKeyOptions.() -> Unit = {}): UIGetToggleFriendsKeyOptions = UIGetToggleFriendsKeyOptions.allocate().apply(block)

@JvmInline
public value class UISetToggleFriendsButtonOptions(
  public val address: Long,
) {
  public var buttonCombination: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: UISetToggleFriendsButtonOptions = UISetToggleFriendsButtonOptions(0)

    context(arena: Arena)
    public fun allocate(): UISetToggleFriendsButtonOptions {
      val struct = UISetToggleFriendsButtonOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UISetToggleFriendsButtonOptions(block: UISetToggleFriendsButtonOptions.() -> Unit = {}): UISetToggleFriendsButtonOptions = UISetToggleFriendsButtonOptions.allocate().apply(block)

@JvmInline
public value class UIGetToggleFriendsButtonOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIGetToggleFriendsButtonOptions = UIGetToggleFriendsButtonOptions(0)

    context(arena: Arena)
    public fun allocate(): UIGetToggleFriendsButtonOptions {
      val struct = UIGetToggleFriendsButtonOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIGetToggleFriendsButtonOptions(block: UIGetToggleFriendsButtonOptions.() -> Unit = {}): UIGetToggleFriendsButtonOptions = UIGetToggleFriendsButtonOptions.allocate().apply(block)

@JvmInline
public value class UISetDisplayPreferenceOptions(
  public val address: Long,
) {
  public var notificationLocation: UIENotificationLocation
    get() = UIENotificationLocation(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: UISetDisplayPreferenceOptions = UISetDisplayPreferenceOptions(0)

    context(arena: Arena)
    public fun allocate(): UISetDisplayPreferenceOptions {
      val struct = UISetDisplayPreferenceOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UISetDisplayPreferenceOptions(block: UISetDisplayPreferenceOptions.() -> Unit = {}): UISetDisplayPreferenceOptions = UISetDisplayPreferenceOptions.allocate().apply(block)

@JvmInline
public value class UIAcknowledgeEventIdOptions(
  public val address: Long,
) {
  public var uiEventId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var result: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: UIAcknowledgeEventIdOptions = UIAcknowledgeEventIdOptions(0)

    context(arena: Arena)
    public fun allocate(): UIAcknowledgeEventIdOptions {
      val struct = UIAcknowledgeEventIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIAcknowledgeEventIdOptions(block: UIAcknowledgeEventIdOptions.() -> Unit = {}): UIAcknowledgeEventIdOptions = UIAcknowledgeEventIdOptions.allocate().apply(block)

@JvmInline
public value class UIReportInputStateOptions(
  public val address: Long,
) {
  public var buttonDownFlags: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var acceptIsFaceButtonRight: Boolean
    get() = RawMemory.getInt(address + 8) != 0
    set(`value`) {
      RawMemory.putInt(address + 8, if (value) 1 else 0)
    }

  public var mouseButtonDown: Boolean
    get() = RawMemory.getInt(address + 12) != 0
    set(`value`) {
      RawMemory.putInt(address + 12, if (value) 1 else 0)
    }

  public var mousePosX: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var mousePosY: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var gamepadIndex: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var leftStickX: Float
    get() = RawMemory.getFloat(address + 28)
    set(`value`) {
      RawMemory.putFloat(address + 28, value)
    }

  public var leftStickY: Float
    get() = RawMemory.getFloat(address + 32)
    set(`value`) {
      RawMemory.putFloat(address + 32, value)
    }

  public var rightStickX: Float
    get() = RawMemory.getFloat(address + 36)
    set(`value`) {
      RawMemory.putFloat(address + 36, value)
    }

  public var rightStickY: Float
    get() = RawMemory.getFloat(address + 40)
    set(`value`) {
      RawMemory.putFloat(address + 40, value)
    }

  public var leftTrigger: Float
    get() = RawMemory.getFloat(address + 44)
    set(`value`) {
      RawMemory.putFloat(address + 44, value)
    }

  public var rightTrigger: Float
    get() = RawMemory.getFloat(address + 48)
    set(`value`) {
      RawMemory.putFloat(address + 48, value)
    }

  public companion object {
    public const val SIZE: Long = 52

    public val NULL: UIReportInputStateOptions = UIReportInputStateOptions(0)

    context(arena: Arena)
    public fun allocate(): UIReportInputStateOptions {
      val struct = UIReportInputStateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIReportInputStateOptions(block: UIReportInputStateOptions.() -> Unit = {}): UIReportInputStateOptions = UIReportInputStateOptions.allocate().apply(block)

@JvmInline
public value class UIPrePresentOptions(
  public val address: Long,
) {
  public var platformSpecificData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIPrePresentOptions = UIPrePresentOptions(0)

    context(arena: Arena)
    public fun allocate(): UIPrePresentOptions {
      val struct = UIPrePresentOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIPrePresentOptions(block: UIPrePresentOptions.() -> Unit = {}): UIPrePresentOptions = UIPrePresentOptions.allocate().apply(block)

@JvmInline
public value class UIShowBlockPlayerOptions(
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

    public val NULL: UIShowBlockPlayerOptions = UIShowBlockPlayerOptions(0)

    context(arena: Arena)
    public fun allocate(): UIShowBlockPlayerOptions {
      val struct = UIShowBlockPlayerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowBlockPlayerOptions(block: UIShowBlockPlayerOptions.() -> Unit = {}): UIShowBlockPlayerOptions = UIShowBlockPlayerOptions.allocate().apply(block)

@JvmInline
public value class UIOnShowBlockPlayerCallbackInfo(
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

    public val NULL: UIOnShowBlockPlayerCallbackInfo = UIOnShowBlockPlayerCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIOnShowBlockPlayerCallbackInfo {
      val struct = UIOnShowBlockPlayerCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIOnShowBlockPlayerCallbackInfo(block: UIOnShowBlockPlayerCallbackInfo.() -> Unit = {}): UIOnShowBlockPlayerCallbackInfo = UIOnShowBlockPlayerCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIShowReportPlayerOptions(
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

    public val NULL: UIShowReportPlayerOptions = UIShowReportPlayerOptions(0)

    context(arena: Arena)
    public fun allocate(): UIShowReportPlayerOptions {
      val struct = UIShowReportPlayerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowReportPlayerOptions(block: UIShowReportPlayerOptions.() -> Unit = {}): UIShowReportPlayerOptions = UIShowReportPlayerOptions.allocate().apply(block)

@JvmInline
public value class UIOnShowReportPlayerCallbackInfo(
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

    public val NULL: UIOnShowReportPlayerCallbackInfo = UIOnShowReportPlayerCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIOnShowReportPlayerCallbackInfo {
      val struct = UIOnShowReportPlayerCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIOnShowReportPlayerCallbackInfo(block: UIOnShowReportPlayerCallbackInfo.() -> Unit = {}): UIOnShowReportPlayerCallbackInfo = UIOnShowReportPlayerCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIShowNativeProfileOptions(
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

    public val NULL: UIShowNativeProfileOptions = UIShowNativeProfileOptions(0)

    context(arena: Arena)
    public fun allocate(): UIShowNativeProfileOptions {
      val struct = UIShowNativeProfileOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowNativeProfileOptions(block: UIShowNativeProfileOptions.() -> Unit = {}): UIShowNativeProfileOptions = UIShowNativeProfileOptions.allocate().apply(block)

@JvmInline
public value class UIShowNativeProfileCallbackInfo(
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

    public val NULL: UIShowNativeProfileCallbackInfo = UIShowNativeProfileCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIShowNativeProfileCallbackInfo {
      val struct = UIShowNativeProfileCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIShowNativeProfileCallbackInfo(block: UIShowNativeProfileCallbackInfo.() -> Unit = {}): UIShowNativeProfileCallbackInfo = UIShowNativeProfileCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIPauseSocialOverlayOptions(
  public val address: Long,
) {
  public var isPaused: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: UIPauseSocialOverlayOptions = UIPauseSocialOverlayOptions(0)

    context(arena: Arena)
    public fun allocate(): UIPauseSocialOverlayOptions {
      val struct = UIPauseSocialOverlayOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIPauseSocialOverlayOptions(block: UIPauseSocialOverlayOptions.() -> Unit = {}): UIPauseSocialOverlayOptions = UIPauseSocialOverlayOptions.allocate().apply(block)

@JvmInline
public value class UIIsSocialOverlayPausedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIIsSocialOverlayPausedOptions = UIIsSocialOverlayPausedOptions(0)

    context(arena: Arena)
    public fun allocate(): UIIsSocialOverlayPausedOptions {
      val struct = UIIsSocialOverlayPausedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIIsSocialOverlayPausedOptions(block: UIIsSocialOverlayPausedOptions.() -> Unit = {}): UIIsSocialOverlayPausedOptions = UIIsSocialOverlayPausedOptions.allocate().apply(block)

@JvmInline
public value class UIRect(
  public val address: Long,
) {
  public var x: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var y: Int
    get() = RawMemory.getInt(address + 8)
    set(`value`) {
      RawMemory.putInt(address + 8, value)
    }

  public var width: Int
    get() = RawMemory.getInt(address + 12)
    set(`value`) {
      RawMemory.putInt(address + 12, value)
    }

  public var height: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 20

    public val NULL: UIRect = UIRect(0)

    context(arena: Arena)
    public fun allocate(): UIRect {
      val struct = UIRect(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIRect(block: UIRect.() -> Unit = {}): UIRect = UIRect.allocate().apply(block)

@JvmInline
public value class UIMemoryMonitorCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var systemMemoryMonitorReport: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIMemoryMonitorCallbackInfo = UIMemoryMonitorCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIMemoryMonitorCallbackInfo {
      val struct = UIMemoryMonitorCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIMemoryMonitorCallbackInfo(block: UIMemoryMonitorCallbackInfo.() -> Unit = {}): UIMemoryMonitorCallbackInfo = UIMemoryMonitorCallbackInfo.allocate().apply(block)

@JvmInline
public value class UIAddNotifyMemoryMonitorOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIAddNotifyMemoryMonitorOptions = UIAddNotifyMemoryMonitorOptions(0)

    context(arena: Arena)
    public fun allocate(): UIAddNotifyMemoryMonitorOptions {
      val struct = UIAddNotifyMemoryMonitorOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIAddNotifyMemoryMonitorOptions(block: UIAddNotifyMemoryMonitorOptions.() -> Unit = {}): UIAddNotifyMemoryMonitorOptions = UIAddNotifyMemoryMonitorOptions.allocate().apply(block)

@JvmInline
public value class UIConfigureOnScreenKeyboardOptions(
  public val address: Long,
) {
  public var behavior: UIEOnScreenKeyboardBehavior
    get() = UIEOnScreenKeyboardBehavior(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var isDeviceChecksEnabled: Boolean
    get() = RawMemory.getInt(address + 8) != 0
    set(`value`) {
      RawMemory.putInt(address + 8, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 12

    public val NULL: UIConfigureOnScreenKeyboardOptions = UIConfigureOnScreenKeyboardOptions(0)

    context(arena: Arena)
    public fun allocate(): UIConfigureOnScreenKeyboardOptions {
      val struct = UIConfigureOnScreenKeyboardOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIConfigureOnScreenKeyboardOptions(block: UIConfigureOnScreenKeyboardOptions.() -> Unit = {}): UIConfigureOnScreenKeyboardOptions = UIConfigureOnScreenKeyboardOptions.allocate().apply(block)

@JvmInline
public value class UIAddNotifyOnScreenKeyboardRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UIAddNotifyOnScreenKeyboardRequestedOptions =
        UIAddNotifyOnScreenKeyboardRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): UIAddNotifyOnScreenKeyboardRequestedOptions {
      val struct = UIAddNotifyOnScreenKeyboardRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIAddNotifyOnScreenKeyboardRequestedOptions(block: UIAddNotifyOnScreenKeyboardRequestedOptions.() -> Unit = {}): UIAddNotifyOnScreenKeyboardRequestedOptions = UIAddNotifyOnScreenKeyboardRequestedOptions.allocate().apply(block)

@JvmInline
public value class UIOnScreenKeyboardRequestedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var type: UIEOnScreenKeyboardType
    get() = UIEOnScreenKeyboardType(RawMemory.getInt(address + 8))
    set(`value`) {
      RawMemory.putInt(address + 8, value.value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: UIOnScreenKeyboardRequestedCallbackInfo =
        UIOnScreenKeyboardRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UIOnScreenKeyboardRequestedCallbackInfo {
      val struct = UIOnScreenKeyboardRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UIOnScreenKeyboardRequestedCallbackInfo(block: UIOnScreenKeyboardRequestedCallbackInfo.() -> Unit = {}): UIOnScreenKeyboardRequestedCallbackInfo = UIOnScreenKeyboardRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class UserInfoQueryUserInfoOptions(
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

    public val NULL: UserInfoQueryUserInfoOptions = UserInfoQueryUserInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoOptions {
      val struct = UserInfoQueryUserInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoOptions(block: UserInfoQueryUserInfoOptions.() -> Unit = {}): UserInfoQueryUserInfoOptions = UserInfoQueryUserInfoOptions.allocate().apply(block)

@JvmInline
public value class UserInfoQueryUserInfoCallbackInfo(
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

    public val NULL: UserInfoQueryUserInfoCallbackInfo = UserInfoQueryUserInfoCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoCallbackInfo {
      val struct = UserInfoQueryUserInfoCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoCallbackInfo(block: UserInfoQueryUserInfoCallbackInfo.() -> Unit = {}): UserInfoQueryUserInfoCallbackInfo = UserInfoQueryUserInfoCallbackInfo.allocate().apply(block)
