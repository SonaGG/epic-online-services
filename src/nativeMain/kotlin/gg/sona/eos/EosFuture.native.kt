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
package gg.sona.eos

import kotlin.concurrent.atomics.AtomicReference

actual class EosFuture<T> actual constructor() {
    private class Failure(val error: Throwable)

    private val state = AtomicReference<Any?>(Pending)
    private val listeners = AtomicReference(emptyList<(T?, Throwable?) -> Unit>())

    actual fun complete(value: T): Boolean = finish(value)

    actual fun completeExceptionally(ex: Throwable): Boolean = finish(Failure(ex))

    val isDone: Boolean get() = state.load() !== Pending

    @Suppress("UNCHECKED_CAST")
    fun getNow(): T = when (val current = state.load()) {
        Pending -> throw IllegalStateException("The EOS call is not complete")
        is Failure -> throw current.error
        else -> current as T
    }

    fun whenComplete(listener: (T?, Throwable?) -> Unit) {
        while (true) {
            val current = listeners.load()
            if (state.load() !== Pending) return notify(listener)
            if (listeners.compareAndSet(current, current + listener)) {
                if (state.load() !== Pending && listeners.compareAndSet(current + listener, current)) notify(listener)
                return
            }
        }
    }

    private fun finish(result: Any?): Boolean {
        if (!state.compareAndSet(Pending, result)) return false
        listeners.exchange(emptyList()).forEach(::notify)
        return true
    }

    @Suppress("UNCHECKED_CAST")
    private fun notify(listener: (T?, Throwable?) -> Unit) = when (val current = state.load()) {
        is Failure -> listener(null, current.error)
        else -> listener(current as T, null)
    }

    private object Pending
}
