package gg.sona.eos.internal

import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.toLong
import platform.windows.GetProcAddress
import platform.windows.HINSTANCE__
import platform.windows.LoadLibraryW

internal actual fun openLibrary(name: String): Long = LoadLibraryW(name).toLong()

internal actual fun librarySymbol(library: Long, name: String): Long = GetProcAddress(library.toCPointer<HINSTANCE__>(), name).toLong()
