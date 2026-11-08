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
import gg.sona.eos.common.ContinuanceToken
import gg.sona.eos.common.EpicAccountId
import gg.sona.eos.common.ProductUserId
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmInline

@JvmInline
public value class AchievementsQueryDefinitionsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var epicUserId_DEPRECATED: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var hiddenAchievementIds_DEPRECATED: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var hiddenAchievementsCount_DEPRECATED: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AchievementsQueryDefinitionsOptions = AchievementsQueryDefinitionsOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsQueryDefinitionsOptions {
      val struct = AchievementsQueryDefinitionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsQueryDefinitionsOptions(block: AchievementsQueryDefinitionsOptions.() -> Unit = {}): AchievementsQueryDefinitionsOptions = AchievementsQueryDefinitionsOptions.allocate().apply(block)

@JvmInline
public value class AchievementsStatThresholds(
  public val address: Long,
) {
  context(arena: Arena)
  public var name: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var threshold: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsStatThresholds = AchievementsStatThresholds(0)

    context(arena: Arena)
    public fun allocate(): AchievementsStatThresholds {
      val struct = AchievementsStatThresholds(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsStatThresholds(block: AchievementsStatThresholds.() -> Unit = {}): AchievementsStatThresholds = AchievementsStatThresholds.allocate().apply(block)

@JvmInline
public value class AchievementsPlayerStatInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var name: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var currentValue: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var thresholdValue: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsPlayerStatInfo = AchievementsPlayerStatInfo(0)

    context(arena: Arena)
    public fun allocate(): AchievementsPlayerStatInfo {
      val struct = AchievementsPlayerStatInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsPlayerStatInfo(block: AchievementsPlayerStatInfo.() -> Unit = {}): AchievementsPlayerStatInfo = AchievementsPlayerStatInfo.allocate().apply(block)

@JvmInline
public value class AchievementsDefinitionV2(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var unlockedDisplayName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var unlockedDescription: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedDisplayName: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedDescription: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var flavorText: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var unlockedIconURL: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedIconURL: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isHidden: Boolean
    get() = RawMemory.getInt(address + 72) != 0
    set(`value`) {
      RawMemory.putInt(address + 72, if (value) 1 else 0)
    }

  public var statThresholdsCount: Int
    get() = RawMemory.getInt(address + 76)
    set(`value`) {
      RawMemory.putInt(address + 76, value)
    }

  public var statThresholds: AchievementsStatThresholds
    get() = AchievementsStatThresholds(RawMemory.getLong(address + 80))
    set(`value`) {
      RawMemory.putLong(address + 80, value.address)
    }

  public companion object {
    public const val SIZE: Long = 88

    public val NULL: AchievementsDefinitionV2 = AchievementsDefinitionV2(0)

    context(arena: Arena)
    public fun allocate(): AchievementsDefinitionV2 {
      val struct = AchievementsDefinitionV2(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsDefinitionV2(block: AchievementsDefinitionV2.() -> Unit = {}): AchievementsDefinitionV2 = AchievementsDefinitionV2.allocate().apply(block)

@JvmInline
public value class AchievementsGetAchievementDefinitionCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AchievementsGetAchievementDefinitionCountOptions =
        AchievementsGetAchievementDefinitionCountOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsGetAchievementDefinitionCountOptions {
      val struct = AchievementsGetAchievementDefinitionCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsGetAchievementDefinitionCountOptions(block: AchievementsGetAchievementDefinitionCountOptions.() -> Unit = {}): AchievementsGetAchievementDefinitionCountOptions = AchievementsGetAchievementDefinitionCountOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyAchievementDefinitionV2ByIndexOptions(
  public val address: Long,
) {
  public var achievementIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AchievementsCopyAchievementDefinitionV2ByIndexOptions =
        AchievementsCopyAchievementDefinitionV2ByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyAchievementDefinitionV2ByIndexOptions {
      val struct = AchievementsCopyAchievementDefinitionV2ByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyAchievementDefinitionV2ByIndexOptions(block: AchievementsCopyAchievementDefinitionV2ByIndexOptions.() -> Unit = {}): AchievementsCopyAchievementDefinitionV2ByIndexOptions = AchievementsCopyAchievementDefinitionV2ByIndexOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions =
        AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions {
      val struct = AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions(block: AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions.() -> Unit = {}): AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions = AchievementsCopyAchievementDefinitionV2ByAchievementIdOptions.allocate().apply(block)

@JvmInline
public value class AchievementsOnQueryDefinitionsCompleteCallbackInfo(
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

    public val NULL: AchievementsOnQueryDefinitionsCompleteCallbackInfo =
        AchievementsOnQueryDefinitionsCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AchievementsOnQueryDefinitionsCompleteCallbackInfo {
      val struct = AchievementsOnQueryDefinitionsCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsOnQueryDefinitionsCompleteCallbackInfo(block: AchievementsOnQueryDefinitionsCompleteCallbackInfo.() -> Unit = {}): AchievementsOnQueryDefinitionsCompleteCallbackInfo = AchievementsOnQueryDefinitionsCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class AchievementsQueryPlayerAchievementsOptions(
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsQueryPlayerAchievementsOptions =
        AchievementsQueryPlayerAchievementsOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsQueryPlayerAchievementsOptions {
      val struct = AchievementsQueryPlayerAchievementsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsQueryPlayerAchievementsOptions(block: AchievementsQueryPlayerAchievementsOptions.() -> Unit = {}): AchievementsQueryPlayerAchievementsOptions = AchievementsQueryPlayerAchievementsOptions.allocate().apply(block)

@JvmInline
public value class AchievementsPlayerAchievement(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var progress: Double
    get() = RawMemory.getDouble(address + 16)
    set(`value`) {
      RawMemory.putDouble(address + 16, value)
    }

  public var unlockTime: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var statInfoCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var statInfo: AchievementsPlayerStatInfo
    get() = AchievementsPlayerStatInfo(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.address)
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var description: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var iconURL: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var flavorText: String?
    get() = RawMemory.getLong(address + 72).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 72, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 80

    public val NULL: AchievementsPlayerAchievement = AchievementsPlayerAchievement(0)

    context(arena: Arena)
    public fun allocate(): AchievementsPlayerAchievement {
      val struct = AchievementsPlayerAchievement(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsPlayerAchievement(block: AchievementsPlayerAchievement.() -> Unit = {}): AchievementsPlayerAchievement = AchievementsPlayerAchievement.allocate().apply(block)

@JvmInline
public value class AchievementsGetPlayerAchievementCountOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AchievementsGetPlayerAchievementCountOptions =
        AchievementsGetPlayerAchievementCountOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsGetPlayerAchievementCountOptions {
      val struct = AchievementsGetPlayerAchievementCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsGetPlayerAchievementCountOptions(block: AchievementsGetPlayerAchievementCountOptions.() -> Unit = {}): AchievementsGetPlayerAchievementCountOptions = AchievementsGetPlayerAchievementCountOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyPlayerAchievementByIndexOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var achievementIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsCopyPlayerAchievementByIndexOptions =
        AchievementsCopyPlayerAchievementByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyPlayerAchievementByIndexOptions {
      val struct = AchievementsCopyPlayerAchievementByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyPlayerAchievementByIndexOptions(block: AchievementsCopyPlayerAchievementByIndexOptions.() -> Unit = {}): AchievementsCopyPlayerAchievementByIndexOptions = AchievementsCopyPlayerAchievementByIndexOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyPlayerAchievementByAchievementIdOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsCopyPlayerAchievementByAchievementIdOptions =
        AchievementsCopyPlayerAchievementByAchievementIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyPlayerAchievementByAchievementIdOptions {
      val struct = AchievementsCopyPlayerAchievementByAchievementIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyPlayerAchievementByAchievementIdOptions(block: AchievementsCopyPlayerAchievementByAchievementIdOptions.() -> Unit = {}): AchievementsCopyPlayerAchievementByAchievementIdOptions = AchievementsCopyPlayerAchievementByAchievementIdOptions.allocate().apply(block)

@JvmInline
public value class AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo(
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

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo =
        AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo {
      val struct = AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo(block: AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo.() -> Unit = {}): AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo = AchievementsOnQueryPlayerAchievementsCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class AchievementsUnlockAchievementsOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var achievementIds: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var achievementsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsUnlockAchievementsOptions =
        AchievementsUnlockAchievementsOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsUnlockAchievementsOptions {
      val struct = AchievementsUnlockAchievementsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsUnlockAchievementsOptions(block: AchievementsUnlockAchievementsOptions.() -> Unit = {}): AchievementsUnlockAchievementsOptions = AchievementsUnlockAchievementsOptions.allocate().apply(block)

@JvmInline
public value class AchievementsOnUnlockAchievementsCompleteCallbackInfo(
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

  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public var achievementsCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsOnUnlockAchievementsCompleteCallbackInfo =
        AchievementsOnUnlockAchievementsCompleteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AchievementsOnUnlockAchievementsCompleteCallbackInfo {
      val struct = AchievementsOnUnlockAchievementsCompleteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsOnUnlockAchievementsCompleteCallbackInfo(block: AchievementsOnUnlockAchievementsCompleteCallbackInfo.() -> Unit = {}): AchievementsOnUnlockAchievementsCompleteCallbackInfo = AchievementsOnUnlockAchievementsCompleteCallbackInfo.allocate().apply(block)

@JvmInline
public value class AchievementsAddNotifyAchievementsUnlockedV2Options(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AchievementsAddNotifyAchievementsUnlockedV2Options =
        AchievementsAddNotifyAchievementsUnlockedV2Options(0)

    context(arena: Arena)
    public fun allocate(): AchievementsAddNotifyAchievementsUnlockedV2Options {
      val struct = AchievementsAddNotifyAchievementsUnlockedV2Options(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsAddNotifyAchievementsUnlockedV2Options(block: AchievementsAddNotifyAchievementsUnlockedV2Options.() -> Unit = {}): AchievementsAddNotifyAchievementsUnlockedV2Options = AchievementsAddNotifyAchievementsUnlockedV2Options.allocate().apply(block)

@JvmInline
public value class AchievementsOnAchievementsUnlockedCallbackV2Info(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var unlockTime: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsOnAchievementsUnlockedCallbackV2Info =
        AchievementsOnAchievementsUnlockedCallbackV2Info(0)

    context(arena: Arena)
    public fun allocate(): AchievementsOnAchievementsUnlockedCallbackV2Info {
      val struct = AchievementsOnAchievementsUnlockedCallbackV2Info(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsOnAchievementsUnlockedCallbackV2Info(block: AchievementsOnAchievementsUnlockedCallbackV2Info.() -> Unit = {}): AchievementsOnAchievementsUnlockedCallbackV2Info = AchievementsOnAchievementsUnlockedCallbackV2Info.allocate().apply(block)

@JvmInline
public value class AchievementsDefinition(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
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
  public var description: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedDisplayName: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedDescription: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var hiddenDescription: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var completionDescription: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var unlockedIconId: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var lockedIconId: String?
    get() = RawMemory.getLong(address + 72).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 72, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isHidden: Boolean
    get() = RawMemory.getInt(address + 80) != 0
    set(`value`) {
      RawMemory.putInt(address + 80, if (value) 1 else 0)
    }

  public var statThresholdsCount: Int
    get() = RawMemory.getInt(address + 84)
    set(`value`) {
      RawMemory.putInt(address + 84, value)
    }

  public var statThresholds: AchievementsStatThresholds
    get() = AchievementsStatThresholds(RawMemory.getLong(address + 88))
    set(`value`) {
      RawMemory.putLong(address + 88, value.address)
    }

  public companion object {
    public const val SIZE: Long = 96

    public val NULL: AchievementsDefinition = AchievementsDefinition(0)

    context(arena: Arena)
    public fun allocate(): AchievementsDefinition {
      val struct = AchievementsDefinition(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsDefinition(block: AchievementsDefinition.() -> Unit = {}): AchievementsDefinition = AchievementsDefinition.allocate().apply(block)

@JvmInline
public value class AchievementsCopyAchievementDefinitionByIndexOptions(
  public val address: Long,
) {
  public var achievementIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AchievementsCopyAchievementDefinitionByIndexOptions =
        AchievementsCopyAchievementDefinitionByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyAchievementDefinitionByIndexOptions {
      val struct = AchievementsCopyAchievementDefinitionByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyAchievementDefinitionByIndexOptions(block: AchievementsCopyAchievementDefinitionByIndexOptions.() -> Unit = {}): AchievementsCopyAchievementDefinitionByIndexOptions = AchievementsCopyAchievementDefinitionByIndexOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyAchievementDefinitionByAchievementIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AchievementsCopyAchievementDefinitionByAchievementIdOptions =
        AchievementsCopyAchievementDefinitionByAchievementIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyAchievementDefinitionByAchievementIdOptions {
      val struct = AchievementsCopyAchievementDefinitionByAchievementIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyAchievementDefinitionByAchievementIdOptions(block: AchievementsCopyAchievementDefinitionByAchievementIdOptions.() -> Unit = {}): AchievementsCopyAchievementDefinitionByAchievementIdOptions = AchievementsCopyAchievementDefinitionByAchievementIdOptions.allocate().apply(block)

@JvmInline
public value class AchievementsUnlockedAchievement(
  public val address: Long,
) {
  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var unlockTime: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsUnlockedAchievement = AchievementsUnlockedAchievement(0)

    context(arena: Arena)
    public fun allocate(): AchievementsUnlockedAchievement {
      val struct = AchievementsUnlockedAchievement(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsUnlockedAchievement(block: AchievementsUnlockedAchievement.() -> Unit = {}): AchievementsUnlockedAchievement = AchievementsUnlockedAchievement.allocate().apply(block)

@JvmInline
public value class AchievementsGetUnlockedAchievementCountOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AchievementsGetUnlockedAchievementCountOptions =
        AchievementsGetUnlockedAchievementCountOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsGetUnlockedAchievementCountOptions {
      val struct = AchievementsGetUnlockedAchievementCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsGetUnlockedAchievementCountOptions(block: AchievementsGetUnlockedAchievementCountOptions.() -> Unit = {}): AchievementsGetUnlockedAchievementCountOptions = AchievementsGetUnlockedAchievementCountOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyUnlockedAchievementByIndexOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var achievementIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsCopyUnlockedAchievementByIndexOptions =
        AchievementsCopyUnlockedAchievementByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyUnlockedAchievementByIndexOptions {
      val struct = AchievementsCopyUnlockedAchievementByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyUnlockedAchievementByIndexOptions(block: AchievementsCopyUnlockedAchievementByIndexOptions.() -> Unit = {}): AchievementsCopyUnlockedAchievementByIndexOptions = AchievementsCopyUnlockedAchievementByIndexOptions.allocate().apply(block)

@JvmInline
public value class AchievementsCopyUnlockedAchievementByAchievementIdOptions(
  public val address: Long,
) {
  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var achievementId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AchievementsCopyUnlockedAchievementByAchievementIdOptions =
        AchievementsCopyUnlockedAchievementByAchievementIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsCopyUnlockedAchievementByAchievementIdOptions {
      val struct = AchievementsCopyUnlockedAchievementByAchievementIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsCopyUnlockedAchievementByAchievementIdOptions(block: AchievementsCopyUnlockedAchievementByAchievementIdOptions.() -> Unit = {}): AchievementsCopyUnlockedAchievementByAchievementIdOptions = AchievementsCopyUnlockedAchievementByAchievementIdOptions.allocate().apply(block)

@JvmInline
public value class AchievementsAddNotifyAchievementsUnlockedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AchievementsAddNotifyAchievementsUnlockedOptions =
        AchievementsAddNotifyAchievementsUnlockedOptions(0)

    context(arena: Arena)
    public fun allocate(): AchievementsAddNotifyAchievementsUnlockedOptions {
      val struct = AchievementsAddNotifyAchievementsUnlockedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsAddNotifyAchievementsUnlockedOptions(block: AchievementsAddNotifyAchievementsUnlockedOptions.() -> Unit = {}): AchievementsAddNotifyAchievementsUnlockedOptions = AchievementsAddNotifyAchievementsUnlockedOptions.allocate().apply(block)

@JvmInline
public value class AchievementsOnAchievementsUnlockedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var achievementsCount: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var achievementIds: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AchievementsOnAchievementsUnlockedCallbackInfo =
        AchievementsOnAchievementsUnlockedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AchievementsOnAchievementsUnlockedCallbackInfo {
      val struct = AchievementsOnAchievementsUnlockedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AchievementsOnAchievementsUnlockedCallbackInfo(block: AchievementsOnAchievementsUnlockedCallbackInfo.() -> Unit = {}): AchievementsOnAchievementsUnlockedCallbackInfo = AchievementsOnAchievementsUnlockedCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatClientOnMessageToServerCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var messageData: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var messageDataSizeBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatClientOnMessageToServerCallbackInfo =
        AntiCheatClientOnMessageToServerCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientOnMessageToServerCallbackInfo {
      val struct = AntiCheatClientOnMessageToServerCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientOnMessageToServerCallbackInfo(block: AntiCheatClientOnMessageToServerCallbackInfo.() -> Unit = {}): AntiCheatClientOnMessageToServerCallbackInfo = AntiCheatClientOnMessageToServerCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatClientOnClientIntegrityViolatedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var violationType: EAntiCheatClientViolationType
    get() = EAntiCheatClientViolationType(RawMemory.getInt(address + 8))
    set(`value`) {
      RawMemory.putInt(address + 8, value.value)
    }

  context(arena: Arena)
  public var violationMessage: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatClientOnClientIntegrityViolatedCallbackInfo =
        AntiCheatClientOnClientIntegrityViolatedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientOnClientIntegrityViolatedCallbackInfo {
      val struct = AntiCheatClientOnClientIntegrityViolatedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientOnClientIntegrityViolatedCallbackInfo(block: AntiCheatClientOnClientIntegrityViolatedCallbackInfo.() -> Unit = {}): AntiCheatClientOnClientIntegrityViolatedCallbackInfo = AntiCheatClientOnClientIntegrityViolatedCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddNotifyMessageToServerOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientAddNotifyMessageToServerOptions =
        AntiCheatClientAddNotifyMessageToServerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddNotifyMessageToServerOptions {
      val struct = AntiCheatClientAddNotifyMessageToServerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddNotifyMessageToServerOptions(block: AntiCheatClientAddNotifyMessageToServerOptions.() -> Unit = {}): AntiCheatClientAddNotifyMessageToServerOptions = AntiCheatClientAddNotifyMessageToServerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddNotifyMessageToPeerOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientAddNotifyMessageToPeerOptions =
        AntiCheatClientAddNotifyMessageToPeerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddNotifyMessageToPeerOptions {
      val struct = AntiCheatClientAddNotifyMessageToPeerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddNotifyMessageToPeerOptions(block: AntiCheatClientAddNotifyMessageToPeerOptions.() -> Unit = {}): AntiCheatClientAddNotifyMessageToPeerOptions = AntiCheatClientAddNotifyMessageToPeerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddNotifyPeerActionRequiredOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientAddNotifyPeerActionRequiredOptions =
        AntiCheatClientAddNotifyPeerActionRequiredOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddNotifyPeerActionRequiredOptions {
      val struct = AntiCheatClientAddNotifyPeerActionRequiredOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddNotifyPeerActionRequiredOptions(block: AntiCheatClientAddNotifyPeerActionRequiredOptions.() -> Unit = {}): AntiCheatClientAddNotifyPeerActionRequiredOptions = AntiCheatClientAddNotifyPeerActionRequiredOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddNotifyPeerAuthStatusChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientAddNotifyPeerAuthStatusChangedOptions =
        AntiCheatClientAddNotifyPeerAuthStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddNotifyPeerAuthStatusChangedOptions {
      val struct = AntiCheatClientAddNotifyPeerAuthStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddNotifyPeerAuthStatusChangedOptions(block: AntiCheatClientAddNotifyPeerAuthStatusChangedOptions.() -> Unit = {}): AntiCheatClientAddNotifyPeerAuthStatusChangedOptions = AntiCheatClientAddNotifyPeerAuthStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddNotifyClientIntegrityViolatedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientAddNotifyClientIntegrityViolatedOptions =
        AntiCheatClientAddNotifyClientIntegrityViolatedOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddNotifyClientIntegrityViolatedOptions {
      val struct = AntiCheatClientAddNotifyClientIntegrityViolatedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddNotifyClientIntegrityViolatedOptions(block: AntiCheatClientAddNotifyClientIntegrityViolatedOptions.() -> Unit = {}): AntiCheatClientAddNotifyClientIntegrityViolatedOptions = AntiCheatClientAddNotifyClientIntegrityViolatedOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientBeginSessionOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var mode: EAntiCheatClientMode
    get() = EAntiCheatClientMode(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatClientBeginSessionOptions = AntiCheatClientBeginSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientBeginSessionOptions {
      val struct = AntiCheatClientBeginSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientBeginSessionOptions(block: AntiCheatClientBeginSessionOptions.() -> Unit = {}): AntiCheatClientBeginSessionOptions = AntiCheatClientBeginSessionOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientEndSessionOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientEndSessionOptions = AntiCheatClientEndSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientEndSessionOptions {
      val struct = AntiCheatClientEndSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientEndSessionOptions(block: AntiCheatClientEndSessionOptions.() -> Unit = {}): AntiCheatClientEndSessionOptions = AntiCheatClientEndSessionOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientReserved01Options(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientReserved01Options = AntiCheatClientReserved01Options(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientReserved01Options {
      val struct = AntiCheatClientReserved01Options(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientReserved01Options(block: AntiCheatClientReserved01Options.() -> Unit = {}): AntiCheatClientReserved01Options = AntiCheatClientReserved01Options.allocate().apply(block)

@JvmInline
public value class AntiCheatClientReserved02Options(
  public val address: Long,
) {
  public var reserved1: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var reserved2: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var reserved3: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var reserved4: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatClientReserved02Options = AntiCheatClientReserved02Options(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientReserved02Options {
      val struct = AntiCheatClientReserved02Options(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientReserved02Options(block: AntiCheatClientReserved02Options.() -> Unit = {}): AntiCheatClientReserved02Options = AntiCheatClientReserved02Options.allocate().apply(block)

@JvmInline
public value class AntiCheatClientGetModuleBuildIdOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatClientGetModuleBuildIdOptions =
        AntiCheatClientGetModuleBuildIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientGetModuleBuildIdOptions {
      val struct = AntiCheatClientGetModuleBuildIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientGetModuleBuildIdOptions(block: AntiCheatClientGetModuleBuildIdOptions.() -> Unit = {}): AntiCheatClientGetModuleBuildIdOptions = AntiCheatClientGetModuleBuildIdOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientGetSystemRequirementStatusOptions(
  public val address: Long,
) {
  public var clientSystemConfig: EAntiCheatCommonClientSystemConfig
    get() = EAntiCheatCommonClientSystemConfig(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var outReasonLength: Int
    get() = RawMemory.getInt(address + 8)
    set(`value`) {
      RawMemory.putInt(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 12

    public val NULL: AntiCheatClientGetSystemRequirementStatusOptions =
        AntiCheatClientGetSystemRequirementStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientGetSystemRequirementStatusOptions {
      val struct = AntiCheatClientGetSystemRequirementStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientGetSystemRequirementStatusOptions(block: AntiCheatClientGetSystemRequirementStatusOptions.() -> Unit = {}): AntiCheatClientGetSystemRequirementStatusOptions = AntiCheatClientGetSystemRequirementStatusOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientAddExternalIntegrityCatalogOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var pathToBinFile: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatClientAddExternalIntegrityCatalogOptions =
        AntiCheatClientAddExternalIntegrityCatalogOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientAddExternalIntegrityCatalogOptions {
      val struct = AntiCheatClientAddExternalIntegrityCatalogOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientAddExternalIntegrityCatalogOptions(block: AntiCheatClientAddExternalIntegrityCatalogOptions.() -> Unit = {}): AntiCheatClientAddExternalIntegrityCatalogOptions = AntiCheatClientAddExternalIntegrityCatalogOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientReceiveMessageFromServerOptions(
  public val address: Long,
) {
  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatClientReceiveMessageFromServerOptions =
        AntiCheatClientReceiveMessageFromServerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientReceiveMessageFromServerOptions {
      val struct = AntiCheatClientReceiveMessageFromServerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientReceiveMessageFromServerOptions(block: AntiCheatClientReceiveMessageFromServerOptions.() -> Unit = {}): AntiCheatClientReceiveMessageFromServerOptions = AntiCheatClientReceiveMessageFromServerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientGetProtectMessageOutputLengthOptions(
  public val address: Long,
) {
  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AntiCheatClientGetProtectMessageOutputLengthOptions =
        AntiCheatClientGetProtectMessageOutputLengthOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientGetProtectMessageOutputLengthOptions {
      val struct = AntiCheatClientGetProtectMessageOutputLengthOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientGetProtectMessageOutputLengthOptions(block: AntiCheatClientGetProtectMessageOutputLengthOptions.() -> Unit = {}): AntiCheatClientGetProtectMessageOutputLengthOptions = AntiCheatClientGetProtectMessageOutputLengthOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientProtectMessageOptions(
  public val address: Long,
) {
  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var outBufferSizeBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatClientProtectMessageOptions = AntiCheatClientProtectMessageOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientProtectMessageOptions {
      val struct = AntiCheatClientProtectMessageOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientProtectMessageOptions(block: AntiCheatClientProtectMessageOptions.() -> Unit = {}): AntiCheatClientProtectMessageOptions = AntiCheatClientProtectMessageOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientUnprotectMessageOptions(
  public val address: Long,
) {
  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var outBufferSizeBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatClientUnprotectMessageOptions =
        AntiCheatClientUnprotectMessageOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientUnprotectMessageOptions {
      val struct = AntiCheatClientUnprotectMessageOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientUnprotectMessageOptions(block: AntiCheatClientUnprotectMessageOptions.() -> Unit = {}): AntiCheatClientUnprotectMessageOptions = AntiCheatClientUnprotectMessageOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientRegisterPeerOptions(
  public val address: Long,
) {
  public var peerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var clientType: EAntiCheatCommonClientType
    get() = EAntiCheatCommonClientType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var clientPlatform: EAntiCheatCommonClientPlatform
    get() = EAntiCheatCommonClientPlatform(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public var authenticationTimeout: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  context(arena: Arena)
  public var accountId_DEPRECATED: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var ipAddress: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var peerProductUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: AntiCheatClientRegisterPeerOptions = AntiCheatClientRegisterPeerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientRegisterPeerOptions {
      val struct = AntiCheatClientRegisterPeerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientRegisterPeerOptions(block: AntiCheatClientRegisterPeerOptions.() -> Unit = {}): AntiCheatClientRegisterPeerOptions = AntiCheatClientRegisterPeerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientUnregisterPeerOptions(
  public val address: Long,
) {
  public var peerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatClientUnregisterPeerOptions = AntiCheatClientUnregisterPeerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientUnregisterPeerOptions {
      val struct = AntiCheatClientUnregisterPeerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientUnregisterPeerOptions(block: AntiCheatClientUnregisterPeerOptions.() -> Unit = {}): AntiCheatClientUnregisterPeerOptions = AntiCheatClientUnregisterPeerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientReceiveMessageFromPeerOptions(
  public val address: Long,
) {
  public var peerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatClientReceiveMessageFromPeerOptions =
        AntiCheatClientReceiveMessageFromPeerOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientReceiveMessageFromPeerOptions {
      val struct = AntiCheatClientReceiveMessageFromPeerOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientReceiveMessageFromPeerOptions(block: AntiCheatClientReceiveMessageFromPeerOptions.() -> Unit = {}): AntiCheatClientReceiveMessageFromPeerOptions = AntiCheatClientReceiveMessageFromPeerOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatClientPollStatusOptions(
  public val address: Long,
) {
  public var outMessageLength: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AntiCheatClientPollStatusOptions = AntiCheatClientPollStatusOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatClientPollStatusOptions {
      val struct = AntiCheatClientPollStatusOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatClientPollStatusOptions(block: AntiCheatClientPollStatusOptions.() -> Unit = {}): AntiCheatClientPollStatusOptions = AntiCheatClientPollStatusOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonVec3f(
  public val address: Long,
) {
  public var x: Float
    get() = RawMemory.getFloat(address)
    set(`value`) {
      RawMemory.putFloat(address, value)
    }

  public var y: Float
    get() = RawMemory.getFloat(address + 4)
    set(`value`) {
      RawMemory.putFloat(address + 4, value)
    }

  public var z: Float
    get() = RawMemory.getFloat(address + 8)
    set(`value`) {
      RawMemory.putFloat(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 12

    public val NULL: AntiCheatCommonVec3f = AntiCheatCommonVec3f(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonVec3f {
      val struct = AntiCheatCommonVec3f(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonVec3f(block: AntiCheatCommonVec3f.() -> Unit = {}): AntiCheatCommonVec3f = AntiCheatCommonVec3f.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonQuat(
  public val address: Long,
) {
  public var w: Float
    get() = RawMemory.getFloat(address)
    set(`value`) {
      RawMemory.putFloat(address, value)
    }

  public var x: Float
    get() = RawMemory.getFloat(address + 4)
    set(`value`) {
      RawMemory.putFloat(address + 4, value)
    }

  public var y: Float
    get() = RawMemory.getFloat(address + 8)
    set(`value`) {
      RawMemory.putFloat(address + 8, value)
    }

  public var z: Float
    get() = RawMemory.getFloat(address + 12)
    set(`value`) {
      RawMemory.putFloat(address + 12, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatCommonQuat = AntiCheatCommonQuat(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonQuat {
      val struct = AntiCheatCommonQuat(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonQuat(block: AntiCheatCommonQuat.() -> Unit = {}): AntiCheatCommonQuat = AntiCheatCommonQuat.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonOnMessageToClientCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var messageData: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var messageDataSizeBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatCommonOnMessageToClientCallbackInfo =
        AntiCheatCommonOnMessageToClientCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonOnMessageToClientCallbackInfo {
      val struct = AntiCheatCommonOnMessageToClientCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonOnMessageToClientCallbackInfo(block: AntiCheatCommonOnMessageToClientCallbackInfo.() -> Unit = {}): AntiCheatCommonOnMessageToClientCallbackInfo = AntiCheatCommonOnMessageToClientCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonOnClientActionRequiredCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var clientAction: EAntiCheatCommonClientAction
    get() = EAntiCheatCommonClientAction(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var actionReasonCode: EAntiCheatCommonClientActionReason
    get() = EAntiCheatCommonClientActionReason(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  context(arena: Arena)
  public var actionReasonDetailsString: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatCommonOnClientActionRequiredCallbackInfo =
        AntiCheatCommonOnClientActionRequiredCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonOnClientActionRequiredCallbackInfo {
      val struct = AntiCheatCommonOnClientActionRequiredCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonOnClientActionRequiredCallbackInfo(block: AntiCheatCommonOnClientActionRequiredCallbackInfo.() -> Unit = {}): AntiCheatCommonOnClientActionRequiredCallbackInfo = AntiCheatCommonOnClientActionRequiredCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(
  public val address: Long,
) {
  public var clientData: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var clientAuthStatus: EAntiCheatCommonClientAuthStatus
    get() = EAntiCheatCommonClientAuthStatus(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatCommonOnClientAuthStatusChangedCallbackInfo =
        AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonOnClientAuthStatusChangedCallbackInfo {
      val struct = AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonOnClientAuthStatusChangedCallbackInfo(block: AntiCheatCommonOnClientAuthStatusChangedCallbackInfo.() -> Unit = {}): AntiCheatCommonOnClientAuthStatusChangedCallbackInfo = AntiCheatCommonOnClientAuthStatusChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonSetClientDetailsOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var clientFlags: EAntiCheatCommonClientFlags
    get() = EAntiCheatCommonClientFlags(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var clientInputMethod: EAntiCheatCommonClientInput
    get() = EAntiCheatCommonClientInput(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatCommonSetClientDetailsOptions =
        AntiCheatCommonSetClientDetailsOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonSetClientDetailsOptions {
      val struct = AntiCheatCommonSetClientDetailsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonSetClientDetailsOptions(block: AntiCheatCommonSetClientDetailsOptions.() -> Unit = {}): AntiCheatCommonSetClientDetailsOptions = AntiCheatCommonSetClientDetailsOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonSetGameSessionIdOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var gameSessionId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatCommonSetGameSessionIdOptions =
        AntiCheatCommonSetGameSessionIdOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonSetGameSessionIdOptions {
      val struct = AntiCheatCommonSetGameSessionIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonSetGameSessionIdOptions(block: AntiCheatCommonSetGameSessionIdOptions.() -> Unit = {}): AntiCheatCommonSetGameSessionIdOptions = AntiCheatCommonSetGameSessionIdOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonRegisterEventParamDef(
  public val address: Long,
) {
  context(arena: Arena)
  public var paramName: String?
    get() = RawMemory.getLong(address).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var paramType: EAntiCheatCommonEventParamType
    get() = EAntiCheatCommonEventParamType(RawMemory.getInt(address + 8))
    set(`value`) {
      RawMemory.putInt(address + 8, value.value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatCommonRegisterEventParamDef = AntiCheatCommonRegisterEventParamDef(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonRegisterEventParamDef {
      val struct = AntiCheatCommonRegisterEventParamDef(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonRegisterEventParamDef(block: AntiCheatCommonRegisterEventParamDef.() -> Unit = {}): AntiCheatCommonRegisterEventParamDef = AntiCheatCommonRegisterEventParamDef.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonRegisterEventOptions(
  public val address: Long,
) {
  public var eventId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var eventName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var eventType: EAntiCheatCommonEventType
    get() = EAntiCheatCommonEventType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var paramDefsCount: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var paramDefs: AntiCheatCommonRegisterEventParamDef
    get() = AntiCheatCommonRegisterEventParamDef(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatCommonRegisterEventOptions = AntiCheatCommonRegisterEventOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonRegisterEventOptions {
      val struct = AntiCheatCommonRegisterEventOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonRegisterEventOptions(block: AntiCheatCommonRegisterEventOptions.() -> Unit = {}): AntiCheatCommonRegisterEventOptions = AntiCheatCommonRegisterEventOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogEventParamPair(
  public val address: Long,
) {
  public var paramValueType: EAntiCheatCommonEventParamType
    get() = EAntiCheatCommonEventParamType(RawMemory.getInt(address))
    set(`value`) {
      RawMemory.putInt(address, value.value)
    }

  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var string: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var uInt32: Int
    get() = RawMemory.getInt(address + 8)
    set(`value`) {
      RawMemory.putInt(address + 8, value)
    }

  public var int32: Int
    get() = RawMemory.getInt(address + 8)
    set(`value`) {
      RawMemory.putInt(address + 8, value)
    }

  public var uInt64: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var int64: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public val vec3f: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(address + 8)

  public val quat: AntiCheatCommonQuat
    get() = AntiCheatCommonQuat(address + 8)

  public var float: Float
    get() = RawMemory.getFloat(address + 8)
    set(`value`) {
      RawMemory.putFloat(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatCommonLogEventParamPair = AntiCheatCommonLogEventParamPair(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogEventParamPair {
      val struct = AntiCheatCommonLogEventParamPair(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogEventParamPair(block: AntiCheatCommonLogEventParamPair.() -> Unit = {}): AntiCheatCommonLogEventParamPair = AntiCheatCommonLogEventParamPair.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogEventOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var eventId: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var paramsCount: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var params: AntiCheatCommonLogEventParamPair
    get() = AntiCheatCommonLogEventParamPair(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatCommonLogEventOptions = AntiCheatCommonLogEventOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogEventOptions {
      val struct = AntiCheatCommonLogEventOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogEventOptions(block: AntiCheatCommonLogEventOptions.() -> Unit = {}): AntiCheatCommonLogEventOptions = AntiCheatCommonLogEventOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogGameRoundStartOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionIdentifier: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var levelName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var modeName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var roundTimeSeconds: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var competitionType: EAntiCheatCommonGameRoundCompetitionType
    get() = EAntiCheatCommonGameRoundCompetitionType(RawMemory.getInt(address + 36))
    set(`value`) {
      RawMemory.putInt(address + 36, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AntiCheatCommonLogGameRoundStartOptions =
        AntiCheatCommonLogGameRoundStartOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogGameRoundStartOptions {
      val struct = AntiCheatCommonLogGameRoundStartOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogGameRoundStartOptions(block: AntiCheatCommonLogGameRoundStartOptions.() -> Unit = {}): AntiCheatCommonLogGameRoundStartOptions = AntiCheatCommonLogGameRoundStartOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogGameRoundEndOptions(
  public val address: Long,
) {
  public var winningTeamId: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AntiCheatCommonLogGameRoundEndOptions =
        AntiCheatCommonLogGameRoundEndOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogGameRoundEndOptions {
      val struct = AntiCheatCommonLogGameRoundEndOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogGameRoundEndOptions(block: AntiCheatCommonLogGameRoundEndOptions.() -> Unit = {}): AntiCheatCommonLogGameRoundEndOptions = AntiCheatCommonLogGameRoundEndOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerSpawnOptions(
  public val address: Long,
) {
  public var spawnedPlayerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var teamId: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var characterId: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatCommonLogPlayerSpawnOptions = AntiCheatCommonLogPlayerSpawnOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerSpawnOptions {
      val struct = AntiCheatCommonLogPlayerSpawnOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerSpawnOptions(block: AntiCheatCommonLogPlayerSpawnOptions.() -> Unit = {}): AntiCheatCommonLogPlayerSpawnOptions = AntiCheatCommonLogPlayerSpawnOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerDespawnOptions(
  public val address: Long,
) {
  public var despawnedPlayerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatCommonLogPlayerDespawnOptions =
        AntiCheatCommonLogPlayerDespawnOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerDespawnOptions {
      val struct = AntiCheatCommonLogPlayerDespawnOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerDespawnOptions(block: AntiCheatCommonLogPlayerDespawnOptions.() -> Unit = {}): AntiCheatCommonLogPlayerDespawnOptions = AntiCheatCommonLogPlayerDespawnOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerReviveOptions(
  public val address: Long,
) {
  public var revivedPlayerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var reviverPlayerHandle: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatCommonLogPlayerReviveOptions =
        AntiCheatCommonLogPlayerReviveOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerReviveOptions {
      val struct = AntiCheatCommonLogPlayerReviveOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerReviveOptions(block: AntiCheatCommonLogPlayerReviveOptions.() -> Unit = {}): AntiCheatCommonLogPlayerReviveOptions = AntiCheatCommonLogPlayerReviveOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerTickOptions(
  public val address: Long,
) {
  public var playerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var playerPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public var playerViewRotation: AntiCheatCommonQuat
    get() = AntiCheatCommonQuat(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var isPlayerViewZoomed: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public var playerHealth: Float
    get() = RawMemory.getFloat(address + 36)
    set(`value`) {
      RawMemory.putFloat(address + 36, value)
    }

  public var playerMovementState: EAntiCheatCommonPlayerMovementState
    get() = EAntiCheatCommonPlayerMovementState(RawMemory.getInt(address + 40))
    set(`value`) {
      RawMemory.putInt(address + 40, value.value)
    }

  public var playerViewPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.address)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: AntiCheatCommonLogPlayerTickOptions = AntiCheatCommonLogPlayerTickOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerTickOptions {
      val struct = AntiCheatCommonLogPlayerTickOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerTickOptions(block: AntiCheatCommonLogPlayerTickOptions.() -> Unit = {}): AntiCheatCommonLogPlayerTickOptions = AntiCheatCommonLogPlayerTickOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerUseWeaponData(
  public val address: Long,
) {
  public var playerHandle: Long
    get() = RawMemory.getLong(address)
    set(`value`) {
      RawMemory.putLong(address, value)
    }

  public var playerPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var playerViewRotation: AntiCheatCommonQuat
    get() = AntiCheatCommonQuat(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public var isPlayerViewZoomed: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public var isMeleeAttack: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var weaponName: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AntiCheatCommonLogPlayerUseWeaponData =
        AntiCheatCommonLogPlayerUseWeaponData(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerUseWeaponData {
      val struct = AntiCheatCommonLogPlayerUseWeaponData(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerUseWeaponData(block: AntiCheatCommonLogPlayerUseWeaponData.() -> Unit = {}): AntiCheatCommonLogPlayerUseWeaponData = AntiCheatCommonLogPlayerUseWeaponData.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerUseWeaponOptions(
  public val address: Long,
) {
  public var useWeaponData: AntiCheatCommonLogPlayerUseWeaponData
    get() = AntiCheatCommonLogPlayerUseWeaponData(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatCommonLogPlayerUseWeaponOptions =
        AntiCheatCommonLogPlayerUseWeaponOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerUseWeaponOptions {
      val struct = AntiCheatCommonLogPlayerUseWeaponOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerUseWeaponOptions(block: AntiCheatCommonLogPlayerUseWeaponOptions.() -> Unit = {}): AntiCheatCommonLogPlayerUseWeaponOptions = AntiCheatCommonLogPlayerUseWeaponOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerUseAbilityOptions(
  public val address: Long,
) {
  public var playerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var abilityId: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var abilityDurationMs: Int
    get() = RawMemory.getInt(address + 20)
    set(`value`) {
      RawMemory.putInt(address + 20, value)
    }

  public var abilityCooldownMs: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatCommonLogPlayerUseAbilityOptions =
        AntiCheatCommonLogPlayerUseAbilityOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerUseAbilityOptions {
      val struct = AntiCheatCommonLogPlayerUseAbilityOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerUseAbilityOptions(block: AntiCheatCommonLogPlayerUseAbilityOptions.() -> Unit = {}): AntiCheatCommonLogPlayerUseAbilityOptions = AntiCheatCommonLogPlayerUseAbilityOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatCommonLogPlayerTakeDamageOptions(
  public val address: Long,
) {
  public var victimPlayerHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var victimPlayerPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.address)
    }

  public var victimPlayerViewRotation: AntiCheatCommonQuat
    get() = AntiCheatCommonQuat(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var attackerPlayerHandle: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var attackerPlayerPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.address)
    }

  public var attackerPlayerViewRotation: AntiCheatCommonQuat
    get() = AntiCheatCommonQuat(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.address)
    }

  public var isHitscanAttack: Boolean
    get() = RawMemory.getInt(address + 56) != 0
    set(`value`) {
      RawMemory.putInt(address + 56, if (value) 1 else 0)
    }

  public var hasLineOfSight: Boolean
    get() = RawMemory.getInt(address + 60) != 0
    set(`value`) {
      RawMemory.putInt(address + 60, if (value) 1 else 0)
    }

  public var isCriticalHit: Boolean
    get() = RawMemory.getInt(address + 64) != 0
    set(`value`) {
      RawMemory.putInt(address + 64, if (value) 1 else 0)
    }

  public var hitBoneId_DEPRECATED: Int
    get() = RawMemory.getInt(address + 68)
    set(`value`) {
      RawMemory.putInt(address + 68, value)
    }

  public var damageTaken: Float
    get() = RawMemory.getFloat(address + 72)
    set(`value`) {
      RawMemory.putFloat(address + 72, value)
    }

  public var healthRemaining: Float
    get() = RawMemory.getFloat(address + 76)
    set(`value`) {
      RawMemory.putFloat(address + 76, value)
    }

  public var damageSource: EAntiCheatCommonPlayerTakeDamageSource
    get() = EAntiCheatCommonPlayerTakeDamageSource(RawMemory.getInt(address + 80))
    set(`value`) {
      RawMemory.putInt(address + 80, value.value)
    }

  public var damageType: EAntiCheatCommonPlayerTakeDamageType
    get() = EAntiCheatCommonPlayerTakeDamageType(RawMemory.getInt(address + 84))
    set(`value`) {
      RawMemory.putInt(address + 84, value.value)
    }

  public var damageResult: EAntiCheatCommonPlayerTakeDamageResult
    get() = EAntiCheatCommonPlayerTakeDamageResult(RawMemory.getInt(address + 88))
    set(`value`) {
      RawMemory.putInt(address + 88, value.value)
    }

  public var playerUseWeaponData: AntiCheatCommonLogPlayerUseWeaponData
    get() = AntiCheatCommonLogPlayerUseWeaponData(RawMemory.getLong(address + 96))
    set(`value`) {
      RawMemory.putLong(address + 96, value.address)
    }

  public var timeSincePlayerUseWeaponMs: Int
    get() = RawMemory.getInt(address + 104)
    set(`value`) {
      RawMemory.putInt(address + 104, value)
    }

  public var damagePosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 112))
    set(`value`) {
      RawMemory.putLong(address + 112, value.address)
    }

  public var attackerPlayerViewPosition: AntiCheatCommonVec3f
    get() = AntiCheatCommonVec3f(RawMemory.getLong(address + 120))
    set(`value`) {
      RawMemory.putLong(address + 120, value.address)
    }

  public companion object {
    public const val SIZE: Long = 128

    public val NULL: AntiCheatCommonLogPlayerTakeDamageOptions =
        AntiCheatCommonLogPlayerTakeDamageOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatCommonLogPlayerTakeDamageOptions {
      val struct = AntiCheatCommonLogPlayerTakeDamageOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 4)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatCommonLogPlayerTakeDamageOptions(block: AntiCheatCommonLogPlayerTakeDamageOptions.() -> Unit = {}): AntiCheatCommonLogPlayerTakeDamageOptions = AntiCheatCommonLogPlayerTakeDamageOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerAddNotifyMessageToClientOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatServerAddNotifyMessageToClientOptions =
        AntiCheatServerAddNotifyMessageToClientOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerAddNotifyMessageToClientOptions {
      val struct = AntiCheatServerAddNotifyMessageToClientOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerAddNotifyMessageToClientOptions(block: AntiCheatServerAddNotifyMessageToClientOptions.() -> Unit = {}): AntiCheatServerAddNotifyMessageToClientOptions = AntiCheatServerAddNotifyMessageToClientOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerAddNotifyClientActionRequiredOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatServerAddNotifyClientActionRequiredOptions =
        AntiCheatServerAddNotifyClientActionRequiredOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerAddNotifyClientActionRequiredOptions {
      val struct = AntiCheatServerAddNotifyClientActionRequiredOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerAddNotifyClientActionRequiredOptions(block: AntiCheatServerAddNotifyClientActionRequiredOptions.() -> Unit = {}): AntiCheatServerAddNotifyClientActionRequiredOptions = AntiCheatServerAddNotifyClientActionRequiredOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerAddNotifyClientAuthStatusChangedOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatServerAddNotifyClientAuthStatusChangedOptions =
        AntiCheatServerAddNotifyClientAuthStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerAddNotifyClientAuthStatusChangedOptions {
      val struct = AntiCheatServerAddNotifyClientAuthStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerAddNotifyClientAuthStatusChangedOptions(block: AntiCheatServerAddNotifyClientAuthStatusChangedOptions.() -> Unit = {}): AntiCheatServerAddNotifyClientAuthStatusChangedOptions = AntiCheatServerAddNotifyClientAuthStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerBeginSessionOptions(
  public val address: Long,
) {
  public var registerTimeoutSeconds: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  context(arena: Arena)
  public var serverName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var enableGameplayData: Boolean
    get() = RawMemory.getInt(address + 16) != 0
    set(`value`) {
      RawMemory.putInt(address + 16, if (value) 1 else 0)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatServerBeginSessionOptions = AntiCheatServerBeginSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerBeginSessionOptions {
      val struct = AntiCheatServerBeginSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerBeginSessionOptions(block: AntiCheatServerBeginSessionOptions.() -> Unit = {}): AntiCheatServerBeginSessionOptions = AntiCheatServerBeginSessionOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerEndSessionOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AntiCheatServerEndSessionOptions = AntiCheatServerEndSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerEndSessionOptions {
      val struct = AntiCheatServerEndSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerEndSessionOptions(block: AntiCheatServerEndSessionOptions.() -> Unit = {}): AntiCheatServerEndSessionOptions = AntiCheatServerEndSessionOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerRegisterClientOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var clientType: EAntiCheatCommonClientType
    get() = EAntiCheatCommonClientType(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var clientPlatform: EAntiCheatCommonClientPlatform
    get() = EAntiCheatCommonClientPlatform(RawMemory.getInt(address + 20))
    set(`value`) {
      RawMemory.putInt(address + 20, value.value)
    }

  context(arena: Arena)
  public var accountId_DEPRECATED: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var ipAddress: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var userId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.raw)
    }

  public var reserved01: Int
    get() = RawMemory.getInt(address + 48)
    set(`value`) {
      RawMemory.putInt(address + 48, value)
    }

  public var reserved02: Int
    get() = RawMemory.getInt(address + 52)
    set(`value`) {
      RawMemory.putInt(address + 52, value)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: AntiCheatServerRegisterClientOptions = AntiCheatServerRegisterClientOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerRegisterClientOptions {
      val struct = AntiCheatServerRegisterClientOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 4)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerRegisterClientOptions(block: AntiCheatServerRegisterClientOptions.() -> Unit = {}): AntiCheatServerRegisterClientOptions = AntiCheatServerRegisterClientOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerUnregisterClientOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AntiCheatServerUnregisterClientOptions =
        AntiCheatServerUnregisterClientOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerUnregisterClientOptions {
      val struct = AntiCheatServerUnregisterClientOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerUnregisterClientOptions(block: AntiCheatServerUnregisterClientOptions.() -> Unit = {}): AntiCheatServerUnregisterClientOptions = AntiCheatServerUnregisterClientOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerReceiveMessageFromClientOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AntiCheatServerReceiveMessageFromClientOptions =
        AntiCheatServerReceiveMessageFromClientOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerReceiveMessageFromClientOptions {
      val struct = AntiCheatServerReceiveMessageFromClientOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerReceiveMessageFromClientOptions(block: AntiCheatServerReceiveMessageFromClientOptions.() -> Unit = {}): AntiCheatServerReceiveMessageFromClientOptions = AntiCheatServerReceiveMessageFromClientOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerSetClientNetworkStateOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var isNetworkActive: Boolean
    get() = RawMemory.getInt(address + 16) != 0
    set(`value`) {
      RawMemory.putInt(address + 16, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AntiCheatServerSetClientNetworkStateOptions =
        AntiCheatServerSetClientNetworkStateOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerSetClientNetworkStateOptions {
      val struct = AntiCheatServerSetClientNetworkStateOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerSetClientNetworkStateOptions(block: AntiCheatServerSetClientNetworkStateOptions.() -> Unit = {}): AntiCheatServerSetClientNetworkStateOptions = AntiCheatServerSetClientNetworkStateOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerGetProtectMessageOutputLengthOptions(
  public val address: Long,
) {
  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: AntiCheatServerGetProtectMessageOutputLengthOptions =
        AntiCheatServerGetProtectMessageOutputLengthOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerGetProtectMessageOutputLengthOptions {
      val struct = AntiCheatServerGetProtectMessageOutputLengthOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerGetProtectMessageOutputLengthOptions(block: AntiCheatServerGetProtectMessageOutputLengthOptions.() -> Unit = {}): AntiCheatServerGetProtectMessageOutputLengthOptions = AntiCheatServerGetProtectMessageOutputLengthOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerProtectMessageOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var outBufferSizeBytes: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AntiCheatServerProtectMessageOptions = AntiCheatServerProtectMessageOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerProtectMessageOptions {
      val struct = AntiCheatServerProtectMessageOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerProtectMessageOptions(block: AntiCheatServerProtectMessageOptions.() -> Unit = {}): AntiCheatServerProtectMessageOptions = AntiCheatServerProtectMessageOptions.allocate().apply(block)

@JvmInline
public value class AntiCheatServerUnprotectMessageOptions(
  public val address: Long,
) {
  public var clientHandle: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public var outBufferSizeBytes: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AntiCheatServerUnprotectMessageOptions =
        AntiCheatServerUnprotectMessageOptions(0)

    context(arena: Arena)
    public fun allocate(): AntiCheatServerUnprotectMessageOptions {
      val struct = AntiCheatServerUnprotectMessageOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AntiCheatServerUnprotectMessageOptions(block: AntiCheatServerUnprotectMessageOptions.() -> Unit = {}): AntiCheatServerUnprotectMessageOptions = AntiCheatServerUnprotectMessageOptions.allocate().apply(block)

@JvmInline
public value class AuthToken(
  public val address: Long,
) {
  context(arena: Arena)
  public var app: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var clientId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var accountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  context(arena: Arena)
  public var accessToken: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var expiresIn: Double
    get() = RawMemory.getDouble(address + 40)
    set(`value`) {
      RawMemory.putDouble(address + 40, value)
    }

  context(arena: Arena)
  public var expiresAt: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var authType: EAuthTokenType
    get() = EAuthTokenType(RawMemory.getInt(address + 56))
    set(`value`) {
      RawMemory.putInt(address + 56, value.value)
    }

  context(arena: Arena)
  public var refreshToken: String?
    get() = RawMemory.getLong(address + 64).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 64, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var refreshExpiresIn: Double
    get() = RawMemory.getDouble(address + 72)
    set(`value`) {
      RawMemory.putDouble(address + 72, value)
    }

  context(arena: Arena)
  public var refreshExpiresAt: String?
    get() = RawMemory.getLong(address + 80).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 80, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 88

    public val NULL: AuthToken = AuthToken(0)

    context(arena: Arena)
    public fun allocate(): AuthToken {
      val struct = AuthToken(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthToken(block: AuthToken.() -> Unit = {}): AuthToken = AuthToken.allocate().apply(block)

@JvmInline
public value class AuthCredentials(
  public val address: Long,
) {
  context(arena: Arena)
  public var id: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var token: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var type: ELoginCredentialType
    get() = ELoginCredentialType(RawMemory.getInt(address + 24))
    set(`value`) {
      RawMemory.putInt(address + 24, value.value)
    }

  public var systemAuthCredentialsOptions: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var externalType: EExternalCredentialType
    get() = EExternalCredentialType(RawMemory.getInt(address + 40))
    set(`value`) {
      RawMemory.putInt(address + 40, value.value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: AuthCredentials = AuthCredentials(0)

    context(arena: Arena)
    public fun allocate(): AuthCredentials {
      val struct = AuthCredentials(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 4)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthCredentials(block: AuthCredentials.() -> Unit = {}): AuthCredentials = AuthCredentials.allocate().apply(block)

@JvmInline
public value class AuthPinGrantInfo(
  public val address: Long,
) {
  context(arena: Arena)
  public var userCode: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var verificationURI: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var expiresIn: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  context(arena: Arena)
  public var verificationURIComplete: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AuthPinGrantInfo = AuthPinGrantInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthPinGrantInfo {
      val struct = AuthPinGrantInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthPinGrantInfo(block: AuthPinGrantInfo.() -> Unit = {}): AuthPinGrantInfo = AuthPinGrantInfo.allocate().apply(block)

@JvmInline
public value class AuthLoginOptions(
  public val address: Long,
) {
  public var credentials: AuthCredentials
    get() = AuthCredentials(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public var scopeFlags: EAuthScopeFlags
    get() = EAuthScopeFlags(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  public var loginFlags: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AuthLoginOptions = AuthLoginOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthLoginOptions {
      val struct = AuthLoginOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLoginOptions(block: AuthLoginOptions.() -> Unit = {}): AuthLoginOptions = AuthLoginOptions.allocate().apply(block)

@JvmInline
public value class AuthLoginCallbackInfo(
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

  public var pinGrantInfo: AuthPinGrantInfo
    get() = AuthPinGrantInfo(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var continuanceToken: ContinuanceToken
    get() = ContinuanceToken(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public var accountFeatureRestrictedInfo_DEPRECATED: AuthAccountFeatureRestrictedInfo
    get() = AuthAccountFeatureRestrictedInfo(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.address)
    }

  public var selectedAccountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 48))
    set(`value`) {
      RawMemory.putLong(address + 48, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: AuthLoginCallbackInfo = AuthLoginCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthLoginCallbackInfo {
      val struct = AuthLoginCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLoginCallbackInfo(block: AuthLoginCallbackInfo.() -> Unit = {}): AuthLoginCallbackInfo = AuthLoginCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthLogoutOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthLogoutOptions = AuthLogoutOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthLogoutOptions {
      val struct = AuthLogoutOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLogoutOptions(block: AuthLogoutOptions.() -> Unit = {}): AuthLogoutOptions = AuthLogoutOptions.allocate().apply(block)

@JvmInline
public value class AuthLogoutCallbackInfo(
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

    public val NULL: AuthLogoutCallbackInfo = AuthLogoutCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthLogoutCallbackInfo {
      val struct = AuthLogoutCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLogoutCallbackInfo(block: AuthLogoutCallbackInfo.() -> Unit = {}): AuthLogoutCallbackInfo = AuthLogoutCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthLinkAccountOptions(
  public val address: Long,
) {
  public var linkAccountFlags: ELinkAccountFlags
    get() = ELinkAccountFlags(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public var continuanceToken: ContinuanceToken
    get() = ContinuanceToken(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AuthLinkAccountOptions = AuthLinkAccountOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthLinkAccountOptions {
      val struct = AuthLinkAccountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLinkAccountOptions(block: AuthLinkAccountOptions.() -> Unit = {}): AuthLinkAccountOptions = AuthLinkAccountOptions.allocate().apply(block)

@JvmInline
public value class AuthLinkAccountCallbackInfo(
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

  public var pinGrantInfo: AuthPinGrantInfo
    get() = AuthPinGrantInfo(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.address)
    }

  public var selectedAccountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: AuthLinkAccountCallbackInfo = AuthLinkAccountCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthLinkAccountCallbackInfo {
      val struct = AuthLinkAccountCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthLinkAccountCallbackInfo(block: AuthLinkAccountCallbackInfo.() -> Unit = {}): AuthLinkAccountCallbackInfo = AuthLinkAccountCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthVerifyUserAuthOptions(
  public val address: Long,
) {
  public var authToken: AuthToken
    get() = AuthToken(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthVerifyUserAuthOptions = AuthVerifyUserAuthOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthVerifyUserAuthOptions {
      val struct = AuthVerifyUserAuthOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthVerifyUserAuthOptions(block: AuthVerifyUserAuthOptions.() -> Unit = {}): AuthVerifyUserAuthOptions = AuthVerifyUserAuthOptions.allocate().apply(block)

@JvmInline
public value class AuthVerifyUserAuthCallbackInfo(
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

    public val NULL: AuthVerifyUserAuthCallbackInfo = AuthVerifyUserAuthCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthVerifyUserAuthCallbackInfo {
      val struct = AuthVerifyUserAuthCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthVerifyUserAuthCallbackInfo(block: AuthVerifyUserAuthCallbackInfo.() -> Unit = {}): AuthVerifyUserAuthCallbackInfo = AuthVerifyUserAuthCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthCopyUserAuthTokenOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: AuthCopyUserAuthTokenOptions = AuthCopyUserAuthTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthCopyUserAuthTokenOptions {
      val struct = AuthCopyUserAuthTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthCopyUserAuthTokenOptions(block: AuthCopyUserAuthTokenOptions.() -> Unit = {}): AuthCopyUserAuthTokenOptions = AuthCopyUserAuthTokenOptions.allocate().apply(block)

@JvmInline
public value class AuthCopyIdTokenOptions(
  public val address: Long,
) {
  public var accountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthCopyIdTokenOptions = AuthCopyIdTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthCopyIdTokenOptions {
      val struct = AuthCopyIdTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthCopyIdTokenOptions(block: AuthCopyIdTokenOptions.() -> Unit = {}): AuthCopyIdTokenOptions = AuthCopyIdTokenOptions.allocate().apply(block)

@JvmInline
public value class AuthIdToken(
  public val address: Long,
) {
  public var accountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
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

    public val NULL: AuthIdToken = AuthIdToken(0)

    context(arena: Arena)
    public fun allocate(): AuthIdToken {
      val struct = AuthIdToken(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthIdToken(block: AuthIdToken.() -> Unit = {}): AuthIdToken = AuthIdToken.allocate().apply(block)

@JvmInline
public value class AuthQueryIdTokenOptions(
  public val address: Long,
) {
  public var localUserId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var targetAccountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: AuthQueryIdTokenOptions = AuthQueryIdTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthQueryIdTokenOptions {
      val struct = AuthQueryIdTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthQueryIdTokenOptions(block: AuthQueryIdTokenOptions.() -> Unit = {}): AuthQueryIdTokenOptions = AuthQueryIdTokenOptions.allocate().apply(block)

@JvmInline
public value class AuthQueryIdTokenCallbackInfo(
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

  public var targetAccountId: EpicAccountId
    get() = EpicAccountId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: AuthQueryIdTokenCallbackInfo = AuthQueryIdTokenCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthQueryIdTokenCallbackInfo {
      val struct = AuthQueryIdTokenCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthQueryIdTokenCallbackInfo(block: AuthQueryIdTokenCallbackInfo.() -> Unit = {}): AuthQueryIdTokenCallbackInfo = AuthQueryIdTokenCallbackInfo.allocate().apply(block)

@JvmInline
public value class AuthVerifyIdTokenOptions(
  public val address: Long,
) {
  public var idToken: AuthIdToken
    get() = AuthIdToken(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.address)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: AuthVerifyIdTokenOptions = AuthVerifyIdTokenOptions(0)

    context(arena: Arena)
    public fun allocate(): AuthVerifyIdTokenOptions {
      val struct = AuthVerifyIdTokenOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthVerifyIdTokenOptions(block: AuthVerifyIdTokenOptions.() -> Unit = {}): AuthVerifyIdTokenOptions = AuthVerifyIdTokenOptions.allocate().apply(block)

@JvmInline
public value class AuthVerifyIdTokenCallbackInfo(
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
  public var applicationId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var clientId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var productId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var sandboxId: String?
    get() = RawMemory.getLong(address + 40).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 40, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deploymentId: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var displayName: String?
    get() = RawMemory.getLong(address + 56).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 56, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var isExternalAccountInfoPresent: Boolean
    get() = RawMemory.getInt(address + 64) != 0
    set(`value`) {
      RawMemory.putInt(address + 64, if (value) 1 else 0)
    }

  public var externalAccountIdType: EExternalAccountType
    get() = EExternalAccountType(RawMemory.getInt(address + 68))
    set(`value`) {
      RawMemory.putInt(address + 68, value.value)
    }

  context(arena: Arena)
  public var externalAccountId: String?
    get() = RawMemory.getLong(address + 72).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 72, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var externalAccountDisplayName: String?
    get() = RawMemory.getLong(address + 80).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 80, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var platform: String?
    get() = RawMemory.getLong(address + 88).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 88, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 96

    public val NULL: AuthVerifyIdTokenCallbackInfo = AuthVerifyIdTokenCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): AuthVerifyIdTokenCallbackInfo {
      val struct = AuthVerifyIdTokenCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun AuthVerifyIdTokenCallbackInfo(block: AuthVerifyIdTokenCallbackInfo.() -> Unit = {}): AuthVerifyIdTokenCallbackInfo = AuthVerifyIdTokenCallbackInfo.allocate().apply(block)
