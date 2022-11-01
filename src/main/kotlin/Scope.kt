import kotlinx.coroutines.*

fun main(){
    println("Program will be Blocking")
    runBlocking {
        launch {
            delay(1000L)
            println( "Task from runBlocking")
        }

        GlobalScope.launch{
            delay(500L)
            println("Task from Global Scope")
        }


        coroutineScope {
            launch {
                delay(1500L)
                println("Task from Coroutine Scope")
            }
        }
    }
    println("Program will now Execute")
}