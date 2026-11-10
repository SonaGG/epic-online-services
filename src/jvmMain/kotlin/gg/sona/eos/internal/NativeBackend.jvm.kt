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

import gg.sona.eos.internal.foreign.UnsafeAccess
import gg.sona.eos.internal.foreign.jni.NativeBridge
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.concurrent.ConcurrentHashMap

internal actual object NativeBackend {
    private val extracted = ConcurrentHashMap<String, String>()

    @Volatile
    private var tempDir: Path? = null

    actual val isWindows: Boolean = System.getProperty("os.name").orEmpty().lowercase().contains("win")

    private val isArm64: Boolean = System.getProperty("os.arch").orEmpty().lowercase().let { it.contains("aarch64") || it.contains("arm64") }

    actual fun openSdk(): Long {
        val names = if (isArm64) {
            listOf("EOSSDK", "EOSSDK-Win64-Shippingarm64", "EOSSDK-Mac-Shipping", "libEOSSDK-LinuxArm64-Shipping.so")
        } else {
            listOf("EOSSDK", "EOSSDK-Win64-Shipping", "EOSSDK-Mac-Shipping", "EOSSDK-Linux-Shipping")
        }
        for (name in names) {
            try {
                val handle = NativeBridge.nOpenLibrary(name)
                if (handle != 0L) return handle
            } catch (_: UnsatisfiedLinkError) {
            }
        }
        val name = bundledLibraryName()
        val path = extractBundledFile(name) ?: error(
            "No EOS SDK native library '$name' found on the classpath under 'natives/$name', and no system-installed EOSSDK was found " +
                "either. This library does not distribute the EOS SDK binaries. The application must supply '$name' as a classpath " +
                "resource at 'natives/$name', or have the EOS SDK installed system-wide."
        )
        val handle = NativeBridge.nOpenLibrary(path)
        if (handle == 0L) error("Found '$name' at '$path' but the native loader failed to open it.")
        return handle
    }

    actual fun findSymbol(library: Long, name: String): Long = NativeBridge.nFindSymbol(library, name)

    actual fun call(function: Long, argumentCodes: ByteArray, returnCode: Byte, argumentBits: LongArray): Long =
        NativeBridge.nCall(function, argumentCodes, returnCode, argumentBits)

    actual fun createClosure(id: Long): Long = NativeBridge.nCreateClosure(id)

    actual fun destroyClosure(id: Long) = NativeBridge.nDestroyClosure(id)

    actual fun extractBundledFile(name: String): String? {
        extracted[name]?.let { return it }
        synchronized(extracted) {
            extracted[name]?.let { return it }
            val loader = NativeBackend::class.java.classLoader
            // xaudio2_9redist.dll has the same name on both architectures, so arm64 copies live in their own folder.
            val stream = (if (isArm64) loader.getResourceAsStream("natives/arm64/$name") else null)
                ?: loader.getResourceAsStream("natives/$name")
                ?: return null
            val target = tempDir().resolve(name)
            stream.use { Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING) }
            val path = target.toAbsolutePath().toString()
            extracted[name] = path
            return path
        }
    }

    private fun bundledLibraryName(): String {
        val os = System.getProperty("os.name").lowercase()
        return when {
            os.contains("win") -> if (isArm64) "EOSSDK-Win64-Shippingarm64.dll" else "EOSSDK-Win64-Shipping.dll"
            os.contains("mac") || os.contains("darwin") -> "libEOSSDK-Mac-Shipping.dylib"
            else -> if (isArm64) "libEOSSDK-LinuxArm64-Shipping.so" else "libEOSSDK-Linux-Shipping.so"
        }
    }

    private fun tempDir(): Path {
        tempDir?.let { return it }
        synchronized(this) {
            tempDir?.let { return it }
            val dir = Files.createTempDirectory("eos-natives-")
            Runtime.getRuntime().addShutdownHook(Thread {
                runCatching { Files.walk(dir).sorted(Comparator.reverseOrder()).forEach { Files.deleteIfExists(it) } }
            })
            tempDir = dir
            return dir
        }
    }
}

internal actual object RawMemory {
    private val unsafe = UnsafeAccess.unsafe
    private val byteArrayBase = unsafe.arrayBaseOffset(ByteArray::class.java).toLong()

    actual fun getByte(address: Long): Byte = unsafe.getByte(address)
    actual fun putByte(address: Long, value: Byte) = unsafe.putByte(address, value)
    actual fun getShort(address: Long): Short = unsafe.getShort(address)
    actual fun putShort(address: Long, value: Short) = unsafe.putShort(address, value)
    actual fun getChar(address: Long): Char = unsafe.getChar(address)
    actual fun putChar(address: Long, value: Char) = unsafe.putChar(address, value)
    actual fun getInt(address: Long): Int = unsafe.getInt(address)
    actual fun putInt(address: Long, value: Int) = unsafe.putInt(address, value)
    actual fun getLong(address: Long): Long = unsafe.getLong(address)
    actual fun putLong(address: Long, value: Long) = unsafe.putLong(address, value)
    actual fun getFloat(address: Long): Float = unsafe.getFloat(address)
    actual fun putFloat(address: Long, value: Float) = unsafe.putFloat(address, value)
    actual fun getDouble(address: Long): Double = unsafe.getDouble(address)
    actual fun putDouble(address: Long, value: Double) = unsafe.putDouble(address, value)

    actual fun allocate(size: Long): Long {
        val address = unsafe.allocateMemory(size)
        unsafe.setMemory(address, size, 0)
        return address
    }

    actual fun free(address: Long) = unsafe.freeMemory(address)
    actual fun copy(from: Long, to: Long, size: Long) = unsafe.copyMemory(from, to, size)
    actual fun getBytes(address: Long, into: ByteArray, offset: Int, length: Int) =
        unsafe.copyMemory(null, address, into, byteArrayBase + offset, length.toLong())

    actual fun putBytes(address: Long, from: ByteArray, offset: Int, length: Int) =
        unsafe.copyMemory(from, byteArrayBase + offset, null, address, length.toLong())
}
