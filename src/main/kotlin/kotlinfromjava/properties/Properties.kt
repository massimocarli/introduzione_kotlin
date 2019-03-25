package kotlinfromjava.properties

class User(var name: String, val age: Int, var enabled: Boolean)
//class User(var name: String, val age: Int, var isEnabled: Boolean)


class WithField {
    @JvmField
    val name: String = "Hello"
}