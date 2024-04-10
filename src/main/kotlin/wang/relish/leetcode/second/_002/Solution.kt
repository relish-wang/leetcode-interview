package wang.relish.leetcode.second._002

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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) return null
        var p1 = l1
        var p2 = l2
        var head: ListNode? = null
        var c: ListNode? = null
        var m = 0
        while (p1 != null || p2 != null) {
            val v1 = p1?.`val` ?: 0
            val v2 = p2?.`val` ?: 0
            val t = v1 + v2 + m
            m = t / 10
            val v = t % 10
            if (head == null || c == null) {
                head = ListNode(v)
                c = head
            } else {
                c.next = ListNode(v)
                c = c.next
            }
            p1 = p1?.next
            p2 = p2?.next
        }
        if (m > 0) {
            c?.next = ListNode(m)
        }
        return head
    }
}

fun main() {
    println(
        Solution().addTwoNumbers(
            ListNode.newInstance(intArrayOf(2, 4, 3)),
            ListNode.newInstance(intArrayOf(5, 6, 4))
        )
    )
}