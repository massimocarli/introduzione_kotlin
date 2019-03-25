package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun printLength(str: Any?) {
    if (str != null && str is String) {
        println("$str length is ${str.length}")
    }
}

@ExperimentalContracts
fun isStr(str: Any?): Boolean {
    contract { returns(true) implies (str != null && str is String) }
    return str != null && str is String
}

@ExperimentalContracts
fun printLengthWithFun(str: Any?) {
    if (isStr(str)) {
        println("$str length is ${str.length}")
    }
//    else {
//        println("$str length is ${str.length}")
//    }
}



@ExperimentalContracts
fun main(args: Array<String>) {
    printLengthWithFun("Hello")
}
