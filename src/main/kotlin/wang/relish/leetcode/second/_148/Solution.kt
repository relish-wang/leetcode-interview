package wang.relish.leetcode.second._148

import struct.ListNode

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
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val (l1, l2) = cut(head)
        val newL1 = sortList(l1)
        val newL2 = sortList(l2)
        return merge(newL1, newL2)
    }

    fun cut(head: ListNode?): Pair<ListNode?, ListNode?> {
        if (head?.next == null) {
            return head to null
        }
        var slow = head
        var fast = head.next
        var c = 0
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            c++
        }
        val next = slow?.next
        slow?.next = null
        return head to next
    }

    fun len(n: ListNode?): Int {
        var c = n
        var co = 0
        while (c != null) {
            co++
            c = c.next
        }
        return co
    }

    fun merge(n1: ListNode?, n2: ListNode?): ListNode? {
        if (n1 == null) return n2
        if (n2 == null) return n1
        val dummy = ListNode(0)
        var c = dummy
        var l1 = n1
        var l2 = n2
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