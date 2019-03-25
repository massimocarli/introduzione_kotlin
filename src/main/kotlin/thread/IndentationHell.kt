package thread

import common.waitRandom
import kotlin.concurrent.thread
import kotlin.random.Random

/**
 * The readValue() function with a callback
 */
fun readValue(callback: Callback<Double>) =
    thread {
        waitRandom()
        val result = Random.nextDouble(100.0)
        callback(result)
    }


/**
 * The calculate() function with a callback
 */
fun calculate(first: Double, second: Double, callback: Callback<Double>) =
    thread {
        waitRandom()
        val result = first + second
        callback(result)
    }


/**
 * The calculateSum() version with callback
 */
fun calculateSumHellCallback(callback: Callback<String>) =
    readValue { first ->
        readValue { second ->
            calculate(first, second) { sum ->
                callback("$first + $second = $sum")
            }
        }
    }

/**
 * The main() function for testing the calculateSumHellCallback() and see the
 * threads name
 */
fun main() {
    println("START APP! in Thread ${Thread.currentThread().name}")
    calculateSumHellCallback {
        println("$it from Thread ${Thread.currentThread().name}")
    }
    println("END APP!")
}
