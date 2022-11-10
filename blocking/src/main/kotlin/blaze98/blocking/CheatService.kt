package blaze98.blocking

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class CheatService {

    fun doSomethingWithObject(heapObject: HeapObject) {
        val randomNumber = Random(42).nextInt(1,10)


    }



}