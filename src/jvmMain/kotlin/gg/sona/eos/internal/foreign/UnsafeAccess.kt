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
package gg.sona.eos.internal.foreign

import sun.misc.Unsafe

/**
 * Reflective access to [sun.misc.Unsafe], used to back [MemorySegment]/[Arena]
 * with raw off-heap memory on Java 8+ (no `java.lang.foreign` available).
 *
 * `Unsafe`'s raw memory methods are marked for eventual removal by the JDK
 * (confirmed present but deprecated as of JDK 25); if a future JDK actually
 * removes them, this is the sole file that needs to migrate to an
 * alternative (e.g. `ByteBuffer.allocateDirect` + reflection).
 */
internal object UnsafeAccess {
    val unsafe: Unsafe = run {
        val field = Unsafe::class.java.getDeclaredField("theUnsafe")
        field.isAccessible = true
        field.get(null) as Unsafe
    }
}
