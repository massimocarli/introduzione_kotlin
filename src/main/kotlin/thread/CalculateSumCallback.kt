package thread

import kotlin.concurrent.thread

/**
 * Type for the callback function
 */
typealias Callback<T> = (T) -> Unit

/**
 * Example of the calculateSum() with a callback. This function
 * sends the result to the caller using the callback reference
 * passed as parameter
 */
fun calculateSumCallback(callback: Callback<String>) =
    thread {
        val thread2 = ReadValueThread()
        val thread3 = ReadValueThread()
        thread2.start()
        thread3.start()
        thread2.join()
        thread3.join()
        val first = thread2.result
        val second = thread3.result
        val sum = calculate(first, second)
        callback("$first + $second = $sum")
    }


/**
 * Main in order to test the calculateSumCallback() function
 */
fun main() {
    println("START APP!")
    calculateSumCallback {
        println(it)
    }
    println("END APP!")
}
