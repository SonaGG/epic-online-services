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
package gg.sona.eos.internal.foreign.jni

import gg.sona.eos.internal.CallbackStubs
import java.nio.file.Files
import java.nio.file.StandardCopyOption

/**
 * The small, generic native surface implemented by the `eos-jni` Rust crate
 * (see `native/eos-jni`), backing [gg.sona.eos.internal.Native]'s downcalls
 * and (in a later migration stage) callback trampolines.
 *
 * Unlike the EOS SDK binary itself - which this library never bundles, see
 * the loader in [gg.sona.eos.internal.Native] - this shim is our own
 * Apache-2.0 code with no third-party IP, so it is safe to bundle directly
 * inside this library's own jar under `natives/jni/<platform>/<file>`. Do
 * not conflate these two loaders: one is legally forbidden from shipping in
 * this jar, the other is expected to.
 */
internal object NativeBridge {
    init {
        loadShimLibrary()
    }

    // @JvmStatic is required here, not just idiomatic: these are native methods, and this file's
    // Rust counterpart (native/eos-jni) declares each JNI entry point with the static-method
    // signature (JNIEnv*, jclass, ...args) rather than the instance-method one (JNIEnv*, jobject,
    // ...args). Native.kt's MethodHandle assembly also specifically looks these up via
    // MethodHandles.Lookup.findStatic, which requires a real static method, not a Kotlin `object`'s
    // default instance-method-on-a-singleton shape.
    @JvmStatic external fun nOpenLibrary(name: String): Long
    @JvmStatic external fun nCloseLibrary(handle: Long)
    @JvmStatic external fun nFindSymbol(handle: Long, name: String): Long
    @JvmStatic external fun nCall(fnPtr: Long, argTypeCodes: ByteArray, retTypeCode: Byte, argBits: LongArray): Long

    /** Creates a native `void(*)(void*)` callback trampoline; returns its callable C function pointer. */
    @JvmStatic external fun nCreateClosure(closureId: Long): Long

    /** Frees a closure previously created by [nCreateClosure]. */
    @JvmStatic external fun nDestroyClosure(closureId: Long)

    /**
     * Fixed JNI callback target: the `eos-jni` Rust crate's closure
     * trampoline (see `closure.rs`) calls this directly via
     * `CallStaticVoidMethod` from whatever native thread EOS invoked the
     * callback on. Looks up the registered [gg.sona.eos.internal.EosCallback]
     * for [closureId] in [gg.sona.eos.internal.CallbackStubs] and invokes it.
     */
    @Suppress("unused")
    @JvmStatic
    fun dispatchCallback(closureId: Long, callbackInfoPtr: Long) {
        CallbackStubs.dispatch(closureId, callbackInfoPtr)
    }

    private fun loadShimLibrary() {
        // Dev/test escape hatch, used before the Gradle build wires up
        // automatic cargo-build-and-copy: point straight at a locally built
        // `cargo build --release` output. Real consumers never need this;
        // the classpath-resource path below is what a published jar uses.
        System.getProperty("eos.jni.shimPath")?.let {
            System.load(it)
            return
        }

        val fileName = platformShimFileName()
        val resourcePath = "natives/jni/${platformDir()}/$fileName"
        val stream = NativeBridge::class.java.classLoader.getResourceAsStream(resourcePath)
            ?: error(
                "eos-jni native shim '$resourcePath' was not found on the classpath. Unlike the EOS " +
                        "SDK binary, this shim is this library's own code and should always be bundled " +
                        "by its own build - this indicates a packaging problem, not a missing " +
                        "externally-supplied dependency."
            )

        val dir = Files.createTempDirectory("eos-jni-shim-")
        val target = dir.resolve(fileName)
        stream.use { Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING) }
        Runtime.getRuntime().addShutdownHook(
            Thread {
                runCatching {
                    Files.deleteIfExists(target)
                    Files.deleteIfExists(dir)
                }
            }
        )
        System.load(target.toAbsolutePath().toString())
    }

    private fun platformDir(): String {
        val os = System.getProperty("os.name").lowercase()
        val arch = System.getProperty("os.arch").lowercase()
        val osKey = when {
            os.contains("win") -> "windows"
            os.contains("mac") || os.contains("darwin") -> "macos"
            else -> "linux"
        }
        val archKey = if (arch.contains("aarch64") || arch.contains("arm64")) "aarch64" else "x86_64"
        return "$osKey-$archKey"
    }

    private fun platformShimFileName(): String {
        val os = System.getProperty("os.name").lowercase()
        return when {
            os.contains("win") -> "eos_jni.dll"
            os.contains("mac") || os.contains("darwin") -> "libeos_jni.dylib"
            else -> "libeos_jni.so"
        }
    }
}
