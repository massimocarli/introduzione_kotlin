package javafromkotlin.`object`

import kotlin.reflect.KClass

fun main() {
    //val withObj = WithObject()
    //val obj: Any = withObj.obj


    val strClazz: KClass<out String> = ""::class
    val strClazz2: KClass<String> = String::class

    val jClazz: Class<out String> = ""::class.java
    val jClazz2: Class<String> = String::class.java

    val jClazz3: Class<String> = "".javaClass
//    val jClazz4: Class<String> = String.javaClass
}