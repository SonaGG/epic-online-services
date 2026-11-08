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
