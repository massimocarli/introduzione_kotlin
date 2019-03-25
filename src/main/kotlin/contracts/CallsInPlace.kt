package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@ExperimentalContracts
fun calledOnlyOnce(fn: () -> Unit) {
    contract { callsInPlace(fn, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }
    fn()
}

@ExperimentalContracts
fun initIntValue() {
    val intValue: Int
    calledOnlyOnce {
        intValue = 1  // OK!!!
    }
}

@ExperimentalContracts
fun main() {
    initIntValue()
}