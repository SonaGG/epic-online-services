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
package gg.sona.eos.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.BOOLEAN
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
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.SHORT
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.joinToCode
import java.io.File

private const val SDK = "gg.sona.eos.sdk"
private val ARENA = ClassName("gg.sona.eos.internal.foreign", "Arena")
private val VALUE_LAYOUT = ClassName("gg.sona.eos.internal.foreign", "ValueLayout")
private val RAW = ClassName("gg.sona.eos.internal", "RawMemory")
private val NATIVE = ClassName("gg.sona.eos.internal", "Native")
private val STUBS = ClassName("gg.sona.eos.internal", "CallbackStubs")
private val RESULT = ClassName("gg.sona.eos", "EosResult")
private val EXCEPTION = ClassName("gg.sona.eos", "EosException")
private val JVM_INLINE = ClassName("kotlin.jvm", "JvmInline")
private val IDS = mapOf(
    "EOS_ProductUserId" to ClassName("gg.sona.eos.common", "ProductUserId"),
    "EOS_EpicAccountId" to ClassName("gg.sona.eos.common", "EpicAccountId"),
    "EOS_ContinuanceToken" to ClassName("gg.sona.eos.common", "ContinuanceToken"),
)

class CMember(val type: String, val name: String, val count: Int?, val offset: Long, val union: List<CMember>?)

class CStruct(val name: String, val members: List<CMember>, val size: Long, val align: Long, val apiLatest: String?)

class CEnum(val name: String, val values: List<Pair<String, Long>>, val flags: Boolean)

class SdkModel(directory: File, private val headers: Headers) {
    private val raw = directory.listFiles { f -> f.extension == "h" || f.extension == "inl" }!!.sortedBy { it.name }.joinToString("\n") { it.readText() }
    private val text = raw.replace(Regex("""/\*.*?\*/""", RegexOption.DOT_MATCHES_ALL), "").replace(Regex("//[^\n]*"), "")

    val defines: Map<String, Long> = Regex("""#define\s+(EOS_\w+)\s+\(?\s*(-?(?:0x[0-9A-Fa-f]+|\d+))[uUlL]*\s*\)?\s*$""", RegexOption.MULTILINE)
        .findAll(text).associate { it.groupValues[1] to parse(it.groupValues[2]) }

    private val apiVersions: Map<String, String> = Regex("""EOS_STRUCT\(\s*(\w+)\s*,\s*\(\s*/\*\*\s*API Version: Set this to (\w+)""")
        .findAll(raw).associate { it.groupValues[1] to it.groupValues[2] }

    val callbacks: Map<String, String> = Regex("""EOS_DECLARE_CALLBACK\(\s*(\w+)\s*,\s*const\s+(\w+)\s*\*""").findAll(text)
        .associate { it.groupValues[1] to it.groupValues[2] }

    val enums: List<CEnum> = run {
        val flagged = Regex("""EOS_ENUM_BOOLEAN_OPERATORS\(\s*(\w+)\s*\)""").findAll(text).map { it.groupValues[1] }.toSet()
        val known = HashMap<String, Long>()
        Regex("""EOS_ENUM\(\s*(\w+)\s*,(.*?)\);""", RegexOption.DOT_MATCHES_ALL).findAll(text).map { match ->
            val name = match.groupValues[1]
            val values = match.groupValues[2].split(',').mapNotNull { entry ->
                val parts = entry.split('=').map { it.trim() }
                if (parts[0].isEmpty()) return@mapNotNull null
                val value = if (parts.size > 1) evaluate(parts[1], known) else (known.values.lastOrNull()?.plus(1) ?: 0)
                value?.let { parts[0] to it }?.also { known[it.first] = it.second }
            }
            CEnum(name, values, name in flagged)
        }.filter { it.name.startsWith("EOS_") && it.values.isNotEmpty() }.distinctBy { it.name }.toList()
    }

    private val enumNames = enums.map { it.name }.toSet() + "EOS_EResult"

    val structs: Map<String, CStruct> = LinkedHashMap<String, CStruct>().also { result ->
        val bodies = LinkedHashMap<String, String>()
        var index = 0
        val start = Regex("""EOS_STRUCT\(\s*(\w+)\s*,\s*\(""")
        while (true) {
            val match = start.find(text, index) ?: break
            var depth = 1
            var i = match.range.last + 1
            while (depth > 0) {
                when (text[i]) {
                    '(' -> depth++
                    ')' -> depth--
                }
                i++
            }
            bodies[match.groupValues[1]] = text.substring(match.range.last + 1, i - 1)
            index = i
        }
        val pending = HashSet<String>()
        fun layout(name: String): CStruct? {
            result[name]?.let { return it }
            val body = bodies[name] ?: return null
            if (!pending.add(name)) return null
            var offset = 0L
            var align = 1L
            val members = ArrayList<CMember>()
            for (declaration in declarations(body)) {
                val union = Regex("""^union\s*\{(.*)\}\s*(\w+)$""", RegexOption.DOT_MATCHES_ALL).find(declaration)
                if (union != null) {
                    val parts = declarations(union.groupValues[1]).map(::member)
                    val size = parts.maxOf { sizeOf(it.type, ::layout) * (it.count ?: 1) }
                    val unionAlign = parts.maxOf { alignOf(it.type, ::layout) }
                    offset = (offset + unionAlign - 1) / unionAlign * unionAlign
                    members += CMember("union", union.groupValues[2], null, offset, parts.map { CMember(it.type, it.name, it.count, offset, null) })
                    offset += size
                    align = maxOf(align, unionAlign)
                    continue
                }
                val member = member(declaration)
                val size = sizeOf(member.type, ::layout)
                val memberAlign = alignOf(member.type, ::layout)
                offset = (offset + memberAlign - 1) / memberAlign * memberAlign
                members += CMember(member.type, member.name, member.count, offset, null)
                offset += size * (member.count ?: 1)
                align = maxOf(align, memberAlign)
            }
            pending.remove(name)
            return CStruct(name, members, (offset + align - 1) / align * align, align, apiVersions[name]).also { result[name] = it }
        }
        for (name in bodies.keys) layout(name)
    }

    private fun declarations(body: String): List<String> {
        val parts = ArrayList<String>()
        var depth = 0
        val current = StringBuilder()
        for (c in body) {
            when (c) {
                '{' -> depth++
                '}' -> depth--
            }
            if (c == ';' && depth == 0) {
                current.toString().trim().takeIf { it.isNotEmpty() }?.let(parts::add)
                current.clear()
            } else current.append(c)
        }
        return parts.map { it.replace(Regex("\\s+"), " ") }
    }

    private fun member(text: String): CMember {
        val match = Regex("""^(.*?)\s*(\w+)\s*(?:\[\s*(\w+)\s*])?$""").find(text.trim()) ?: error("Bad member $text")
        val count = match.groupValues[3].ifEmpty { null }?.let { it.toIntOrNull() ?: defines[it]?.toInt() ?: error("Unknown size $it") }
        return CMember(match.groupValues[1].replace("const", "").trim(), match.groupValues[2], count, 0, null)
    }

    private fun sizeOf(type: String, layout: (String) -> CStruct?): Long {
        val clean = type.replace("const", "").trim()
        if ('*' in clean) return 8
        if (clean in enumNames) return 4
        layout(clean)?.let { return it.size }
        return when (headers.kind(clean)) { 'B' -> 1; 'S' -> 2; 'I', 'F' -> 4; else -> 8 }
    }

    private fun alignOf(type: String, layout: (String) -> CStruct?): Long {
        val clean = type.replace("const", "").trim()
        if ('*' in clean) return 8
        if (clean in enumNames) return 4
        layout(clean)?.let { return it.align }
        return sizeOf(clean, layout)
    }

    fun isEnum(type: String) = type in enumNames

    companion object {
        fun parse(text: String): Long = text.trim().lowercase().removeSuffix("ull").removeSuffix("ul").removeSuffix("u").removeSuffix("l").let {
            if (it.startsWith("-")) -parse(it.drop(1)) else if (it.startsWith("0x")) it.drop(2).toULong(16).toLong() else it.toLong()
        }

        fun evaluate(expression: String, known: Map<String, Long>): Long? {
            val text = expression.trim().removeSurrounding("(", ")").trim()
            if (text.contains('|')) return text.split('|').map { evaluate(it, known) ?: return null }.reduce(Long::or)
            if (text.contains("<<")) {
                val (a, b) = text.split("<<").map { evaluate(it, known) ?: return null }
                return a shl b.toInt()
            }
            return known[text] ?: runCatching { parse(text) }.getOrNull()
        }
    }
}

private fun kotlinName(cName: String) = cName.removePrefix("EOS_").replace("_", "")

private fun propertyName(cName: String): String {
    val base = if (cName.length > 1 && cName[0] == 'b' && cName[1].isUpperCase()) cName.drop(1) else cName
    return base.replaceFirstChar { it.lowercase() }
}

class SdkGenerator(private val model: SdkModel, private val headers: Headers, private val output: File) {
    private val handles = headers.functions.flatMap { listOf(it.returns) + it.params.map { p -> p.type } }
        .map { it.replace("const", "").trim() }.filter { it.startsWith("EOS_H") && '*' !in it }.toSortedSet()

    private fun file(name: String, build: FileSpec.Builder.() -> Unit) {
        FileSpec.builder(SDK, name)
            .addAnnotation(AnnotationSpec.builder(Suppress::class).useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).addMember("%S, %S, %S", "unused", "FunctionName", "PropertyName").build())
            .apply(build).build().writeLicensed(output)
    }

    fun run() {
        File(output, SDK.replace('.', '/')).deleteRecursively()
        writeEnums()
        writeStructs()
        writeHandles()
        println("Generated ${model.enums.size} enums, ${model.structs.size} structs, ${handles.size} handles")
    }

    private fun valueNames(values: List<String>): List<String> {
        if (values.size < 2) return values.map { kotlinName(it) }
        val split = values.map { it.split('_') }
        var common = 0
        while (split.all { it.size > common + 1 && it[common] == split[0][common] }) common++
        return split.map { parts -> parts.drop(common).joinToString("").let { if (it.first().isDigit()) "Value$it" else it } }
    }

    private fun writeEnums() = file("Enums") {
        for (enum in model.enums) {
            val cls = ClassName(SDK, kotlinName(enum.name))
            val type = TypeSpec.classBuilder(cls).addModifiers(KModifier.VALUE).addAnnotation(JVM_INLINE)
                .primaryConstructor(FunSpec.constructorBuilder().addParameter("value", INT).build())
                .addProperty(PropertySpec.builder("value", INT).initializer("value").build())
            if (enum.flags) {
                type.addFunction(FunSpec.builder("or").addModifiers(KModifier.INFIX).addParameter("other", cls).returns(cls).addStatement("return %T(value or other.value)", cls).build())
                type.addFunction(FunSpec.builder("and").addModifiers(KModifier.INFIX).addParameter("other", cls).returns(cls).addStatement("return %T(value and other.value)", cls).build())
                type.addFunction(FunSpec.builder("contains").addModifiers(KModifier.OPERATOR).addParameter("other", cls).returns(BOOLEAN).addStatement("return value and other.value == other.value").build())
            }
            val companion = TypeSpec.companionObjectBuilder()
            val used = HashSet<String>()
            for ((name, value) in valueNames(enum.values.map { it.first }).zip(enum.values.map { it.second })) {
                if (used.add(name)) companion.addProperty(PropertySpec.builder(name, cls).initializer("%T(%L)", cls, value.toInt()).build())
            }
            addType(type.addType(companion.build()).build())
        }
    }

    private sealed class Ref
    private class Prim(val kind: Char) : Ref()
    private object Bool : Ref()
    private object Result : Ref()
    private class Enum(val name: String) : Ref()
    private class Id(val type: ClassName) : Ref()
    private class Handle(val name: String) : Ref()
    private class Struct(val name: String) : Ref()
    private class StructPointer(val name: String) : Ref()
    private object Text : Ref()
    private object Pointer : Ref()

    private fun ref(type: String): Ref {
        val clean = type.replace("const", "").trim()
        val pointers = clean.count { it == '*' }
        val base = clean.replace("*", "").trim()
        if (pointers == 1 && base == "char") return Text
        if (pointers == 1 && base in model.structs) return StructPointer(base)
        if (pointers > 0) return Pointer
        if (base == "EOS_Bool") return Bool
        if (base == "EOS_EResult") return Result
        if (model.isEnum(base)) return Enum(base)
        IDS[base]?.let { return Id(it) }
        if (base in handles) return Handle(base)
        if (base in model.structs) return Struct(base)
        return when (val kind = headers.kind(base)) { 'V' -> Pointer; else -> if (kind == 'J' && !base.startsWith("int") && !base.startsWith("uint") && base != "EOS_NotificationId" && base != "size_t" && base != "EOS_UI_EventId") Pointer else Prim(kind) }
    }

    private fun typeOf(ref: Ref): TypeName = when (ref) {
        is Prim -> when (ref.kind) { 'B' -> BYTE; 'S' -> SHORT; 'I' -> INT; 'F' -> FLOAT; 'D' -> DOUBLE; else -> LONG }
        Bool -> BOOLEAN
        Result -> RESULT
        is Enum -> ClassName(SDK, kotlinName(ref.name))
        is Id -> ref.type
        is Handle -> ClassName(SDK, kotlinName(ref.name))
        is Struct -> ClassName(SDK, kotlinName(ref.name))
        is StructPointer -> ClassName(SDK, kotlinName(ref.name))
        Text -> STRING.copy(nullable = true)
        Pointer -> LONG
    }

    private fun access(kind: Char) = when (kind) { 'B' -> "Byte"; 'S' -> "Short"; 'I' -> "Int"; 'F' -> "Float"; 'D' -> "Double"; else -> "Long" }

    private fun read(ref: Ref, at: CodeBlock): CodeBlock = when (ref) {
        is Prim -> CodeBlock.of("%T.get%L(%L)", RAW, access(ref.kind), at)
        Bool -> CodeBlock.of("%T.getInt(%L) != 0", RAW, at)
        Result -> CodeBlock.of("%T.fromValue(%T.getInt(%L))", RESULT, RAW, at)
        is Enum -> CodeBlock.of("%T(%T.getInt(%L))", typeOf(ref), RAW, at)
        is Id, is Handle, is StructPointer -> CodeBlock.of("%T(%T.getLong(%L))", typeOf(ref), RAW, at)
        is Struct -> CodeBlock.of("%T(%L)", typeOf(ref), at)
        Text -> CodeBlock.of("%T.getLong(%L).let { if (it == 0L) null else %T.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }", RAW, at, ClassName("gg.sona.eos.internal.foreign", "MemorySegment"))
        Pointer -> CodeBlock.of("%T.getLong(%L)", RAW, at)
    }

    private fun write(ref: Ref, at: CodeBlock): CodeBlock = when (ref) {
        is Prim -> CodeBlock.of("%T.put%L(%L, value)", RAW, access(ref.kind), at)
        Bool -> CodeBlock.of("%T.putInt(%L, if (value) 1 else 0)", RAW, at)
        Result -> CodeBlock.of("%T.putInt(%L, value.value)", RAW, at)
        is Enum -> CodeBlock.of("%T.putInt(%L, value.value)", RAW, at)
        is Id -> CodeBlock.of("%T.putLong(%L, value.raw)", RAW, at)
        is Handle -> CodeBlock.of("%T.putLong(%L, value.handle)", RAW, at)
        is StructPointer -> CodeBlock.of("%T.putLong(%L, value.address)", RAW, at)
        is Struct -> CodeBlock.of("%T.copy(value.address, %L, %T.SIZE)", RAW, at, typeOf(ref))
        Text -> CodeBlock.of("%T.putLong(%L, if (value == null) 0L else arena.allocateFrom(value).address())", RAW, at)
        Pointer -> CodeBlock.of("%T.putLong(%L, value)", RAW, at)
    }

    private fun at(offset: Long) = if (offset == 0L) CodeBlock.of("address") else CodeBlock.of("address + %L", offset)

    private fun writeStructs() {
        model.structs.values.chunked(100).forEachIndexed { chunk, structs ->
            file("Structs$chunk") {
                for (struct in structs) {
                    val cls = ClassName(SDK, kotlinName(struct.name))
                    val type = TypeSpec.classBuilder(cls).addModifiers(KModifier.VALUE).addAnnotation(JVM_INLINE)
                        .primaryConstructor(FunSpec.constructorBuilder().addParameter("address", LONG).build())
                        .addProperty(PropertySpec.builder("address", LONG).initializer("address").build())
                    val used = HashSet<String>()
                    for (member in struct.members.flatMap { it.union ?: listOf(it) }) {
                        if (member.name == "ApiVersion") continue
                        val name = propertyName(member.name).let { if (used.add(it)) it else member.name }
                        if (member.count != null) {
                            if (member.type == "char") type.addProperty(
                                PropertySpec.builder(name, STRING).getter(
                                    FunSpec.getterBuilder().addStatement("return %T.ofAddress(%L).reinterpret(%L).getString(0)", ClassName("gg.sona.eos.internal.foreign", "MemorySegment"), at(member.offset), member.count).build()
                                ).build()
                            ) else type.addProperty(PropertySpec.builder("${name}Address", LONG).getter(FunSpec.getterBuilder().addStatement("return %L", at(member.offset)).build()).build())
                            continue
                        }
                        val ref = ref(member.type)
                        val property = PropertySpec.builder(name, typeOf(ref)).getter(FunSpec.getterBuilder().addStatement("return %L", read(ref, at(member.offset))).build())
                        if (ref !is Struct) {
                            property.mutable(true).setter(FunSpec.setterBuilder().addParameter("value", typeOf(ref)).addStatement("%L", write(ref, at(member.offset))).build())
                            if (ref === Text) property.contextParameter("arena", ARENA)
                        }
                        type.addProperty(property.build())
                    }
                    val allocate = FunSpec.builder("allocate").contextParameter("arena", ARENA).returns(cls)
                        .addStatement("val struct = %T(arena.allocate(SIZE).address())", cls)
                    val version = struct.apiLatest?.let { model.defines[it] }
                    if (version != null && struct.members.firstOrNull()?.name == "ApiVersion") allocate.addStatement("%T.putInt(struct.address, %L)", RAW, version)
                    allocate.addStatement("return struct")
                    type.addType(
                        TypeSpec.companionObjectBuilder()
                            .addProperty(PropertySpec.builder("SIZE", LONG, KModifier.CONST).initializer("%L", struct.size).build())
                            .addProperty(PropertySpec.builder("NULL", cls).initializer("%T(0)", cls).build())
                            .addFunction(allocate.build())
                            .build()
                    )
                    addType(type.build())
                    addFunction(
                        FunSpec.builder(kotlinName(struct.name)).addModifiers(KModifier.INLINE).contextParameter("arena", ARENA)
                            .addParameter(ParameterSpec.builder("block", LambdaTypeName.get(cls, emptyList(), UNIT)).defaultValue("{}").build())
                            .returns(cls).addStatement("return %T.allocate().apply(block)", cls).build()
                    )
                }
            }
        }
    }

    private fun layoutOf(ref: Ref): CodeBlock = when {
        ref is Prim && ref.kind == 'B' -> CodeBlock.of("%T.JAVA_BYTE", VALUE_LAYOUT)
        ref is Prim && ref.kind == 'S' -> CodeBlock.of("%T.JAVA_SHORT", VALUE_LAYOUT)
        ref is Prim && ref.kind == 'I' || ref === Bool || ref === Result || ref is Enum -> CodeBlock.of("%T.JAVA_INT", VALUE_LAYOUT)
        ref is Prim && ref.kind == 'F' -> CodeBlock.of("%T.JAVA_FLOAT", VALUE_LAYOUT)
        ref is Prim && ref.kind == 'D' -> CodeBlock.of("%T.JAVA_DOUBLE", VALUE_LAYOUT)
        else -> CodeBlock.of("%T.JAVA_LONG", VALUE_LAYOUT)
    }

    private fun pass(ref: Ref, name: String): CodeBlock = when (ref) {
        Bool -> CodeBlock.of("if (%N) 1 else 0", name)
        Result, is Enum -> CodeBlock.of("%N.value", name)
        is Id -> CodeBlock.of("%N.raw", name)
        is Handle -> CodeBlock.of("%N.handle", name)
        is StructPointer -> CodeBlock.of("%N.address", name)
        Text -> CodeBlock.of("if (%N == null) 0L else arena.allocateFrom(%N).address()", name, name)
        else -> CodeBlock.of("%N", name)
    }

    private fun value(ref: Ref, raw: CodeBlock): CodeBlock = when (ref) {
        is Prim -> when (ref.kind) { 'B' -> CodeBlock.of("(%L as Byte)", raw); 'S' -> CodeBlock.of("(%L as Short)", raw); 'I' -> CodeBlock.of("(%L as Int)", raw); 'F' -> CodeBlock.of("(%L as Float)", raw); 'D' -> CodeBlock.of("(%L as Double)", raw); else -> CodeBlock.of("(%L as Long)", raw) }
        Bool -> CodeBlock.of("(%L as Int) != 0", raw)
        Result -> CodeBlock.of("%T.fromValue(%L as Int)", RESULT, raw)
        is Enum -> CodeBlock.of("%T(%L as Int)", typeOf(ref), raw)
        is Id, is Handle, is StructPointer -> CodeBlock.of("%T(%L as Long)", typeOf(ref), raw)
        Text -> CodeBlock.of("(%L as Long).let { if (it == 0L) null else %T.ofAddress(it).reinterpret(Long.MAX_VALUE).getString(0) }", raw, ClassName("gg.sona.eos.internal.foreign", "MemorySegment"))
        else -> CodeBlock.of("(%L as Long)", raw)
    }

    private fun method(function: CFunction, receiver: String?): FunSpec? {
        val params = if (receiver != null) function.params.drop(1) else function.params
        val interfaceName = receiver?.removePrefix("EOS_H")
        val base = function.name.removePrefix("EOS_").let { name -> interfaceName?.let { name.removePrefix("${it}_") } ?: name }
        val spec = FunSpec.builder(base.replace("_", "").replaceFirstChar { it.lowercase() })
        val args = ArrayList<CodeBlock>()
        val layouts = ArrayList<CodeBlock>()
        if (receiver != null) {
            args += CodeBlock.of("handle")
            layouts += CodeBlock.of("%T.JAVA_LONG", VALUE_LAYOUT)
        }
        val before = ArrayList<CodeBlock>()
        var stack = false
        var out: Pair<Ref, String>? = null
        val clientData = params.indexOfFirst { it.name == "ClientData" }
        val buffer = params.indexOfFirst { it.name == "OutBuffer" && it.type.replace("const", "").trim() == "char*" }
            .takeIf { it >= 0 && params.getOrNull(it + 1)?.name == "InOutBufferLength" }
        val outs = params.filter { it.name.startsWith("Out") && '*' in it.type }.takeIf { buffer == null }.orEmpty()
        for ((index, param) in params.withIndex()) {
            val name = propertyName(param.name)
            val clean = param.type.replace("const", "").trim()
            when {
                buffer != null && index == buffer -> {
                    stack = true
                    args += CodeBlock.of("text")
                    layouts += CodeBlock.of("%T.ADDRESS", VALUE_LAYOUT)
                }
                buffer != null && index == buffer + 1 -> {
                    args += CodeBlock.of("length")
                    layouts += CodeBlock.of("%T.ADDRESS", VALUE_LAYOUT)
                }
                index == clientData -> {
                    args += CodeBlock.of("0L")
                    layouts += CodeBlock.of("%T.ADDRESS", VALUE_LAYOUT)
                }
                clientData >= 0 && clean in model.callbacks -> {
                    val info = ClassName(SDK, kotlinName(model.callbacks.getValue(clean)))
                    val once = "Complete" in clean
                    val resultFirst = model.structs[model.callbacks.getValue(clean)]?.members?.firstOrNull()?.type == "EOS_EResult"
                    spec.addParameter(name, LambdaTypeName.get(null, listOf(ParameterSpec.unnamed(info)), UNIT))
                    before += CodeBlock.of("var stubId = 0L")
                    before += CodeBlock.of(
                        "val stub = %T.register { data -> val info = %T(data.address()); %N(info)%L }", STUBS, info, name,
                        if (once && resultFirst) CodeBlock.of("; if (info.resultCode != %T.OperationWillRetry) %T.release(stubId)", RESULT, STUBS) else if (once) CodeBlock.of("; %T.release(stubId)", STUBS) else CodeBlock.of(""),
                    )
                    before += CodeBlock.of("stubId = stub.id")
                    args += CodeBlock.of("stub.segment.address()")
                    layouts += CodeBlock.of("%T.ADDRESS", VALUE_LAYOUT)
                }
                outs.size == 1 && param === outs[0] && param.type.count { it == '*' } in 1..2 && ref(clean.removeSuffix("*").trim()) !is Struct -> {
                    val target = ref(clean.removeSuffix("*").trim())
                    out = target to name
                    stack = true
                    before += CodeBlock.of("val out = arena.allocate(8).address()")
                    args += CodeBlock.of("out")
                    layouts += CodeBlock.of("%T.ADDRESS", VALUE_LAYOUT)
                }
                else -> {
                    val ref = ref(param.type)
                    if (ref === Text) stack = true
                    spec.addParameter(name, typeOf(ref))
                    args += pass(ref, name)
                    layouts += layoutOf(ref)
                }
            }
        }
        val ret = if (function.returns == "void") null else ref(function.returns)
        val call = if (ret == null) CodeBlock.of("%T.invokeVoid(%S, listOf(%L), listOf(%L))", NATIVE, function.name, args.joinToCode(", "), layouts.joinToCode(", "))
        else CodeBlock.of("%T.invoke(%S, listOf(%L), listOf(%L), %L)", NATIVE, function.name, args.joinToCode(", "), layouts.joinToCode(", "), layoutOf(ret))
        val body = CodeBlock.builder()
        if (stack) body.beginControlFlow("return %T.ofConfined().use { arena ->", ARENA)
        before.forEach { body.addStatement("%L", it) }
        val output = out
        if (buffer != null && ret === Result) {
            spec.returns(STRING)
            body.addStatement("var size = 256")
            body.addStatement("var text: Long")
            body.addStatement("var result: %T", RESULT)
            body.beginControlFlow("do")
            body.addStatement("text = arena.allocate(size.toLong()).address()")
            body.addStatement("val length = arena.allocate(4).address()")
            body.addStatement("%T.putInt(length, size)", RAW)
            body.addStatement("result = %L", value(Result, call))
            body.addStatement("val retry = result == %T.LimitExceeded && %T.getInt(length) > size", RESULT, RAW)
            body.addStatement("if (retry) size = %T.getInt(length)", RAW)
            body.endControlFlow()
            body.addStatement("while (retry)")
            body.addStatement("if (result != %T.Success) throw %T(result)", RESULT, EXCEPTION)
            body.addStatement("%T.ofAddress(text).reinterpret(size.toLong()).getString(0)", ClassName("gg.sona.eos.internal.foreign", "MemorySegment"))
            body.endControlFlow()
            return spec.addCode(body.build()).build()
        }
        when {
            output != null -> {
                val (target, _) = output
                if (ret === Result) body.addStatement("val result = %L", value(Result, call)).addStatement("if (result != %T.Success) throw %T(result)", RESULT, EXCEPTION)
                else body.addStatement("%L", call)
                val read = when (target) {
                    is Struct -> CodeBlock.of("%T(out)", typeOf(target))
                    else -> read(target, CodeBlock.of("out"))
                }
                spec.returns(if (target is Struct) typeOf(target) else typeOf(target))
                body.addStatement("${if (stack) "" else "return "}%L", read)
            }
            ret == null -> body.addStatement("%L", call)
            else -> {
                spec.returns(typeOf(ret))
                body.addStatement("${if (stack) "" else "return "}%L", value(ret, call))
            }
        }
        if (stack) body.endControlFlow()
        return spec.addCode(body.build()).build()
    }

    private fun writeHandles() = file("Handles") {
        val byReceiver = headers.functions.groupBy { function ->
            function.params.firstOrNull()?.type?.replace("const", "")?.trim()?.takeIf { it in handles }
        }
        for (handle in handles) {
            val cls = ClassName(SDK, kotlinName(handle))
            addType(
                TypeSpec.classBuilder(cls).addModifiers(KModifier.VALUE).addAnnotation(JVM_INLINE)
                    .primaryConstructor(FunSpec.constructorBuilder().addParameter("handle", LONG).build())
                    .addProperty(PropertySpec.builder("handle", LONG).initializer("handle").build())
                    .addFunctions(byReceiver[handle].orEmpty().mapNotNull { method(it, handle) }.distinctBy { it.name + it.parameters.size })
                    .addType(TypeSpec.companionObjectBuilder().addProperty(PropertySpec.builder("NULL", cls).initializer("%T(0)", cls).build()).build())
                    .build()
            )
        }
        addType(
            TypeSpec.objectBuilder("EosSdk")
                .addFunctions(byReceiver[null].orEmpty().mapNotNull { method(it, null) }.distinctBy { it.name + it.parameters.size })
                .build()
        )
    }
}
