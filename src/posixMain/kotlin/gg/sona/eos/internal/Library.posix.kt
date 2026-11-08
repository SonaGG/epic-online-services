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
