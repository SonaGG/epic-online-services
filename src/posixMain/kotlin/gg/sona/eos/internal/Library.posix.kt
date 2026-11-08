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

import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.toLong
import kotlinx.cinterop.CPointed
import platform.posix.RTLD_LOCAL
import platform.posix.RTLD_NOW
import platform.posix.dlopen
import platform.posix.dlsym

internal actual fun openLibrary(name: String): Long = dlopen(name, RTLD_NOW or RTLD_LOCAL).toLong()

internal actual fun librarySymbol(library: Long, name: String): Long = dlsym(library.toCPointer<CPointed>(), name).toLong()
