package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun simpleCancellation() = runBlocking {
    val job = GlobalScope.launch {
        // We launch a coroutine which last long
        launch {
            try {
                delay(Long.MAX_VALUE)
            } catch (e: Exception) {
                println("Delay ended with exception $e")
            }
        }
        launch {
            // We wait 1 second
            delay(1000L)
            // We throw an exception
            throw Exception("This exception should cancel the first coroutine")
        }
    }
    job.join()
}

fun main(args: Array<String>) {
    simpleCancellation()
}