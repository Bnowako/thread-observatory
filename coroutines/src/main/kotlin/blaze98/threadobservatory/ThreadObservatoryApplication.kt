package blaze98.threadobservatory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThreadObservatoryApplication

fun main(args: Array<String>) {
    runApplication<ThreadObservatoryApplication>(*args)
}
