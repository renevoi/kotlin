// IGNORE_BACKEND: NATIVE

class VarByMapExtensionsTest {
    val map = hashMapOf<String, Any?>("a" to "all", "b" to null, "c" to 1, "xProperty" to 1.0)

    var a: String by map
    var b: Any? by map
    var c: Int by map
    var d: String? by map

    fun doTest() {
        map["c"] = "string"
        // fails { c }  // does not fail in JS due to KT-8135

        map["a"] = null
        a // fails { a } // does not fail due to KT-8135
    }
}

fun box() = VarByMapExtensionsTest().doTest()