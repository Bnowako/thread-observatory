package blaze98.threadobservatory

import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("coroutines")
class Controller() {

    @GetMapping("suspend")
    suspend fun suspendFunction() {
        measureTime("suspend 5s") {
            delay(5000)
        }
    }

    @GetMapping("runBlocking")
    fun runBlocking() {
        kotlinx.coroutines.runBlocking {
            measureTime("runBlocking 5s") {
                delay(5000)
            }
        }
    }
}
