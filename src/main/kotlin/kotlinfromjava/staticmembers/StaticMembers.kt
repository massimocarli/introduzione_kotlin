package kotlinfromjava.staticmembers

class CompClass {

    companion object {
        @JvmStatic
        var name: String = "Hello"

        @JvmStatic
        fun stMethod() {
        }
    }
}
