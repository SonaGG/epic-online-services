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

actual class JavaClass<T> internal constructor(val name: String)

actual class JavaOptional<T> internal constructor(private val value: T?) {
    val isPresent: Boolean get() = value != null

    fun get(): T = value ?: throw NoSuchElementException("No value present")
}

internal actual fun <T : Any> optionalOf(value: T?): JavaOptional<T> = JavaOptional(value)

internal actual object Carriers {
    actual val byte: JavaClass<*> = JavaClass<Byte>("byte")
    actual val short: JavaClass<*> = JavaClass<Short>("short")
    actual val char: JavaClass<*> = JavaClass<Char>("char")
    actual val int: JavaClass<*> = JavaClass<Int>("int")
    actual val long: JavaClass<*> = JavaClass<Long>("long")
    actual val float: JavaClass<*> = JavaClass<Float>("float")
    actual val double: JavaClass<*> = JavaClass<Double>("double")
    actual val boolean: JavaClass<*> = JavaClass<Boolean>("boolean")
    actual val address: JavaClass<*> = JavaClass<MemorySegment>("address")
}
