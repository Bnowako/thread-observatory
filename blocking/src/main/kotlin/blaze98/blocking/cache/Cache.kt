package blaze98.blocking.cache

interface Cache<K, V> {
    val size: Int
    operator fun get(key: K): V?
    operator fun set(key: K, value: V)
    fun remove(key: K): V?
    fun clear()
}