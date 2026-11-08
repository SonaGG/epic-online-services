@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
import gg.sona.eos.common.ContinuanceToken
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class AuthAddNotifyLoginStatusChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AuthAddNotifyLoginStatusChangedOptions =
        AuthAddNotifyLoginStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthAddNotifyLoginStatusChangedOptions {
      val struct = AuthAddNotifyLoginStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthAddNotifyLoginStatusChangedOptions(block: AuthAddNotifyLoginStatusChangedOptions.() -> Unit = {}): AuthAddNotifyLoginStatusChangedOptions = AuthAddNotifyLoginStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class AuthDeletePersistentAuthOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var refreshToken: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthDeletePersistentAuthOptions = AuthDeletePersistentAuthOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthDeletePersistentAuthOptions {
      val struct = AuthDeletePersistentAuthOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthDeletePersistentAuthOptions(block: AuthDeletePersistentAuthOptions.() -> Unit = {}): AuthDeletePersistentAuthOptions = AuthDeletePersistentAuthOptions.allocate().apply(block)

@JvmInline
public value class AuthDeletePersistentAuthCallbackInfo(
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

    public val NULL: AuthDeletePersistentAuthCallbackInfo = AuthDeletePersistentAuthCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthDeletePersistentAuthCallbackInfo {
      val struct = AuthDeletePersistentAuthCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthDeletePersistentAuthCallbackInfo(block: AuthDeletePersistentAuthCallbackInfo.() -> Unit = {}): AuthDeletePersistentAuthCallbackInfo = AuthDeletePersistentAuthCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthLoginStatusChangedCallbackInfo(
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

  public var prevStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var currentStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AuthLoginStatusChangedCallbackInfo = AuthLoginStatusChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthLoginStatusChangedCallbackInfo {
      val struct = AuthLoginStatusChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLoginStatusChangedCallbackInfo(block: AuthLoginStatusChangedCallbackInfo.() -> Unit = {}): AuthLoginStatusChangedCallbackInfo = AuthLoginStatusChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthAccountFeatureRestrictedInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var verificationURI: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthAccountFeatureRestrictedInfo = AuthAccountFeatureRestrictedInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthAccountFeatureRestrictedInfo {
      val struct = AuthAccountFeatureRestrictedInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthAccountFeatureRestrictedInfo(block: AuthAccountFeatureRestrictedInfo.() -> Unit = {}): AuthAccountFeatureRestrictedInfo = AuthAccountFeatureRestrictedInfo.allocate().apply(block)

@JvmInline
public value class ConnectCredentials(
  public val address: Long,
) {
  context(arena: Arena)
  public var token: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var type: EExternalCredentialType
    get() = EExternalCredentialType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectCredentials = ConnectCredentials(0)

    context(arena: Arena)
    public fun allocate(): ConnectCredentials {
      val struct = ConnectCredentials(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCredentials(block: ConnectCredentials.() -> Unit = {}): ConnectCredentials = ConnectCredentials.allocate().apply(block)

@JvmInline
public value class ConnectUserLoginInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var nsaIdToken: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectUserLoginInfo = ConnectUserLoginInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectUserLoginInfo {
      val struct = ConnectUserLoginInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectUserLoginInfo(block: ConnectUserLoginInfo.() -> Unit = {}): ConnectUserLoginInfo = ConnectUserLoginInfo.allocate().apply(block)

@JvmInline
public value class ConnectLoginOptions(
  public val address: Long,
) {
  public var credentials: ConnectCredentials
    get() = ConnectCredentials(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var userLoginInfo: ConnectUserLoginInfo
    get() = ConnectUserLoginInfo(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectLoginOptions = ConnectLoginOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectLoginOptions {
      val struct = ConnectLoginOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLoginOptions(block: ConnectLoginOptions.() -> Unit = {}): ConnectLoginOptions = ConnectLoginOptions.allocate().apply(block)

@JvmInline
public value class ConnectLoginCallbackInfo(
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

  public var continuanceToken: ContinuanceToken
    get() = ContinuanceToken(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ConnectLoginCallbackInfo = ConnectLoginCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectLoginCallbackInfo {
      val struct = ConnectLoginCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLoginCallbackInfo(block: ConnectLoginCallbackInfo.() -> Unit = {}): ConnectLoginCallbackInfo = ConnectLoginCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectLogoutOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectLogoutOptions = ConnectLogoutOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectLogoutOptions {
      val struct = ConnectLogoutOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLogoutOptions(block: ConnectLogoutOptions.() -> Unit = {}): ConnectLogoutOptions = ConnectLogoutOptions.allocate().apply(block)

@JvmInline
public value class ConnectLogoutCallbackInfo(
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

    public val NULL: ConnectLogoutCallbackInfo = ConnectLogoutCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectLogoutCallbackInfo {
      val struct = ConnectLogoutCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLogoutCallbackInfo(block: ConnectLogoutCallbackInfo.() -> Unit = {}): ConnectLogoutCallbackInfo = ConnectLogoutCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectCreateUserOptions(
  public val address: Long,
) {
  public var continuanceToken: ContinuanceToken
    get() = ContinuanceToken(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectCreateUserOptions = ConnectCreateUserOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCreateUserOptions {
      val struct = ConnectCreateUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCreateUserOptions(block: ConnectCreateUserOptions.() -> Unit = {}): ConnectCreateUserOptions = ConnectCreateUserOptions.allocate().apply(block)

@JvmInline
public value class ConnectCreateUserCallbackInfo(
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

    public val NULL: ConnectCreateUserCallbackInfo = ConnectCreateUserCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectCreateUserCallbackInfo {
      val struct = ConnectCreateUserCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCreateUserCallbackInfo(block: ConnectCreateUserCallbackInfo.() -> Unit = {}): ConnectCreateUserCallbackInfo = ConnectCreateUserCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectLinkAccountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var continuanceToken: ContinuanceToken
    get() = ContinuanceToken(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectLinkAccountOptions = ConnectLinkAccountOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectLinkAccountOptions {
      val struct = ConnectLinkAccountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLinkAccountOptions(block: ConnectLinkAccountOptions.() -> Unit = {}): ConnectLinkAccountOptions = ConnectLinkAccountOptions.allocate().apply(block)

@JvmInline
public value class ConnectLinkAccountCallbackInfo(
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

    public val NULL: ConnectLinkAccountCallbackInfo = ConnectLinkAccountCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectLinkAccountCallbackInfo {
      val struct = ConnectLinkAccountCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLinkAccountCallbackInfo(block: ConnectLinkAccountCallbackInfo.() -> Unit = {}): ConnectLinkAccountCallbackInfo = ConnectLinkAccountCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectUnlinkAccountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectUnlinkAccountOptions = ConnectUnlinkAccountOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectUnlinkAccountOptions {
      val struct = ConnectUnlinkAccountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectUnlinkAccountOptions(block: ConnectUnlinkAccountOptions.() -> Unit = {}): ConnectUnlinkAccountOptions = ConnectUnlinkAccountOptions.allocate().apply(block)

@JvmInline
public value class ConnectUnlinkAccountCallbackInfo(
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

    public val NULL: ConnectUnlinkAccountCallbackInfo = ConnectUnlinkAccountCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectUnlinkAccountCallbackInfo {
      val struct = ConnectUnlinkAccountCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectUnlinkAccountCallbackInfo(block: ConnectUnlinkAccountCallbackInfo.() -> Unit = {}): ConnectUnlinkAccountCallbackInfo = ConnectUnlinkAccountCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectCreateDeviceIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var deviceModel: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectCreateDeviceIdOptions = ConnectCreateDeviceIdOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCreateDeviceIdOptions {
      val struct = ConnectCreateDeviceIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCreateDeviceIdOptions(block: ConnectCreateDeviceIdOptions.() -> Unit = {}): ConnectCreateDeviceIdOptions = ConnectCreateDeviceIdOptions.allocate().apply(block)

@JvmInline
public value class ConnectCreateDeviceIdCallbackInfo(
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

    public val NULL: ConnectCreateDeviceIdCallbackInfo = ConnectCreateDeviceIdCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectCreateDeviceIdCallbackInfo {
      val struct = ConnectCreateDeviceIdCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCreateDeviceIdCallbackInfo(block: ConnectCreateDeviceIdCallbackInfo.() -> Unit = {}): ConnectCreateDeviceIdCallbackInfo = ConnectCreateDeviceIdCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectDeleteDeviceIdOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: ConnectDeleteDeviceIdOptions = ConnectDeleteDeviceIdOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectDeleteDeviceIdOptions {
      val struct = ConnectDeleteDeviceIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectDeleteDeviceIdOptions(block: ConnectDeleteDeviceIdOptions.() -> Unit = {}): ConnectDeleteDeviceIdOptions = ConnectDeleteDeviceIdOptions.allocate().apply(block)

@JvmInline
public value class ConnectDeleteDeviceIdCallbackInfo(
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

    public val NULL: ConnectDeleteDeviceIdCallbackInfo = ConnectDeleteDeviceIdCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectDeleteDeviceIdCallbackInfo {
      val struct = ConnectDeleteDeviceIdCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectDeleteDeviceIdCallbackInfo(block: ConnectDeleteDeviceIdCallbackInfo.() -> Unit = {}): ConnectDeleteDeviceIdCallbackInfo = ConnectDeleteDeviceIdCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectTransferDeviceIdAccountOptions(
  public val address: Long,
) {
  public var primaryLocalUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localDeviceUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var productUserIdToPreserve: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ConnectTransferDeviceIdAccountOptions =
        ConnectTransferDeviceIdAccountOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectTransferDeviceIdAccountOptions {
      val struct = ConnectTransferDeviceIdAccountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectTransferDeviceIdAccountOptions(block: ConnectTransferDeviceIdAccountOptions.() -> Unit = {}): ConnectTransferDeviceIdAccountOptions = ConnectTransferDeviceIdAccountOptions.allocate().apply(block)

@JvmInline
public value class ConnectTransferDeviceIdAccountCallbackInfo(
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

    public val NULL: ConnectTransferDeviceIdAccountCallbackInfo =
        ConnectTransferDeviceIdAccountCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectTransferDeviceIdAccountCallbackInfo {
      val struct = ConnectTransferDeviceIdAccountCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectTransferDeviceIdAccountCallbackInfo(block: ConnectTransferDeviceIdAccountCallbackInfo.() -> Unit = {}): ConnectTransferDeviceIdAccountCallbackInfo = ConnectTransferDeviceIdAccountCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectQueryExternalAccountMappingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var externalAccountIds: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var externalAccountIdCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: ConnectQueryExternalAccountMappingsOptions =
        ConnectQueryExternalAccountMappingsOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectQueryExternalAccountMappingsOptions {
      val struct = ConnectQueryExternalAccountMappingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectQueryExternalAccountMappingsOptions(block: ConnectQueryExternalAccountMappingsOptions.() -> Unit = {}): ConnectQueryExternalAccountMappingsOptions = ConnectQueryExternalAccountMappingsOptions.allocate().apply(block)

@JvmInline
public value class ConnectQueryExternalAccountMappingsCallbackInfo(
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

    public val NULL: ConnectQueryExternalAccountMappingsCallbackInfo =
        ConnectQueryExternalAccountMappingsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectQueryExternalAccountMappingsCallbackInfo {
      val struct = ConnectQueryExternalAccountMappingsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectQueryExternalAccountMappingsCallbackInfo(block: ConnectQueryExternalAccountMappingsCallbackInfo.() -> Unit = {}): ConnectQueryExternalAccountMappingsCallbackInfo = ConnectQueryExternalAccountMappingsCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectGetExternalAccountMappingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  context(arena: Arena)
  public var targetExternalUserId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ConnectGetExternalAccountMappingsOptions =
        ConnectGetExternalAccountMappingsOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectGetExternalAccountMappingsOptions {
      val struct = ConnectGetExternalAccountMappingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectGetExternalAccountMappingsOptions(block: ConnectGetExternalAccountMappingsOptions.() -> Unit = {}): ConnectGetExternalAccountMappingsOptions = ConnectGetExternalAccountMappingsOptions.allocate().apply(block)

@JvmInline
public value class ConnectQueryProductUserIdMappingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var accountIdType_DEPRECATED: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var productUserIds: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var productUserIdCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: ConnectQueryProductUserIdMappingsOptions =
        ConnectQueryProductUserIdMappingsOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectQueryProductUserIdMappingsOptions {
      val struct = ConnectQueryProductUserIdMappingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectQueryProductUserIdMappingsOptions(block: ConnectQueryProductUserIdMappingsOptions.() -> Unit = {}): ConnectQueryProductUserIdMappingsOptions = ConnectQueryProductUserIdMappingsOptions.allocate().apply(block)

@JvmInline
public value class ConnectQueryProductUserIdMappingsCallbackInfo(
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

    public val NULL: ConnectQueryProductUserIdMappingsCallbackInfo =
        ConnectQueryProductUserIdMappingsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectQueryProductUserIdMappingsCallbackInfo {
      val struct = ConnectQueryProductUserIdMappingsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectQueryProductUserIdMappingsCallbackInfo(block: ConnectQueryProductUserIdMappingsCallbackInfo.() -> Unit = {}): ConnectQueryProductUserIdMappingsCallbackInfo = ConnectQueryProductUserIdMappingsCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectGetProductUserIdMappingOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var targetProductUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: ConnectGetProductUserIdMappingOptions =
        ConnectGetProductUserIdMappingOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectGetProductUserIdMappingOptions {
      val struct = ConnectGetProductUserIdMappingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectGetProductUserIdMappingOptions(block: ConnectGetProductUserIdMappingOptions.() -> Unit = {}): ConnectGetProductUserIdMappingOptions = ConnectGetProductUserIdMappingOptions.allocate().apply(block)

@JvmInline
public value class ConnectGetProductUserExternalAccountCountOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectGetProductUserExternalAccountCountOptions =
        ConnectGetProductUserExternalAccountCountOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectGetProductUserExternalAccountCountOptions {
      val struct = ConnectGetProductUserExternalAccountCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectGetProductUserExternalAccountCountOptions(block: ConnectGetProductUserExternalAccountCountOptions.() -> Unit = {}): ConnectGetProductUserExternalAccountCountOptions = ConnectGetProductUserExternalAccountCountOptions.allocate().apply(block)

@JvmInline
public value class ConnectCopyProductUserExternalAccountByIndexOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var externalAccountInfoIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectCopyProductUserExternalAccountByIndexOptions =
        ConnectCopyProductUserExternalAccountByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCopyProductUserExternalAccountByIndexOptions {
      val struct = ConnectCopyProductUserExternalAccountByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCopyProductUserExternalAccountByIndexOptions(block: ConnectCopyProductUserExternalAccountByIndexOptions.() -> Unit = {}): ConnectCopyProductUserExternalAccountByIndexOptions = ConnectCopyProductUserExternalAccountByIndexOptions.allocate().apply(block)

@JvmInline
public value class ConnectCopyProductUserExternalAccountByAccountTypeOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectCopyProductUserExternalAccountByAccountTypeOptions =
        ConnectCopyProductUserExternalAccountByAccountTypeOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCopyProductUserExternalAccountByAccountTypeOptions {
      val struct = ConnectCopyProductUserExternalAccountByAccountTypeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCopyProductUserExternalAccountByAccountTypeOptions(block: ConnectCopyProductUserExternalAccountByAccountTypeOptions.() -> Unit = {}): ConnectCopyProductUserExternalAccountByAccountTypeOptions = ConnectCopyProductUserExternalAccountByAccountTypeOptions.allocate().apply(block)

@JvmInline
public value class ConnectCopyProductUserExternalAccountByAccountIdOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var accountId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectCopyProductUserExternalAccountByAccountIdOptions =
        ConnectCopyProductUserExternalAccountByAccountIdOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCopyProductUserExternalAccountByAccountIdOptions {
      val struct = ConnectCopyProductUserExternalAccountByAccountIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCopyProductUserExternalAccountByAccountIdOptions(block: ConnectCopyProductUserExternalAccountByAccountIdOptions.() -> Unit = {}): ConnectCopyProductUserExternalAccountByAccountIdOptions = ConnectCopyProductUserExternalAccountByAccountIdOptions.allocate().apply(block)

@JvmInline
public value class ConnectCopyProductUserInfoOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectCopyProductUserInfoOptions = ConnectCopyProductUserInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCopyProductUserInfoOptions {
      val struct = ConnectCopyProductUserInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCopyProductUserInfoOptions(block: ConnectCopyProductUserInfoOptions.() -> Unit = {}): ConnectCopyProductUserInfoOptions = ConnectCopyProductUserInfoOptions.allocate().apply(block)

@JvmInline
public value class ConnectExternalAccountInfo(
  public val address: Long,
) {
  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var accountId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public var lastLoginTime: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: ConnectExternalAccountInfo = ConnectExternalAccountInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectExternalAccountInfo {
      val struct = ConnectExternalAccountInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectExternalAccountInfo(block: ConnectExternalAccountInfo.() -> Unit = {}): ConnectExternalAccountInfo = ConnectExternalAccountInfo.allocate().apply(block)

@JvmInline
public value class ConnectAddNotifyAuthExpirationOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: ConnectAddNotifyAuthExpirationOptions =
        ConnectAddNotifyAuthExpirationOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectAddNotifyAuthExpirationOptions {
      val struct = ConnectAddNotifyAuthExpirationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectAddNotifyAuthExpirationOptions(block: ConnectAddNotifyAuthExpirationOptions.() -> Unit = {}): ConnectAddNotifyAuthExpirationOptions = ConnectAddNotifyAuthExpirationOptions.allocate().apply(block)

@JvmInline
public value class ConnectAuthExpirationCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectAuthExpirationCallbackInfo = ConnectAuthExpirationCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectAuthExpirationCallbackInfo {
      val struct = ConnectAuthExpirationCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectAuthExpirationCallbackInfo(block: ConnectAuthExpirationCallbackInfo.() -> Unit = {}): ConnectAuthExpirationCallbackInfo = ConnectAuthExpirationCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectAddNotifyLoginStatusChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: ConnectAddNotifyLoginStatusChangedOptions =
        ConnectAddNotifyLoginStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectAddNotifyLoginStatusChangedOptions {
      val struct = ConnectAddNotifyLoginStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectAddNotifyLoginStatusChangedOptions(block: ConnectAddNotifyLoginStatusChangedOptions.() -> Unit = {}): ConnectAddNotifyLoginStatusChangedOptions = ConnectAddNotifyLoginStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class ConnectLoginStatusChangedCallbackInfo(
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

  public var previousStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var currentStatus: ELoginStatus
    get() = ELoginStatus(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectLoginStatusChangedCallbackInfo =
        ConnectLoginStatusChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectLoginStatusChangedCallbackInfo {
      val struct = ConnectLoginStatusChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectLoginStatusChangedCallbackInfo(block: ConnectLoginStatusChangedCallbackInfo.() -> Unit = {}): ConnectLoginStatusChangedCallbackInfo = ConnectLoginStatusChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class ConnectIdToken(
  public val address: Long,
) {
  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var jsonWebToken: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: ConnectIdToken = ConnectIdToken(0)

    context(arena: Arena)
    public fun allocate(): ConnectIdToken {
      val struct = ConnectIdToken(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectIdToken(block: ConnectIdToken.() -> Unit = {}): ConnectIdToken = ConnectIdToken.allocate().apply(block)

@JvmInline
public value class ConnectCopyIdTokenOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectCopyIdTokenOptions = ConnectCopyIdTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectCopyIdTokenOptions {
      val struct = ConnectCopyIdTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectCopyIdTokenOptions(block: ConnectCopyIdTokenOptions.() -> Unit = {}): ConnectCopyIdTokenOptions = ConnectCopyIdTokenOptions.allocate().apply(block)

@JvmInline
public value class ConnectVerifyIdTokenOptions(
  public val address: Long,
) {
  public var idToken: ConnectIdToken
    get() = ConnectIdToken(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: ConnectVerifyIdTokenOptions = ConnectVerifyIdTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): ConnectVerifyIdTokenOptions {
      val struct = ConnectVerifyIdTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectVerifyIdTokenOptions(block: ConnectVerifyIdTokenOptions.() -> Unit = {}): ConnectVerifyIdTokenOptions = ConnectVerifyIdTokenOptions.allocate().apply(block)

@JvmInline
public value class ConnectVerifyIdTokenCallbackInfo(
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

  public var productUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var isAccountInfoPresent: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var accountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 28))
    set(`value`) {
      RawMemory.putInt(address + 28, value.value)
    }

  context(arena: Arena)
  public var accountId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var platform: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deviceType: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var clientId: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var productId: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var sandboxId: String?
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

  public companion object {
    public const val SIZE: Long = 88

    public val NULL: ConnectVerifyIdTokenCallbackInfo = ConnectVerifyIdTokenCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): ConnectVerifyIdTokenCallbackInfo {
      val struct = ConnectVerifyIdTokenCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun ConnectVerifyIdTokenCallbackInfo(block: ConnectVerifyIdTokenCallbackInfo.() -> Unit = {}): ConnectVerifyIdTokenCallbackInfo = ConnectVerifyIdTokenCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesSetCustomInviteOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var payload: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesSetCustomInviteOptions = CustomInvitesSetCustomInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSetCustomInviteOptions {
      val struct = CustomInvitesSetCustomInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSetCustomInviteOptions(block: CustomInvitesSetCustomInviteOptions.() -> Unit = {}): CustomInvitesSetCustomInviteOptions = CustomInvitesSetCustomInviteOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesSendCustomInviteOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetUserIds: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var targetUserIdsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: CustomInvitesSendCustomInviteOptions = CustomInvitesSendCustomInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSendCustomInviteOptions {
      val struct = CustomInvitesSendCustomInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSendCustomInviteOptions(block: CustomInvitesSendCustomInviteOptions.() -> Unit = {}): CustomInvitesSendCustomInviteOptions = CustomInvitesSendCustomInviteOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesSendCustomInviteCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: CustomInvitesSendCustomInviteCallbackInfo =
        CustomInvitesSendCustomInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSendCustomInviteCallbackInfo {
      val struct = CustomInvitesSendCustomInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSendCustomInviteCallbackInfo(block: CustomInvitesSendCustomInviteCallbackInfo.() -> Unit = {}): CustomInvitesSendCustomInviteCallbackInfo = CustomInvitesSendCustomInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyCustomInviteReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyCustomInviteReceivedOptions =
        CustomInvitesAddNotifyCustomInviteReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyCustomInviteReceivedOptions {
      val struct = CustomInvitesAddNotifyCustomInviteReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyCustomInviteReceivedOptions(block: CustomInvitesAddNotifyCustomInviteReceivedOptions.() -> Unit = {}): CustomInvitesAddNotifyCustomInviteReceivedOptions = CustomInvitesAddNotifyCustomInviteReceivedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesOnCustomInviteReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  context(arena: Arena)
  public var customInviteId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var payload: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: CustomInvitesOnCustomInviteReceivedCallbackInfo =
        CustomInvitesOnCustomInviteReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesOnCustomInviteReceivedCallbackInfo {
      val struct = CustomInvitesOnCustomInviteReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesOnCustomInviteReceivedCallbackInfo(block: CustomInvitesOnCustomInviteReceivedCallbackInfo.() -> Unit = {}): CustomInvitesOnCustomInviteReceivedCallbackInfo = CustomInvitesOnCustomInviteReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyCustomInviteAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyCustomInviteAcceptedOptions =
        CustomInvitesAddNotifyCustomInviteAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyCustomInviteAcceptedOptions {
      val struct = CustomInvitesAddNotifyCustomInviteAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyCustomInviteAcceptedOptions(block: CustomInvitesAddNotifyCustomInviteAcceptedOptions.() -> Unit = {}): CustomInvitesAddNotifyCustomInviteAcceptedOptions = CustomInvitesAddNotifyCustomInviteAcceptedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesOnCustomInviteAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  context(arena: Arena)
  public var customInviteId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var payload: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: CustomInvitesOnCustomInviteAcceptedCallbackInfo =
        CustomInvitesOnCustomInviteAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesOnCustomInviteAcceptedCallbackInfo {
      val struct = CustomInvitesOnCustomInviteAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesOnCustomInviteAcceptedCallbackInfo(block: CustomInvitesOnCustomInviteAcceptedCallbackInfo.() -> Unit = {}): CustomInvitesOnCustomInviteAcceptedCallbackInfo = CustomInvitesOnCustomInviteAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyCustomInviteRejectedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyCustomInviteRejectedOptions =
        CustomInvitesAddNotifyCustomInviteRejectedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyCustomInviteRejectedOptions {
      val struct = CustomInvitesAddNotifyCustomInviteRejectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyCustomInviteRejectedOptions(block: CustomInvitesAddNotifyCustomInviteRejectedOptions.() -> Unit = {}): CustomInvitesAddNotifyCustomInviteRejectedOptions = CustomInvitesAddNotifyCustomInviteRejectedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesCustomInviteRejectedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  context(arena: Arena)
  public var customInviteId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var payload: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: CustomInvitesCustomInviteRejectedCallbackInfo =
        CustomInvitesCustomInviteRejectedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesCustomInviteRejectedCallbackInfo {
      val struct = CustomInvitesCustomInviteRejectedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesCustomInviteRejectedCallbackInfo(block: CustomInvitesCustomInviteRejectedCallbackInfo.() -> Unit = {}): CustomInvitesCustomInviteRejectedCallbackInfo = CustomInvitesCustomInviteRejectedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesFinalizeInviteOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  context(arena: Arena)
  public var customInviteId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var processingResult: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: CustomInvitesFinalizeInviteOptions = CustomInvitesFinalizeInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesFinalizeInviteOptions {
      val struct = CustomInvitesFinalizeInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesFinalizeInviteOptions(block: CustomInvitesFinalizeInviteOptions.() -> Unit = {}): CustomInvitesFinalizeInviteOptions = CustomInvitesFinalizeInviteOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesSendRequestToJoinOptions(
  public val address: Long,
) {
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesSendRequestToJoinOptions =
        CustomInvitesSendRequestToJoinOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSendRequestToJoinOptions {
      val struct = CustomInvitesSendRequestToJoinOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSendRequestToJoinOptions(block: CustomInvitesSendRequestToJoinOptions.() -> Unit = {}): CustomInvitesSendRequestToJoinOptions = CustomInvitesSendRequestToJoinOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesSendRequestToJoinCallbackInfo(
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

    public val NULL: CustomInvitesSendRequestToJoinCallbackInfo =
        CustomInvitesSendRequestToJoinCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSendRequestToJoinCallbackInfo {
      val struct = CustomInvitesSendRequestToJoinCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSendRequestToJoinCallbackInfo(block: CustomInvitesSendRequestToJoinCallbackInfo.() -> Unit = {}): CustomInvitesSendRequestToJoinCallbackInfo = CustomInvitesSendRequestToJoinCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions =
        CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions {
      val struct = CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions(block: CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions.() -> Unit = {}): CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions = CustomInvitesAddNotifyRequestToJoinResponseReceivedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesRequestToJoinResponseReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var fromUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var toUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var response: ERequestToJoinResponse
    get() = ERequestToJoinResponse(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: CustomInvitesRequestToJoinResponseReceivedCallbackInfo =
        CustomInvitesRequestToJoinResponseReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesRequestToJoinResponseReceivedCallbackInfo {
      val struct = CustomInvitesRequestToJoinResponseReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesRequestToJoinResponseReceivedCallbackInfo(block: CustomInvitesRequestToJoinResponseReceivedCallbackInfo.() -> Unit = {}): CustomInvitesRequestToJoinResponseReceivedCallbackInfo = CustomInvitesRequestToJoinResponseReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyRequestToJoinReceivedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyRequestToJoinReceivedOptions =
        CustomInvitesAddNotifyRequestToJoinReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyRequestToJoinReceivedOptions {
      val struct = CustomInvitesAddNotifyRequestToJoinReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyRequestToJoinReceivedOptions(block: CustomInvitesAddNotifyRequestToJoinReceivedOptions.() -> Unit = {}): CustomInvitesAddNotifyRequestToJoinReceivedOptions = CustomInvitesAddNotifyRequestToJoinReceivedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesRequestToJoinReceivedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var fromUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var toUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesRequestToJoinReceivedCallbackInfo =
        CustomInvitesRequestToJoinReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesRequestToJoinReceivedCallbackInfo {
      val struct = CustomInvitesRequestToJoinReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesRequestToJoinReceivedCallbackInfo(block: CustomInvitesRequestToJoinReceivedCallbackInfo.() -> Unit = {}): CustomInvitesRequestToJoinReceivedCallbackInfo = CustomInvitesRequestToJoinReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAcceptRequestToJoinOptions(
  public val address: Long,
) {
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesAcceptRequestToJoinOptions =
        CustomInvitesAcceptRequestToJoinOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAcceptRequestToJoinOptions {
      val struct = CustomInvitesAcceptRequestToJoinOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAcceptRequestToJoinOptions(block: CustomInvitesAcceptRequestToJoinOptions.() -> Unit = {}): CustomInvitesAcceptRequestToJoinOptions = CustomInvitesAcceptRequestToJoinOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesAcceptRequestToJoinCallbackInfo(
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

    public val NULL: CustomInvitesAcceptRequestToJoinCallbackInfo =
        CustomInvitesAcceptRequestToJoinCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAcceptRequestToJoinCallbackInfo {
      val struct = CustomInvitesAcceptRequestToJoinCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAcceptRequestToJoinCallbackInfo(block: CustomInvitesAcceptRequestToJoinCallbackInfo.() -> Unit = {}): CustomInvitesAcceptRequestToJoinCallbackInfo = CustomInvitesAcceptRequestToJoinCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesRejectRequestToJoinOptions(
  public val address: Long,
) {
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesRejectRequestToJoinOptions =
        CustomInvitesRejectRequestToJoinOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesRejectRequestToJoinOptions {
      val struct = CustomInvitesRejectRequestToJoinOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesRejectRequestToJoinOptions(block: CustomInvitesRejectRequestToJoinOptions.() -> Unit = {}): CustomInvitesRejectRequestToJoinOptions = CustomInvitesRejectRequestToJoinOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesRejectRequestToJoinCallbackInfo(
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

    public val NULL: CustomInvitesRejectRequestToJoinCallbackInfo =
        CustomInvitesRejectRequestToJoinCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesRejectRequestToJoinCallbackInfo {
      val struct = CustomInvitesRejectRequestToJoinCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesRejectRequestToJoinCallbackInfo(block: CustomInvitesRejectRequestToJoinCallbackInfo.() -> Unit = {}): CustomInvitesRejectRequestToJoinCallbackInfo = CustomInvitesRejectRequestToJoinCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesDisableRequestToJoinOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesDisableRequestToJoinOptions =
        CustomInvitesDisableRequestToJoinOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesDisableRequestToJoinOptions {
      val struct = CustomInvitesDisableRequestToJoinOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesDisableRequestToJoinOptions(block: CustomInvitesDisableRequestToJoinOptions.() -> Unit = {}): CustomInvitesDisableRequestToJoinOptions = CustomInvitesDisableRequestToJoinOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions =
        CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions {
      val struct = CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions(block: CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions.() -> Unit = {}): CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions = CustomInvitesAddNotifySendCustomNativeInviteRequestedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesSendCustomNativeInviteRequestedCallbackInfo(
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
  public var inviteId: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: CustomInvitesSendCustomNativeInviteRequestedCallbackInfo =
        CustomInvitesSendCustomNativeInviteRequestedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesSendCustomNativeInviteRequestedCallbackInfo {
      val struct = CustomInvitesSendCustomNativeInviteRequestedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesSendCustomNativeInviteRequestedCallbackInfo(block: CustomInvitesSendCustomNativeInviteRequestedCallbackInfo.() -> Unit = {}): CustomInvitesSendCustomNativeInviteRequestedCallbackInfo = CustomInvitesSendCustomNativeInviteRequestedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyRequestToJoinAcceptedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyRequestToJoinAcceptedOptions =
        CustomInvitesAddNotifyRequestToJoinAcceptedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyRequestToJoinAcceptedOptions {
      val struct = CustomInvitesAddNotifyRequestToJoinAcceptedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyRequestToJoinAcceptedOptions(block: CustomInvitesAddNotifyRequestToJoinAcceptedOptions.() -> Unit = {}): CustomInvitesAddNotifyRequestToJoinAcceptedOptions = CustomInvitesAddNotifyRequestToJoinAcceptedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesOnRequestToJoinAcceptedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesOnRequestToJoinAcceptedCallbackInfo =
        CustomInvitesOnRequestToJoinAcceptedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesOnRequestToJoinAcceptedCallbackInfo {
      val struct = CustomInvitesOnRequestToJoinAcceptedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesOnRequestToJoinAcceptedCallbackInfo(block: CustomInvitesOnRequestToJoinAcceptedCallbackInfo.() -> Unit = {}): CustomInvitesOnRequestToJoinAcceptedCallbackInfo = CustomInvitesOnRequestToJoinAcceptedCallbackInfo.allocate().apply(block)

@JvmInline
public value class CustomInvitesAddNotifyRequestToJoinRejectedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: CustomInvitesAddNotifyRequestToJoinRejectedOptions =
        CustomInvitesAddNotifyRequestToJoinRejectedOptions(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesAddNotifyRequestToJoinRejectedOptions {
      val struct = CustomInvitesAddNotifyRequestToJoinRejectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesAddNotifyRequestToJoinRejectedOptions(block: CustomInvitesAddNotifyRequestToJoinRejectedOptions.() -> Unit = {}): CustomInvitesAddNotifyRequestToJoinRejectedOptions = CustomInvitesAddNotifyRequestToJoinRejectedOptions.allocate().apply(block)

@JvmInline
public value class CustomInvitesOnRequestToJoinRejectedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: CustomInvitesOnRequestToJoinRejectedCallbackInfo =
        CustomInvitesOnRequestToJoinRejectedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): CustomInvitesOnRequestToJoinRejectedCallbackInfo {
      val struct = CustomInvitesOnRequestToJoinRejectedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun CustomInvitesOnRequestToJoinRejectedCallbackInfo(block: CustomInvitesOnRequestToJoinRejectedCallbackInfo.() -> Unit = {}): CustomInvitesOnRequestToJoinRejectedCallbackInfo = CustomInvitesOnRequestToJoinRejectedCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomEntitlement(
  public val address: Long,
) {
  public var entitlementName: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var entitlementId: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var catalogItemId: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var serverIndex: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var redeemed: Boolean
    get() = RawMemory.getInt(address + 36) != 0
    set(`value`) {
      RawMemory.putInt(address + 36, if (value) 1 else 0)
    }

  public var endTimestamp: Long
    get() = RawMemory.getLong(address + 40)
    set(`value`) {
      RawMemory.putLong(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: EcomEntitlement = EcomEntitlement(0)

    context(arena: Arena)
    public fun allocate(): EcomEntitlement {
      val struct = EcomEntitlement(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomEntitlement(block: EcomEntitlement.() -> Unit = {}): EcomEntitlement = EcomEntitlement.allocate().apply(block)

@JvmInline
public value class EcomItemOwnership(
  public val address: Long,
) {
  public var id: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var ownershipStatus: EOwnershipStatus
    get() = EOwnershipStatus(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomItemOwnership = EcomItemOwnership(0)

    context(arena: Arena)
    public fun allocate(): EcomItemOwnership {
      val struct = EcomItemOwnership(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomItemOwnership(block: EcomItemOwnership.() -> Unit = {}): EcomItemOwnership = EcomItemOwnership.allocate().apply(block)

@JvmInline
public value class EcomCatalogItem(
  public val address: Long,
) {
  context(arena: Arena)
  public var catalogNamespace: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var id: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var entitlementName: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  context(arena: Arena)
  public var titleText: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var descriptionText: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var longDescriptionText: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var technicalDetailsText: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var developerText: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var itemType: EEcomItemType
    get() = EEcomItemType(RawMemory.getInt(address + 72))
    set(`value`) {
      RawMemory.putInt(address + 72, value.value)
    }

  public var entitlementEndTimestamp: Long
    get() = RawMemory.getLong(address + 80)
    set(`value`) {
      RawMemory.putLong(address + 80, value)
    }

  public companion object {
    public const val SIZE: Long = 88

    public val NULL: EcomCatalogItem = EcomCatalogItem(0)

    context(arena: Arena)
    public fun allocate(): EcomCatalogItem {
      val struct = EcomCatalogItem(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCatalogItem(block: EcomCatalogItem.() -> Unit = {}): EcomCatalogItem = EcomCatalogItem.allocate().apply(block)

@JvmInline
public value class EcomCatalogOffer(
  public val address: Long,
) {
  public var serverIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var catalogNamespace: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var id: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  context(arena: Arena)
  public var titleText: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var descriptionText: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var longDescriptionText: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var technicalDetailsText_DEPRECATED: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var currencyCode: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var priceResult: EosResult
    get() = EosResult.fromValue(RawMemory.getInt(address + 64))
    set(`value`) {
      RawMemory.putInt(address + 64, value.value)
    }

  public var originalPrice_DEPRECATED: Int
    get() = RawMemory.getInt(address + 68)
    set(`value`) {
      RawMemory.putInt(address + 68, value)
    }

  public var currentPrice_DEPRECATED: Int
    get() = RawMemory.getInt(address + 72)
    set(`value`) {
      RawMemory.putInt(address + 72, value)
    }

  public var discountPercentage: Byte
    get() = RawMemory.getByte(address + 76)
    set(`value`) {
      RawMemory.putByte(address + 76, value)
    }

  public var expirationTimestamp: Long
    get() = RawMemory.getLong(address + 80)
    set(`value`) {
      RawMemory.putLong(address + 80, value)
    }

  public var purchasedCount_DEPRECATED: Int
    get() = RawMemory.getInt(address + 88)
    set(`value`) {
      RawMemory.putInt(address + 88, value)
    }

  public var purchaseLimit: Int
    get() = RawMemory.getInt(address + 92)
    set(`value`) {
      RawMemory.putInt(address + 92, value)
    }

  public var availableForPurchase: Boolean
    get() = RawMemory.getInt(address + 96) != 0
    set(`value`) {
      RawMemory.putInt(address + 96, if (value) 1 else 0)
    }

  public var originalPrice64: Long
    get() = RawMemory.getLong(address + 104)
    set(`value`) {
      RawMemory.putLong(address + 104, value)
    }

  public var currentPrice64: Long
    get() = RawMemory.getLong(address + 112)
    set(`value`) {
      RawMemory.putLong(address + 112, value)
    }

  public var decimalPoint: Int
    get() = RawMemory.getInt(address + 120)
    set(`value`) {
      RawMemory.putInt(address + 120, value)
    }

  public var releaseDateTimestamp: Long
    get() = RawMemory.getLong(address + 128)
    set(`value`) {
      RawMemory.putLong(address + 128, value)
    }

  public var effectiveDateTimestamp: Long
    get() = RawMemory.getLong(address + 136)
    set(`value`) {
      RawMemory.putLong(address + 136, value)
    }

  public companion object {
    public const val SIZE: Long = 144

    public val NULL: EcomCatalogOffer = EcomCatalogOffer(0)

    context(arena: Arena)
    public fun allocate(): EcomCatalogOffer {
      val struct = EcomCatalogOffer(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 5)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCatalogOffer(block: EcomCatalogOffer.() -> Unit = {}): EcomCatalogOffer = EcomCatalogOffer.allocate().apply(block)

@JvmInline
public value class EcomKeyImageInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var type: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var url: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var width: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var height: Int
    get() = RawMemory.getInt(address + 28)
    set(`value`) {
      RawMemory.putInt(address + 28, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomKeyImageInfo = EcomKeyImageInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomKeyImageInfo {
      val struct = EcomKeyImageInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomKeyImageInfo(block: EcomKeyImageInfo.() -> Unit = {}): EcomKeyImageInfo = EcomKeyImageInfo.allocate().apply(block)

@JvmInline
public value class EcomCatalogRelease(
  public val address: Long,
) {
  public var compatibleAppIdCount: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var compatibleAppIds: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var compatiblePlatformCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var compatiblePlatforms: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  context(arena: Arena)
  public var releaseNote: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomCatalogRelease = EcomCatalogRelease(0)

    context(arena: Arena)
    public fun allocate(): EcomCatalogRelease {
      val struct = EcomCatalogRelease(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCatalogRelease(block: EcomCatalogRelease.() -> Unit = {}): EcomCatalogRelease = EcomCatalogRelease.allocate().apply(block)

@JvmInline
public value class EcomCheckoutEntry(
  public val address: Long,
) {
  public var offerId: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: EcomCheckoutEntry = EcomCheckoutEntry(0)

    context(arena: Arena)
    public fun allocate(): EcomCheckoutEntry {
      val struct = EcomCheckoutEntry(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCheckoutEntry(block: EcomCheckoutEntry.() -> Unit = {}): EcomCheckoutEntry = EcomCheckoutEntry.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var catalogItemIds: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var catalogItemIdCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  context(arena: Arena)
  public var catalogNamespace: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomQueryOwnershipOptions = EcomQueryOwnershipOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipOptions {
      val struct = EcomQueryOwnershipOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipOptions(block: EcomQueryOwnershipOptions.() -> Unit = {}): EcomQueryOwnershipOptions = EcomQueryOwnershipOptions.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipCallbackInfo(
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

  public var itemOwnership: EcomItemOwnership
    get() = EcomItemOwnership(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var itemOwnershipCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomQueryOwnershipCallbackInfo = EcomQueryOwnershipCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipCallbackInfo {
      val struct = EcomQueryOwnershipCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipCallbackInfo(block: EcomQueryOwnershipCallbackInfo.() -> Unit = {}): EcomQueryOwnershipCallbackInfo = EcomQueryOwnershipCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipBySandboxIdsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var sandboxIds: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var sandboxIdsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomQueryOwnershipBySandboxIdsOptions =
        EcomQueryOwnershipBySandboxIdsOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipBySandboxIdsOptions {
      val struct = EcomQueryOwnershipBySandboxIdsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipBySandboxIdsOptions(block: EcomQueryOwnershipBySandboxIdsOptions.() -> Unit = {}): EcomQueryOwnershipBySandboxIdsOptions = EcomQueryOwnershipBySandboxIdsOptions.allocate().apply(block)

@JvmInline
public value class EcomSandboxIdItemOwnership(
  public val address: Long,
) {
  public var sandboxId: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var ownedCatalogItemIds: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var ownedCatalogItemIdsCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomSandboxIdItemOwnership = EcomSandboxIdItemOwnership(0)

    context(arena: Arena)
    public fun allocate(): EcomSandboxIdItemOwnership {
      val struct = EcomSandboxIdItemOwnership(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomSandboxIdItemOwnership(block: EcomSandboxIdItemOwnership.() -> Unit = {}): EcomSandboxIdItemOwnership = EcomSandboxIdItemOwnership.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipBySandboxIdsCallbackInfo(
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

  public var sandboxIdItemOwnerships: EcomSandboxIdItemOwnership
    get() = EcomSandboxIdItemOwnership(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var sandboxIdItemOwnershipsCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomQueryOwnershipBySandboxIdsCallbackInfo =
        EcomQueryOwnershipBySandboxIdsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipBySandboxIdsCallbackInfo {
      val struct = EcomQueryOwnershipBySandboxIdsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipBySandboxIdsCallbackInfo(block: EcomQueryOwnershipBySandboxIdsCallbackInfo.() -> Unit = {}): EcomQueryOwnershipBySandboxIdsCallbackInfo = EcomQueryOwnershipBySandboxIdsCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipTokenOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var catalogItemIds: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var catalogItemIdCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  context(arena: Arena)
  public var catalogNamespace: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomQueryOwnershipTokenOptions = EcomQueryOwnershipTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipTokenOptions {
      val struct = EcomQueryOwnershipTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipTokenOptions(block: EcomQueryOwnershipTokenOptions.() -> Unit = {}): EcomQueryOwnershipTokenOptions = EcomQueryOwnershipTokenOptions.allocate().apply(block)

@JvmInline
public value class EcomQueryOwnershipTokenCallbackInfo(
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

  context(arena: Arena)
  public var ownershipToken: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomQueryOwnershipTokenCallbackInfo = EcomQueryOwnershipTokenCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOwnershipTokenCallbackInfo {
      val struct = EcomQueryOwnershipTokenCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOwnershipTokenCallbackInfo(block: EcomQueryOwnershipTokenCallbackInfo.() -> Unit = {}): EcomQueryOwnershipTokenCallbackInfo = EcomQueryOwnershipTokenCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomQueryEntitlementsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementNames: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var entitlementNameCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var includeRedeemed: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var overrideCatalogNamespace: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomQueryEntitlementsOptions = EcomQueryEntitlementsOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryEntitlementsOptions {
      val struct = EcomQueryEntitlementsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryEntitlementsOptions(block: EcomQueryEntitlementsOptions.() -> Unit = {}): EcomQueryEntitlementsOptions = EcomQueryEntitlementsOptions.allocate().apply(block)

@JvmInline
public value class EcomQueryEntitlementsCallbackInfo(
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

    public val NULL: EcomQueryEntitlementsCallbackInfo = EcomQueryEntitlementsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryEntitlementsCallbackInfo {
      val struct = EcomQueryEntitlementsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryEntitlementsCallbackInfo(block: EcomQueryEntitlementsCallbackInfo.() -> Unit = {}): EcomQueryEntitlementsCallbackInfo = EcomQueryEntitlementsCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomQueryEntitlementTokenOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementNames: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var entitlementNameCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomQueryEntitlementTokenOptions = EcomQueryEntitlementTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryEntitlementTokenOptions {
      val struct = EcomQueryEntitlementTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryEntitlementTokenOptions(block: EcomQueryEntitlementTokenOptions.() -> Unit = {}): EcomQueryEntitlementTokenOptions = EcomQueryEntitlementTokenOptions.allocate().apply(block)

@JvmInline
public value class EcomQueryEntitlementTokenCallbackInfo(
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

  context(arena: Arena)
  public var entitlementToken: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomQueryEntitlementTokenCallbackInfo =
        EcomQueryEntitlementTokenCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryEntitlementTokenCallbackInfo {
      val struct = EcomQueryEntitlementTokenCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryEntitlementTokenCallbackInfo(block: EcomQueryEntitlementTokenCallbackInfo.() -> Unit = {}): EcomQueryEntitlementTokenCallbackInfo = EcomQueryEntitlementTokenCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomQueryOffersOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var overrideCatalogNamespace: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomQueryOffersOptions = EcomQueryOffersOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOffersOptions {
      val struct = EcomQueryOffersOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOffersOptions(block: EcomQueryOffersOptions.() -> Unit = {}): EcomQueryOffersOptions = EcomQueryOffersOptions.allocate().apply(block)

@JvmInline
public value class EcomQueryOffersCallbackInfo(
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

    public val NULL: EcomQueryOffersCallbackInfo = EcomQueryOffersCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomQueryOffersCallbackInfo {
      val struct = EcomQueryOffersCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomQueryOffersCallbackInfo(block: EcomQueryOffersCallbackInfo.() -> Unit = {}): EcomQueryOffersCallbackInfo = EcomQueryOffersCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomCheckoutOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var overrideCatalogNamespace: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var entryCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var entries: EcomCheckoutEntry
    get() = EcomCheckoutEntry(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.address)
    }

  public var preferredOrientation: ECheckoutOrientation
    get() = ECheckoutOrientation(RawMemory.getInt(address + 40))
    set(`value`) {
      RawMemory.putInt(address + 40, value.value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: EcomCheckoutOptions = EcomCheckoutOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCheckoutOptions {
      val struct = EcomCheckoutOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCheckoutOptions(block: EcomCheckoutOptions.() -> Unit = {}): EcomCheckoutOptions = EcomCheckoutOptions.allocate().apply(block)

@JvmInline
public value class EcomCheckoutCallbackInfo(
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

  context(arena: Arena)
  public var transactionId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var cTCToken: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var cTCTokenType: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var catalogRegion: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: EcomCheckoutCallbackInfo = EcomCheckoutCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomCheckoutCallbackInfo {
      val struct = EcomCheckoutCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCheckoutCallbackInfo(block: EcomCheckoutCallbackInfo.() -> Unit = {}): EcomCheckoutCallbackInfo = EcomCheckoutCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomRedeemEntitlementsOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var entitlementIdCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var entitlementIds: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: EcomRedeemEntitlementsOptions = EcomRedeemEntitlementsOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomRedeemEntitlementsOptions {
      val struct = EcomRedeemEntitlementsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomRedeemEntitlementsOptions(block: EcomRedeemEntitlementsOptions.() -> Unit = {}): EcomRedeemEntitlementsOptions = EcomRedeemEntitlementsOptions.allocate().apply(block)

@JvmInline
public value class EcomRedeemEntitlementsCallbackInfo(
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

  public var redeemedEntitlementIdsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var previouslyRedeemedEntitlementIdsCount: Int
    get() = RawMemory.getInt(address + 28)
    set(`value`) {
      RawMemory.putInt(address + 28, value)
    }

  public var invalidEntitlementIdsCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: EcomRedeemEntitlementsCallbackInfo = EcomRedeemEntitlementsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): EcomRedeemEntitlementsCallbackInfo {
      val struct = EcomRedeemEntitlementsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomRedeemEntitlementsCallbackInfo(block: EcomRedeemEntitlementsCallbackInfo.() -> Unit = {}): EcomRedeemEntitlementsCallbackInfo = EcomRedeemEntitlementsCallbackInfo.allocate().apply(block)

@JvmInline
public value class EcomGetLastRedeemedEntitlementsCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: EcomGetLastRedeemedEntitlementsCountOptions =
        EcomGetLastRedeemedEntitlementsCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetLastRedeemedEntitlementsCountOptions {
      val struct = EcomGetLastRedeemedEntitlementsCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetLastRedeemedEntitlementsCountOptions(block: EcomGetLastRedeemedEntitlementsCountOptions.() -> Unit = {}): EcomGetLastRedeemedEntitlementsCountOptions = EcomGetLastRedeemedEntitlementsCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyLastRedeemedEntitlementByIndexOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var redeemedEntitlementIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyLastRedeemedEntitlementByIndexOptions =
        EcomCopyLastRedeemedEntitlementByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyLastRedeemedEntitlementByIndexOptions {
      val struct = EcomCopyLastRedeemedEntitlementByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyLastRedeemedEntitlementByIndexOptions(block: EcomCopyLastRedeemedEntitlementByIndexOptions.() -> Unit = {}): EcomCopyLastRedeemedEntitlementByIndexOptions = EcomCopyLastRedeemedEntitlementByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomGetLastRedeemEntitlementsResultCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var resultType: ERedeemEntitlementsResultListType
    get() = ERedeemEntitlementsResultListType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetLastRedeemEntitlementsResultCountOptions =
        EcomGetLastRedeemEntitlementsResultCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetLastRedeemEntitlementsResultCountOptions {
      val struct = EcomGetLastRedeemEntitlementsResultCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetLastRedeemEntitlementsResultCountOptions(block: EcomGetLastRedeemEntitlementsResultCountOptions.() -> Unit = {}): EcomGetLastRedeemEntitlementsResultCountOptions = EcomGetLastRedeemEntitlementsResultCountOptions.allocate().apply(block)

@JvmInline
public value class EcomCopyLastRedeemEntitlementsResultByIndexOptions(
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

  public var resultType: ERedeemEntitlementsResultListType
    get() = ERedeemEntitlementsResultListType(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomCopyLastRedeemEntitlementsResultByIndexOptions =
        EcomCopyLastRedeemEntitlementsResultByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomCopyLastRedeemEntitlementsResultByIndexOptions {
      val struct = EcomCopyLastRedeemEntitlementsResultByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomCopyLastRedeemEntitlementsResultByIndexOptions(block: EcomCopyLastRedeemEntitlementsResultByIndexOptions.() -> Unit = {}): EcomCopyLastRedeemEntitlementsResultByIndexOptions = EcomCopyLastRedeemEntitlementsResultByIndexOptions.allocate().apply(block)

@JvmInline
public value class EcomGetEntitlementsCountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: EcomGetEntitlementsCountOptions = EcomGetEntitlementsCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetEntitlementsCountOptions {
      val struct = EcomGetEntitlementsCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetEntitlementsCountOptions(block: EcomGetEntitlementsCountOptions.() -> Unit = {}): EcomGetEntitlementsCountOptions = EcomGetEntitlementsCountOptions.allocate().apply(block)

@JvmInline
public value class EcomGetEntitlementsByNameCountOptions(
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: EcomGetEntitlementsByNameCountOptions =
        EcomGetEntitlementsByNameCountOptions(0)

    context(arena: Arena)
    public fun allocate(): EcomGetEntitlementsByNameCountOptions {
      val struct = EcomGetEntitlementsByNameCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun EcomGetEntitlementsByNameCountOptions(block: EcomGetEntitlementsByNameCountOptions.() -> Unit = {}): EcomGetEntitlementsByNameCountOptions = EcomGetEntitlementsByNameCountOptions.allocate().apply(block)
