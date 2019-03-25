package coroutine

import common.waitRandom
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface Lifecycle {

    fun onCreate()
    fun onStart()
    fun onStop()
    fun onDestroy()
}

class MyComponent : Lifecycle {

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE")
    }

    override fun onStart() {
        println("START")
    }

    override fun onStop() {
        println("STOP")
    }

    override fun onDestroy() {
        println("DESTROY")
    }
}

class MyComponent2 : Lifecycle {

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE")
    }

    override fun onStart() {
        println("START")
        GlobalScope.launch {
            Thread.sleep(2000L)
            println("RESULT FROM COROUTINE 1")
        }
        GlobalScope.launch {
            Thread.sleep(1000L)
            println("RESULT FROM COROUTINE 2")
        }
    }

    override fun onStop() {
        println("STOP")
    }

    override fun onDestroy() {
        println("DESTROY")
    }
}

class MyComponent3 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE")
        job = Job()
    }

    override fun onStart() {
        println("START")
        launch {
            Thread.sleep(2000L)
            println("RESULT FROM COROUTINE 1")
        }
        launch {
            Thread.sleep(1000L)
            println("RESULT FROM COROUTINE 2")
        }
    }

    override fun onStop() {
        println("STOP")
    }

    override fun onDestroy() {
        println("DESTROY")
        job.cancel()
    }
}

class MyComponent4 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE")
        job = Job()
    }

    override fun onStart() {
        println("START")
        launch {
            Thread.sleep(2000L)
            if (job.isActive) {
                println("RESULT FROM COROUTINE 1")
            }
        }
        launch {
            Thread.sleep(1000L)
            if (job.isActive) {
                println("RESULT FROM COROUTINE 2")
            }
        }
    }

    override fun onStop() {
        println("STOP")
    }

    override fun onDestroy() {
        println("DESTROY")
        job.cancel()
    }
}


class MyComponent5 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE")
        job = Job()
    }

    override fun onStart() {
        println("START")
        launch {
            delay(2000L)
            println("RESULT FROM COROUTINE 1")
        }
        launch {
            delay(1000L)
            println("RESULT FROM COROUTINE 2")
        }
    }

    override fun onStop() {
        println("STOP")
    }

    override fun onDestroy() {
        println("DESTROY")
        job.cancel()
    }
}

class MyComponent6 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE on ${Thread.currentThread()}")
        job = Job()
    }

    override fun onStart() {
        println("START on ${Thread.currentThread()}")
        launch {
            delay(200L)
            println("RESULT FROM COROUTINE 1 on ${Thread.currentThread()}")
        }
        launch {
            delay(100L)
            println("RESULT FROM COROUTINE 2 on ${Thread.currentThread()}")
        }
    }

    override fun onStop() {
        println("STOP on ${Thread.currentThread()}")
    }

    override fun onDestroy() {
        println("DESTROY on ${Thread.currentThread()}")
        job.cancel()
    }
}

class MyComponent7 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    init {
        onCreate()
    }

    override fun onCreate() {
        println("CREATE on ${Thread.currentThread()}")
        job = Job()
    }

    override fun onStart() {
        println("START on ${Thread.currentThread()}")
        launch(Dispatchers.Main) {
            launch {
                delay(200L)
                println("RESULT FROM COROUTINE 1 on ${Thread.currentThread()}")
            }
            launch {
                delay(100L)
                println("RESULT FROM COROUTINE 2 on ${Thread.currentThread()}")
            }
        }

    }

    override fun onStop() {
        println("STOP on ${Thread.currentThread()}")
    }

    override fun onDestroy() {
        println("DESTROY on ${Thread.currentThread()}")
        job.cancel()
    }
}

object MyComponent1 : Lifecycle, CoroutineScope {

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + EmptyCoroutineContext

    override fun onCreate() {
        job = Job()
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
        job.cancel()
    }
}


fun main() {
    // We create the component
    val comp = MyComponent7()
    // We start it after a random time
    waitRandom()
    comp.onStart()
    // We stop after a random time
    waitRandom()
    comp.onStop()
    // We destroy it
    waitRandom()
    comp.onDestroy()
    //Thread.sleep(5000L)
}