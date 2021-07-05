package example

data class TestScriptClass(private val description: String) {
    fun sout() {
        println(description)
    }
}
