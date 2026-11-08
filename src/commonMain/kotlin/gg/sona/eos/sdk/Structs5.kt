@file:Suppress("unused", "FunctionName", "PropertyName")

package gg.sona.eos.sdk

import gg.sona.eos.EosResult
import gg.sona.eos.`internal`.RawMemory
import gg.sona.eos.`internal`.foreign.Arena
import gg.sona.eos.`internal`.foreign.MemorySegment
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
public value class RTCAudioUpdateSendingVolumeCallbackInfo(
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

  public var volume: Float
    get() = RawMemory.getFloat(address + 32)
    set(`value`) {
      RawMemory.putFloat(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioUpdateSendingVolumeCallbackInfo =
        RTCAudioUpdateSendingVolumeCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateSendingVolumeCallbackInfo {
      val struct = RTCAudioUpdateSendingVolumeCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateSendingVolumeCallbackInfo(block: RTCAudioUpdateSendingVolumeCallbackInfo.() -> Unit = {}): RTCAudioUpdateSendingVolumeCallbackInfo = RTCAudioUpdateSendingVolumeCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateReceivingVolumeOptions(
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

    public val NULL: RTCAudioUpdateReceivingVolumeOptions = RTCAudioUpdateReceivingVolumeOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateReceivingVolumeOptions {
      val struct = RTCAudioUpdateReceivingVolumeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateReceivingVolumeOptions(block: RTCAudioUpdateReceivingVolumeOptions.() -> Unit = {}): RTCAudioUpdateReceivingVolumeOptions = RTCAudioUpdateReceivingVolumeOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateReceivingVolumeCallbackInfo(
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

  public var volume: Float
    get() = RawMemory.getFloat(address + 32)
    set(`value`) {
      RawMemory.putFloat(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioUpdateReceivingVolumeCallbackInfo =
        RTCAudioUpdateReceivingVolumeCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateReceivingVolumeCallbackInfo {
      val struct = RTCAudioUpdateReceivingVolumeCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateReceivingVolumeCallbackInfo(block: RTCAudioUpdateReceivingVolumeCallbackInfo.() -> Unit = {}): RTCAudioUpdateReceivingVolumeCallbackInfo = RTCAudioUpdateReceivingVolumeCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateParticipantVolumeOptions(
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

  public var volume: Float
    get() = RawMemory.getFloat(address + 32)
    set(`value`) {
      RawMemory.putFloat(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCAudioUpdateParticipantVolumeOptions =
        RTCAudioUpdateParticipantVolumeOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateParticipantVolumeOptions {
      val struct = RTCAudioUpdateParticipantVolumeOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateParticipantVolumeOptions(block: RTCAudioUpdateParticipantVolumeOptions.() -> Unit = {}): RTCAudioUpdateParticipantVolumeOptions = RTCAudioUpdateParticipantVolumeOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUpdateParticipantVolumeCallbackInfo(
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

  public var volume: Float
    get() = RawMemory.getFloat(address + 40)
    set(`value`) {
      RawMemory.putFloat(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCAudioUpdateParticipantVolumeCallbackInfo =
        RTCAudioUpdateParticipantVolumeCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUpdateParticipantVolumeCallbackInfo {
      val struct = RTCAudioUpdateParticipantVolumeCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUpdateParticipantVolumeCallbackInfo(block: RTCAudioUpdateParticipantVolumeCallbackInfo.() -> Unit = {}): RTCAudioUpdateParticipantVolumeCallbackInfo = RTCAudioUpdateParticipantVolumeCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioRegisterPlatformUserOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var platformUserId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: RTCAudioRegisterPlatformUserOptions = RTCAudioRegisterPlatformUserOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioRegisterPlatformUserOptions {
      val struct = RTCAudioRegisterPlatformUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioRegisterPlatformUserOptions(block: RTCAudioRegisterPlatformUserOptions.() -> Unit = {}): RTCAudioRegisterPlatformUserOptions = RTCAudioRegisterPlatformUserOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnRegisterPlatformUserCallbackInfo(
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
  public var platformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioOnRegisterPlatformUserCallbackInfo =
        RTCAudioOnRegisterPlatformUserCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnRegisterPlatformUserCallbackInfo {
      val struct = RTCAudioOnRegisterPlatformUserCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnRegisterPlatformUserCallbackInfo(block: RTCAudioOnRegisterPlatformUserCallbackInfo.() -> Unit = {}): RTCAudioOnRegisterPlatformUserCallbackInfo = RTCAudioOnRegisterPlatformUserCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioUnregisterPlatformUserOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var platformUserId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: RTCAudioUnregisterPlatformUserOptions =
        RTCAudioUnregisterPlatformUserOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUnregisterPlatformUserOptions {
      val struct = RTCAudioUnregisterPlatformUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUnregisterPlatformUserOptions(block: RTCAudioUnregisterPlatformUserOptions.() -> Unit = {}): RTCAudioUnregisterPlatformUserOptions = RTCAudioUnregisterPlatformUserOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnUnregisterPlatformUserCallbackInfo(
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
  public var platformUserId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioOnUnregisterPlatformUserCallbackInfo =
        RTCAudioOnUnregisterPlatformUserCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnUnregisterPlatformUserCallbackInfo {
      val struct = RTCAudioOnUnregisterPlatformUserCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnUnregisterPlatformUserCallbackInfo(block: RTCAudioOnUnregisterPlatformUserCallbackInfo.() -> Unit = {}): RTCAudioOnUnregisterPlatformUserCallbackInfo = RTCAudioOnUnregisterPlatformUserCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioQueryInputDevicesInformationOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioQueryInputDevicesInformationOptions =
        RTCAudioQueryInputDevicesInformationOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioQueryInputDevicesInformationOptions {
      val struct = RTCAudioQueryInputDevicesInformationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioQueryInputDevicesInformationOptions(block: RTCAudioQueryInputDevicesInformationOptions.() -> Unit = {}): RTCAudioQueryInputDevicesInformationOptions = RTCAudioQueryInputDevicesInformationOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnQueryInputDevicesInformationCallbackInfo(
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

    public val NULL: RTCAudioOnQueryInputDevicesInformationCallbackInfo =
        RTCAudioOnQueryInputDevicesInformationCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnQueryInputDevicesInformationCallbackInfo {
      val struct = RTCAudioOnQueryInputDevicesInformationCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnQueryInputDevicesInformationCallbackInfo(block: RTCAudioOnQueryInputDevicesInformationCallbackInfo.() -> Unit = {}): RTCAudioOnQueryInputDevicesInformationCallbackInfo = RTCAudioOnQueryInputDevicesInformationCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioGetInputDevicesCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioGetInputDevicesCountOptions = RTCAudioGetInputDevicesCountOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetInputDevicesCountOptions {
      val struct = RTCAudioGetInputDevicesCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetInputDevicesCountOptions(block: RTCAudioGetInputDevicesCountOptions.() -> Unit = {}): RTCAudioGetInputDevicesCountOptions = RTCAudioGetInputDevicesCountOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioCopyInputDeviceInformationByIndexOptions(
  public val address: Long,
) {
  public var deviceIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: RTCAudioCopyInputDeviceInformationByIndexOptions =
        RTCAudioCopyInputDeviceInformationByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioCopyInputDeviceInformationByIndexOptions {
      val struct = RTCAudioCopyInputDeviceInformationByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioCopyInputDeviceInformationByIndexOptions(block: RTCAudioCopyInputDeviceInformationByIndexOptions.() -> Unit = {}): RTCAudioCopyInputDeviceInformationByIndexOptions = RTCAudioCopyInputDeviceInformationByIndexOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioInputDeviceInformation(
  public val address: Long,
) {
  public var defaultDevice: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var deviceId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deviceName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioInputDeviceInformation = RTCAudioInputDeviceInformation(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioInputDeviceInformation {
      val struct = RTCAudioInputDeviceInformation(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioInputDeviceInformation(block: RTCAudioInputDeviceInformation.() -> Unit = {}): RTCAudioInputDeviceInformation = RTCAudioInputDeviceInformation.allocate().apply(block)

@JvmInline
public value class RTCAudioQueryOutputDevicesInformationOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioQueryOutputDevicesInformationOptions =
        RTCAudioQueryOutputDevicesInformationOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioQueryOutputDevicesInformationOptions {
      val struct = RTCAudioQueryOutputDevicesInformationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioQueryOutputDevicesInformationOptions(block: RTCAudioQueryOutputDevicesInformationOptions.() -> Unit = {}): RTCAudioQueryOutputDevicesInformationOptions = RTCAudioQueryOutputDevicesInformationOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnQueryOutputDevicesInformationCallbackInfo(
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

    public val NULL: RTCAudioOnQueryOutputDevicesInformationCallbackInfo =
        RTCAudioOnQueryOutputDevicesInformationCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnQueryOutputDevicesInformationCallbackInfo {
      val struct = RTCAudioOnQueryOutputDevicesInformationCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnQueryOutputDevicesInformationCallbackInfo(block: RTCAudioOnQueryOutputDevicesInformationCallbackInfo.() -> Unit = {}): RTCAudioOnQueryOutputDevicesInformationCallbackInfo = RTCAudioOnQueryOutputDevicesInformationCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioGetOutputDevicesCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioGetOutputDevicesCountOptions = RTCAudioGetOutputDevicesCountOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetOutputDevicesCountOptions {
      val struct = RTCAudioGetOutputDevicesCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetOutputDevicesCountOptions(block: RTCAudioGetOutputDevicesCountOptions.() -> Unit = {}): RTCAudioGetOutputDevicesCountOptions = RTCAudioGetOutputDevicesCountOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioCopyOutputDeviceInformationByIndexOptions(
  public val address: Long,
) {
  public var deviceIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: RTCAudioCopyOutputDeviceInformationByIndexOptions =
        RTCAudioCopyOutputDeviceInformationByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioCopyOutputDeviceInformationByIndexOptions {
      val struct = RTCAudioCopyOutputDeviceInformationByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioCopyOutputDeviceInformationByIndexOptions(block: RTCAudioCopyOutputDeviceInformationByIndexOptions.() -> Unit = {}): RTCAudioCopyOutputDeviceInformationByIndexOptions = RTCAudioCopyOutputDeviceInformationByIndexOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOutputDeviceInformation(
  public val address: Long,
) {
  public var defaultDevice: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var deviceId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deviceName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioOutputDeviceInformation = RTCAudioOutputDeviceInformation(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOutputDeviceInformation {
      val struct = RTCAudioOutputDeviceInformation(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOutputDeviceInformation(block: RTCAudioOutputDeviceInformation.() -> Unit = {}): RTCAudioOutputDeviceInformation = RTCAudioOutputDeviceInformation.allocate().apply(block)

@JvmInline
public value class RTCAudioSetInputDeviceSettingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var realDeviceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var platformAEC: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioSetInputDeviceSettingsOptions =
        RTCAudioSetInputDeviceSettingsOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioSetInputDeviceSettingsOptions {
      val struct = RTCAudioSetInputDeviceSettingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioSetInputDeviceSettingsOptions(block: RTCAudioSetInputDeviceSettingsOptions.() -> Unit = {}): RTCAudioSetInputDeviceSettingsOptions = RTCAudioSetInputDeviceSettingsOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnSetInputDeviceSettingsCallbackInfo(
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
  public var realDeviceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioOnSetInputDeviceSettingsCallbackInfo =
        RTCAudioOnSetInputDeviceSettingsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnSetInputDeviceSettingsCallbackInfo {
      val struct = RTCAudioOnSetInputDeviceSettingsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnSetInputDeviceSettingsCallbackInfo(block: RTCAudioOnSetInputDeviceSettingsCallbackInfo.() -> Unit = {}): RTCAudioOnSetInputDeviceSettingsCallbackInfo = RTCAudioOnSetInputDeviceSettingsCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioSetOutputDeviceSettingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var realDeviceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioSetOutputDeviceSettingsOptions =
        RTCAudioSetOutputDeviceSettingsOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioSetOutputDeviceSettingsOptions {
      val struct = RTCAudioSetOutputDeviceSettingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioSetOutputDeviceSettingsOptions(block: RTCAudioSetOutputDeviceSettingsOptions.() -> Unit = {}): RTCAudioSetOutputDeviceSettingsOptions = RTCAudioSetOutputDeviceSettingsOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioOnSetOutputDeviceSettingsCallbackInfo(
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
  public var realDeviceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioOnSetOutputDeviceSettingsCallbackInfo =
        RTCAudioOnSetOutputDeviceSettingsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioOnSetOutputDeviceSettingsCallbackInfo {
      val struct = RTCAudioOnSetOutputDeviceSettingsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioOnSetOutputDeviceSettingsCallbackInfo(block: RTCAudioOnSetOutputDeviceSettingsCallbackInfo.() -> Unit = {}): RTCAudioOnSetOutputDeviceSettingsCallbackInfo = RTCAudioOnSetOutputDeviceSettingsCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioRegisterPlatformAudioUserOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var userId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: RTCAudioRegisterPlatformAudioUserOptions =
        RTCAudioRegisterPlatformAudioUserOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioRegisterPlatformAudioUserOptions {
      val struct = RTCAudioRegisterPlatformAudioUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioRegisterPlatformAudioUserOptions(block: RTCAudioRegisterPlatformAudioUserOptions.() -> Unit = {}): RTCAudioRegisterPlatformAudioUserOptions = RTCAudioRegisterPlatformAudioUserOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioUnregisterPlatformAudioUserOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var userId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: RTCAudioUnregisterPlatformAudioUserOptions =
        RTCAudioUnregisterPlatformAudioUserOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioUnregisterPlatformAudioUserOptions {
      val struct = RTCAudioUnregisterPlatformAudioUserOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioUnregisterPlatformAudioUserOptions(block: RTCAudioUnregisterPlatformAudioUserOptions.() -> Unit = {}): RTCAudioUnregisterPlatformAudioUserOptions = RTCAudioUnregisterPlatformAudioUserOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioGetAudioInputDevicesCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioGetAudioInputDevicesCountOptions =
        RTCAudioGetAudioInputDevicesCountOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetAudioInputDevicesCountOptions {
      val struct = RTCAudioGetAudioInputDevicesCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetAudioInputDevicesCountOptions(block: RTCAudioGetAudioInputDevicesCountOptions.() -> Unit = {}): RTCAudioGetAudioInputDevicesCountOptions = RTCAudioGetAudioInputDevicesCountOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioGetAudioInputDeviceByIndexOptions(
  public val address: Long,
) {
  public var deviceInfoIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: RTCAudioGetAudioInputDeviceByIndexOptions =
        RTCAudioGetAudioInputDeviceByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetAudioInputDeviceByIndexOptions {
      val struct = RTCAudioGetAudioInputDeviceByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetAudioInputDeviceByIndexOptions(block: RTCAudioGetAudioInputDeviceByIndexOptions.() -> Unit = {}): RTCAudioGetAudioInputDeviceByIndexOptions = RTCAudioGetAudioInputDeviceByIndexOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioInputDeviceInfo(
  public val address: Long,
) {
  public var defaultDevice: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var deviceId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deviceName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAudioInputDeviceInfo = RTCAudioAudioInputDeviceInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioInputDeviceInfo {
      val struct = RTCAudioAudioInputDeviceInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioInputDeviceInfo(block: RTCAudioAudioInputDeviceInfo.() -> Unit = {}): RTCAudioAudioInputDeviceInfo = RTCAudioAudioInputDeviceInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioGetAudioOutputDevicesCountOptions(
  public val address: Long,
) {
  public companion object {
    public const val SIZE: Long = 4

    public val NULL: RTCAudioGetAudioOutputDevicesCountOptions =
        RTCAudioGetAudioOutputDevicesCountOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetAudioOutputDevicesCountOptions {
      val struct = RTCAudioGetAudioOutputDevicesCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetAudioOutputDevicesCountOptions(block: RTCAudioGetAudioOutputDevicesCountOptions.() -> Unit = {}): RTCAudioGetAudioOutputDevicesCountOptions = RTCAudioGetAudioOutputDevicesCountOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioGetAudioOutputDeviceByIndexOptions(
  public val address: Long,
) {
  public var deviceInfoIndex: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: RTCAudioGetAudioOutputDeviceByIndexOptions =
        RTCAudioGetAudioOutputDeviceByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioGetAudioOutputDeviceByIndexOptions {
      val struct = RTCAudioGetAudioOutputDeviceByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioGetAudioOutputDeviceByIndexOptions(block: RTCAudioGetAudioOutputDeviceByIndexOptions.() -> Unit = {}): RTCAudioGetAudioOutputDeviceByIndexOptions = RTCAudioGetAudioOutputDeviceByIndexOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioAudioOutputDeviceInfo(
  public val address: Long,
) {
  public var defaultDevice: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var deviceId: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var deviceName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCAudioAudioOutputDeviceInfo = RTCAudioAudioOutputDeviceInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioAudioOutputDeviceInfo {
      val struct = RTCAudioAudioOutputDeviceInfo(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioAudioOutputDeviceInfo(block: RTCAudioAudioOutputDeviceInfo.() -> Unit = {}): RTCAudioAudioOutputDeviceInfo = RTCAudioAudioOutputDeviceInfo.allocate().apply(block)

@JvmInline
public value class RTCAudioSetAudioInputSettingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var deviceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var volume: Float
    get() = RawMemory.getFloat(address + 24)
    set(`value`) {
      RawMemory.putFloat(address + 24, value)
    }

  public var platformAEC: Boolean
    get() = RawMemory.getInt(address + 28) != 0
    set(`value`) {
      RawMemory.putInt(address + 28, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCAudioSetAudioInputSettingsOptions = RTCAudioSetAudioInputSettingsOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioSetAudioInputSettingsOptions {
      val struct = RTCAudioSetAudioInputSettingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioSetAudioInputSettingsOptions(block: RTCAudioSetAudioInputSettingsOptions.() -> Unit = {}): RTCAudioSetAudioInputSettingsOptions = RTCAudioSetAudioInputSettingsOptions.allocate().apply(block)

@JvmInline
public value class RTCAudioSetAudioOutputSettingsOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var deviceId: String?
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

    public val NULL: RTCAudioSetAudioOutputSettingsOptions =
        RTCAudioSetAudioOutputSettingsOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAudioSetAudioOutputSettingsOptions {
      val struct = RTCAudioSetAudioOutputSettingsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAudioSetAudioOutputSettingsOptions(block: RTCAudioSetAudioOutputSettingsOptions.() -> Unit = {}): RTCAudioSetAudioOutputSettingsOptions = RTCAudioSetAudioOutputSettingsOptions.allocate().apply(block)

@JvmInline
public value class RTCDataAddNotifyParticipantUpdatedOptions(
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

    public val NULL: RTCDataAddNotifyParticipantUpdatedOptions =
        RTCDataAddNotifyParticipantUpdatedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCDataAddNotifyParticipantUpdatedOptions {
      val struct = RTCDataAddNotifyParticipantUpdatedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataAddNotifyParticipantUpdatedOptions(block: RTCDataAddNotifyParticipantUpdatedOptions.() -> Unit = {}): RTCDataAddNotifyParticipantUpdatedOptions = RTCDataAddNotifyParticipantUpdatedOptions.allocate().apply(block)

@JvmInline
public value class RTCDataParticipantUpdatedCallbackInfo(
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

  public var dataStatus: ERTCDataStatus
    get() = ERTCDataStatus(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCDataParticipantUpdatedCallbackInfo =
        RTCDataParticipantUpdatedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCDataParticipantUpdatedCallbackInfo {
      val struct = RTCDataParticipantUpdatedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataParticipantUpdatedCallbackInfo(block: RTCDataParticipantUpdatedCallbackInfo.() -> Unit = {}): RTCDataParticipantUpdatedCallbackInfo = RTCDataParticipantUpdatedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCDataSendDataOptions(
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

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCDataSendDataOptions = RTCDataSendDataOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCDataSendDataOptions {
      val struct = RTCDataSendDataOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataSendDataOptions(block: RTCDataSendDataOptions.() -> Unit = {}): RTCDataSendDataOptions = RTCDataSendDataOptions.allocate().apply(block)

@JvmInline
public value class RTCDataAddNotifyDataReceivedOptions(
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

    public val NULL: RTCDataAddNotifyDataReceivedOptions = RTCDataAddNotifyDataReceivedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCDataAddNotifyDataReceivedOptions {
      val struct = RTCDataAddNotifyDataReceivedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataAddNotifyDataReceivedOptions(block: RTCDataAddNotifyDataReceivedOptions.() -> Unit = {}): RTCDataAddNotifyDataReceivedOptions = RTCDataAddNotifyDataReceivedOptions.allocate().apply(block)

@JvmInline
public value class RTCDataDataReceivedCallbackInfo(
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

  public var dataLengthBytes: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var `data`: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCDataDataReceivedCallbackInfo = RTCDataDataReceivedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCDataDataReceivedCallbackInfo {
      val struct = RTCDataDataReceivedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataDataReceivedCallbackInfo(block: RTCDataDataReceivedCallbackInfo.() -> Unit = {}): RTCDataDataReceivedCallbackInfo = RTCDataDataReceivedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCDataUpdateSendingOptions(
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

  public var dataEnabled: Boolean
    get() = RawMemory.getInt(address + 24) != 0
    set(`value`) {
      RawMemory.putInt(address + 24, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCDataUpdateSendingOptions = RTCDataUpdateSendingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCDataUpdateSendingOptions {
      val struct = RTCDataUpdateSendingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataUpdateSendingOptions(block: RTCDataUpdateSendingOptions.() -> Unit = {}): RTCDataUpdateSendingOptions = RTCDataUpdateSendingOptions.allocate().apply(block)

@JvmInline
public value class RTCDataUpdateSendingCallbackInfo(
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

  public var dataEnabled: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCDataUpdateSendingCallbackInfo = RTCDataUpdateSendingCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCDataUpdateSendingCallbackInfo {
      val struct = RTCDataUpdateSendingCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataUpdateSendingCallbackInfo(block: RTCDataUpdateSendingCallbackInfo.() -> Unit = {}): RTCDataUpdateSendingCallbackInfo = RTCDataUpdateSendingCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCDataUpdateReceivingOptions(
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

  public var dataEnabled: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCDataUpdateReceivingOptions = RTCDataUpdateReceivingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCDataUpdateReceivingOptions {
      val struct = RTCDataUpdateReceivingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataUpdateReceivingOptions(block: RTCDataUpdateReceivingOptions.() -> Unit = {}): RTCDataUpdateReceivingOptions = RTCDataUpdateReceivingOptions.allocate().apply(block)

@JvmInline
public value class RTCDataUpdateReceivingCallbackInfo(
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

  public var dataEnabled: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCDataUpdateReceivingCallbackInfo = RTCDataUpdateReceivingCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCDataUpdateReceivingCallbackInfo {
      val struct = RTCDataUpdateReceivingCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDataUpdateReceivingCallbackInfo(block: RTCDataUpdateReceivingCallbackInfo.() -> Unit = {}): RTCDataUpdateReceivingCallbackInfo = RTCDataUpdateReceivingCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCJoinRoomOptions(
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

  context(arena: Arena)
  public var clientBaseUrl: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var participantToken: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var participantId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.raw)
    }

  public var flags: Int
    get() = RawMemory.getInt(address + 48)
    set(`value`) {
      RawMemory.putInt(address + 48, value)
    }

  public var manualAudioInputEnabled: Boolean
    get() = RawMemory.getInt(address + 52) != 0
    set(`value`) {
      RawMemory.putInt(address + 52, if (value) 1 else 0)
    }

  public var manualAudioOutputEnabled: Boolean
    get() = RawMemory.getInt(address + 56) != 0
    set(`value`) {
      RawMemory.putInt(address + 56, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 64

    public val NULL: RTCJoinRoomOptions = RTCJoinRoomOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCJoinRoomOptions {
      val struct = RTCJoinRoomOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCJoinRoomOptions(block: RTCJoinRoomOptions.() -> Unit = {}): RTCJoinRoomOptions = RTCJoinRoomOptions.allocate().apply(block)

@JvmInline
public value class RTCOption(
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

    public val NULL: RTCOption = RTCOption(0)

    context(arena: Arena)
    public fun allocate(): RTCOption {
      val struct = RTCOption(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCOption(block: RTCOption.() -> Unit = {}): RTCOption = RTCOption.allocate().apply(block)

@JvmInline
public value class RTCJoinRoomCallbackInfo(
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

  public var roomOptionsCount: Int
    get() = RawMemory.getInt(address + 32)
    set(`value`) {
      RawMemory.putInt(address + 32, value)
    }

  public var roomOptions: RTCOption
    get() = RTCOption(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.address)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCJoinRoomCallbackInfo = RTCJoinRoomCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCJoinRoomCallbackInfo {
      val struct = RTCJoinRoomCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCJoinRoomCallbackInfo(block: RTCJoinRoomCallbackInfo.() -> Unit = {}): RTCJoinRoomCallbackInfo = RTCJoinRoomCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCLeaveRoomOptions(
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

    public val NULL: RTCLeaveRoomOptions = RTCLeaveRoomOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCLeaveRoomOptions {
      val struct = RTCLeaveRoomOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCLeaveRoomOptions(block: RTCLeaveRoomOptions.() -> Unit = {}): RTCLeaveRoomOptions = RTCLeaveRoomOptions.allocate().apply(block)

@JvmInline
public value class RTCLeaveRoomCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCLeaveRoomCallbackInfo = RTCLeaveRoomCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCLeaveRoomCallbackInfo {
      val struct = RTCLeaveRoomCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCLeaveRoomCallbackInfo(block: RTCLeaveRoomCallbackInfo.() -> Unit = {}): RTCLeaveRoomCallbackInfo = RTCLeaveRoomCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCBlockParticipantOptions(
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

  public var blocked: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCBlockParticipantOptions = RTCBlockParticipantOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCBlockParticipantOptions {
      val struct = RTCBlockParticipantOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCBlockParticipantOptions(block: RTCBlockParticipantOptions.() -> Unit = {}): RTCBlockParticipantOptions = RTCBlockParticipantOptions.allocate().apply(block)

@JvmInline
public value class RTCBlockParticipantCallbackInfo(
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

  public var blocked: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: RTCBlockParticipantCallbackInfo = RTCBlockParticipantCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCBlockParticipantCallbackInfo {
      val struct = RTCBlockParticipantCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCBlockParticipantCallbackInfo(block: RTCBlockParticipantCallbackInfo.() -> Unit = {}): RTCBlockParticipantCallbackInfo = RTCBlockParticipantCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAddNotifyDisconnectedOptions(
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

    public val NULL: RTCAddNotifyDisconnectedOptions = RTCAddNotifyDisconnectedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAddNotifyDisconnectedOptions {
      val struct = RTCAddNotifyDisconnectedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAddNotifyDisconnectedOptions(block: RTCAddNotifyDisconnectedOptions.() -> Unit = {}): RTCAddNotifyDisconnectedOptions = RTCAddNotifyDisconnectedOptions.allocate().apply(block)

@JvmInline
public value class RTCDisconnectedCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCDisconnectedCallbackInfo = RTCDisconnectedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCDisconnectedCallbackInfo {
      val struct = RTCDisconnectedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCDisconnectedCallbackInfo(block: RTCDisconnectedCallbackInfo.() -> Unit = {}): RTCDisconnectedCallbackInfo = RTCDisconnectedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCParticipantMetadata(
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

    public val NULL: RTCParticipantMetadata = RTCParticipantMetadata(0)

    context(arena: Arena)
    public fun allocate(): RTCParticipantMetadata {
      val struct = RTCParticipantMetadata(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCParticipantMetadata(block: RTCParticipantMetadata.() -> Unit = {}): RTCParticipantMetadata = RTCParticipantMetadata.allocate().apply(block)

@JvmInline
public value class RTCAddNotifyParticipantStatusChangedOptions(
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

    public val NULL: RTCAddNotifyParticipantStatusChangedOptions =
        RTCAddNotifyParticipantStatusChangedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAddNotifyParticipantStatusChangedOptions {
      val struct = RTCAddNotifyParticipantStatusChangedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAddNotifyParticipantStatusChangedOptions(block: RTCAddNotifyParticipantStatusChangedOptions.() -> Unit = {}): RTCAddNotifyParticipantStatusChangedOptions = RTCAddNotifyParticipantStatusChangedOptions.allocate().apply(block)

@JvmInline
public value class RTCParticipantStatusChangedCallbackInfo(
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

  public var participantStatus: ERTCParticipantStatus
    get() = ERTCParticipantStatus(RawMemory.getInt(address + 32))
    set(`value`) {
      RawMemory.putInt(address + 32, value.value)
    }

  public var participantMetadataCount: Int
    get() = RawMemory.getInt(address + 36)
    set(`value`) {
      RawMemory.putInt(address + 36, value)
    }

  public var participantMetadata: RTCParticipantMetadata
    get() = RTCParticipantMetadata(RawMemory.getLong(address + 40))
    set(`value`) {
      RawMemory.putLong(address + 40, value.address)
    }

  public var participantInBlocklist: Boolean
    get() = RawMemory.getInt(address + 48) != 0
    set(`value`) {
      RawMemory.putInt(address + 48, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 56

    public val NULL: RTCParticipantStatusChangedCallbackInfo =
        RTCParticipantStatusChangedCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCParticipantStatusChangedCallbackInfo {
      val struct = RTCParticipantStatusChangedCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCParticipantStatusChangedCallbackInfo(block: RTCParticipantStatusChangedCallbackInfo.() -> Unit = {}): RTCParticipantStatusChangedCallbackInfo = RTCParticipantStatusChangedCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCAddNotifyRoomBeforeJoinOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: RTCAddNotifyRoomBeforeJoinOptions = RTCAddNotifyRoomBeforeJoinOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAddNotifyRoomBeforeJoinOptions {
      val struct = RTCAddNotifyRoomBeforeJoinOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAddNotifyRoomBeforeJoinOptions(block: RTCAddNotifyRoomBeforeJoinOptions.() -> Unit = {}): RTCAddNotifyRoomBeforeJoinOptions = RTCAddNotifyRoomBeforeJoinOptions.allocate().apply(block)

@JvmInline
public value class RTCRoomBeforeJoinCallbackInfo(
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

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCRoomBeforeJoinCallbackInfo = RTCRoomBeforeJoinCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCRoomBeforeJoinCallbackInfo {
      val struct = RTCRoomBeforeJoinCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCRoomBeforeJoinCallbackInfo(block: RTCRoomBeforeJoinCallbackInfo.() -> Unit = {}): RTCRoomBeforeJoinCallbackInfo = RTCRoomBeforeJoinCallbackInfo.allocate().apply(block)

@JvmInline
public value class RTCSetSettingOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var settingName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var settingValue: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: RTCSetSettingOptions = RTCSetSettingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCSetSettingOptions {
      val struct = RTCSetSettingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCSetSettingOptions(block: RTCSetSettingOptions.() -> Unit = {}): RTCSetSettingOptions = RTCSetSettingOptions.allocate().apply(block)

@JvmInline
public value class RTCSetRoomSettingOptions(
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

  context(arena: Arena)
  public var settingName: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var settingValue: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: RTCSetRoomSettingOptions = RTCSetRoomSettingOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCSetRoomSettingOptions {
      val struct = RTCSetRoomSettingOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCSetRoomSettingOptions(block: RTCSetRoomSettingOptions.() -> Unit = {}): RTCSetRoomSettingOptions = RTCSetRoomSettingOptions.allocate().apply(block)

@JvmInline
public value class RTCAddNotifyRoomStatisticsUpdatedOptions(
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

    public val NULL: RTCAddNotifyRoomStatisticsUpdatedOptions =
        RTCAddNotifyRoomStatisticsUpdatedOptions(0)

    context(arena: Arena)
    public fun allocate(): RTCAddNotifyRoomStatisticsUpdatedOptions {
      val struct = RTCAddNotifyRoomStatisticsUpdatedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCAddNotifyRoomStatisticsUpdatedOptions(block: RTCAddNotifyRoomStatisticsUpdatedOptions.() -> Unit = {}): RTCAddNotifyRoomStatisticsUpdatedOptions = RTCAddNotifyRoomStatisticsUpdatedOptions.allocate().apply(block)

@JvmInline
public value class RTCRoomStatisticsUpdatedInfo(
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

  context(arena: Arena)
  public var statistic: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: RTCRoomStatisticsUpdatedInfo = RTCRoomStatisticsUpdatedInfo(0)

    context(arena: Arena)
    public fun allocate(): RTCRoomStatisticsUpdatedInfo {
      val struct = RTCRoomStatisticsUpdatedInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun RTCRoomStatisticsUpdatedInfo(block: RTCRoomStatisticsUpdatedInfo.() -> Unit = {}): RTCRoomStatisticsUpdatedInfo = RTCRoomStatisticsUpdatedInfo.allocate().apply(block)

@JvmInline
public value class SanctionsPlayerSanction(
  public val address: Long,
) {
  public var timePlaced: Long
    get() = RawMemory.getLong(address + 8)
    set(`value`) {
      RawMemory.putLong(address + 8, value)
    }

  context(arena: Arena)
  public var action: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var timeExpires: Long
    get() = RawMemory.getLong(address + 24)
    set(`value`) {
      RawMemory.putLong(address + 24, value)
    }

  context(arena: Arena)
  public var referenceId: String?
    get() = RawMemory.getLong(address + 32).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 32, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: SanctionsPlayerSanction = SanctionsPlayerSanction(0)

    context(arena: Arena)
    public fun allocate(): SanctionsPlayerSanction {
      val struct = SanctionsPlayerSanction(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsPlayerSanction(block: SanctionsPlayerSanction.() -> Unit = {}): SanctionsPlayerSanction = SanctionsPlayerSanction.allocate().apply(block)

@JvmInline
public value class SanctionsQueryActivePlayerSanctionsOptions(
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

    public val NULL: SanctionsQueryActivePlayerSanctionsOptions =
        SanctionsQueryActivePlayerSanctionsOptions(0)

    context(arena: Arena)
    public fun allocate(): SanctionsQueryActivePlayerSanctionsOptions {
      val struct = SanctionsQueryActivePlayerSanctionsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsQueryActivePlayerSanctionsOptions(block: SanctionsQueryActivePlayerSanctionsOptions.() -> Unit = {}): SanctionsQueryActivePlayerSanctionsOptions = SanctionsQueryActivePlayerSanctionsOptions.allocate().apply(block)

@JvmInline
public value class SanctionsQueryActivePlayerSanctionsCallbackInfo(
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

    public val NULL: SanctionsQueryActivePlayerSanctionsCallbackInfo =
        SanctionsQueryActivePlayerSanctionsCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SanctionsQueryActivePlayerSanctionsCallbackInfo {
      val struct = SanctionsQueryActivePlayerSanctionsCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsQueryActivePlayerSanctionsCallbackInfo(block: SanctionsQueryActivePlayerSanctionsCallbackInfo.() -> Unit = {}): SanctionsQueryActivePlayerSanctionsCallbackInfo = SanctionsQueryActivePlayerSanctionsCallbackInfo.allocate().apply(block)

@JvmInline
public value class SanctionsGetPlayerSanctionCountOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SanctionsGetPlayerSanctionCountOptions =
        SanctionsGetPlayerSanctionCountOptions(0)

    context(arena: Arena)
    public fun allocate(): SanctionsGetPlayerSanctionCountOptions {
      val struct = SanctionsGetPlayerSanctionCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsGetPlayerSanctionCountOptions(block: SanctionsGetPlayerSanctionCountOptions.() -> Unit = {}): SanctionsGetPlayerSanctionCountOptions = SanctionsGetPlayerSanctionCountOptions.allocate().apply(block)

@JvmInline
public value class SanctionsCopyPlayerSanctionByIndexOptions(
  public val address: Long,
) {
  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var sanctionIndex: Int
    get() = RawMemory.getInt(address + 16)
    set(`value`) {
      RawMemory.putInt(address + 16, value)
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SanctionsCopyPlayerSanctionByIndexOptions =
        SanctionsCopyPlayerSanctionByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): SanctionsCopyPlayerSanctionByIndexOptions {
      val struct = SanctionsCopyPlayerSanctionByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsCopyPlayerSanctionByIndexOptions(block: SanctionsCopyPlayerSanctionByIndexOptions.() -> Unit = {}): SanctionsCopyPlayerSanctionByIndexOptions = SanctionsCopyPlayerSanctionByIndexOptions.allocate().apply(block)

@JvmInline
public value class SanctionsCreatePlayerSanctionAppealOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public var reason: ESanctionAppealReason
    get() = ESanctionAppealReason(RawMemory.getInt(address + 16))
    set(`value`) {
      RawMemory.putInt(address + 16, value.value)
    }

  context(arena: Arena)
  public var referenceId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SanctionsCreatePlayerSanctionAppealOptions =
        SanctionsCreatePlayerSanctionAppealOptions(0)

    context(arena: Arena)
    public fun allocate(): SanctionsCreatePlayerSanctionAppealOptions {
      val struct = SanctionsCreatePlayerSanctionAppealOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsCreatePlayerSanctionAppealOptions(block: SanctionsCreatePlayerSanctionAppealOptions.() -> Unit = {}): SanctionsCreatePlayerSanctionAppealOptions = SanctionsCreatePlayerSanctionAppealOptions.allocate().apply(block)

@JvmInline
public value class SanctionsCreatePlayerSanctionAppealCallbackInfo(
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
  public var referenceId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SanctionsCreatePlayerSanctionAppealCallbackInfo =
        SanctionsCreatePlayerSanctionAppealCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SanctionsCreatePlayerSanctionAppealCallbackInfo {
      val struct = SanctionsCreatePlayerSanctionAppealCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SanctionsCreatePlayerSanctionAppealCallbackInfo(block: SanctionsCreatePlayerSanctionAppealCallbackInfo.() -> Unit = {}): SanctionsCreatePlayerSanctionAppealCallbackInfo = SanctionsCreatePlayerSanctionAppealCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsCreateSessionModificationOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var bucketId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var maxPlayers: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 32))
    set(`value`) {
      RawMemory.putLong(address + 32, value.raw)
    }

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 40) != 0
    set(`value`) {
      RawMemory.putInt(address + 40, if (value) 1 else 0)
    }

  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 48).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 48, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var sanctionsEnabled: Boolean
    get() = RawMemory.getInt(address + 56) != 0
    set(`value`) {
      RawMemory.putInt(address + 56, if (value) 1 else 0)
    }

  public var allowedPlatformIds: Long
    get() = RawMemory.getLong(address + 64)
    set(`value`) {
      RawMemory.putLong(address + 64, value)
    }

  public var allowedPlatformIdsCount: Int
    get() = RawMemory.getInt(address + 72)
    set(`value`) {
      RawMemory.putInt(address + 72, value)
    }

  public companion object {
    public const val SIZE: Long = 80

    public val NULL: SessionsCreateSessionModificationOptions =
        SessionsCreateSessionModificationOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCreateSessionModificationOptions {
      val struct = SessionsCreateSessionModificationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 5)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCreateSessionModificationOptions(block: SessionsCreateSessionModificationOptions.() -> Unit = {}): SessionsCreateSessionModificationOptions = SessionsCreateSessionModificationOptions.allocate().apply(block)

@JvmInline
public value class SessionsUpdateSessionModificationOptions(
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

    public val NULL: SessionsUpdateSessionModificationOptions =
        SessionsUpdateSessionModificationOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsUpdateSessionModificationOptions {
      val struct = SessionsUpdateSessionModificationOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsUpdateSessionModificationOptions(block: SessionsUpdateSessionModificationOptions.() -> Unit = {}): SessionsUpdateSessionModificationOptions = SessionsUpdateSessionModificationOptions.allocate().apply(block)

@JvmInline
public value class SessionsSendInviteOptions(
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

  public var targetUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsSendInviteOptions = SessionsSendInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsSendInviteOptions {
      val struct = SessionsSendInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSendInviteOptions(block: SessionsSendInviteOptions.() -> Unit = {}): SessionsSendInviteOptions = SessionsSendInviteOptions.allocate().apply(block)

@JvmInline
public value class SessionsSendInviteCallbackInfo(
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

    public val NULL: SessionsSendInviteCallbackInfo = SessionsSendInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsSendInviteCallbackInfo {
      val struct = SessionsSendInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsSendInviteCallbackInfo(block: SessionsSendInviteCallbackInfo.() -> Unit = {}): SessionsSendInviteCallbackInfo = SessionsSendInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsRejectInviteOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  context(arena: Arena)
  public var inviteId: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 24

    public val NULL: SessionsRejectInviteOptions = SessionsRejectInviteOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsRejectInviteOptions {
      val struct = SessionsRejectInviteOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsRejectInviteOptions(block: SessionsRejectInviteOptions.() -> Unit = {}): SessionsRejectInviteOptions = SessionsRejectInviteOptions.allocate().apply(block)

@JvmInline
public value class SessionsRejectInviteCallbackInfo(
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

    public val NULL: SessionsRejectInviteCallbackInfo = SessionsRejectInviteCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsRejectInviteCallbackInfo {
      val struct = SessionsRejectInviteCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsRejectInviteCallbackInfo(block: SessionsRejectInviteCallbackInfo.() -> Unit = {}): SessionsRejectInviteCallbackInfo = SessionsRejectInviteCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsQueryInvitesOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsQueryInvitesOptions = SessionsQueryInvitesOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsQueryInvitesOptions {
      val struct = SessionsQueryInvitesOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsQueryInvitesOptions(block: SessionsQueryInvitesOptions.() -> Unit = {}): SessionsQueryInvitesOptions = SessionsQueryInvitesOptions.allocate().apply(block)

@JvmInline
public value class SessionsQueryInvitesCallbackInfo(
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

    public val NULL: SessionsQueryInvitesCallbackInfo = SessionsQueryInvitesCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsQueryInvitesCallbackInfo {
      val struct = SessionsQueryInvitesCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsQueryInvitesCallbackInfo(block: SessionsQueryInvitesCallbackInfo.() -> Unit = {}): SessionsQueryInvitesCallbackInfo = SessionsQueryInvitesCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsGetInviteCountOptions(
  public val address: Long,
) {
  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.raw)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsGetInviteCountOptions = SessionsGetInviteCountOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsGetInviteCountOptions {
      val struct = SessionsGetInviteCountOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsGetInviteCountOptions(block: SessionsGetInviteCountOptions.() -> Unit = {}): SessionsGetInviteCountOptions = SessionsGetInviteCountOptions.allocate().apply(block)

@JvmInline
public value class SessionsGetInviteIdByIndexOptions(
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

    public val NULL: SessionsGetInviteIdByIndexOptions = SessionsGetInviteIdByIndexOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsGetInviteIdByIndexOptions {
      val struct = SessionsGetInviteIdByIndexOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsGetInviteIdByIndexOptions(block: SessionsGetInviteIdByIndexOptions.() -> Unit = {}): SessionsGetInviteIdByIndexOptions = SessionsGetInviteIdByIndexOptions.allocate().apply(block)

@JvmInline
public value class SessionsCreateSessionSearchOptions(
  public val address: Long,
) {
  public var maxSearchResults: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionsCreateSessionSearchOptions = SessionsCreateSessionSearchOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsCreateSessionSearchOptions {
      val struct = SessionsCreateSessionSearchOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsCreateSessionSearchOptions(block: SessionsCreateSessionSearchOptions.() -> Unit = {}): SessionsCreateSessionSearchOptions = SessionsCreateSessionSearchOptions.allocate().apply(block)

@JvmInline
public value class SessionsUpdateSessionOptions(
  public val address: Long,
) {
  public var sessionModificationHandle: HSessionModification
    get() = HSessionModification(RawMemory.getLong(address + 8))
    set(`value`) {
      RawMemory.putLong(address + 8, value.handle)
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionsUpdateSessionOptions = SessionsUpdateSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsUpdateSessionOptions {
      val struct = SessionsUpdateSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsUpdateSessionOptions(block: SessionsUpdateSessionOptions.() -> Unit = {}): SessionsUpdateSessionOptions = SessionsUpdateSessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsUpdateSessionCallbackInfo(
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
  public var sessionName: String?
    get() = RawMemory.getLong(address + 16).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 16, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  context(arena: Arena)
  public var sessionId: String?
    get() = RawMemory.getLong(address + 24).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 24, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsUpdateSessionCallbackInfo = SessionsUpdateSessionCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsUpdateSessionCallbackInfo {
      val struct = SessionsUpdateSessionCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsUpdateSessionCallbackInfo(block: SessionsUpdateSessionCallbackInfo.() -> Unit = {}): SessionsUpdateSessionCallbackInfo = SessionsUpdateSessionCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsDestroySessionOptions(
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

    public val NULL: SessionsDestroySessionOptions = SessionsDestroySessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsDestroySessionOptions {
      val struct = SessionsDestroySessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsDestroySessionOptions(block: SessionsDestroySessionOptions.() -> Unit = {}): SessionsDestroySessionOptions = SessionsDestroySessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsDestroySessionCallbackInfo(
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

    public val NULL: SessionsDestroySessionCallbackInfo = SessionsDestroySessionCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsDestroySessionCallbackInfo {
      val struct = SessionsDestroySessionCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsDestroySessionCallbackInfo(block: SessionsDestroySessionCallbackInfo.() -> Unit = {}): SessionsDestroySessionCallbackInfo = SessionsDestroySessionCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsJoinSessionOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var sessionHandle: HSessionDetails
    get() = HSessionDetails(RawMemory.getLong(address + 16))
    set(`value`) {
      RawMemory.putLong(address + 16, value.handle)
    }

  public var localUserId: ProductUserId
    get() = ProductUserId(RawMemory.getLong(address + 24))
    set(`value`) {
      RawMemory.putLong(address + 24, value.raw)
    }

  public var presenceEnabled: Boolean
    get() = RawMemory.getInt(address + 32) != 0
    set(`value`) {
      RawMemory.putInt(address + 32, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 40

    public val NULL: SessionsJoinSessionOptions = SessionsJoinSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsJoinSessionOptions {
      val struct = SessionsJoinSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsJoinSessionOptions(block: SessionsJoinSessionOptions.() -> Unit = {}): SessionsJoinSessionOptions = SessionsJoinSessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsJoinSessionCallbackInfo(
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

    public val NULL: SessionsJoinSessionCallbackInfo = SessionsJoinSessionCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsJoinSessionCallbackInfo {
      val struct = SessionsJoinSessionCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsJoinSessionCallbackInfo(block: SessionsJoinSessionCallbackInfo.() -> Unit = {}): SessionsJoinSessionCallbackInfo = SessionsJoinSessionCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsStartSessionOptions(
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

    public val NULL: SessionsStartSessionOptions = SessionsStartSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsStartSessionOptions {
      val struct = SessionsStartSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsStartSessionOptions(block: SessionsStartSessionOptions.() -> Unit = {}): SessionsStartSessionOptions = SessionsStartSessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsStartSessionCallbackInfo(
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

    public val NULL: SessionsStartSessionCallbackInfo = SessionsStartSessionCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsStartSessionCallbackInfo {
      val struct = SessionsStartSessionCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsStartSessionCallbackInfo(block: SessionsStartSessionCallbackInfo.() -> Unit = {}): SessionsStartSessionCallbackInfo = SessionsStartSessionCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsEndSessionOptions(
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

    public val NULL: SessionsEndSessionOptions = SessionsEndSessionOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsEndSessionOptions {
      val struct = SessionsEndSessionOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsEndSessionOptions(block: SessionsEndSessionOptions.() -> Unit = {}): SessionsEndSessionOptions = SessionsEndSessionOptions.allocate().apply(block)

@JvmInline
public value class SessionsEndSessionCallbackInfo(
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

    public val NULL: SessionsEndSessionCallbackInfo = SessionsEndSessionCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsEndSessionCallbackInfo {
      val struct = SessionsEndSessionCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsEndSessionCallbackInfo(block: SessionsEndSessionCallbackInfo.() -> Unit = {}): SessionsEndSessionCallbackInfo = SessionsEndSessionCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsRegisterPlayersOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var playersToRegister: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var playersToRegisterCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsRegisterPlayersOptions = SessionsRegisterPlayersOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsRegisterPlayersOptions {
      val struct = SessionsRegisterPlayersOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 3)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsRegisterPlayersOptions(block: SessionsRegisterPlayersOptions.() -> Unit = {}): SessionsRegisterPlayersOptions = SessionsRegisterPlayersOptions.allocate().apply(block)

@JvmInline
public value class SessionsRegisterPlayersCallbackInfo(
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

  public var registeredPlayers: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var registeredPlayersCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public var sanctionedPlayers: Long
    get() = RawMemory.getLong(address + 32)
    set(`value`) {
      RawMemory.putLong(address + 32, value)
    }

  public var sanctionedPlayersCount: Int
    get() = RawMemory.getInt(address + 40)
    set(`value`) {
      RawMemory.putInt(address + 40, value)
    }

  public companion object {
    public const val SIZE: Long = 48

    public val NULL: SessionsRegisterPlayersCallbackInfo = SessionsRegisterPlayersCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsRegisterPlayersCallbackInfo {
      val struct = SessionsRegisterPlayersCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsRegisterPlayersCallbackInfo(block: SessionsRegisterPlayersCallbackInfo.() -> Unit = {}): SessionsRegisterPlayersCallbackInfo = SessionsRegisterPlayersCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionsUnregisterPlayersOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var sessionName: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public var playersToUnregister: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var playersToUnregisterCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsUnregisterPlayersOptions = SessionsUnregisterPlayersOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionsUnregisterPlayersOptions {
      val struct = SessionsUnregisterPlayersOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 2)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsUnregisterPlayersOptions(block: SessionsUnregisterPlayersOptions.() -> Unit = {}): SessionsUnregisterPlayersOptions = SessionsUnregisterPlayersOptions.allocate().apply(block)

@JvmInline
public value class SessionsUnregisterPlayersCallbackInfo(
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

  public var unregisteredPlayers: Long
    get() = RawMemory.getLong(address + 16)
    set(`value`) {
      RawMemory.putLong(address + 16, value)
    }

  public var unregisteredPlayersCount: Int
    get() = RawMemory.getInt(address + 24)
    set(`value`) {
      RawMemory.putInt(address + 24, value)
    }

  public companion object {
    public const val SIZE: Long = 32

    public val NULL: SessionsUnregisterPlayersCallbackInfo =
        SessionsUnregisterPlayersCallbackInfo(0)

    context(arena: Arena)
    public fun allocate(): SessionsUnregisterPlayersCallbackInfo {
      val struct = SessionsUnregisterPlayersCallbackInfo(arena.allocate(SIZE).address())
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsUnregisterPlayersCallbackInfo(block: SessionsUnregisterPlayersCallbackInfo.() -> Unit = {}): SessionsUnregisterPlayersCallbackInfo = SessionsUnregisterPlayersCallbackInfo.allocate().apply(block)

@JvmInline
public value class SessionModificationSetBucketIdOptions(
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

    public val NULL: SessionModificationSetBucketIdOptions =
        SessionModificationSetBucketIdOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetBucketIdOptions {
      val struct = SessionModificationSetBucketIdOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetBucketIdOptions(block: SessionModificationSetBucketIdOptions.() -> Unit = {}): SessionModificationSetBucketIdOptions = SessionModificationSetBucketIdOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetHostAddressOptions(
  public val address: Long,
) {
  context(arena: Arena)
  public var hostAddress: String?
    get() = RawMemory.getLong(address + 8).let { if (it == 0L) null else MemorySegment.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }
    set(`value`) {
      RawMemory.putLong(address + 8, if (value == null) 0L else arena.allocateFrom(value).address())
    }

  public companion object {
    public const val SIZE: Long = 16

    public val NULL: SessionModificationSetHostAddressOptions =
        SessionModificationSetHostAddressOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetHostAddressOptions {
      val struct = SessionModificationSetHostAddressOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetHostAddressOptions(block: SessionModificationSetHostAddressOptions.() -> Unit = {}): SessionModificationSetHostAddressOptions = SessionModificationSetHostAddressOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetPermissionLevelOptions(
  public val address: Long,
) {
  public var permissionLevel: EOnlineSessionPermissionLevel
    get() = EOnlineSessionPermissionLevel(RawMemory.getInt(address + 4))
    set(`value`) {
      RawMemory.putInt(address + 4, value.value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionModificationSetPermissionLevelOptions =
        SessionModificationSetPermissionLevelOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetPermissionLevelOptions {
      val struct = SessionModificationSetPermissionLevelOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetPermissionLevelOptions(block: SessionModificationSetPermissionLevelOptions.() -> Unit = {}): SessionModificationSetPermissionLevelOptions = SessionModificationSetPermissionLevelOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetJoinInProgressAllowedOptions(
  public val address: Long,
) {
  public var allowJoinInProgress: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionModificationSetJoinInProgressAllowedOptions =
        SessionModificationSetJoinInProgressAllowedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetJoinInProgressAllowedOptions {
      val struct = SessionModificationSetJoinInProgressAllowedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetJoinInProgressAllowedOptions(block: SessionModificationSetJoinInProgressAllowedOptions.() -> Unit = {}): SessionModificationSetJoinInProgressAllowedOptions = SessionModificationSetJoinInProgressAllowedOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetMaxPlayersOptions(
  public val address: Long,
) {
  public var maxPlayers: Int
    get() = RawMemory.getInt(address + 4)
    set(`value`) {
      RawMemory.putInt(address + 4, value)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionModificationSetMaxPlayersOptions =
        SessionModificationSetMaxPlayersOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetMaxPlayersOptions {
      val struct = SessionModificationSetMaxPlayersOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetMaxPlayersOptions(block: SessionModificationSetMaxPlayersOptions.() -> Unit = {}): SessionModificationSetMaxPlayersOptions = SessionModificationSetMaxPlayersOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetInvitesAllowedOptions(
  public val address: Long,
) {
  public var invitesAllowed: Boolean
    get() = RawMemory.getInt(address + 4) != 0
    set(`value`) {
      RawMemory.putInt(address + 4, if (value) 1 else 0)
    }

  public companion object {
    public const val SIZE: Long = 8

    public val NULL: SessionModificationSetInvitesAllowedOptions =
        SessionModificationSetInvitesAllowedOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetInvitesAllowedOptions {
      val struct = SessionModificationSetInvitesAllowedOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetInvitesAllowedOptions(block: SessionModificationSetInvitesAllowedOptions.() -> Unit = {}): SessionModificationSetInvitesAllowedOptions = SessionModificationSetInvitesAllowedOptions.allocate().apply(block)

@JvmInline
public value class SessionModificationSetAllowedPlatformIdsOptions(
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

    public val NULL: SessionModificationSetAllowedPlatformIdsOptions =
        SessionModificationSetAllowedPlatformIdsOptions(0)

    context(arena: Arena)
    public fun allocate(): SessionModificationSetAllowedPlatformIdsOptions {
      val struct = SessionModificationSetAllowedPlatformIdsOptions(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionModificationSetAllowedPlatformIdsOptions(block: SessionModificationSetAllowedPlatformIdsOptions.() -> Unit = {}): SessionModificationSetAllowedPlatformIdsOptions = SessionModificationSetAllowedPlatformIdsOptions.allocate().apply(block)

@JvmInline
public value class SessionsAttributeData(
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

    public val NULL: SessionsAttributeData = SessionsAttributeData(0)

    context(arena: Arena)
    public fun allocate(): SessionsAttributeData {
      val struct = SessionsAttributeData(arena.allocate(SIZE).address())
      RawMemory.putInt(struct.address, 1)
      return struct
    }
  }
}

context(arena: Arena)
public inline fun SessionsAttributeData(block: SessionsAttributeData.() -> Unit = {}): SessionsAttributeData = SessionsAttributeData.allocate().apply(block)
