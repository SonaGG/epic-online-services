package gg.sona.eos.internal.foreign

expect class JavaClass<T>

expect class JavaOptional<T>

internal expect fun <T : Any> optionalOf(value: T?): JavaOptional<T>

internal expect object Carriers {
    val byte: JavaClass<*>
    val short: JavaClass<*>
    val char: JavaClass<*>
    val int: JavaClass<*>
    val long: JavaClass<*>
    val float: JavaClass<*>
    val double: JavaClass<*>
    val boolean: JavaClass<*>
    val address: JavaClass<*>
}
