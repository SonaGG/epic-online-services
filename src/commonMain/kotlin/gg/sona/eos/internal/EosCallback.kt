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

import gg.sona.eos.internal.foreign.MemorySegment

/**
 * The shape of a typical EOS callback: one argument which is a pointer to a
 * callback-info struct, no return value. Implementations extract the relevant
 * fields from the supplied [MemorySegment] and call the user's lambda.
 */
fun interface EosCallback {
    fun invoke(data: MemorySegment)
}
