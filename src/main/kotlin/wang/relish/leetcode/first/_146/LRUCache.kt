import struct.ClassExecutor
import struct.ClassExecutor.Companion.parseArrayOfIntArray

/**
 * 双指针
 * https://leetcode.cn/problems/lru-cache/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class LRUCache(capacity: Int) {
    val maxSize = capacity

    private val map = object : LinkedHashMap<Int, Int>(capacity, 0.75F, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > maxSize
        }
    }

    fun get(key: Int): Int {
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        map.put(key, value)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    val executor = ClassExecutor()
    println(
        executor.parseCommand(
            arrayOf("LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"),
            parseArrayOfIntArray("[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]")
        )
    )
}