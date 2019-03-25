package javafromkotlin.arrays

open class Animal
class Dog : Animal()
class Cat : Animal()

fun main() {

    //val zoo: Array<Animal> = arrayOf<Dog>() // ERROR!!
    val zoo = ArrayTest()
    zoo.setZoo(arrayOf<Dog>())
}