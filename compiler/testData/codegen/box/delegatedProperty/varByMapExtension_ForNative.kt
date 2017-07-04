// TARGET_BACKEND: NATIVE

class VarByMapExtensionsTest_ForNative {
    val map = hashMapOf<String, Any?>("a" to "all", "b" to null, "c" to 1, "xProperty" to 1.0)

    var a: String by map
    var b: Any? by map
    var c: Int by map
    var d: String? by map

    fun doTest() {
        map["c"] = "string"
        assertFailsWith<ClassCastException> { c } // KT-8135 is already fixed in Native.

        map["a"] = null
        assertFailsWith<TypeCastException> { a } // KT-8135 is already fixed in Native.
    }
}

fun box() = VarByMapExtensionsTest_ForNative().doTest()