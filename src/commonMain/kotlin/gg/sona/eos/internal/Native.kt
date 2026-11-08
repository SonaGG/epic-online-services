package gg.sona.eos.internal

import gg.sona.eos.internal.foreign.FunctionDescriptor
import gg.sona.eos.internal.foreign.MemoryLayout
import gg.sona.eos.internal.foreign.MemorySegment
import gg.sona.eos.internal.foreign.ValueLayout
import kotlin.concurrent.atomics.AtomicReference

internal class NativeFunction(private val address: Long, descriptor: FunctionDescriptor) {
    private val layouts = descriptor.argumentLayouts()
    private val returns = descriptor.returnValueLayout
    private val codes = ByteArray(layouts.size) { Native.code(layouts[it]) }
    private val returnCode = returns?.let(Native::code) ?: Native.VOID

    fun invokeExact(vararg args: Any?): Any? = invokeWithArguments(args.asList())

    fun invokeWithArguments(vararg args: Any?): Any? = invokeWithArguments(args.asList())

    fun invokeWithArguments(args: List<Any?>): Any? {
        require(args.size == layouts.size) { "Expected ${layouts.size} arguments, got ${args.size}" }
        val bits = LongArray(args.size) { Native.bits(layouts[it], args[it]) }
        val result = NativeBackend.call(address, codes, returnCode, bits)
        return returns?.let { Native.value(it, result) }
    }
}

internal object Native {
    const val BOOL: Byte = 0
    const val BYTE: Byte = 1
    const val SHORT: Byte = 2
    const val INT: Byte = 3
    const val LONG: Byte = 4
    const val FLOAT: Byte = 5
    const val DOUBLE: Byte = 6
    const val POINTER: Byte = 7
    const val VOID: Byte = 8

    private val library: Long = NativeBackend.openSdk()
    private val functions = AtomicReference(emptyMap<Pair<String, FunctionDescriptor>, NativeFunction>())

    fun code(layout: ValueLayout): Byte = when (layout) {
        is ValueLayout.OfByte -> BYTE
        is ValueLayout.OfShort, is ValueLayout.OfChar -> SHORT
        is ValueLayout.OfInt -> INT
        is ValueLayout.OfLong -> LONG
        is ValueLayout.OfFloat -> FLOAT
        is ValueLayout.OfDouble -> DOUBLE
        is ValueLayout.OfBoolean -> BOOL
        is ValueLayout.AddressLayout -> POINTER
        else -> POINTER
    }

    fun bits(layout: ValueLayout, value: Any?): Long = when (layout) {
        is ValueLayout.OfFloat -> (value as Float).toRawBits().toLong()
        is ValueLayout.OfDouble -> (value as Double).toRawBits()
        is ValueLayout.OfBoolean -> if (value as Boolean) 1L else 0L
        is ValueLayout.OfChar -> (value as Char).code.toLong()
        is ValueLayout.AddressLayout -> when (value) {
            null -> 0L
            is MemorySegment -> value.address()
            else -> (value as Number).toLong()
        }
        else -> (value as Number).toLong()
    }

    fun value(layout: ValueLayout, bits: Long): Any = when (layout) {
        is ValueLayout.OfByte -> bits.toByte()
        is ValueLayout.OfShort -> bits.toShort()
        is ValueLayout.OfChar -> bits.toInt().toChar()
        is ValueLayout.OfInt -> bits.toInt()
        is ValueLayout.OfLong -> bits
        is ValueLayout.OfFloat -> Float.fromBits(bits.toInt())
        is ValueLayout.OfDouble -> Double.fromBits(bits)
        is ValueLayout.OfBoolean -> bits.toInt() != 0
        is ValueLayout.AddressLayout -> MemorySegment.ofAddress(bits)
        else -> bits
    }

    fun downcall(name: String, descriptor: FunctionDescriptor): NativeFunction {
        val key = name to descriptor
        functions.load()[key]?.let { return it }
        val address = NativeBackend.findSymbol(library, name)
        if (address == 0L) throw IllegalStateException("EOS symbol $name not found in shared library")
        val function = NativeFunction(address, descriptor)
        while (true) {
            val current = functions.load()
            current[key]?.let { return it }
            if (functions.compareAndSet(current, current + (key to function))) return function
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> invoke(name: String, descriptor: FunctionDescriptor, vararg args: Any?): T =
        downcall(name, descriptor).invokeWithArguments(args.asList()) as T

    fun invokeVoid(name: String, args: List<Any?>, argLayouts: List<MemoryLayout>) {
        val layouts = argLayouts.map { it as ValueLayout }
        downcall(name, FunctionDescriptor.ofVoid(*layouts.toTypedArray())).invokeWithArguments(args)
    }

    fun invoke(name: String, args: List<Any?>, argLayouts: List<MemoryLayout>, returnLayout: ValueLayout): Any? {
        val layouts = argLayouts.map { it as ValueLayout }
        return downcall(name, FunctionDescriptor.of(returnLayout, *layouts.toTypedArray())).invokeWithArguments(args)
    }

    fun version(): String {
        val segment = downcall("EOS_GetVersion", FunctionDescriptor.of(ValueLayout.ADDRESS)).invokeExact() as MemorySegment
        return segment.reinterpret(Long.MAX_VALUE).getString(0)
    }

    fun extractBundledFile(name: String): String? = NativeBackend.extractBundledFile(name)
}
