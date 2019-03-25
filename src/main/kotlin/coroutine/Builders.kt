package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Double the input
 */
suspend fun double(value: Double): Double {
    println("Doing double in ${Thread.currentThread()}")
    return 2 * value
}

/**
 * Square the input
 */
suspend fun square(value: Double): Double {
    println("Doing square in ${Thread.currentThread()}")
    return value * value
}


/**
 * Example of a function witch uses another suspend function
 */
suspend fun calculate(value: Double): Double {
    val ret1 = double(value)
    val ret2 = square(ret1)
    val ret3 = double(ret2)
    return square(ret3)
}

fun main2() {
    println("START")
    GlobalScope.launch {
        val result = calculate(10.0)
        println("Result $result in ${Thread.currentThread()}")
    }
    println("END")
    Thread.sleep(3000L)
}

fun main() {
    println("START")
    runBlocking {
        val result = calculate(10.0)
        println("Result $result in ${Thread.currentThread()}")
    }
    println("END")
}