package properties

fun main() {
    val b = BaseImpl(18)
    val derived = Derived(b)
    derived.print()
    println(derived.message)
}

interface Base {
    val message: String
    fun print()
}

class BaseImpl(val x: Int): Base {
    override val message: String
        get() = "BaseImpl: x= $x"

    override fun print() {
        println(message)
    }
}

class Derived(b: Base): Base by b {
    override val message: String
        get() = "Message of Derived"

//    override fun print() {
//        println("from Derived")
//    }
}