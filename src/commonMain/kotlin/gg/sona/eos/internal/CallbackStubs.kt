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

import gg.sona.eos.internal.foreign.MemorySegment
import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.fetchAndIncrement

/**
 * Holds registered callbacks and their native-callable function pointers
 * (closures created by the `eos-jni` Rust crate; see `closure.rs`).
 *
 * The Rust closure retains the trampoline's executable memory for the
 * lifetime of a subscription and invokes it from arbitrary threads (EOS's
 * own tick/IO threads). This registry keeps the corresponding
 * [EosCallback] reachable - and calls [NativeBridge.nDestroyClosure] to
 * free the trampoline - until [release] is called.
 *
 * Unlike the FFM-based version this replaced, native code here never holds
 * a `java.lang.invoke.MethodHandle` at all: the Rust trampoline calls a
 * single fixed static dispatcher ([NativeBridge.dispatchCallback]), which
 * looks the callback up here by id and invokes it directly. This is a real
 * simplification, not just an API swap - the previous
 * `unreflect`/`asType`/`filterArguments`/`catchException` MethodHandle
 * chain existed purely so FFM's `upcallStub` had something to link
 * against, and none of it is needed anymore.
 */
internal object CallbackStubs {
    private val entries = AtomicReference(emptyMap<Long, Entry>())
    private val nextId = AtomicLong(1L shl 60)

    private class Entry(val callback: EosCallback, val closureFnPtr: Long)

    /** Register an [EosCallback] as a C-callable function pointer. */
    fun register(callback: EosCallback): StubHandle {
        val id = nextId.fetchAndIncrement()
        val fnPtr = NativeBackend.createClosure(id)
        update { it + (id to Entry(callback, fnPtr)) }
        return StubHandle(id, MemorySegment.ofAddress(fnPtr))
    }

    fun release(id: Long) {
        var removed: Entry? = null
        update { current -> removed = current[id]; current - id }
        if (removed != null) NativeBackend.destroyClosure(id)
    }

    fun getStubSegment(id: Long): MemorySegment? = entries.load()[id]?.let { MemorySegment.ofAddress(it.closureFnPtr) }

    fun releaseAll() {
        val toClose = entries.load().keys.toList()
        toClose.forEach { release(it) }
    }

    /**
     * Invoked by [NativeBridge.dispatchCallback] on whatever native thread
     * EOS called the trampoline from.
     *
     * A Java exception thrown while a callback runs must never be allowed
     * to propagate back into native code - the trampoline's C frame (owned
     * by EOS/libffi) has no way to handle it, and in practice letting one
     * escape corrupts the call stack rather than failing cleanly at the
     * throw site. Every callback is therefore guarded so exceptions are
     * caught and logged here instead.
     */
    internal fun dispatch(closureId: Long, callbackInfoPtr: Long) {
        val entry = entries.load()[closureId] ?: return
        try {
            entry.callback.invoke(MemorySegment.ofAddress(callbackInfoPtr).reinterpret(Long.MAX_VALUE))
        } catch (t: Throwable) {
            logUpcallException(t)
        }
    }

    private fun logUpcallException(t: Throwable) {
        println(
            "[eos] Uncaught exception in a native callback was suppressed to avoid crossing " +
                    "back into native code (undefined behavior) and crashing the JVM:"
        )
        println(t.stackTraceToString())
    }

    private inline fun update(transform: (Map<Long, Entry>) -> Map<Long, Entry>) {
        while (true) {
            val current = entries.load()
            if (entries.compareAndSet(current, transform(current))) return
        }
    }
}
