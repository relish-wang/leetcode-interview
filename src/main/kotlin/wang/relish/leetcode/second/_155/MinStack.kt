package wang.relish.leetcode.second._155

import struct.ClassExecutor
import java.util.*

class MinStack() {

    val stack = Stack<Int>()
    val sorted = mutableListOf<Int>()
    fun push(`val`: Int) {
        stack.push(`val`)
        if (sorted.isEmpty()) {
            sorted.add(`val`)
            return
        }
        if (sorted[0] > `val`) {
            sorted.add(0, `val`)
            return
        }
        var add = false
        for (i in 0 until sorted.size - 1) {
            if (sorted[i] <= `val` && sorted[i + 1] >= `val`) {
                sorted.add(i + 1, `val`)
                add = true
                break
            }
        }
        if (add.not()) {
            sorted.add(`val`)
        }
    }

    fun pop() {
        val e = stack.pop()
        val iterator = sorted.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == e) {
                iterator.remove()
                break
            }
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return sorted.first()
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