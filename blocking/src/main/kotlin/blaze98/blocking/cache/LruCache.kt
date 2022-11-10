package blaze98.blocking.cache

class LruCache<K, V>(override val size: Int): Cache<K, V> {
    private val map = HashMap<K, V>(size)
    private var tail: Node<K> = Node(null)
    private var head: Node<K> = Node(null)

    init {
        head.next = tail
        tail.prev = head
    }

    override fun get(key: K): V? {
        if(head.key == key) return map[key]
        val newNode = Node(key)
        head.next = newNode
        head = newNode
        return map[key]
    }

    override fun set(key: K, value: V) {
        if(map.size == size) {
            map.remove(tail.key)
            tail = tail.prev!!
            tail.next = null
        }

        val newNode = Node(key)
        head.prev = newNode
        newNode.next = head
        head = newNode
        map[key] = value
    }

    override fun remove(key: K): V? {
        return map.remove(key)
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}

class Node<K>(val key: K?) {
    var next: Node<K>? = null
    var prev: Node<K>? = null

    fun remove() {
        next?.prev = prev
        prev?.next = next
    }
}
