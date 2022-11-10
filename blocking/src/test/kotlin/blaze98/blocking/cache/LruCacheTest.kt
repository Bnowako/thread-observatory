package blaze98.blocking.cache

import kotlin.test.Test
import kotlin.test.assertEquals



internal class LruCacheTest {

    @Test
    fun set_and_get() {
        val cache = LruCache<String, String>(10)
        cache["a"] = "test"
        val result = cache["a"]

        assertEquals(result, "test")
    }

    @Test
    fun set_two_times_get() {
        val cache = LruCache<String, String>(10)
        cache["a"] = "test"
        cache["a"] = "changed-test"
        val result = cache["a"]

        assertEquals(result, "changed-test")
    }

    @Test
    fun set_and_remove() {
        val cache = LruCache<String, String>(10)
        cache["a"] = "test"
        cache.remove("a")
        val result = cache["a"]

        assertEquals(result, null)
    }

    @Test
    fun size_constrained() {
        val cache = LruCache<String, String>(1)
        cache["a"] = "testa"
        cache["b"] = "testb"
        cache["c"] = "testc"

        val resulta = cache["a"]
        val resultb = cache["b"]
        val resultc = cache["c"]

        assertEquals(resulta, null)
        assertEquals(resultb, null)
        assertEquals(resultc, "testc")
    }

    @Test
    fun used_keys_should_be_longer_in_cache() {
        val cache = LruCache<String, String>(1)
        cache["a"] = "testa"
        cache["b"] = "testb"
        cache["c"] = "testc"
        val value = cache["a"]

        val resulta = cache["a"]
        val resultb = cache["b"]
        val resultc = cache["c"]

        assertEquals(resulta, "a")
        assertEquals(resultb, null)
        assertEquals(resultc, null)
    }

}