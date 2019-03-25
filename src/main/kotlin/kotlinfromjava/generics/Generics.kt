package kotlinfromjava.generics

class Box<out T>(val value: T)

interface Base
class Derived : Base

fun boxDerived(value: Derived): Box<@JvmWildcard Derived> = Box(value)
fun unboxBase(box: Box<@JvmSuppressWildcards Base>): Base = box.value