package builders

import java.lang.StringBuilder

fun <T> T.myApply(f: T.() -> Unit): T {
    f();
    return this
}

fun createString(): String {
    return StringBuilder().myApply{
        append("numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}