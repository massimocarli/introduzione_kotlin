package common

import kotlin.random.Random

/**
 * Waits a random interval from 0 to (at least) 1000 milliseconds
 */
fun waitRandom(forceTime: Boolean = false) {
    if (forceTime) {
        Thread.sleep(1000L)
    } else {
        Thread.sleep(Random.nextLong(1000))
    }

}

/**
 * Utility method we can use in order to measure the time we need
 * for executing a given lambda
 *
 */
fun measure(f: () -> Unit): Long {
    val start = System.currentTimeMillis()
    f()
    return System.currentTimeMillis() - start
}

/**
 * Utility function which deletes the current value and
 * prints the new one on the same line
 */
fun reprint(str: String) {
    print("\b\b\b\b\b\b\b\b\b\b $str")
}