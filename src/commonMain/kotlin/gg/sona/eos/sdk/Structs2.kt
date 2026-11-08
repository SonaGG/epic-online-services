@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class EcomCopyEntitlementByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyEntitlementByIndexOptions = EcomCopyEntitlementByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyEntitlementByIndexOptions {
      val struct = EcomCopyEntitlementByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyEntitlementByIndexOptions(block: EcomCopyEntitlementByIndexOptions.() -> Unit = {}): EcomCopyEntitlementByIndexOptions = EcomCopyEntitlementByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyEntitlementByNameAndIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementName: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var index: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomCopyEntitlementByNameAndIndexOptions =
        EcomCopyEntitlementByNameAndIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyEntitlementByNameAndIndexOptions {
      val struct = EcomCopyEntitlementByNameAndIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyEntitlementByNameAndIndexOptions(block: EcomCopyEntitlementByNameAndIndexOptions.() -> Unit = {}): EcomCopyEntitlementByNameAndIndexOptions = EcomCopyEntitlementByNameAndIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyEntitlementByIdOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyEntitlementByIdOptions = EcomCopyEntitlementByIdOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyEntitlementByIdOptions {
      val struct = EcomCopyEntitlementByIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyEntitlementByIdOptions(block: EcomCopyEntitlementByIdOptions.() -> Unit = {}): EcomCopyEntitlementByIdOptions = EcomCopyEntitlementByIdOptions.allocate().apply(block)

@JvmInline
public value class EcomGetOfferCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: EcomGetOfferCountOptions = EcomGetOfferCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetOfferCountOptions {
      val struct = EcomGetOfferCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetOfferCountOptions(block: EcomGetOfferCountOptions.() -> Unit = {}): EcomGetOfferCountOptions = EcomGetOfferCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyOfferByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyOfferByIndexOptions = EcomCopyOfferByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyOfferByIndexOptions {
      val struct = EcomCopyOfferByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyOfferByIndexOptions(block: EcomCopyOfferByIndexOptions.() -> Unit = {}): EcomCopyOfferByIndexOptions = EcomCopyOfferByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyOfferByIdOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyOfferByIdOptions = EcomCopyOfferByIdOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyOfferByIdOptions {
      val struct = EcomCopyOfferByIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyOfferByIdOptions(block: EcomCopyOfferByIdOptions.() -> Unit = {}): EcomCopyOfferByIdOptions = EcomCopyOfferByIdOptions.allocate().apply(block)

@JvmInline
public value class EcomGetOfferItemCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetOfferItemCountOptions = EcomGetOfferItemCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetOfferItemCountOptions {
      val struct = EcomGetOfferItemCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetOfferItemCountOptions(block: EcomGetOfferItemCountOptions.() -> Unit = {}): EcomGetOfferItemCountOptions = EcomGetOfferItemCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyOfferItemByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var itemIndex: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomCopyOfferItemByIndexOptions = EcomCopyOfferItemByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyOfferItemByIndexOptions {
      val struct = EcomCopyOfferItemByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyOfferItemByIndexOptions(block: EcomCopyOfferItemByIndexOptions.() -> Unit = {}): EcomCopyOfferItemByIndexOptions = EcomCopyOfferItemByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyItemByIdOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var itemId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyItemByIdOptions = EcomCopyItemByIdOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyItemByIdOptions {
      val struct = EcomCopyItemByIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyItemByIdOptions(block: EcomCopyItemByIdOptions.() -> Unit = {}): EcomCopyItemByIdOptions = EcomCopyItemByIdOptions.allocate().apply(block)

@JvmInline
public value class EcomGetOfferImageInfoCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetOfferImageInfoCountOptions = EcomGetOfferImageInfoCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetOfferImageInfoCountOptions {
      val struct = EcomGetOfferImageInfoCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetOfferImageInfoCountOptions(block: EcomGetOfferImageInfoCountOptions.() -> Unit = {}): EcomGetOfferImageInfoCountOptions = EcomGetOfferImageInfoCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyOfferImageInfoByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var offerId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var imageInfoIndex: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomCopyOfferImageInfoByIndexOptions = EcomCopyOfferImageInfoByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyOfferImageInfoByIndexOptions {
      val struct = EcomCopyOfferImageInfoByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyOfferImageInfoByIndexOptions(block: EcomCopyOfferImageInfoByIndexOptions.() -> Unit = {}): EcomCopyOfferImageInfoByIndexOptions = EcomCopyOfferImageInfoByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomGetItemImageInfoCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var itemId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetItemImageInfoCountOptions = EcomGetItemImageInfoCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetItemImageInfoCountOptions {
      val struct = EcomGetItemImageInfoCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetItemImageInfoCountOptions(block: EcomGetItemImageInfoCountOptions.() -> Unit = {}): EcomGetItemImageInfoCountOptions = EcomGetItemImageInfoCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyItemImageInfoByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var itemId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var imageInfoIndex: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomCopyItemImageInfoByIndexOptions = EcomCopyItemImageInfoByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyItemImageInfoByIndexOptions {
      val struct = EcomCopyItemImageInfoByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyItemImageInfoByIndexOptions(block: EcomCopyItemImageInfoByIndexOptions.() -> Unit = {}): EcomCopyItemImageInfoByIndexOptions = EcomCopyItemImageInfoByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomGetItemReleaseCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var itemId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetItemReleaseCountOptions = EcomGetItemReleaseCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetItemReleaseCountOptions {
      val struct = EcomGetItemReleaseCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetItemReleaseCountOptions(block: EcomGetItemReleaseCountOptions.() -> Unit = {}): EcomGetItemReleaseCountOptions = EcomGetItemReleaseCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyItemReleaseByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var itemId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var releaseIndex: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomCopyItemReleaseByIndexOptions = EcomCopyItemReleaseByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyItemReleaseByIndexOptions {
      val struct = EcomCopyItemReleaseByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyItemReleaseByIndexOptions(block: EcomCopyItemReleaseByIndexOptions.() -> Unit = {}): EcomCopyItemReleaseByIndexOptions = EcomCopyItemReleaseByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomGetTransactionCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: EcomGetTransactionCountOptions = EcomGetTransactionCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetTransactionCountOptions {
      val struct = EcomGetTransactionCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetTransactionCountOptions(block: EcomGetTransactionCountOptions.() -> Unit = {}): EcomGetTransactionCountOptions = EcomGetTransactionCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyTransactionByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var transactionIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyTransactionByIndexOptions = EcomCopyTransactionByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyTransactionByIndexOptions {
      val struct = EcomCopyTransactionByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyTransactionByIndexOptions(block: EcomCopyTransactionByIndexOptions.() -> Unit = {}): EcomCopyTransactionByIndexOptions = EcomCopyTransactionByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyTransactionByIdOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var transactionId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyTransactionByIdOptions = EcomCopyTransactionByIdOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyTransactionByIdOptions {
      val struct = EcomCopyTransactionByIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyTransactionByIdOptions(block: EcomCopyTransactionByIdOptions.() -> Unit = {}): EcomCopyTransactionByIdOptions = EcomCopyTransactionByIdOptions.allocate().apply(block)

@JvmInline
public value class EcomTransactionGetEntitlementsCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: EcomTransactionGetEntitlementsCountOptions =
        EcomTransactionGetEntitlementsCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomTransactionGetEntitlementsCountOptions {
      val struct = EcomTransactionGetEntitlementsCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomTransactionGetEntitlementsCountOptions(block: EcomTransactionGetEntitlementsCountOptions.() -> Unit = {}): EcomTransactionGetEntitlementsCountOptions = EcomTransactionGetEntitlementsCountOptions.allocate().apply(block)

@JvmInline
public value class EcomTransactionCopyEntitlementByIndexOptions(
  public val address: Long,
) {
  public var entitlementIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: EcomTransactionCopyEntitlementByIndexOptions =
        EcomTransactionCopyEntitlementByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomTransactionCopyEntitlementByIndexOptions {
      val struct = EcomTransactionCopyEntitlementByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomTransactionCopyEntitlementByIndexOptions(block: EcomTransactionCopyEntitlementByIndexOptions.() -> Unit = {}): EcomTransactionCopyEntitlementByIndexOptions = EcomTransactionCopyEntitlementByIndexOptions.allocate().apply(block)

@JvmInline
public value class FriendsQueryFriendsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: FriendsQueryFriendsOptions = FriendsQueryFriendsOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsQueryFriendsOptions {
      val struct = FriendsQueryFriendsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsQueryFriendsOptions(block: FriendsQueryFriendsOptions.() -> Unit = {}): FriendsQueryFriendsOptions = FriendsQueryFriendsOptions.allocate().apply(block)

@JvmInline
public value class FriendsQueryFriendsCallbackInfo(
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

    public val NULL: FriendsQueryFriendsCallbackInfo = FriendsQueryFriendsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsQueryFriendsCallbackInfo {
      val struct = FriendsQueryFriendsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsQueryFriendsCallbackInfo(block: FriendsQueryFriendsCallbackInfo.() -> Unit = {}): FriendsQueryFriendsCallbackInfo = FriendsQueryFriendsCallbackInfo.allocate().apply(block)

@JvmInline
public value class FriendsSendInviteOptions(
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

    public val NULL: FriendsSendInviteOptions = FriendsSendInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsSendInviteOptions {
      val struct = FriendsSendInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsSendInviteOptions(block: FriendsSendInviteOptions.() -> Unit = {}): FriendsSendInviteOptions = FriendsSendInviteOptions.allocate().apply(block)

@JvmInline
public value class FriendsSendInviteCallbackInfo(
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

    public val NULL: FriendsSendInviteCallbackInfo = FriendsSendInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsSendInviteCallbackInfo {
      val struct = FriendsSendInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsSendInviteCallbackInfo(block: FriendsSendInviteCallbackInfo.() -> Unit = {}): FriendsSendInviteCallbackInfo = FriendsSendInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class FriendsAcceptInviteOptions(
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

    public val NULL: FriendsAcceptInviteOptions = FriendsAcceptInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsAcceptInviteOptions {
      val struct = FriendsAcceptInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsAcceptInviteOptions(block: FriendsAcceptInviteOptions.() -> Unit = {}): FriendsAcceptInviteOptions = FriendsAcceptInviteOptions.allocate().apply(block)

@JvmInline
public value class FriendsAcceptInviteCallbackInfo(
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

    public val NULL: FriendsAcceptInviteCallbackInfo = FriendsAcceptInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsAcceptInviteCallbackInfo {
      val struct = FriendsAcceptInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsAcceptInviteCallbackInfo(block: FriendsAcceptInviteCallbackInfo.() -> Unit = {}): FriendsAcceptInviteCallbackInfo = FriendsAcceptInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class FriendsRejectInviteOptions(
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

    public val NULL: FriendsRejectInviteOptions = FriendsRejectInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsRejectInviteOptions {
      val struct = FriendsRejectInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsRejectInviteOptions(block: FriendsRejectInviteOptions.() -> Unit = {}): FriendsRejectInviteOptions = FriendsRejectInviteOptions.allocate().apply(block)

@JvmInline
public value class FriendsRejectInviteCallbackInfo(
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

    public val NULL: FriendsRejectInviteCallbackInfo = FriendsRejectInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsRejectInviteCallbackInfo {
      val struct = FriendsRejectInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsRejectInviteCallbackInfo(block: FriendsRejectInviteCallbackInfo.() -> Unit = {}): FriendsRejectInviteCallbackInfo = FriendsRejectInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class FriendsGetFriendsCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: FriendsGetFriendsCountOptions = FriendsGetFriendsCountOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsGetFriendsCountOptions {
      val struct = FriendsGetFriendsCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsGetFriendsCountOptions(block: FriendsGetFriendsCountOptions.() -> Unit = {}): FriendsGetFriendsCountOptions = FriendsGetFriendsCountOptions.allocate().apply(block)

@JvmInline
public value class FriendsGetFriendAtIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
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

    public val NULL: FriendsGetFriendAtIndexOptions = FriendsGetFriendAtIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsGetFriendAtIndexOptions {
      val struct = FriendsGetFriendAtIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsGetFriendAtIndexOptions(block: FriendsGetFriendAtIndexOptions.() -> Unit = {}): FriendsGetFriendAtIndexOptions = FriendsGetFriendAtIndexOptions.allocate().apply(block)

@JvmInline
public value class FriendsGetStatusOptions(
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

    public val NULL: FriendsGetStatusOptions = FriendsGetStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsGetStatusOptions {
      val struct = FriendsGetStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsGetStatusOptions(block: FriendsGetStatusOptions.() -> Unit = {}): FriendsGetStatusOptions = FriendsGetStatusOptions.allocate().apply(block)

@JvmInline
public value class FriendsAddNotifyFriendsUpdateOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: FriendsAddNotifyFriendsUpdateOptions = FriendsAddNotifyFriendsUpdateOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsAddNotifyFriendsUpdateOptions {
      val struct = FriendsAddNotifyFriendsUpdateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsAddNotifyFriendsUpdateOptions(block: FriendsAddNotifyFriendsUpdateOptions.() -> Unit = {}): FriendsAddNotifyFriendsUpdateOptions = FriendsAddNotifyFriendsUpdateOptions.allocate().apply(block)

@JvmInline
public value class FriendsOnFriendsUpdateInfo(
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

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var previousStatus: EFriendsStatus
    get() = EFriendsStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var currentStatus: EFriendsStatus
    get() = EFriendsStatus(RawMemory.getInt(address + 28))
    set(`value`) {
      RawMemory.putInt(address + 28, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: FriendsOnFriendsUpdateInfo = FriendsOnFriendsUpdateInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsOnFriendsUpdateInfo {
      val struct = FriendsOnFriendsUpdateInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsOnFriendsUpdateInfo(block: FriendsOnFriendsUpdateInfo.() -> Unit = {}): FriendsOnFriendsUpdateInfo = FriendsOnFriendsUpdateInfo.allocate().apply(block)

@JvmInline
public value class FriendsGetBlockedUsersCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: FriendsGetBlockedUsersCountOptions = FriendsGetBlockedUsersCountOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsGetBlockedUsersCountOptions {
      val struct = FriendsGetBlockedUsersCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsGetBlockedUsersCountOptions(block: FriendsGetBlockedUsersCountOptions.() -> Unit = {}): FriendsGetBlockedUsersCountOptions = FriendsGetBlockedUsersCountOptions.allocate().apply(block)

@JvmInline
public value class FriendsGetBlockedUserAtIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
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

    public val NULL: FriendsGetBlockedUserAtIndexOptions = FriendsGetBlockedUserAtIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsGetBlockedUserAtIndexOptions {
      val struct = FriendsGetBlockedUserAtIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsGetBlockedUserAtIndexOptions(block: FriendsGetBlockedUserAtIndexOptions.() -> Unit = {}): FriendsGetBlockedUserAtIndexOptions = FriendsGetBlockedUserAtIndexOptions.allocate().apply(block)

@JvmInline
public value class FriendsAddNotifyBlockedUsersUpdateOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: FriendsAddNotifyBlockedUsersUpdateOptions =
        FriendsAddNotifyBlockedUsersUpdateOptions(0)

    context(arena: Arena)
    public fun allocate(): FriendsAddNotifyBlockedUsersUpdateOptions {
      val struct = FriendsAddNotifyBlockedUsersUpdateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsAddNotifyBlockedUsersUpdateOptions(block: FriendsAddNotifyBlockedUsersUpdateOptions.() -> Unit = {}): FriendsAddNotifyBlockedUsersUpdateOptions = FriendsAddNotifyBlockedUsersUpdateOptions.allocate().apply(block)

@JvmInline
public value class FriendsOnBlockedUsersUpdateInfo(
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

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var blocked: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: FriendsOnBlockedUsersUpdateInfo = FriendsOnBlockedUsersUpdateInfo(0)

    context(arena: Arena)
    public fun allocate(): FriendsOnBlockedUsersUpdateInfo {
      val struct = FriendsOnBlockedUsersUpdateInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun FriendsOnBlockedUsersUpdateInfo(block: FriendsOnBlockedUsersUpdateInfo.() -> Unit = {}): FriendsOnBlockedUsersUpdateInfo = FriendsOnBlockedUsersUpdateInfo.allocate().apply(block)

@JvmInline
public value class InitializeThreadAffinity(
  public val address: Long,
) {
  public var networkWork: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var storageIo: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var webSocketIo: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var p2PIo: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var httpRequestIo: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public var rTCIo: Long
    get() = RawMemory.getLong(address + 48)
    set(`value`) {
      RawMemory.putLong(address + 48, value)
    }

  public var embeddedOverlayMainThread: Long
    get() = RawMemory.getLong(address + 56)
    set(`value`) {
      RawMemory.putLong(address + 56, value)
    }

  public var embeddedOverlayWorkerThreads: Long
    get() = RawMemory.getLong(address + 64)
    set(`value`) {
      RawMemory.putLong(address + 64, value)
    }

  public var cryptographyWork: Long
    get() = RawMemory.getLong(address + 72)
    set(`value`) {
      RawMemory.putLong(address + 72, value)
    }

  public companion object {
    public const val SIZE: Long = 80

    public val NULL: InitializeThreadAffinity = InitializeThreadAffinity(0)

    context(arena: Arena)
    public fun allocate(): InitializeThreadAffinity {
      val struct = InitializeThreadAffinity(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 4)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun InitializeThreadAffinity(block: InitializeThreadAffinity.() -> Unit = {}): InitializeThreadAffinity = InitializeThreadAffinity.allocate().apply(block)

@JvmInline
public value class InitializeOptions(
  public val address: Long,
) {
  public var allocateMemoryFunction: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var reallocateMemoryFunction: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var releaseMemoryFunction: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  context(arena: Arena)
  public var productName: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var productVersion: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var reserved: Long
    get() = RawMemory.getLong(address + 48)
    set(`value`) {
      RawMemory.putLong(address + 48, value)
    }

  public var systemInitializeOptions: Long
    get() = RawMemory.getLong(address + 56)
    set(`value`) {
      RawMemory.putLong(address + 56, value)
    }

  public var overrideThreadAffinity: InitializeThreadAffinity
    get() = InitializeThreadAffinity(RawMemory.getLong(address + 64))
    set(`value`) {
      RawMemory.putLong(address + 64, value.address)
    }

  public companion object {
    public const val SIZE: Long = 72

    public val NULL: InitializeOptions = InitializeOptions(0)

    context(arena: Arena)
    public fun allocate(): InitializeOptions {
      val struct = InitializeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 5)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun InitializeOptions(block: InitializeOptions.() -> Unit = {}): InitializeOptions = InitializeOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformOptions(
  public val address: Long,
) {
  public var type: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var flags: EIntegratedPlatformManagementFlags
    get() = EIntegratedPlatformManagementFlags(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var initOptions: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: IntegratedPlatformOptions = IntegratedPlatformOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformOptions {
      val struct = IntegratedPlatformOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformOptions(block: IntegratedPlatformOptions.() -> Unit = {}): IntegratedPlatformOptions = IntegratedPlatformOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformSteamOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var overrideLibraryPath: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var steamMajorVersion: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var steamMinorVersion: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  context(arena: Arena)
  public var steamApiInterfaceVersionsArray: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var steamApiInterfaceVersionsArrayBytes: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: IntegratedPlatformSteamOptions = IntegratedPlatformSteamOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformSteamOptions {
      val struct = IntegratedPlatformSteamOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformSteamOptions(block: IntegratedPlatformSteamOptions.() -> Unit = {}): IntegratedPlatformSteamOptions = IntegratedPlatformSteamOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions =
        IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions {
      val struct = IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions(block: IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions.() -> Unit = {}): IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions = IntegratedPlatformCreateIntegratedPlatformOptionsContainerOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformOptionsContainerAddOptions(
  public val address: Long,
) {
  public var options: IntegratedPlatformOptions
    get() = IntegratedPlatformOptions(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: IntegratedPlatformOptionsContainerAddOptions =
        IntegratedPlatformOptionsContainerAddOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformOptionsContainerAddOptions {
      val struct = IntegratedPlatformOptionsContainerAddOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformOptionsContainerAddOptions(block: IntegratedPlatformOptionsContainerAddOptions.() -> Unit = {}): IntegratedPlatformOptionsContainerAddOptions = IntegratedPlatformOptionsContainerAddOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformSetUserLoginStatusOptions(
  public val address: Long,
) {
  public var platformType: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var localPlatformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var currentLoginStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: IntegratedPlatformSetUserLoginStatusOptions =
        IntegratedPlatformSetUserLoginStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformSetUserLoginStatusOptions {
      val struct = IntegratedPlatformSetUserLoginStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformSetUserLoginStatusOptions(block: IntegratedPlatformSetUserLoginStatusOptions.() -> Unit = {}): IntegratedPlatformSetUserLoginStatusOptions = IntegratedPlatformSetUserLoginStatusOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformAddNotifyUserLoginStatusChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: IntegratedPlatformAddNotifyUserLoginStatusChangedOptions =
        IntegratedPlatformAddNotifyUserLoginStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformAddNotifyUserLoginStatusChangedOptions {
      val struct = IntegratedPlatformAddNotifyUserLoginStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformAddNotifyUserLoginStatusChangedOptions(block: IntegratedPlatformAddNotifyUserLoginStatusChangedOptions.() -> Unit = {}): IntegratedPlatformAddNotifyUserLoginStatusChangedOptions = IntegratedPlatformAddNotifyUserLoginStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformUserLoginStatusChangedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var platformType: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var localPlatformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public var previousLoginStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 40))
    set(`value`) {
      RawMemory.putInt(address + 40, value.value)
    }

  public var currentLoginStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 44))
    set(`value`) {
      RawMemory.putInt(address + 44, value.value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: IntegratedPlatformUserLoginStatusChangedCallbackInfo =
        IntegratedPlatformUserLoginStatusChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformUserLoginStatusChangedCallbackInfo {
      val struct = IntegratedPlatformUserLoginStatusChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformUserLoginStatusChangedCallbackInfo(block: IntegratedPlatformUserLoginStatusChangedCallbackInfo.() -> Unit = {}): IntegratedPlatformUserLoginStatusChangedCallbackInfo = IntegratedPlatformUserLoginStatusChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformSetUserPreLogoutCallbackOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: IntegratedPlatformSetUserPreLogoutCallbackOptions =
        IntegratedPlatformSetUserPreLogoutCallbackOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformSetUserPreLogoutCallbackOptions {
      val struct = IntegratedPlatformSetUserPreLogoutCallbackOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformSetUserPreLogoutCallbackOptions(block: IntegratedPlatformSetUserPreLogoutCallbackOptions.() -> Unit = {}): IntegratedPlatformSetUserPreLogoutCallbackOptions = IntegratedPlatformSetUserPreLogoutCallbackOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformUserPreLogoutCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var platformType: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var localPlatformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: IntegratedPlatformUserPreLogoutCallbackInfo =
        IntegratedPlatformUserPreLogoutCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformUserPreLogoutCallbackInfo {
      val struct = IntegratedPlatformUserPreLogoutCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformUserPreLogoutCallbackInfo(block: IntegratedPlatformUserPreLogoutCallbackInfo.() -> Unit = {}): IntegratedPlatformUserPreLogoutCallbackInfo = IntegratedPlatformUserPreLogoutCallbackInfo.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformClearUserPreLogoutCallbackOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: IntegratedPlatformClearUserPreLogoutCallbackOptions =
        IntegratedPlatformClearUserPreLogoutCallbackOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformClearUserPreLogoutCallbackOptions {
      val struct = IntegratedPlatformClearUserPreLogoutCallbackOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformClearUserPreLogoutCallbackOptions(block: IntegratedPlatformClearUserPreLogoutCallbackOptions.() -> Unit = {}): IntegratedPlatformClearUserPreLogoutCallbackOptions = IntegratedPlatformClearUserPreLogoutCallbackOptions.allocate().apply(block)

@JvmInline
public value class IntegratedPlatformFinalizeDeferredUserLogoutOptions(
  public val address: Long,
) {
  public var platformType: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var localPlatformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var expectedLoginStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: IntegratedPlatformFinalizeDeferredUserLogoutOptions =
        IntegratedPlatformFinalizeDeferredUserLogoutOptions(0)

    context(arena: Arena)
    public fun allocate(): IntegratedPlatformFinalizeDeferredUserLogoutOptions {
      val struct = IntegratedPlatformFinalizeDeferredUserLogoutOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun IntegratedPlatformFinalizeDeferredUserLogoutOptions(block: IntegratedPlatformFinalizeDeferredUserLogoutOptions.() -> Unit = {}): IntegratedPlatformFinalizeDeferredUserLogoutOptions = IntegratedPlatformFinalizeDeferredUserLogoutOptions.allocate().apply(block)

@JvmInline
public value class KWSPermissionStatus(
  public val address: Long,
) {
  context(arena: Arena)
  public var name: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var status: EKWSPermissionStatus
    get() = EKWSPermissionStatus(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: KWSPermissionStatus = KWSPermissionStatus(0)

    context(arena: Arena)
    public fun allocate(): KWSPermissionStatus {
      val struct = KWSPermissionStatus(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSPermissionStatus(block: KWSPermissionStatus.() -> Unit = {}): KWSPermissionStatus = KWSPermissionStatus.allocate().apply(block)

@JvmInline
public value class KWSQueryAgeGateOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: KWSQueryAgeGateOptions = KWSQueryAgeGateOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSQueryAgeGateOptions {
      val struct = KWSQueryAgeGateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSQueryAgeGateOptions(block: KWSQueryAgeGateOptions.() -> Unit = {}): KWSQueryAgeGateOptions = KWSQueryAgeGateOptions.allocate().apply(block)

@JvmInline
public value class KWSQueryAgeGateCallbackInfo(
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
  public var countryCode: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var ageOfConsent: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: KWSQueryAgeGateCallbackInfo = KWSQueryAgeGateCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSQueryAgeGateCallbackInfo {
      val struct = KWSQueryAgeGateCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSQueryAgeGateCallbackInfo(block: KWSQueryAgeGateCallbackInfo.() -> Unit = {}): KWSQueryAgeGateCallbackInfo = KWSQueryAgeGateCallbackInfo.allocate().apply(block)

@JvmInline
public value class KWSCreateUserOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var dateOfBirth: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var parentEmail: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: KWSCreateUserOptions = KWSCreateUserOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSCreateUserOptions {
      val struct = KWSCreateUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSCreateUserOptions(block: KWSCreateUserOptions.() -> Unit = {}): KWSCreateUserOptions = KWSCreateUserOptions.allocate().apply(block)

@JvmInline
public value class KWSCreateUserCallbackInfo(
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
  public var kWSUserId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isMinor: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: KWSCreateUserCallbackInfo = KWSCreateUserCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSCreateUserCallbackInfo {
      val struct = KWSCreateUserCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSCreateUserCallbackInfo(block: KWSCreateUserCallbackInfo.() -> Unit = {}): KWSCreateUserCallbackInfo = KWSCreateUserCallbackInfo.allocate().apply(block)

@JvmInline
public value class KWSQueryPermissionsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: KWSQueryPermissionsOptions = KWSQueryPermissionsOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSQueryPermissionsOptions {
      val struct = KWSQueryPermissionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSQueryPermissionsOptions(block: KWSQueryPermissionsOptions.() -> Unit = {}): KWSQueryPermissionsOptions = KWSQueryPermissionsOptions.allocate().apply(block)

@JvmInline
public value class KWSQueryPermissionsCallbackInfo(
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
  public var kWSUserId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var dateOfBirth: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isMinor: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var parentEmail: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: KWSQueryPermissionsCallbackInfo = KWSQueryPermissionsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSQueryPermissionsCallbackInfo {
      val struct = KWSQueryPermissionsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSQueryPermissionsCallbackInfo(block: KWSQueryPermissionsCallbackInfo.() -> Unit = {}): KWSQueryPermissionsCallbackInfo = KWSQueryPermissionsCallbackInfo.allocate().apply(block)

@JvmInline
public value class KWSUpdateParentEmailOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var parentEmail: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: KWSUpdateParentEmailOptions = KWSUpdateParentEmailOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSUpdateParentEmailOptions {
      val struct = KWSUpdateParentEmailOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSUpdateParentEmailOptions(block: KWSUpdateParentEmailOptions.() -> Unit = {}): KWSUpdateParentEmailOptions = KWSUpdateParentEmailOptions.allocate().apply(block)

@JvmInline
public value class KWSUpdateParentEmailCallbackInfo(
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

    public val NULL: KWSUpdateParentEmailCallbackInfo = KWSUpdateParentEmailCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSUpdateParentEmailCallbackInfo {
      val struct = KWSUpdateParentEmailCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSUpdateParentEmailCallbackInfo(block: KWSUpdateParentEmailCallbackInfo.() -> Unit = {}): KWSUpdateParentEmailCallbackInfo = KWSUpdateParentEmailCallbackInfo.allocate().apply(block)

@JvmInline
public value class KWSRequestPermissionsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var permissionKeyCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var permissionKeys: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: KWSRequestPermissionsOptions = KWSRequestPermissionsOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSRequestPermissionsOptions {
      val struct = KWSRequestPermissionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSRequestPermissionsOptions(block: KWSRequestPermissionsOptions.() -> Unit = {}): KWSRequestPermissionsOptions = KWSRequestPermissionsOptions.allocate().apply(block)

@JvmInline
public value class KWSRequestPermissionsCallbackInfo(
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

    public val NULL: KWSRequestPermissionsCallbackInfo = KWSRequestPermissionsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSRequestPermissionsCallbackInfo {
      val struct = KWSRequestPermissionsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSRequestPermissionsCallbackInfo(block: KWSRequestPermissionsCallbackInfo.() -> Unit = {}): KWSRequestPermissionsCallbackInfo = KWSRequestPermissionsCallbackInfo.allocate().apply(block)

@JvmInline
public value class KWSGetPermissionsCountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: KWSGetPermissionsCountOptions = KWSGetPermissionsCountOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSGetPermissionsCountOptions {
      val struct = KWSGetPermissionsCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSGetPermissionsCountOptions(block: KWSGetPermissionsCountOptions.() -> Unit = {}): KWSGetPermissionsCountOptions = KWSGetPermissionsCountOptions.allocate().apply(block)

@JvmInline
public value class KWSCopyPermissionByIndexOptions(
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

    public val NULL: KWSCopyPermissionByIndexOptions = KWSCopyPermissionByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSCopyPermissionByIndexOptions {
      val struct = KWSCopyPermissionByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSCopyPermissionByIndexOptions(block: KWSCopyPermissionByIndexOptions.() -> Unit = {}): KWSCopyPermissionByIndexOptions = KWSCopyPermissionByIndexOptions.allocate().apply(block)

@JvmInline
public value class KWSGetPermissionByKeyOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var key: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: KWSGetPermissionByKeyOptions = KWSGetPermissionByKeyOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSGetPermissionByKeyOptions {
      val struct = KWSGetPermissionByKeyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSGetPermissionByKeyOptions(block: KWSGetPermissionByKeyOptions.() -> Unit = {}): KWSGetPermissionByKeyOptions = KWSGetPermissionByKeyOptions.allocate().apply(block)

@JvmInline
public value class KWSAddNotifyPermissionsUpdateReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: KWSAddNotifyPermissionsUpdateReceivedOptions =
        KWSAddNotifyPermissionsUpdateReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): KWSAddNotifyPermissionsUpdateReceivedOptions {
      val struct = KWSAddNotifyPermissionsUpdateReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSAddNotifyPermissionsUpdateReceivedOptions(block: KWSAddNotifyPermissionsUpdateReceivedOptions.() -> Unit = {}): KWSAddNotifyPermissionsUpdateReceivedOptions = KWSAddNotifyPermissionsUpdateReceivedOptions.allocate().apply(block)

@JvmInline
public value class KWSPermissionsUpdateReceivedCallbackInfo(
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
  public var kWSUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var dateOfBirth: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isMinor: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var parentEmail: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: KWSPermissionsUpdateReceivedCallbackInfo =
        KWSPermissionsUpdateReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): KWSPermissionsUpdateReceivedCallbackInfo {
      val struct = KWSPermissionsUpdateReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun KWSPermissionsUpdateReceivedCallbackInfo(block: KWSPermissionsUpdateReceivedCallbackInfo.() -> Unit = {}): KWSPermissionsUpdateReceivedCallbackInfo = KWSPermissionsUpdateReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class LeaderboardsQueryLeaderboardDefinitionsOptions(
  public val address: Long,
) {
  public var startTime: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var endTime: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LeaderboardsQueryLeaderboardDefinitionsOptions =
        LeaderboardsQueryLeaderboardDefinitionsOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsQueryLeaderboardDefinitionsOptions {
      val struct = LeaderboardsQueryLeaderboardDefinitionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsQueryLeaderboardDefinitionsOptions(block: LeaderboardsQueryLeaderboardDefinitionsOptions.() -> Unit = {}): LeaderboardsQueryLeaderboardDefinitionsOptions = LeaderboardsQueryLeaderboardDefinitionsOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsDefinition(
  public val address: Long,
) {
  context(arena: Arena)
  public var leaderboardId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var aggregation: ELeaderboardAggregation
    get() = ELeaderboardAggregation(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var startTime: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var endTime: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: LeaderboardsDefinition = LeaderboardsDefinition(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsDefinition {
      val struct = LeaderboardsDefinition(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsDefinition(block: LeaderboardsDefinition.() -> Unit = {}): LeaderboardsDefinition = LeaderboardsDefinition.allocate().apply(block)

@JvmInline
public value class LeaderboardsGetLeaderboardDefinitionCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LeaderboardsGetLeaderboardDefinitionCountOptions =
        LeaderboardsGetLeaderboardDefinitionCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsGetLeaderboardDefinitionCountOptions {
      val struct = LeaderboardsGetLeaderboardDefinitionCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsGetLeaderboardDefinitionCountOptions(block: LeaderboardsGetLeaderboardDefinitionCountOptions.() -> Unit = {}): LeaderboardsGetLeaderboardDefinitionCountOptions = LeaderboardsGetLeaderboardDefinitionCountOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardDefinitionByIndexOptions(
  public val address: Long,
) {
  public var leaderboardIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LeaderboardsCopyLeaderboardDefinitionByIndexOptions =
        LeaderboardsCopyLeaderboardDefinitionByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardDefinitionByIndexOptions {
      val struct = LeaderboardsCopyLeaderboardDefinitionByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardDefinitionByIndexOptions(block: LeaderboardsCopyLeaderboardDefinitionByIndexOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardDefinitionByIndexOptions = LeaderboardsCopyLeaderboardDefinitionByIndexOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var leaderboardId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions =
        LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions {
      val struct = LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions(block: LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions = LeaderboardsCopyLeaderboardDefinitionByLeaderboardIdOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo(
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

    public val NULL: LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo =
        LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo {
      val struct = LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo(block: LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo.() -> Unit = {}): LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo = LeaderboardsOnQueryLeaderboardDefinitionsCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class LeaderboardsUserScoresQueryStatInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var aggregation: ELeaderboardAggregation
    get() = ELeaderboardAggregation(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LeaderboardsUserScoresQueryStatInfo = LeaderboardsUserScoresQueryStatInfo(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsUserScoresQueryStatInfo {
      val struct = LeaderboardsUserScoresQueryStatInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsUserScoresQueryStatInfo(block: LeaderboardsUserScoresQueryStatInfo.() -> Unit = {}): LeaderboardsUserScoresQueryStatInfo = LeaderboardsUserScoresQueryStatInfo.allocate().apply(block)

@JvmInline
public value class LeaderboardsQueryLeaderboardUserScoresOptions(
  public val address: Long,
) {
  public var userIds: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var userIdsCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var statInfo: LeaderboardsUserScoresQueryStatInfo
    get() = LeaderboardsUserScoresQueryStatInfo(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var statInfoCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var startTime: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public var endTime: Long
    get() = RawMemory.getLong(address + 48)
    set(`value`) {
      RawMemory.putLong(address + 48, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 56))
    set(`value`) {
      RawMemory.putLong(address + 56, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 64

    public val NULL: LeaderboardsQueryLeaderboardUserScoresOptions =
        LeaderboardsQueryLeaderboardUserScoresOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsQueryLeaderboardUserScoresOptions {
      val struct = LeaderboardsQueryLeaderboardUserScoresOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsQueryLeaderboardUserScoresOptions(block: LeaderboardsQueryLeaderboardUserScoresOptions.() -> Unit = {}): LeaderboardsQueryLeaderboardUserScoresOptions = LeaderboardsQueryLeaderboardUserScoresOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsLeaderboardUserScore(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var score: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LeaderboardsLeaderboardUserScore = LeaderboardsLeaderboardUserScore(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsLeaderboardUserScore {
      val struct = LeaderboardsLeaderboardUserScore(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsLeaderboardUserScore(block: LeaderboardsLeaderboardUserScore.() -> Unit = {}): LeaderboardsLeaderboardUserScore = LeaderboardsLeaderboardUserScore.allocate().apply(block)

@JvmInline
public value class LeaderboardsGetLeaderboardUserScoreCountOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LeaderboardsGetLeaderboardUserScoreCountOptions =
        LeaderboardsGetLeaderboardUserScoreCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsGetLeaderboardUserScoreCountOptions {
      val struct = LeaderboardsGetLeaderboardUserScoreCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsGetLeaderboardUserScoreCountOptions(block: LeaderboardsGetLeaderboardUserScoreCountOptions.() -> Unit = {}): LeaderboardsGetLeaderboardUserScoreCountOptions = LeaderboardsGetLeaderboardUserScoreCountOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardUserScoreByIndexOptions(
  public val address: Long,
) {
  public var leaderboardUserScoreIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LeaderboardsCopyLeaderboardUserScoreByIndexOptions =
        LeaderboardsCopyLeaderboardUserScoreByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardUserScoreByIndexOptions {
      val struct = LeaderboardsCopyLeaderboardUserScoreByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardUserScoreByIndexOptions(block: LeaderboardsCopyLeaderboardUserScoreByIndexOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardUserScoreByIndexOptions = LeaderboardsCopyLeaderboardUserScoreByIndexOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardUserScoreByUserIdOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var statName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LeaderboardsCopyLeaderboardUserScoreByUserIdOptions =
        LeaderboardsCopyLeaderboardUserScoreByUserIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardUserScoreByUserIdOptions {
      val struct = LeaderboardsCopyLeaderboardUserScoreByUserIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardUserScoreByUserIdOptions(block: LeaderboardsCopyLeaderboardUserScoreByUserIdOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardUserScoreByUserIdOptions = LeaderboardsCopyLeaderboardUserScoreByUserIdOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo(
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

    public val NULL: LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo =
        LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo {
      val struct = LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo(block: LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo.() -> Unit = {}): LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo = LeaderboardsOnQueryLeaderboardUserScoresCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class LeaderboardsQueryLeaderboardRanksOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var leaderboardId: String?
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

    public val NULL: LeaderboardsQueryLeaderboardRanksOptions =
        LeaderboardsQueryLeaderboardRanksOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsQueryLeaderboardRanksOptions {
      val struct = LeaderboardsQueryLeaderboardRanksOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsQueryLeaderboardRanksOptions(block: LeaderboardsQueryLeaderboardRanksOptions.() -> Unit = {}): LeaderboardsQueryLeaderboardRanksOptions = LeaderboardsQueryLeaderboardRanksOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsLeaderboardRecord(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var rank: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var score: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  context(arena: Arena)
  public var userDisplayName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LeaderboardsLeaderboardRecord = LeaderboardsLeaderboardRecord(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsLeaderboardRecord {
      val struct = LeaderboardsLeaderboardRecord(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsLeaderboardRecord(block: LeaderboardsLeaderboardRecord.() -> Unit = {}): LeaderboardsLeaderboardRecord = LeaderboardsLeaderboardRecord.allocate().apply(block)

@JvmInline
public value class LeaderboardsGetLeaderboardRecordCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: LeaderboardsGetLeaderboardRecordCountOptions =
        LeaderboardsGetLeaderboardRecordCountOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsGetLeaderboardRecordCountOptions {
      val struct = LeaderboardsGetLeaderboardRecordCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsGetLeaderboardRecordCountOptions(block: LeaderboardsGetLeaderboardRecordCountOptions.() -> Unit = {}): LeaderboardsGetLeaderboardRecordCountOptions = LeaderboardsGetLeaderboardRecordCountOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardRecordByIndexOptions(
  public val address: Long,
) {
  public var leaderboardRecordIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: LeaderboardsCopyLeaderboardRecordByIndexOptions =
        LeaderboardsCopyLeaderboardRecordByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardRecordByIndexOptions {
      val struct = LeaderboardsCopyLeaderboardRecordByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardRecordByIndexOptions(block: LeaderboardsCopyLeaderboardRecordByIndexOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardRecordByIndexOptions = LeaderboardsCopyLeaderboardRecordByIndexOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsCopyLeaderboardRecordByUserIdOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LeaderboardsCopyLeaderboardRecordByUserIdOptions =
        LeaderboardsCopyLeaderboardRecordByUserIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsCopyLeaderboardRecordByUserIdOptions {
      val struct = LeaderboardsCopyLeaderboardRecordByUserIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsCopyLeaderboardRecordByUserIdOptions(block: LeaderboardsCopyLeaderboardRecordByUserIdOptions.() -> Unit = {}): LeaderboardsCopyLeaderboardRecordByUserIdOptions = LeaderboardsCopyLeaderboardRecordByUserIdOptions.allocate().apply(block)

@JvmInline
public value class LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo(
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
  public var leaderboardId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo =
        LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo {
      val struct = LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo(block: LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo.() -> Unit = {}): LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo = LeaderboardsOnQueryLeaderboardRanksCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyDetailsInfo(
  public val address: Long,
) {
  public var lobbyId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var lobbyOwnerUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var permissionLevel: ELobbyPermissionLevel
    get() = ELobbyPermissionLevel(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var availableSlots: Int
    get() = RawMemory.getInt(address + 28)
    set(`value`) {
      RawMemory.putInt(address + 28, value)
    }

  public var maxMembers: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var allowInvites: Boolean
    get() = RawMemory.getInt(address + 36) != 0
    set(`value`) {
      RawMemory.putInt(address + 36, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var bucketId: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var allowHostMigration: Boolean
    get() = RawMemory.getInt(address + 48) != 0
    set(`value`) {
      RawMemory.putInt(address + 48, if (value) 1 else 0)
    }

  public var rTCRoomEnabled: Boolean
    get() = RawMemory.getInt(address + 52) != 0
    set(`value`) {
      RawMemory.putInt(address + 52, if (value) 1 else 0)
    }

  public var allowJoinById: Boolean
    get() = RawMemory.getInt(address + 56) != 0
    set(`value`) {
      RawMemory.putInt(address + 56, if (value) 1 else 0)
    }

  public var rejoinAfterKickRequiresInvite: Boolean
    get() = RawMemory.getInt(address + 60) != 0
    set(`value`) {
      RawMemory.putInt(address + 60, if (value) 1 else 0)
    }

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 64) != 0
    set(`value`) {
      RawMemory.putInt(address + 64, if (value) 1 else 0)
    }

  public var allowedPlatformIds: Long
    get() = RawMemory.getLong(address + 72)
    set(`value`) {
      RawMemory.putLong(address + 72, value)
    }

  public var allowedPlatformIdsCount: Int
    get() = RawMemory.getInt(address + 80)
    set(`value`) {
      RawMemory.putInt(address + 80, value)
    }

  public companion object {
    public const val SIZE: Long = 88

    public val NULL: LobbyDetailsInfo = LobbyDetailsInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyDetailsInfo {
      val struct = LobbyDetailsInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDetailsInfo(block: LobbyDetailsInfo.() -> Unit = {}): LobbyDetailsInfo = LobbyDetailsInfo.allocate().apply(block)

@JvmInline
public value class LobbyLocalRTCOptions(
  public val address: Long,
) {
  public var flags: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var useManualAudioInput: Boolean
    get() = RawMemory.getInt(address + 8) != 0
    set(`value`) {
      RawMemory.putInt(address + 8, if (value) 1 else 0)
    }

  public var useManualAudioOutput: Boolean
    get() = RawMemory.getInt(address + 12) != 0
    set(`value`) {
      RawMemory.putInt(address + 12, if (value) 1 else 0)
    }

  public var localAudioDeviceInputStartsMuted: Boolean
    get() = RawMemory.getInt(address + 16) != 0
    set(`value`) {
      RawMemory.putInt(address + 16, if (value) 1 else 0)
    }

  public var reserved: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: LobbyLocalRTCOptions = LobbyLocalRTCOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyLocalRTCOptions {
      val struct = LobbyLocalRTCOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLocalRTCOptions(block: LobbyLocalRTCOptions.() -> Unit = {}): LobbyLocalRTCOptions = LobbyLocalRTCOptions.allocate().apply(block)

@JvmInline
public value class LobbyCreateLobbyOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var maxLobbyMembers: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var permissionLevel: ELobbyPermissionLevel
    get() = ELobbyPermissionLevel(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var allowInvites: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var bucketId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var disableHostMigration: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public var enableRTCRoom: Boolean
    get() = RawMemory.getInt(address + 44) != 0
    set(`value`) {
      RawMemory.putInt(address + 44, if (value) 1 else 0)
    }

  public var localRTCOptions: LobbyLocalRTCOptions
    get() = LobbyLocalRTCOptions(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.address)
    }

  public var lobbyId: Long
    get() = RawMemory.getLong(address + 56)
    set(`value`) {
      RawMemory.putLong(address + 56, value)
    }

  public var enableJoinById: Boolean
    get() = RawMemory.getInt(address + 64) != 0
    set(`value`) {
      RawMemory.putInt(address + 64, if (value) 1 else 0)
    }

  public var rejoinAfterKickRequiresInvite: Boolean
    get() = RawMemory.getInt(address + 68) != 0
    set(`value`) {
      RawMemory.putInt(address + 68, if (value) 1 else 0)
    }

  public var allowedPlatformIds: Long
    get() = RawMemory.getLong(address + 72)
    set(`value`) {
      RawMemory.putLong(address + 72, value)
    }

  public var allowedPlatformIdsCount: Int
    get() = RawMemory.getInt(address + 80)
    set(`value`) {
      RawMemory.putInt(address + 80, value)
    }

  public var crossplayOptOut: Boolean
    get() = RawMemory.getInt(address + 84) != 0
    set(`value`) {
      RawMemory.putInt(address + 84, if (value) 1 else 0)
    }

  public var rTCRoomJoinActionType: ELobbyRTCRoomJoinActionType
    get() = ELobbyRTCRoomJoinActionType(RawMemory.getInt(address + 88))
    set(`value`) {
      RawMemory.putInt(address + 88, value.value)
    }

  public companion object {
    public const val SIZE: Long = 96

    public val NULL: LobbyCreateLobbyOptions = LobbyCreateLobbyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyCreateLobbyOptions {
      val struct = LobbyCreateLobbyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 10)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCreateLobbyOptions(block: LobbyCreateLobbyOptions.() -> Unit = {}): LobbyCreateLobbyOptions = LobbyCreateLobbyOptions.allocate().apply(block)

@JvmInline
public value class LobbyCreateLobbyCallbackInfo(
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

    public val NULL: LobbyCreateLobbyCallbackInfo = LobbyCreateLobbyCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyCreateLobbyCallbackInfo {
      val struct = LobbyCreateLobbyCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyCreateLobbyCallbackInfo(block: LobbyCreateLobbyCallbackInfo.() -> Unit = {}): LobbyCreateLobbyCallbackInfo = LobbyCreateLobbyCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyDestroyLobbyOptions(
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

    public val NULL: LobbyDestroyLobbyOptions = LobbyDestroyLobbyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyDestroyLobbyOptions {
      val struct = LobbyDestroyLobbyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDestroyLobbyOptions(block: LobbyDestroyLobbyOptions.() -> Unit = {}): LobbyDestroyLobbyOptions = LobbyDestroyLobbyOptions.allocate().apply(block)

@JvmInline
public value class LobbyDestroyLobbyCallbackInfo(
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

    public val NULL: LobbyDestroyLobbyCallbackInfo = LobbyDestroyLobbyCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyDestroyLobbyCallbackInfo {
      val struct = LobbyDestroyLobbyCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyDestroyLobbyCallbackInfo(block: LobbyDestroyLobbyCallbackInfo.() -> Unit = {}): LobbyDestroyLobbyCallbackInfo = LobbyDestroyLobbyCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyJoinLobbyOptions(
  public val address: Long,
) {
  public var lobbyDetailsHandle: HLobbyDetails
    get() = HLobbyDetails(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.handle)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var localRTCOptions: LobbyLocalRTCOptions
    get() = LobbyLocalRTCOptions(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.address)
    }

  public var crossplayOptOut: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public var rTCRoomJoinActionType: ELobbyRTCRoomJoinActionType
    get() = ELobbyRTCRoomJoinActionType(RawMemory.getInt(address + 44))
    set(`value`) {
      RawMemory.putInt(address + 44, value.value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: LobbyJoinLobbyOptions = LobbyJoinLobbyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinLobbyOptions {
      val struct = LobbyJoinLobbyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 5)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinLobbyOptions(block: LobbyJoinLobbyOptions.() -> Unit = {}): LobbyJoinLobbyOptions = LobbyJoinLobbyOptions.allocate().apply(block)

@JvmInline
public value class LobbyJoinLobbyCallbackInfo(
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

    public val NULL: LobbyJoinLobbyCallbackInfo = LobbyJoinLobbyCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinLobbyCallbackInfo {
      val struct = LobbyJoinLobbyCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinLobbyCallbackInfo(block: LobbyJoinLobbyCallbackInfo.() -> Unit = {}): LobbyJoinLobbyCallbackInfo = LobbyJoinLobbyCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyJoinLobbyByIdOptions(
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

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var localRTCOptions: LobbyLocalRTCOptions
    get() = LobbyLocalRTCOptions(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.address)
    }

  public var crossplayOptOut: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public var rTCRoomJoinActionType: ELobbyRTCRoomJoinActionType
    get() = ELobbyRTCRoomJoinActionType(RawMemory.getInt(address + 44))
    set(`value`) {
      RawMemory.putInt(address + 44, value.value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: LobbyJoinLobbyByIdOptions = LobbyJoinLobbyByIdOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinLobbyByIdOptions {
      val struct = LobbyJoinLobbyByIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinLobbyByIdOptions(block: LobbyJoinLobbyByIdOptions.() -> Unit = {}): LobbyJoinLobbyByIdOptions = LobbyJoinLobbyByIdOptions.allocate().apply(block)

@JvmInline
public value class LobbyJoinLobbyByIdCallbackInfo(
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

    public val NULL: LobbyJoinLobbyByIdCallbackInfo = LobbyJoinLobbyByIdCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyJoinLobbyByIdCallbackInfo {
      val struct = LobbyJoinLobbyByIdCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyJoinLobbyByIdCallbackInfo(block: LobbyJoinLobbyByIdCallbackInfo.() -> Unit = {}): LobbyJoinLobbyByIdCallbackInfo = LobbyJoinLobbyByIdCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyLeaveLobbyOptions(
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

    public val NULL: LobbyLeaveLobbyOptions = LobbyLeaveLobbyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyLeaveLobbyOptions {
      val struct = LobbyLeaveLobbyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLeaveLobbyOptions(block: LobbyLeaveLobbyOptions.() -> Unit = {}): LobbyLeaveLobbyOptions = LobbyLeaveLobbyOptions.allocate().apply(block)

@JvmInline
public value class LobbyLeaveLobbyCallbackInfo(
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

    public val NULL: LobbyLeaveLobbyCallbackInfo = LobbyLeaveLobbyCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyLeaveLobbyCallbackInfo {
      val struct = LobbyLeaveLobbyCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyLeaveLobbyCallbackInfo(block: LobbyLeaveLobbyCallbackInfo.() -> Unit = {}): LobbyLeaveLobbyCallbackInfo = LobbyLeaveLobbyCallbackInfo.allocate().apply(block)

@JvmInline
public value class LobbyUpdateLobbyModificationOptions(
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

    public val NULL: LobbyUpdateLobbyModificationOptions = LobbyUpdateLobbyModificationOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyUpdateLobbyModificationOptions {
      val struct = LobbyUpdateLobbyModificationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyUpdateLobbyModificationOptions(block: LobbyUpdateLobbyModificationOptions.() -> Unit = {}): LobbyUpdateLobbyModificationOptions = LobbyUpdateLobbyModificationOptions.allocate().apply(block)

@JvmInline
public value class LobbyUpdateLobbyOptions(
  public val address: Long,
) {
  public var lobbyModificationHandle: HLobbyModification
    get() = HLobbyModification(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.handle)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: LobbyUpdateLobbyOptions = LobbyUpdateLobbyOptions(0)

    context(arena: Arena)
    public fun allocate(): LobbyUpdateLobbyOptions {
      val struct = LobbyUpdateLobbyOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyUpdateLobbyOptions(block: LobbyUpdateLobbyOptions.() -> Unit = {}): LobbyUpdateLobbyOptions = LobbyUpdateLobbyOptions.allocate().apply(block)

@JvmInline
public value class LobbyUpdateLobbyCallbackInfo(
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

    public val NULL: LobbyUpdateLobbyCallbackInfo = LobbyUpdateLobbyCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): LobbyUpdateLobbyCallbackInfo {
      val struct = LobbyUpdateLobbyCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun LobbyUpdateLobbyCallbackInfo(block: LobbyUpdateLobbyCallbackInfo.() -> Unit = {}): LobbyUpdateLobbyCallbackInfo = LobbyUpdateLobbyCallbackInfo.allocate().apply(block)
