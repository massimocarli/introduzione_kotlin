package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Example of a normal function
 */
suspend fun doNothing(str: String) {
    println("Doing nothing in ${Thread.currentThread().name}")
}


/**
 * Example of a function witch uses another suspend function
 */
suspend fun doSomething(str: String) {
    doNothing(str)
    doNothing(str)
    doNothing(str)
    doNothing(str)
}

fun main() {
    println("START")
    GlobalScope.launch {
        doSomething("Hello")
    }
    println("END")
}
