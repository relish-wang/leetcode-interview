package _142

import ListNode
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    /**
     * 快慢指针确定是否有环
     * 确认有环后, 慢指针和【头结点慢指针】迭代直到两个值一样, 那么它就是环入口
     * 哈希表
     */
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var s = head
        var f = head
        val stack = Stack<ListNode>()
        val loopStack = Stack<ListNode>()
        stack.push(s)
        var hasCircle = false
        while (s != null && f != null) {
            s = s.next?.also {
                stack.push(it)
            }
            f = f.next?.next
            if (f == null) {
                // no circle
                return null
            }
            if (s != null && s == f) {
                // has circle
                loopStack.push(s)
                //s = s.next
                hasCircle = true
                break

            }
        }
        if (hasCircle.not()) {
            return null
        }
        do {
            s = s?.next
            loopStack.push(s)
        } while (stack.peek() != s)
        var le: ListNode? = null
        var ls: ListNode? = null
        while (loopStack.isNotEmpty()) {
            le = stack.pop()
            ls = loopStack.pop()
            if (le != ls) {
                return le.next
            }
        }
        return ls
    }

    /**
     * hash表赛高
     */
    fun detectCycle2(head: ListNode?): ListNode? {
        var pos = head
        val visited = hashSetOf<ListNode>()
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos
            } else {
                visited.add(pos)
            }
            pos = pos.next
        }
        return null
    }
}

fun main() {
//    val head = ListNode.withLoop(intArrayOf(3, 2, 0, -4), 1)
    val head = ListNode.withLoop(intArrayOf(0, 1), 0)
    println(head)
    val node = Solution().detectCycle(head)
    println(node)
}