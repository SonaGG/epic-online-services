/*
 * Copyright 2026 Sona Softworks LLC
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

import gg.sona.eos.internal.foreign.FunctionDescriptor
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.ValueLayout
import gg.sona.eos.internal.foreign.jni.NativeBridge
import gg.sona.eos.internal.foreign.jni.NativeTypeCode
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.concurrent.ConcurrentHashMap

/**
 * Low-level JNI/libffi bindings for the EOS SDK shared library (see
 * `native/eos-jni` for the Rust side of this bridge).
 *
 * The shared library is loaded once at class initialization. Downcall
 * [MethodHandle]s are cached per (symbol, descriptor): building one is the
 * expensive part of a native call (resolving the symbol and assembling the
 * `MethodHandle` combinator chain), so each symbol is resolved and built at
 * most once and every subsequent call is a plain [MethodHandle] invoke.
 *
 * The C ABI is little-endian and 64-bit; EOS uses the platform default
 * calling convention.
 *
 * @author Luna
 */
internal object Native {
    // Declared above the init block on purpose: object properties initialize in declaration order,
    // and the block below loads the library through these fields.
    private val handles = ConcurrentHashMap<HandleKey, MethodHandle>()
    private val extracted = ConcurrentHashMap<String, String>()

    @Volatile
    private var tempDir: Path? = null

    private var libraryHandle: Long = 0L

    init {
        libraryHandle = loadNativeLibrary()
    }

    private data class HandleKey(val symbol: String, val descriptor: FunctionDescriptor)

    /**
     * Returns a cached downcall handle for [name] with the given [descriptor].
     * Symbol resolution and handle assembly happen once per distinct
     * (symbol, descriptor); repeat calls hit the cache.
     */
    fun downcall(name: String, descriptor: FunctionDescriptor): MethodHandle =
        handles.computeIfAbsent(HandleKey(name, descriptor)) { key ->
            val addr = NativeBridge.nFindSymbol(libraryHandle, key.symbol)
            if (addr == 0L) throw UnsatisfiedLinkError("EOS symbol ${key.symbol} not found in shared library")
            buildDowncallHandle(addr, key.descriptor)
        }

    fun <T> invoke(name: String, descriptor: FunctionDescriptor, vararg args: Any?): T {
        @Suppress("UNCHECKED_CAST")
        return downcall(name, descriptor).invokeWithArguments(*args) as T
    }

    /** Invoke a void-returning downcall. */
    fun invokeVoid(name: String, args: List<Any?>, argLayouts: List<MemoryLayout>) {
        val descriptor = if (argLayouts.isEmpty()) {
            FunctionDescriptor.ofVoid()
        } else {
            FunctionDescriptor.ofVoid(*argLayouts.map { it as ValueLayout }.toTypedArray())
        }
        downcall(name, descriptor).invokeWithArguments(args)
    }

    /** Invoke a value-returning downcall. */
    fun invoke(name: String, args: List<Any?>, argLayouts: List<MemoryLayout>, returnLayout: ValueLayout): Any? {
        val descriptor = FunctionDescriptor.of(returnLayout, *argLayouts.map { it as ValueLayout }.toTypedArray())
        return downcall(name, descriptor).invokeWithArguments(args)
    }

    fun version(): String {
        val handle = downcall("EOS_GetVersion", FunctionDescriptor.of(ValueLayout.ADDRESS))
        val seg = handle.invokeExact() as MemorySegment
        return seg.reinterpret(Long.MAX_VALUE).getString(0)
    }

    // region Downcall MethodHandle assembly
    //
    // Facade code calls `Native.downcall(name, descriptor).invokeExact(args)` directly, so this
    // must produce a genuine `java.lang.invoke.MethodHandle` (invokeExact is a JVM-level
    // polymorphic-signature method, not something a lookalike type could intercept). The handle is
    // built by binding NativeBridge.nCall's generic "raw 8-byte bit pattern per argument" signature
    // and adapting it to the descriptor's real Java types with standard MethodHandles combinators -
    // the same asType-based adaptation technique CallbackStubs already used (for upcalls) before
    // this migration.

    private val DO_CALL: MethodHandle = MethodHandles.lookup().findStatic(
        NativeBridge::class.java,
        "nCall",
        MethodType.methodType(
            java.lang.Long.TYPE,
            java.lang.Long.TYPE,
            ByteArray::class.java,
            java.lang.Byte.TYPE,
            LongArray::class.java,
        ),
    )

    private val FLOAT_TO_BITS: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "floatToBits",
        MethodType.methodType(java.lang.Long.TYPE, java.lang.Float.TYPE),
    )

    private val DOUBLE_TO_BITS: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "doubleToBits",
        MethodType.methodType(java.lang.Long.TYPE, java.lang.Double.TYPE),
    )

    private val SEGMENT_TO_ADDRESS: MethodHandle = MethodHandles.lookup().findVirtual(
        MemorySegment::class.java,
        "address",
        MethodType.methodType(java.lang.Long.TYPE),
    )

    private val BITS_TO_FLOAT: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "bitsToFloat",
        MethodType.methodType(java.lang.Float.TYPE, java.lang.Long.TYPE),
    )

    private val BITS_TO_DOUBLE: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "bitsToDouble",
        MethodType.methodType(java.lang.Double.TYPE, java.lang.Long.TYPE),
    )

    private val ADDRESS_TO_SEGMENT: MethodHandle = MethodHandles.lookup().findStatic(
        MemorySegment::class.java,
        "ofAddress",
        MethodType.methodType(MemorySegment::class.java, java.lang.Long.TYPE),
    )

    private val DROP_LONG: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "dropLong",
        MethodType.methodType(Void.TYPE, java.lang.Long.TYPE),
    )

    @Suppress("unused")
    @JvmStatic
    private fun floatToBits(f: Float): Long = java.lang.Float.floatToRawIntBits(f).toLong()

    @Suppress("unused")
    @JvmStatic
    private fun doubleToBits(d: Double): Long = java.lang.Double.doubleToRawLongBits(d)

    @Suppress("unused")
    @JvmStatic
    private fun bitsToFloat(bits: Long): Float = java.lang.Float.intBitsToFloat(bits.toInt())

    @Suppress("unused")
    @JvmStatic
    private fun bitsToDouble(bits: Long): Double = java.lang.Double.longBitsToDouble(bits)

    @Suppress("unused", "UNUSED_PARAMETER")
    @JvmStatic
    private fun dropLong(bits: Long) {
        // Intentionally empty: adapts a long-returning handle to void via filterReturnValue.
    }

    // long -> int/short/byte are NARROWING primitive conversions (JLS 5.1.3). MethodHandle.asType
    // only performs the JLS 5.3 *method invocation* conversion for primitives, which is
    // widening-only - it happily widens an int argument up to the long the collector requires, but
    // cannot narrow a long return down to int/short/byte, so those return positions need an
    // explicit filterReturnValue converter too (mirrors BITS_TO_FLOAT/BITS_TO_DOUBLE below).
    private val BITS_TO_INT: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "bitsToInt",
        MethodType.methodType(Integer.TYPE, java.lang.Long.TYPE),
    )

    private val BITS_TO_SHORT: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "bitsToShort",
        MethodType.methodType(java.lang.Short.TYPE, java.lang.Long.TYPE),
    )

    private val BITS_TO_BYTE: MethodHandle = MethodHandles.lookup().findStatic(
        Native::class.java,
        "bitsToByte",
        MethodType.methodType(java.lang.Byte.TYPE, java.lang.Long.TYPE),
    )

    @Suppress("unused")
    @JvmStatic
    private fun bitsToInt(bits: Long): Int = bits.toInt()

    @Suppress("unused")
    @JvmStatic
    private fun bitsToShort(bits: Long): Short = bits.toShort()

    @Suppress("unused")
    @JvmStatic
    private fun bitsToByte(bits: Long): Byte = bits.toByte()

    private fun buildDowncallHandle(fnPtr: Long, descriptor: FunctionDescriptor): MethodHandle {
        val argLayouts = descriptor.argumentLayouts()
        val n = argLayouts.size
        val argCodes = ByteArray(n) { i -> NativeTypeCode.of(argLayouts[i]) }
        val returnLayoutOpt = descriptor.returnLayout()
        val retCode = if (returnLayoutOpt.isPresent) NativeTypeCode.of(returnLayoutOpt.get()) else NativeTypeCode.VOID

        // (long, byte[], byte, long[]) -> long
        var handle = MethodHandles.insertArguments(DO_CALL, 0, fnPtr, argCodes, retCode)
        // (long[]) -> long
        handle = handle.asCollector(LongArray::class.java, n)
        // (long, long, ..., long) [n times] -> long

        argLayouts.forEachIndexed { i, layout ->
            handle = when (layout.carrier) {
                java.lang.Float.TYPE -> MethodHandles.filterArguments(handle, i, FLOAT_TO_BITS)
                java.lang.Double.TYPE -> MethodHandles.filterArguments(handle, i, DOUBLE_TO_BITS)
                MemorySegment::class.java -> MethodHandles.filterArguments(handle, i, SEGMENT_TO_ADDRESS)
                else -> handle // byte/short/int/long: widened to long by the final asType below
            }
        }

        handle = when {
            !returnLayoutOpt.isPresent -> MethodHandles.filterReturnValue(handle, DROP_LONG)
            returnLayoutOpt.get().carrier == java.lang.Float.TYPE -> MethodHandles.filterReturnValue(handle, BITS_TO_FLOAT)
            returnLayoutOpt.get().carrier == java.lang.Double.TYPE -> MethodHandles.filterReturnValue(handle, BITS_TO_DOUBLE)
            returnLayoutOpt.get().carrier == MemorySegment::class.java -> MethodHandles.filterReturnValue(handle, ADDRESS_TO_SEGMENT)
            returnLayoutOpt.get().carrier == Integer.TYPE -> MethodHandles.filterReturnValue(handle, BITS_TO_INT)
            returnLayoutOpt.get().carrier == java.lang.Short.TYPE -> MethodHandles.filterReturnValue(handle, BITS_TO_SHORT)
            returnLayoutOpt.get().carrier == java.lang.Byte.TYPE -> MethodHandles.filterReturnValue(handle, BITS_TO_BYTE)
            else -> handle // long: already the correct type
        }

        val targetType = MethodType.methodType(
            javaClassFor(returnLayoutOpt.orElse(null)),
            argLayouts.map { javaClassFor(it) }.toTypedArray(),
        )
        return handle.asType(targetType)
    }

    private fun javaClassFor(layout: ValueLayout?): Class<*> = when (layout?.carrier) {
        null -> Void.TYPE
        java.lang.Byte.TYPE -> java.lang.Byte.TYPE
        java.lang.Short.TYPE -> java.lang.Short.TYPE
        Integer.TYPE -> Integer.TYPE
        java.lang.Long.TYPE -> java.lang.Long.TYPE
        java.lang.Float.TYPE -> java.lang.Float.TYPE
        java.lang.Double.TYPE -> java.lang.Double.TYPE
        else -> MemorySegment::class.java
    }

    // endregion

    /**
     * Extracts a file from `natives/[name]` on the classpath and returns its absolute path, or null
     * when the resource isn't present. This library does not bundle the EOS SDK binaries itself
     * (they are owned by Epic Games); the application embedding this library is expected to ship
     * them as a classpath resource under `natives/`, e.g. `src/main/resources/natives/` in the app's
     * own build. Used for dependencies EOS loads by path rather than by linking, such as the Windows
     * RTC XAudio redistributable.
     */
    fun extractBundledFile(name: String): String? {
        extracted[name]?.let { return it }

        synchronized(extracted) {
            extracted[name]?.let { return it }

            val stream = Native::class.java.classLoader.getResourceAsStream("natives/$name")
                ?: return null

            val target = tempDir().resolve(name)
            stream.use { Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING) }

            val path = target.toAbsolutePath().toString()
            extracted[name] = path
            return path
        }
    }

    private fun loadNativeLibrary(): Long {
        // Prefer a system-installed SDK, then fall back to the platform native bundled by the
        // embedding application's resources. Neither path is ever backed by a copy of the EOS SDK
        // binary bundled in *this* library's own jar - that binary is owned by Epic Games and this
        // library never distributes it. Only NativeBridge's own shim (see NativeBridge.kt) is
        // allowed to ship inside this jar.
        val installed = listOf("EOSSDK", "EOSSDK-Win64-Shipping", "EOSSDK-Mac-Shipping", "EOSSDK-Linux-Shipping")
        for (name in installed) {
            try {
                val handle = NativeBridge.nOpenLibrary(name)
                if (handle != 0L) return handle
            } catch (_: UnsatisfiedLinkError) {
                // try next
            }
        }
        return extractBundledLibrary()
    }

    private fun extractBundledLibrary(): Long {
        val name = bundledLibraryName()
        val path = extractBundledFile(name) ?: error(
            "No EOS SDK native library '$name' found on the classpath under 'natives/$name', and no " +
                    "system-installed EOSSDK was found either. This library does not distribute the EOS " +
                    "SDK binaries (they are owned by Epic Games and covered by Epic's own license). The " +
                    "application embedding this library must supply '$name' as a classpath resource at " +
                    "'natives/$name' (for example, under 'src/main/resources/natives/' in the app's own " +
                    "build), or have the EOS SDK installed system-wide."
        )
        val handle = NativeBridge.nOpenLibrary(path)
        if (handle == 0L) error("Found '$name' at '$path' but the native loader failed to open it.")
        return handle
    }

    /** The bundled native library filename for the current OS. */
    private fun bundledLibraryName(): String {
        val os = System.getProperty("os.name").lowercase()
        return when {
            os.contains("win") -> "EOSSDK-Win64-Shipping.dll"
            os.contains("mac") || os.contains("darwin") -> "libEOSSDK-Mac-Shipping.dylib"
            else -> "libEOSSDK-Linux-Shipping.so"
        }
    }

    private fun tempDir(): Path {
        tempDir?.let { return it }

        synchronized(this) {
            tempDir?.let { return it }

            val dir = Files.createTempDirectory("eos-natives-")
            Runtime.getRuntime().addShutdownHook(
                Thread {
                    runCatching {
                        Files.walk(dir).sorted(Comparator.reverseOrder())
                            .forEach { Files.deleteIfExists(it) }
                    }
                }
            )
            tempDir = dir
            return dir
        }
    }
}
