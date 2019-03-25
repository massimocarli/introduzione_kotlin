package coroutine

import kotlinx.coroutines.*

fun exceptionFromLaunch() = runBlocking {
    val job1 = GlobalScope.launch {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    job1.join()
}

fun multipleExceptionFromLaunch() = runBlocking {
    val job1 = GlobalScope.launch {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    job1.join()
    val job2 = GlobalScope.launch {
        println("Throws Exception 2")
        throw Exception("This is Exception 2")
    }
    job2.join()
}

fun exceptionFromAsync(): Nothing = runBlocking {
    println("1")
    val deferred = GlobalScope.async {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    println("2")
    deferred.await()
}

fun multipleExceptionFromAsync(): Nothing = runBlocking {
    println("1")
    val deferred1 = GlobalScope.async {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    println("2")
    deferred1.await()
    println("3")
    val deferred2 = GlobalScope.async {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    println("4")
    deferred2.await()
}


val customHandler = CoroutineExceptionHandler { _, exception ->
    println("CustomHandler caught $exception")
    for (sups in exception.suppressed) {
        println("Suppressed $sups")
    }
}

fun exceptionFromLaunchWithCustomHandler() = runBlocking {
    val job1 = GlobalScope.launch(customHandler) {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    job1.join()
}

fun multipleExceptionFromLaunchWithCustomHandler() = runBlocking {
    val job1 = GlobalScope.launch(customHandler) {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    job1.join()
    val job2 = GlobalScope.launch(customHandler) {
        println("Throws Exception 2")
        throw Exception("This is Exception 2")
    }
    job2.join()
}


fun exceptionFromAsyncWithCustomHandler(): Nothing = runBlocking {
    println("1")
    val deferred = GlobalScope.async(customHandler) {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    println("2")
    deferred.await()
}

fun exceptionFromAsyncWithCustomHandlerAndTry() = runBlocking {
    println("1")
    val deferred = GlobalScope.async(customHandler) {
        println("Throws Exception 1")
        throw Exception("This is Exception 1")
    }
    println("2")
    try {
        deferred.await()
    } catch (e: java.lang.Exception) {
        println("Exception $e")
    }
}

fun main() {
    exceptionFromAsyncWithCustomHandlerAndTry()
}
