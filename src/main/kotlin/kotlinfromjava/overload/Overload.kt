package kotlinfromjava.overload

class Overloaded() {
    fun method(input: Int) {}
    fun method(input: String) {}
    fun method(input: Double) {}
    fun method(input: Boolean) {}
}


class WithOptional @JvmOverloads constructor(
    var name: String = "Anonymous",
    var age: Int = -1,
    var enabled: Boolean = false
)
