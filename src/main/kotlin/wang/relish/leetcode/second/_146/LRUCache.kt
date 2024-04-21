package wang.relish.leetcode.second._146

import struct.ClassExecutor


class LRUCache(val capacity: Int) {

    val map = hashMapOf<Int, Node>()
    val head = Node(-1, -1)
    val tail = Node(-2, -2)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val old = map[key]
        if (old != null) {
            old.value = value
            moveToHead(old)
        } else {
            if (map.size == capacity) {
                removeTail()
            }
            val node = Node(key, value)
            map[key] = node
            addToHead(node)
        }
    }

    fun addToHead(node: Node) {
        val t = head.next

        node.prev = head
        node.next = t

        t?.prev = node
        head.next = node
    }

    fun moveToHead(node: Node) {
        // 断口缝合
        val next = node.next
        node.next?.prev = node.prev
        node.prev?.next = next

        val hNext = head.next
        node.prev = head
        head.next = node
        node.next = hNext
        hNext?.prev = node
    }

    fun removeTail() {
        val remove = tail.prev
        remove?.key?.let { map.remove(it) }
        val newTail = remove?.prev
        newTail?.next = tail
        tail.prev = newTail
    }


    class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}

fun main() {
    val executor = ClassExecutor()
//    println(
//        executor.parseCommand(
//            arrayOf("wang.relish.leetcode.second._146.LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"),
//            ClassExecutor.parseArrayOfIntArray("[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]")
//        )
//    )
//    println(
//        executor.parseCommand(
//            arrayOf("wang.relish.leetcode.second._146.LRUCache", "put", "put", "put", "put", "get", "get"),
//            ClassExecutor.parseArrayOfIntArray("[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]")
//        )
//    ) // [null,null,null,null,null,-1,3]
    executor.parseCommand(
        arrayOf("wang.relish.leetcode.second._146.LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"),
        ClassExecutor.parseArrayOfIntArray("[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]")
    ) // [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */