package ru.nartiss.ktsloader
import java.io.Reader
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

object KotlinScriptLoader {
    val ktsScriptEngine: ScriptEngine = ScriptEngineManager().getEngineByExtension("kts")

    inline fun <reified T> Any?.safeCast(): T = takeIf { it is T }?.let { it as T } ?: throw IllegalArgumentException("$this can't be cast to type ${T::class}")

    inline fun <reified T> load(script: String): T = runCatching { ktsScriptEngine.eval(script) }
        .getOrElse { throw RuntimeException("Can't load script: $script", it) }
        .safeCast()

    inline fun <reified T> load(reader: Reader): T = load(reader.readText())

    fun eval(script: String) = ktsScriptEngine.eval(script)
}