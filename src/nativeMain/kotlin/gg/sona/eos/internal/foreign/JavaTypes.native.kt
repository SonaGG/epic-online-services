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
