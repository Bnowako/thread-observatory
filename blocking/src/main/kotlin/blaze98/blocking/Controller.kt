package blaze98.blocking

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/sleep")
    fun sleep(@RequestParam("sleepTimeMillis", required = false) sleepTimeMillis: Long?) {
        println("sleep with sleepTimeMilli $sleepTimeMillis")
        Thread.sleep(sleepTimeMillis ?: 5000)
    }

    @GetMapping("/objects/spawn")
    fun createObjects(@RequestParam("count", required = false) count: Int?) {
        //todo this code will be optimized by compiler
        // it will be cheat compiler somehow
        println("/objects/spawn called with count: $count")
        val heapObjects: MutableList<HeapObject> = mutableListOf()
        for(i in 0..(count ?: 10)) {
            heapObjects.add(HeapObject("objNo: $i", "$i", i))
        }
    }

}

data class HeapObject(val id: String, val value: String, val someInt: Int)
