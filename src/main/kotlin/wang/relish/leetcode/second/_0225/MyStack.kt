package wang.relish.leetcode.second._0225

import java.util.*

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class MyStack() {

    val q = LinkedList<Int>()

    fun push(x: Int) {
        val n = q.size
        q.offer(x)
        for (i in 0 until n) {
            q.offer(q.poll())
        }
    }

    fun pop(): Int {
        return q.poll()
    }

    fun top(): Int {
        return q.peek()
    }

    fun empty(): Boolean {
        return q.isEmpty()
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