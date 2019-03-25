package thread

import common.reprint
import java.util.concurrent.Executors
import kotlin.concurrent.thread

/**
 * We try to run 1 million threads creating a new one every time
 */
fun runParallelThreads() {
    try {
        val jobs = List(1_000_000) {
            thread(start = false) {
                Thread.sleep(1000L)
                reprint("$it")
            }
        }
        jobs.forEach { it.start() }
        jobs.forEach { it.join() }
    } catch (e: Exception) {
        println(e)
    }
}

/**
 * We try to run 1 million threads using an ExecutorService
 */
fun runParallelThreadsWithExecutor() {
    val executor = Executors.newFixedThreadPool(100)
    try {
        val jobs = List(1_000_000) {
            executor.submit {
                Thread.sleep(1000L)
                reprint("$it")
            }
        }
        jobs.forEach { it.get() }
    } catch (e: Exception) {
        println(e)
    }
}


fun main(args: Array<String>) {
    // Uncomment if you want to run 1_000_000 tasks with 1_000_000 threads
    //runParallelThreads()
    // Uncomment if you want to run 1_000_000 tasks with 100 threads
    runParallelThreadsWithExecutor()
}