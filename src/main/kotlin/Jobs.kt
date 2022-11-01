import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val job1 = launch {
            println("Job1 Launched")
            val job2  = launch {
                println("Job2 Launched")
                delay(3000L)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion { println("Job2 is Completed") }

            val job3 = launch {
                println("Job3 Launched")
                delay(3000L)
                println("Job3 is finishing")
            }
            job3.invokeOnCompletion { println("Job3 is Completed") }
        }

        job1.invokeOnCompletion {
            println("Job1 is Completed")
        }

        delay(500L)
        job1.cancel()
        println("Job1 is Cancelling")

    }
}