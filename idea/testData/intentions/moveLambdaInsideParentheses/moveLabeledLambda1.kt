// IS_APPLICABLE: true
fun foo() {
    bar(2) <caret>@l{ it * 3 }
}

fun bar(a: Int, b: (Int) -> Int) {
    b(a)
}
