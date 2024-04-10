package wang.relish.leetcode.second._019

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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }
        val dummy = ListNode(-1).apply { next = head }
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy
        var i = 0
        while (i < n && fast != null) {
            i++
            fast = fast.next
        }
        var pre = dummy
        while (slow != null && fast != null) {
            pre = slow
            slow = slow.next
            fast = fast.next
        }
        pre.next = slow?.next
        return dummy.next
    }
}

fun main() {
//    println(Solution().removeNthFromEnd(ListNode.newInstance(intArrayOf(1, 2, 3, 4, 5)), 2))
    println(Solution().removeNthFromEnd(ListNode.newInstance(intArrayOf(1)), 1))
}