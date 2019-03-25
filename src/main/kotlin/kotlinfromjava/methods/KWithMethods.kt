package kotlinfromjava.methods

class KWithMethods {

    @get:JvmName("getMyName")
    @set:JvmName("setMyName")
    var name: String = "Hello"


    @JvmName("useIntList")
    fun useList(stringList: List<Int>) {
    }

    @JvmName("useStringList")
    fun useList(stringList: List<String>) {
    }
}