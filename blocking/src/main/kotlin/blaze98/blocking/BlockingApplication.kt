package blaze98.blocking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlockingApplication

fun main(args: Array<String>) {
    runApplication<BlockingApplication>(*args)
}
