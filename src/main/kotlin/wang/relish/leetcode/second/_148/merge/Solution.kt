package wang.relish.leetcode.second._148.merge

import struct.ListNode

/**
 * 归并解法
 */
class Solution {
    /**
     * 29:13
     */
    fun sortList(head: ListNode?): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        val len = len(head)
        var subLen = 1

        while (subLen < len) {
            var prev: ListNode? = dummy
            var curr: ListNode? = dummy.next
            while (curr != null) {
                val h1 = curr
                var i = 1
                while (i < subLen && curr != null && curr.next != null) {
                    curr = curr.next
                    i++
                }

                val h2 = curr?.next
                curr?.next = null // 断开
                curr = h2
                var j = 1
                while (j < subLen && curr != null && curr.next != null) {
                    curr = curr.next
                    j++
                }

                val next = curr?.next
                curr?.next = null

                val merged = merge(h1, h2)
                prev?.next = merged
                while (prev?.next != null) {
                    prev = prev.next
                }
                curr = next
            }
            subLen = subLen shl 1
        }
        return dummy.next
    }

    fun len(head: ListNode?): Int {
        var c = head
        var co = 0
        while (c != null) {
            c = c.next
            co++
        }
        return co
    }

    fun merge(n1: ListNode?, n2: ListNode?): ListNode? {
        var l1 = n1
        var l2 = n2
        val d = ListNode(0)
        var c = d
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
        return d.next
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println(head)
    println(Solution().sortList(head))
}