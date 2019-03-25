package javafromkotlin.nullability


fun main() {
    val wrapper = StringWrapper(null)
    val str = wrapper.value
    println("Length: ${str?.length ?: "Unknown"}")

    val intWrapper = Wrapper<Int>(10)

}