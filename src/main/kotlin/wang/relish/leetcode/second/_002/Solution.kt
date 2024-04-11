package wang.relish.leetcode.second._002

import struct.ListNode

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        val dummy = ListNode(0)
        var cur: ListNode? = dummy
        var n1 = l1
        var n2 = l2
        var c = 0
        while (n1 != null || n2 != null) {
            val v1 = n1?.`val` ?: 0
            val v2 = n2?.`val` ?: 0
            val v = v1 + v2 + c
            c = v / 10
            cur?.next = ListNode(v % 10)
            cur = cur?.next
            n1 = n1?.next
            n2 = n2?.next
        }
        if (c > 0) {
            if (n1 != null) {
                cur?.next = ListNode(n1.`val` + c)
                cur = cur?.next
                n1 = n1.next
                cur?.next = n1
            } else if (n2 != null) {
                cur?.next = ListNode(n2.`val` + c)
                cur = cur?.next
                n2 = n2.next
                cur?.next = n2
            } else {
                cur?.next = ListNode(c)
            }
        } else {
            if (n1 != null) {
                cur?.next = n1
            } else if (n2 != null) {
                cur?.next = n2
            }
        }
        return dummy.next
    }
}

fun main() {

}