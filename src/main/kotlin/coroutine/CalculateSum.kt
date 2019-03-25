package coroutine

import common.waitRandom
import kotlinx.coroutines.*
import kotlin.random.Random

fun readValue(): Deferred<Double> = GlobalScope.async {
    waitRandom()
    println("readValue() in ${Thread.currentThread()}")
    Random.nextDouble()
}

fun calculate(first: Double, second: Double): Deferred<Double> =
    GlobalScope.async {
        waitRandom()
        println("calculate() in ${Thread.currentThread()}")
        first + second
    }

fun printResult(str: String) {
    println("$str in ${Thread.currentThread()}")
}

fun calculateSum() {
    runBlocking(Dispatchers.Main) {
        println("1")
        val first = readValue()
        println("2")
        val second = readValue()
        println("3")
        val sum = calculate(first.await(), second.await()).await()
        println("4")
        printResult("${first.getCompleted()} + ${second.getCompleted()} = $sum")
    }
}


fun main(args: Array<String>) {
    calculateSum()
}