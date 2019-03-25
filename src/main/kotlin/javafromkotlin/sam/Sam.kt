package javafromkotlin.sam

fun main() {
    val sam = Sam { println("I'm Sam") }
    val samWithParam = SamWithParam { a, b -> println("$a $b") }
    val consumer = SamConsumer()
    consumer.consume { println("I'm Sam") }
}