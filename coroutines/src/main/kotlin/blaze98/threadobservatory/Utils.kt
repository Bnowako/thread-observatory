package blaze98.threadobservatory

import kotlin.math.abs

inline fun measureTime(name: String, block: () -> Unit) {
    val start = System.nanoTime()
    block.invoke()
    val end = System.nanoTime()
    println(name + " took: " + abs(start - end))
}
