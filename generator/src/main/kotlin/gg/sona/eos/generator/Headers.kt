package gg.sona.eos.generator

import java.io.File

class CParam(val type: String, val name: String)

class CFunction(val name: String, val returns: String, val params: List<CParam>)

class Headers(directory: File) {
    private val text = directory.listFiles { file -> file.extension == "h" || file.extension == "inl" }!!.sortedBy { it.name }.joinToString("\n") { strip(it.readText()) }

    val functions: List<CFunction> = Regex("""EOS_DECLARE_FUNC\(([^)]*)\)\s*(\w+)\s*\(([^)]*)\)\s*;""").findAll(text).map { match ->
        val (returns, name, params) = match.destructured
        CFunction(name, returns.trim(), params.split(',').map { it.trim() }.filter { it.isNotEmpty() && it != "void" }.map(::param))
    }.filter { it.name != "EOS_DECLARE_FUNC" }.distinctBy { it.name }.toList()

    private val enums = Regex("""EOS_ENUM(?:_START)?\(\s*(\w+)""").findAll(text).map { it.groupValues[1] }.toSet()
    private val callbacks = (Regex("""EOS_DECLARE_CALLBACK\(\s*(\w+)""").findAll(text) + Regex("""EOS_DECLARE_CALLBACK_RETVALUE\(\s*[\w ]+?\s*\*?\s*,\s*(\w+)""").findAll(text))
        .map { it.groupValues[1] }.toSet() + Regex("""typedef[^;(]*\(\s*\w*\s*\*\s*(\w+)\s*\)""").findAll(text).map { it.groupValues[1] }
    private val typedefs = Regex("""typedef\s+(?:const\s+)?([\w\s]+?)\s*(\*?)\s*(\w+)\s*;""").findAll(text).associate { match ->
        val (target, pointer, name) = match.destructured
        name to if (pointer.isNotEmpty()) "void*" else target.trim()
    }

    fun kind(type: String): Char {
        val clean = type.replace("const", "").trim()
        if ('*' in clean) return 'J'
        if (clean == "void") return 'V'
        if (clean in enums) return 'I'
        if (clean in callbacks || clean.endsWith("Callback") || clean.endsWith("Delegate")) return 'J'
        return when (clean) {
            "int8_t", "uint8_t", "char" -> 'B'
            "int16_t", "uint16_t" -> 'S'
            "int32_t", "uint32_t", "int" -> 'I'
            "int64_t", "uint64_t", "size_t" -> 'J'
            "float" -> 'F'
            "double" -> 'D'
            else -> typedefs[clean]?.takeIf { it != clean }?.let(::kind) ?: if (clean.startsWith("EOS_H")) 'J' else error("Unknown C type $type")
        }
    }

    fun signature(function: CFunction): String = function.params.joinToString("") { kind(it.type).toString() } + "_" + kind(function.returns)

    companion object {
        private fun strip(source: String) = source.replace(Regex("""/\*.*?\*/""", RegexOption.DOT_MATCHES_ALL), "").replace(Regex("//[^\n]*"), "")

        private fun param(text: String): CParam {
            val name = Regex("""(\w+)\s*$""").find(text)!!.groupValues[1]
            return CParam(text.removeSuffix(name).trim(), name)
        }
    }
}
