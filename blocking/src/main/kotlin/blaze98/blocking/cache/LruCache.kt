package blaze98.blocking.cache

class LruCache<K, V>(override val size: Int) : Cache<K, V> {
    private val map = HashMap<K, Node<K, V>>(size)
    private val tail: Node<K, V> = Node(null, null)
    private val head: Node<K, V> = Node(null, null)

    init {
        head.next = tail
        tail.prev = head
    }

    override fun get(key: K): V? {
        val node = map[key] ?: return null
        node.remove()
        head.addAsNext(node)
        return node.value
    }

    override fun set(key: K, value: V) {
        if (map.size >= size) {
            map.remove(tail.prev!!.key)
            tail.prev!!.remove()
        }

        val newNode = Node(key, value)
        head.addAsNext(newNode)
        map[key] = newNode
    }

    override fun remove(key: K): V? {
        return map.remove(key)?.value
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}

class Node<K, V>(val key: K?, val value: V?) {
    var next: Node<K, V>? = null
    var prev: Node<K, V>? = null

    fun remove() {
        next?.prev = prev
        prev?.next = next
    }

    fun addAsNext(node: Node<K, V>) {
        next!!.prev = node
        node.next = next
        node.prev = this
        next = node
    }

    fun addAsPrev(node: Node<K, V>) {
        prev!!.next = node
        node.prev = prev
        node.next = this
        prev = node
    }
}
