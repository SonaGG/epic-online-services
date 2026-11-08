package gg.sona.eos.internal

internal expect object NativeBackend {
    val isWindows: Boolean

    fun openSdk(): Long

    fun findSymbol(library: Long, name: String): Long

    fun call(function: Long, argumentCodes: ByteArray, returnCode: Byte, argumentBits: LongArray): Long

    fun createClosure(id: Long): Long

    fun destroyClosure(id: Long)

    fun extractBundledFile(name: String): String?
}

internal expect object RawMemory {
    fun getByte(address: Long): Byte
    fun putByte(address: Long, value: Byte)
    fun getShort(address: Long): Short
    fun putShort(address: Long, value: Short)
    fun getChar(address: Long): Char
    fun putChar(address: Long, value: Char)
    fun getInt(address: Long): Int
    fun putInt(address: Long, value: Int)
    fun getLong(address: Long): Long
    fun putLong(address: Long, value: Long)
    fun getFloat(address: Long): Float
    fun putFloat(address: Long, value: Float)
    fun getDouble(address: Long): Double
    fun putDouble(address: Long, value: Double)
    fun allocate(size: Long): Long
    fun free(address: Long)
    fun copy(from: Long, to: Long, size: Long)
    fun getBytes(address: Long, into: ByteArray, offset: Int, length: Int)
    fun putBytes(address: Long, from: ByteArray, offset: Int, length: Int)
}
