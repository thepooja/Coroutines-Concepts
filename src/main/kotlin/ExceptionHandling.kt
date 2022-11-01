import kotlinx.coroutines.*

fun main() {
    runBlocking {

        val myHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
            println("Exception Handled :${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler)
        {
            println("Throwing Exception from job")
            throw IndexOutOfBoundsException("Exception in coroutine")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing Exception from async")
            throw ArithmeticException("Exception from async")
        }

        try {
            deferred.await()
        }catch (e: java.lang.ArithmeticException)
        {
            println("Caught ArithmeticException ${e.localizedMessage}")
        }
    }
}