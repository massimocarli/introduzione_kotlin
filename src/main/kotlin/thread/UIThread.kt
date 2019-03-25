package thread

import javax.swing.SwingUtilities

/**
 * Abstraction for the object responsible to execute the given callback
 * into a specific thread and in particular into the UI thread
 */
interface Dispatcher<T> {
    fun dispatch(value: T, callback: Callback<T>)
}

/**
 * Dispatcher implementation for the Java Swing
 */
class MainDispatcher<T> : Dispatcher<T> {
    override fun dispatch(value: T, callback: Callback<T>) {
        SwingUtilities.invokeLater {
            callback(value)
        }
    }
}

/**
 * Version of calculateSumCallbackHell() with the Dispatcher
 */
fun calculateSumCallbackHellWithDispatcher(
    dispatcher: Dispatcher<String> = MainDispatcher(),
    callback: Callback<String>
) =
    readValue { first ->
        println("readValue 1 This is Thread ${Thread.currentThread().name}")
        readValue { second ->
            println("readValue 2 This is Thread ${Thread.currentThread().name}")
            calculate(first, second) { sum ->
                println("calculate This is Thread ${Thread.currentThread().name}")
                dispatcher.dispatch("$first + $second = $sum", callback)
            }
        }
    }

/**
 * Example of usage of the Dispatcher
 */
fun main() {
    calculateSumCallbackHellWithDispatcher {
        println("result Thread ${Thread.currentThread().name}")
        println("$it")
    }
}
