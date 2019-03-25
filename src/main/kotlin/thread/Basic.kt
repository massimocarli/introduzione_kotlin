package thread

/**
 * Simple function that returns a Double. In this case it just returns a
 * literal value but in theory this could be the result of a more
 * complicated invocation like a network call.
 */
fun readValue(): Double = 10.0


/**
 * Simple operation that simulate a service which might take time to
 * complete. At the moment this just execute an addition between 2
 * input values
 */
fun calculate(first: Double, second: Double) = first + second


/**
 * This is a simple function which simulate a simple use case. Basically we:
 * 1) Read a value from a device
 * 2) Read a second value from a device
 * 3) Invoke a calculate() function in order to use previous data
 * 4) Display the result of the operation
 */
fun calculateSum() {
    val first = readValue()
    val second = readValue()
    val sum = calculate(first, second)
    println("$first + $second = $sum")
}


fun main() {
    calculateSum()
}