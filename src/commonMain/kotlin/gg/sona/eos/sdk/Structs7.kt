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
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class UserInfoQueryUserInfoByDisplayNameOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: UserInfoQueryUserInfoByDisplayNameOptions =
        UserInfoQueryUserInfoByDisplayNameOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoByDisplayNameOptions {
      val struct = UserInfoQueryUserInfoByDisplayNameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoByDisplayNameOptions(block: UserInfoQueryUserInfoByDisplayNameOptions.() -> Unit = {}): UserInfoQueryUserInfoByDisplayNameOptions = UserInfoQueryUserInfoByDisplayNameOptions.allocate().apply(block)

@JvmInline
public value class UserInfoQueryUserInfoByDisplayNameCallbackInfo(
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

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: UserInfoQueryUserInfoByDisplayNameCallbackInfo =
        UserInfoQueryUserInfoByDisplayNameCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoByDisplayNameCallbackInfo {
      val struct = UserInfoQueryUserInfoByDisplayNameCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoByDisplayNameCallbackInfo(block: UserInfoQueryUserInfoByDisplayNameCallbackInfo.() -> Unit = {}): UserInfoQueryUserInfoByDisplayNameCallbackInfo = UserInfoQueryUserInfoByDisplayNameCallbackInfo.allocate().apply(block)

@JvmInline
public value class UserInfoQueryUserInfoByExternalAccountOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var externalAccountId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoQueryUserInfoByExternalAccountOptions =
        UserInfoQueryUserInfoByExternalAccountOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoByExternalAccountOptions {
      val struct = UserInfoQueryUserInfoByExternalAccountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoByExternalAccountOptions(block: UserInfoQueryUserInfoByExternalAccountOptions.() -> Unit = {}): UserInfoQueryUserInfoByExternalAccountOptions = UserInfoQueryUserInfoByExternalAccountOptions.allocate().apply(block)

@JvmInline
public value class UserInfoQueryUserInfoByExternalAccountCallbackInfo(
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
  public var externalAccountId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public var targetUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: UserInfoQueryUserInfoByExternalAccountCallbackInfo =
        UserInfoQueryUserInfoByExternalAccountCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): UserInfoQueryUserInfoByExternalAccountCallbackInfo {
      val struct = UserInfoQueryUserInfoByExternalAccountCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoQueryUserInfoByExternalAccountCallbackInfo(block: UserInfoQueryUserInfoByExternalAccountCallbackInfo.() -> Unit = {}): UserInfoQueryUserInfoByExternalAccountCallbackInfo = UserInfoQueryUserInfoByExternalAccountCallbackInfo.allocate().apply(block)

@JvmInline
public value class UserInfo(
  public val address: Long,
) {
  public var userId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var country: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var preferredLanguage: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var nickname: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var displayNameSanitized: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: UserInfo = UserInfo(0)

    context(arena: Arena)
    public fun allocate(): UserInfo {
      val struct = UserInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfo(block: UserInfo.() -> Unit = {}): UserInfo = UserInfo.allocate().apply(block)

@JvmInline
public value class UserInfoCopyUserInfoOptions(
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

    public val NULL: UserInfoCopyUserInfoOptions = UserInfoCopyUserInfoOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyUserInfoOptions {
      val struct = UserInfoCopyUserInfoOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyUserInfoOptions(block: UserInfoCopyUserInfoOptions.() -> Unit = {}): UserInfoCopyUserInfoOptions = UserInfoCopyUserInfoOptions.allocate().apply(block)

@JvmInline
public value class UserInfoExternalUserInfo(
  public val address: Long,
) {
  public var accountType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  context(arena: Arena)
  public var accountId: String?
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

  context(arena: Arena)
  public var displayNameSanitized: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoExternalUserInfo = UserInfoExternalUserInfo(0)

    context(arena: Arena)
    public fun allocate(): UserInfoExternalUserInfo {
      val struct = UserInfoExternalUserInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoExternalUserInfo(block: UserInfoExternalUserInfo.() -> Unit = {}): UserInfoExternalUserInfo = UserInfoExternalUserInfo.allocate().apply(block)

@JvmInline
public value class UserInfoGetExternalUserInfoCountOptions(
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

    public val NULL: UserInfoGetExternalUserInfoCountOptions =
        UserInfoGetExternalUserInfoCountOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoGetExternalUserInfoCountOptions {
      val struct = UserInfoGetExternalUserInfoCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoGetExternalUserInfoCountOptions(block: UserInfoGetExternalUserInfoCountOptions.() -> Unit = {}): UserInfoGetExternalUserInfoCountOptions = UserInfoGetExternalUserInfoCountOptions.allocate().apply(block)

@JvmInline
public value class UserInfoCopyExternalUserInfoByIndexOptions(
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

  public var index: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoCopyExternalUserInfoByIndexOptions =
        UserInfoCopyExternalUserInfoByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyExternalUserInfoByIndexOptions {
      val struct = UserInfoCopyExternalUserInfoByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyExternalUserInfoByIndexOptions(block: UserInfoCopyExternalUserInfoByIndexOptions.() -> Unit = {}): UserInfoCopyExternalUserInfoByIndexOptions = UserInfoCopyExternalUserInfoByIndexOptions.allocate().apply(block)

@JvmInline
public value class UserInfoCopyExternalUserInfoByAccountTypeOptions(
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

  public var accountType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoCopyExternalUserInfoByAccountTypeOptions =
        UserInfoCopyExternalUserInfoByAccountTypeOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyExternalUserInfoByAccountTypeOptions {
      val struct = UserInfoCopyExternalUserInfoByAccountTypeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyExternalUserInfoByAccountTypeOptions(block: UserInfoCopyExternalUserInfoByAccountTypeOptions.() -> Unit = {}): UserInfoCopyExternalUserInfoByAccountTypeOptions = UserInfoCopyExternalUserInfoByAccountTypeOptions.allocate().apply(block)

@JvmInline
public value class UserInfoCopyExternalUserInfoByAccountIdOptions(
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

  context(arena: Arena)
  public var accountId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoCopyExternalUserInfoByAccountIdOptions =
        UserInfoCopyExternalUserInfoByAccountIdOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyExternalUserInfoByAccountIdOptions {
      val struct = UserInfoCopyExternalUserInfoByAccountIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyExternalUserInfoByAccountIdOptions(block: UserInfoCopyExternalUserInfoByAccountIdOptions.() -> Unit = {}): UserInfoCopyExternalUserInfoByAccountIdOptions = UserInfoCopyExternalUserInfoByAccountIdOptions.allocate().apply(block)

@JvmInline
public value class UserInfoBestDisplayName(
  public val address: Long,
) {
  public var userId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
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
  public var displayNameSanitized: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var nickname: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var platformType: Int
    get() = RawMemory.getInt(address + 40)
    set(`value`) {
      RawMemory.putInt(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: UserInfoBestDisplayName = UserInfoBestDisplayName(0)

    context(arena: Arena)
    public fun allocate(): UserInfoBestDisplayName {
      val struct = UserInfoBestDisplayName(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoBestDisplayName(block: UserInfoBestDisplayName.() -> Unit = {}): UserInfoBestDisplayName = UserInfoBestDisplayName.allocate().apply(block)

@JvmInline
public value class UserInfoCopyBestDisplayNameOptions(
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

    public val NULL: UserInfoCopyBestDisplayNameOptions = UserInfoCopyBestDisplayNameOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyBestDisplayNameOptions {
      val struct = UserInfoCopyBestDisplayNameOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyBestDisplayNameOptions(block: UserInfoCopyBestDisplayNameOptions.() -> Unit = {}): UserInfoCopyBestDisplayNameOptions = UserInfoCopyBestDisplayNameOptions.allocate().apply(block)

@JvmInline
public value class UserInfoCopyBestDisplayNameWithPlatformOptions(
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

  public var targetPlatformType: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: UserInfoCopyBestDisplayNameWithPlatformOptions =
        UserInfoCopyBestDisplayNameWithPlatformOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoCopyBestDisplayNameWithPlatformOptions {
      val struct = UserInfoCopyBestDisplayNameWithPlatformOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoCopyBestDisplayNameWithPlatformOptions(block: UserInfoCopyBestDisplayNameWithPlatformOptions.() -> Unit = {}): UserInfoCopyBestDisplayNameWithPlatformOptions = UserInfoCopyBestDisplayNameWithPlatformOptions.allocate().apply(block)

@JvmInline
public value class UserInfoGetLocalPlatformTypeOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: UserInfoGetLocalPlatformTypeOptions = UserInfoGetLocalPlatformTypeOptions(0)

    context(arena: Arena)
    public fun allocate(): UserInfoGetLocalPlatformTypeOptions {
      val struct = UserInfoGetLocalPlatformTypeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun UserInfoGetLocalPlatformTypeOptions(block: UserInfoGetLocalPlatformTypeOptions.() -> Unit = {}): UserInfoGetLocalPlatformTypeOptions = UserInfoGetLocalPlatformTypeOptions.allocate().apply(block)
