package blaze98.blocking

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("blocking")
class Controller {

    @GetMapping("/sleep")
    fun sleep() {
        Thread.sleep(5000)
    }
}
