package thread

import common.waitRandom
import kotlin.random.Random

/**
 * This is an example of how to implement a task into a Thread. The client
 * of this thread should wait for the result using the join() function
 */
class ReadValueThread : Thread("ReadValueThread") {

    var result: Double = 0.0
        private set
        get

    override fun run() {
        waitRandom()
        result = Random.nextDouble(100.0)
    }
}


/**
 * This is the implementation of the original problem using the Thread version
 * of the readValue() function
 */
fun calculateSumWithThread() {
    val thread2 = ReadValueThread()
    val thread3 = ReadValueThread()
    thread2.start()
    thread3.start()
    thread2.join()
    thread3.join()
    val first = thread2.result
    val second = thread3.result
    val sum = calculate(first, second)
    println("$first + $second = $sum")
}

fun main() {
    calculateSumWithThread()
}