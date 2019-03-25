package javafromkotlin.properties

fun main() {
    val user = User("Paperino", "Paolino", 50, true)
    // Getters
    println(user.firstName)
    println(user.lastName)
    println(user.age)
    println(user.completeName)
    println(user.isEnabled)

    // Setters
    //user.firstName = "Mickey"   // Error!!
    //user.lastName = "Mouse"     // Error!!
    user.age = 60               // OK
    user.isEnabled = true       // OK
    //user.completeName = "Mickey Mouse" // Error!!


    val result: Unit = user.doSomething()

    user.`when` { }
}