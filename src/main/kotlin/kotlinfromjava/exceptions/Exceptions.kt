package kotlinfromjava.exceptions

import java.io.IOException

@Throws(IOException::class)
fun maybeThrowsEx() {
    throw IOException("Something wrong")
}

fun useMethodWithEx() {
    maybeThrowsEx()
}