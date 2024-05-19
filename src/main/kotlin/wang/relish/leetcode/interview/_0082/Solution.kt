package wang.relish.leetcode.interview._0082

import struct.ListNode

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        var cur = head.next
        if (cur == null) return head
        val dummy = ListNode(0).apply { next = head }
        var pp: ListNode? = dummy
        var pr: ListNode? = head
        while (cur != null) {
            if (cur.`val` == pr?.`val`) {
                cur = cur.next
                if (cur?.`val` != pr?.`val`) {
                    pp?.next = cur
                    pr = cur
                    cur = cur?.next
                }
            } else {
                pp = pr
                pr = cur
                cur = cur.next
            }
        }
        return dummy.next
    }
}

fun main() {
    println(Solution().deleteDuplicates(ListNode.newInstance(intArrayOf(1, 1))))//null
}