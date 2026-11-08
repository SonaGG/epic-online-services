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
package gg.sona.eos.internal.foreign


/**
 * `java.lang.foreign.FunctionDescriptor`-compatible signature description.
 *
 * Must implement value equality: [gg.sona.eos.internal.Native] caches
 * downcall [java.lang.invoke.MethodHandle]s in a `HashMap` keyed by
 * `(symbol, descriptor)`.
 */
class FunctionDescriptor private constructor(
    private val returnLayout: ValueLayout?,
    private val argLayouts: List<ValueLayout>,
) {
    fun argumentLayouts(): List<ValueLayout> = argLayouts

    internal val returnValueLayout: ValueLayout? get() = returnLayout

    fun returnLayout(): JavaOptional<ValueLayout> = optionalOf(returnLayout)

    override fun equals(other: Any?): Boolean =
        other is FunctionDescriptor && other.returnLayout == returnLayout && other.argLayouts == argLayouts

    override fun hashCode(): Int = (returnLayout?.hashCode() ?: 0) * 31 + argLayouts.hashCode()

    companion object {
        fun of(returnLayout: ValueLayout, vararg args: ValueLayout): FunctionDescriptor =
            FunctionDescriptor(returnLayout, args.toList())

        fun ofVoid(vararg args: ValueLayout): FunctionDescriptor =
            FunctionDescriptor(null, args.toList())
    }
}
