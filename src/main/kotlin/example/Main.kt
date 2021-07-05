package example

import KtsLoader
import kotlin.system.measureTimeMillis

fun main() {
    val long = measureTimeMillis {
        KtsLoader.load<TestScriptClass>(KtsLoader.javaClass.getResourceAsStream("Test.kts")!!.bufferedReader())
    }
    println("Script loaded in $long")
}