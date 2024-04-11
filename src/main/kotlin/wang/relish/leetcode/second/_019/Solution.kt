package wang.relish.leetcode.second._019

import struct.ListNode

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }
        var d = ListNode(0).apply { next = head }
        var slow: ListNode? = d
        var fast: ListNode? = d
        var i = 0
        while (fast != null) {
            fast = fast.next
            i++
            if (i == n) {
                break
            }
        }
        var pre: ListNode? = null
        while (slow != null && fast != null) {
            pre = slow
            slow = slow.next
            fast = fast.next
        }
        pre?.next = slow?.next
        return d.next
    }
}
