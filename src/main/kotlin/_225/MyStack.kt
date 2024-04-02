package _225

import java.util.LinkedList

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class MyStack() {

    private val queue = LinkedList<Int>()

    fun push(x: Int) {
        val n = queue.size
        queue.offer(x)
        for (i in 0 until n) {
            queue.offer(queue.poll())
        }
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */