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

actual typealias JavaClass<T> = java.lang.Class<T>

actual typealias JavaOptional<T> = java.util.Optional<T>

internal actual fun <T : Any> optionalOf(value: T?): JavaOptional<T> = java.util.Optional.ofNullable(value)

internal actual object Carriers {
    actual val byte: JavaClass<*> = java.lang.Byte.TYPE
    actual val short: JavaClass<*> = java.lang.Short.TYPE
    actual val char: JavaClass<*> = Character.TYPE
    actual val int: JavaClass<*> = Integer.TYPE
    actual val long: JavaClass<*> = java.lang.Long.TYPE
    actual val float: JavaClass<*> = java.lang.Float.TYPE
    actual val double: JavaClass<*> = java.lang.Double.TYPE
    actual val boolean: JavaClass<*> = java.lang.Boolean.TYPE
    actual val address: JavaClass<*> = MemorySegment::class.java
}
