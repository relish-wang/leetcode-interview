import java.util.*

/**
 * 双指针
 */
class LRUCache(capacity: Int) {
    val maxSize = capacity

    private val map = object :LinkedHashMap<Int, Int>(capacity, 0.75F, true){
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size>maxSize
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