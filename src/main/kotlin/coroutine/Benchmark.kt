package coroutine

import common.reprint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * We try to run 1 million coroutines
 */
fun runParallelCoroutines() = runBlocking {
    try {
        val jobs = List(1_000_000) {
            launch {
                Thread.sleep(1000L)
                reprint("$it")
            }
        }
        jobs.forEach { it.join() }
    } catch (e: Exception) {
        println(e)
    }
}


fun main(args: Array<String>) {
    runParallelCoroutines()
}