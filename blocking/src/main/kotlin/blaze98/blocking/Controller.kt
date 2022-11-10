package blaze98.blocking

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("blocking")
class Controller {

    @GetMapping("/sleep")
    fun sleep(@RequestParam("sleepTimeMillis", required = false) sleepTimeMillis: Long?) {
        Thread.sleep(sleepTimeMillis ?: 5000)
    }
}
