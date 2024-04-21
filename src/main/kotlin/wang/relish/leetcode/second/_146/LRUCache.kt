package wang.relish.leetcode.second._146

import struct.ClassExecutor
import java.util.LinkedHashMap

class LRUCache(val capacity: Int) {

    val map = object : LinkedHashMap<Int, Int>(capacity, 0.75F, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size >= capacity
        }
    }


    fun get(key: Int): Int {
        return map.get(key) ?: -1
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