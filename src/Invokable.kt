fun main() {
    val inv = Invokable()
    val invoketwice = invoketwice(inv)
    println(invoketwice.numberOfInvocations)
}

class Invokable {
    var numberOfInvocations: Int = 0
    private set
    operator fun  invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}

fun invoketwice(invokable: Invokable) = invokable()()