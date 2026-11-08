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
package gg.sona.eos.internal

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.DoubleVar
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.IntVar
import kotlinx.cinterop.LongVar
import kotlinx.cinterop.ShortVar
import kotlinx.cinterop.UShortVar
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.toLong
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import kotlin.concurrent.atomics.AtomicLongArray
import kotlin.experimental.ExperimentalNativeApi
import kotlinx.cinterop.toKString
import platform.posix.calloc
import platform.posix.getenv
import platform.posix.memcpy
import platform.posix.memmove

internal expect fun openLibrary(name: String): Long

internal expect fun librarySymbol(library: Long, name: String): Long

private val slots = AtomicLongArray(TRAMPOLINE_COUNT)

internal fun dispatchTrampoline(slot: Int, data: Long) {
    val id = slots.loadAt(slot)
    if (id != 0L) CallbackStubs.dispatch(id, data)
}

internal actual object NativeBackend {
    @OptIn(ExperimentalNativeApi::class)
    actual val isWindows: Boolean = Platform.osFamily == OsFamily.WINDOWS

    @OptIn(ExperimentalNativeApi::class)
    actual fun openSdk(): Long {
        val names = when (Platform.osFamily) {
            OsFamily.WINDOWS -> listOf("EOSSDK-Win64-Shipping.dll", "EOSSDK.dll")
            OsFamily.MACOSX -> listOf("libEOSSDK-Mac-Shipping.dylib", "@executable_path/libEOSSDK-Mac-Shipping.dylib")
            else -> listOf("libEOSSDK-Linux-Shipping.so", "libEOSSDK.so")
        }
        for (name in listOfNotNull(getenv("EOS_SDK_LIBRARY")?.toKString()) + names) openLibrary(name).takeIf { it != 0L }?.let { return it }
        error("Could not load the EOS SDK. Put one of ${names.joinToString()} next to the executable or on the library path.")
    }

    actual fun findSymbol(library: Long, name: String): Long = librarySymbol(library, name)

    actual fun call(function: Long, argumentCodes: ByteArray, returnCode: Byte, argumentBits: LongArray): Long {
        val signature = buildString(argumentCodes.size + 2) {
            for (code in argumentCodes) append(kind(code))
            append('_').append(kind(returnCode))
        }
        return invokeNative(signature, function, argumentBits)
    }

    actual fun createClosure(id: Long): Long {
        for (slot in 0 until TRAMPOLINE_COUNT) if (slots.compareAndSetAt(slot, 0L, id)) return trampolineAddress(slot)
        throw IllegalStateException("All $TRAMPOLINE_COUNT EOS callback slots are in use")
    }

    actual fun destroyClosure(id: Long) {
        for (slot in 0 until TRAMPOLINE_COUNT) if (slots.compareAndSetAt(slot, id, 0L)) return
    }

    actual fun extractBundledFile(name: String): String? = null

    private fun kind(code: Byte): Char = when (code) {
        Native.BOOL, Native.INT -> 'I'
        Native.BYTE -> 'B'
        Native.SHORT -> 'S'
        Native.FLOAT -> 'F'
        Native.DOUBLE -> 'D'
        Native.VOID -> 'V'
        else -> 'J'
    }
}

internal actual object RawMemory {
    actual fun getByte(address: Long): Byte = address.toCPointer<ByteVar>()!!.pointed.value
    actual fun putByte(address: Long, value: Byte) { address.toCPointer<ByteVar>()!!.pointed.value = value }
    actual fun getShort(address: Long): Short = address.toCPointer<ShortVar>()!!.pointed.value
    actual fun putShort(address: Long, value: Short) { address.toCPointer<ShortVar>()!!.pointed.value = value }
    actual fun getChar(address: Long): Char = address.toCPointer<UShortVar>()!!.pointed.value.toInt().toChar()
    actual fun putChar(address: Long, value: Char) { address.toCPointer<UShortVar>()!!.pointed.value = value.code.toUShort() }
    actual fun getInt(address: Long): Int = address.toCPointer<IntVar>()!!.pointed.value
    actual fun putInt(address: Long, value: Int) { address.toCPointer<IntVar>()!!.pointed.value = value }
    actual fun getLong(address: Long): Long = address.toCPointer<LongVar>()!!.pointed.value
    actual fun putLong(address: Long, value: Long) { address.toCPointer<LongVar>()!!.pointed.value = value }
    actual fun getFloat(address: Long): Float = address.toCPointer<FloatVar>()!!.pointed.value
    actual fun putFloat(address: Long, value: Float) { address.toCPointer<FloatVar>()!!.pointed.value = value }
    actual fun getDouble(address: Long): Double = address.toCPointer<DoubleVar>()!!.pointed.value
    actual fun putDouble(address: Long, value: Double) { address.toCPointer<DoubleVar>()!!.pointed.value = value }

    actual fun allocate(size: Long): Long = calloc(1u, size.toULong()).toLong().also {
        if (it == 0L) throw IllegalStateException("Could not allocate $size native bytes")
    }

    actual fun free(address: Long) = platform.posix.free(address.toCPointer<ByteVar>())

    actual fun copy(from: Long, to: Long, size: Long) {
        memmove(to.toCPointer<ByteVar>(), from.toCPointer<ByteVar>(), size.toULong())
    }

    actual fun getBytes(address: Long, into: ByteArray, offset: Int, length: Int) {
        if (length > 0) into.usePinned { memcpy(it.addressOf(offset), address.toCPointer<ByteVar>(), length.toULong()) }
    }

    actual fun putBytes(address: Long, from: ByteArray, offset: Int, length: Int) {
        if (length > 0) from.usePinned { memcpy(address.toCPointer<ByteVar>(), it.addressOf(offset), length.toULong()) }
    }
}
