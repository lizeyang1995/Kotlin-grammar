package properties

fun main() {
    val init: () -> Int = {1}
    val lazy = LazyProperty(init).lazy
    println(lazy)
}

class LazyProperty(val initializer: () -> Int) {
    var value: Int? = null
    val lazy: Int
        get() {
            if (value == null) {
                value = initializer()
            }
            return value!!
        }
}