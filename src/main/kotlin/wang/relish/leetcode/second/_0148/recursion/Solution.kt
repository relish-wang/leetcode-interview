package wang.relish.leetcode.second._0148.recursion

import struct.ListNode

/**
 * 递归解法
 */
class Solution {
    /**
     * 5:05 又练了一遍递归解法
     */
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val (l1, l2) = cut(head)
        return merge(sortList(l1), sortList(l2))
    }

    fun cut(head: ListNode?): Pair<ListNode?, ListNode?> {
        if (head?.next == null) return head to null
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val next = slow?.next
        slow?.next = null
        return head to next
    }

    fun merge(n1: ListNode?, n2: ListNode?): ListNode? {
        if (n1 == null) return n2
        if (n2 == null) return n1
        var l1 = n1
        var l2 = n2
        val dummy = ListNode(0)
        var c = dummy
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                c.next = l1
                l1 = l1.next
            } else {
                c.next = l2
                l2 = l2.next
            }
            c = c.next!!
        }
        c.next = l1 ?: l2
        return dummy.next
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println(head)
    println(Solution().sortList(head))
}