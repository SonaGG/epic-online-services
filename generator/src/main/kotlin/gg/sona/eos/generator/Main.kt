package gg.sona.eos.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.BYTE
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.LONG_ARRAY
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.SHORT
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.joinToCode
import java.io.File

private const val PACKAGE = "gg.sona.eos.internal"
private const val TRAMPOLINES = 2048
private val C_FUNCTION = ClassName("kotlinx.cinterop", "CFunction")
private val C_OPAQUE_POINTER = ClassName("kotlinx.cinterop", "COpaquePointer")
private val TO_C_POINTER = MemberName("kotlinx.cinterop", "toCPointer", isExtension = true)
private val TO_LONG = MemberName("kotlinx.cinterop", "toLong", isExtension = true)
private val INVOKE = MemberName("kotlinx.cinterop", "invoke", isExtension = true)
private val STATIC_C_FUNCTION = MemberName("kotlinx.cinterop", "staticCFunction")

fun main(args: Array<String>) {
    val headers = Headers(File(args[0]))
    val output = File(args[1])
    writeInvokers(headers, output)
    writeTrampolines(output)
    println("Generated ${headers.functions.size} functions with ${headers.functions.map(headers::signature).toSet().size} signatures")
}

private fun file(name: String, output: File, build: FileSpec.Builder.() -> Unit) {
    FileSpec.builder(PACKAGE, name)
        .addAnnotation(AnnotationSpec.builder(Suppress::class).useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).addMember("%S", "unused").build())
        .apply(build)
        .build()
        .writeTo(output)
}

private fun type(kind: Char): TypeName = when (kind) {
    'B' -> BYTE; 'S' -> SHORT; 'I' -> INT; 'J' -> LONG; 'F' -> FLOAT; 'D' -> DOUBLE; else -> UNIT
}

private fun argument(kind: Char, index: Int): CodeBlock = when (kind) {
    'B' -> CodeBlock.of("bits[%L].toByte()", index)
    'S' -> CodeBlock.of("bits[%L].toShort()", index)
    'I' -> CodeBlock.of("bits[%L].toInt()", index)
    'F' -> CodeBlock.of("Float.fromBits(bits[%L].toInt())", index)
    'D' -> CodeBlock.of("Double.fromBits(bits[%L])", index)
    else -> CodeBlock.of("bits[%L]", index)
}

private fun result(kind: Char, call: CodeBlock): CodeBlock = when (kind) {
    'V' -> CodeBlock.of("%L.let { 0L }", call)
    'F' -> CodeBlock.of("%L.toRawBits().toLong()", call)
    'D' -> CodeBlock.of("%L.toRawBits()", call)
    'J' -> call
    else -> CodeBlock.of("%L.toLong()", call)
}

private fun writeInvokers(headers: Headers, output: File) = file("Invokers", output) {
    val signatures = (headers.functions.map(headers::signature) + "_J").toSortedSet()
    val function = FunSpec.builder("invokeNative").addModifiers(KModifier.INTERNAL)
        .addParameter("signature", STRING).addParameter("function", LONG).addParameter("bits", LONG_ARRAY).returns(LONG)
        .beginControlFlow("return when (signature)")
    for (signature in signatures) {
        val params = signature.substringBefore('_')
        val ret = signature.substringAfter('_').single()
        val pointer = C_FUNCTION.parameterizedBy(LambdaTypeName.get(null, params.map { ParameterSpec.unnamed(type(it)) }, type(ret)))
        val call = CodeBlock.of("function.%M<%T>()!!.%M(%L)", TO_C_POINTER, pointer, INVOKE, params.mapIndexed { i, kind -> argument(kind, i) }.joinToCode(", "))
        function.addStatement("%S -> %L", signature, result(ret, call))
    }
    function.addStatement("else -> throw UnsupportedOperationException(%P)", "No native invoker for the signature \$signature")
    addFunction(function.endControlFlow().build())
}

private fun writeTrampolines(output: File) = file("Trampolines", output) {
    for (slot in 0 until TRAMPOLINES) {
        addFunction(
            FunSpec.builder("trampoline$slot").addModifiers(KModifier.PRIVATE)
                .addParameter("data", C_OPAQUE_POINTER.copy(nullable = true))
                .addStatement("dispatchTrampoline(%L, data.%M())", slot, TO_LONG)
                .build()
        )
    }
    addProperty(
        com.squareup.kotlinpoet.PropertySpec.builder("TRAMPOLINE_COUNT", INT, KModifier.INTERNAL, KModifier.CONST).initializer("%L", TRAMPOLINES).build()
    )
    val address = FunSpec.builder("trampolineAddress").addModifiers(KModifier.INTERNAL).addParameter("slot", INT).returns(LONG)
        .beginControlFlow("return when (slot)")
    for (slot in 0 until TRAMPOLINES) address.addStatement("%L -> %M(::%N).%M()", slot, STATIC_C_FUNCTION, "trampoline$slot", TO_LONG)
    address.addStatement("else -> throw IndexOutOfBoundsException(%P)", "No trampoline \$slot")
    addFunction(address.endControlFlow().build())
}
