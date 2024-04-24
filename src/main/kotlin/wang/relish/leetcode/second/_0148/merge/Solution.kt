package wang.relish.leetcode.second._0148.merge

import struct.ListNode

/**
 * 归并解法
 */
class Solution {
    /**
     * 14: 08
     */
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val dummy = ListNode(0).apply { next = head }
        val len = s(head)
        var subLen = 1
        while (subLen < len) {
            var c = dummy.next
            var prev = dummy
            while (c != null) {
                var i = 1
                val h1 = c
                while (i < subLen && c != null && c.next != null) {
                    c = c.next
                    i++
                }
                // cut
                val h2 = c?.next
                c?.next = null // 断开1
                c = h2
                var j = 1
                while (j < subLen && c != null && c.next != null) {
                    c = c.next
                    j++
                }
                val next = c?.next // 剩下的
                c?.next = null // 断开

                print("【$subLen】h1 = $h1, h2 = $h2")
                val h = mr(h1, h2).also {
                    println(", mr = $it")
                }// 合并

                prev.next = h
                while (prev.next != null) {
                    prev = prev.next!!
                }
                prev.next = next
                c = next
            }
            println()
            subLen = subLen shl 1
        }
        return dummy.next
    }

    fun s(h: ListNode?): Int {
        if (h == null) return 0
        var c = 0
        var n = h
        while (n != null) {
            n = n.next
            c++
        }
        return c
    }

    fun mr(n1: ListNode?, n2: ListNode?): ListNode? {
        val d = ListNode(0)
        var c = d
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
        return d.next
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println("排序前: $head")
    println("排序后: ${Solution().sortList(head)}")
}