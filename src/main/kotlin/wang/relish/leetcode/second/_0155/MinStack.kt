package wang.relish.leetcode.second._0155

import struct.ClassExecutor
import kotlin.math.min

class MinStack() {

    var peek = Node(0)
    var tail: Node? = null

    init {
        peek.next = tail
    }

    fun push(`val`: Int) {
        val n = Node(`val`).apply {
            min = peek.next?.min.let {
                if (it == null) {
                    `val`
                } else {
                    min(it, `val`)
                }
            }
        }
        val next = peek.next
        peek.next = n
        n.next = next
    }

    fun pop() {
        peek.next = peek.next?.next
    }

    fun top(): Int {
        return peek.next!!.n
    }

    fun getMin(): Int {
        return peek.next!!.min
    }

    class Node(val n: Int) {
        var min: Int = n
        var next: Node? = null
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
fun main() {
    val executor = ClassExecutor()
    executor.parseCommand(
        arrayOf("wang.relish.leetcode.second._155.MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"),
        ClassExecutor.parseArrayOfIntArray("[[],[-2],[0],[-3],[],[],[],[]]")
    ) // [null,null,null,null,-3,null,0,-2]
}