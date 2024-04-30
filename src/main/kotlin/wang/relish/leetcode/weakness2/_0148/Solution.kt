package wang.relish.leetcode.weakness2._0148

import struct.ListNode

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        val len = len(head)
        var subLen = 1
        val dummy = ListNode(0).apply { next = head }
        while (subLen < len) {
            var pre: ListNode? = dummy
            var cur = dummy.next
            while (cur != null) {
                var i = 1
                val l1 = cur
                while (i < subLen && cur != null) {
                    cur = cur.next
                    i++
                }
                // 切断
                val l2 = cur?.next
                cur?.next = null
                i = 1
                cur = l2
                while (i < subLen && cur != null) {
                    cur = cur.next
                    i++
                }
                // 归并
                val next = cur?.next
                cur?.next = null // 切断
                val newL = merge(l1, l2)
                pre?.next = newL
                cur = newL
                while (cur?.next != null) {
                    cur = cur.next
                }
                cur?.next = next
                pre = cur
                cur = cur?.next
                if(next == null) {
                    break
                }
            }
            subLen = subLen shl 1
        }
        return dummy.next
    }

    fun len(head: ListNode?): Int {
        if (head == null) return 0
        var c = head
        var co = 0
        while (c != null) {
            c = c.next
            co++
        }
        return co
    }

    fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1
        var n1 = l1
        var n2 = l2
        val dummy = ListNode(0)
        var cur = dummy
        while (n1 != null && n2 != null) {
            if (n1.`val` > n2.`val`) {
                cur.next = n2
                n2 = n2.next
            } else {
                cur.next = n1
                n1 = n1.next
            }
            cur = cur.next!!
        }
        cur.next = n1 ?: n2
        return dummy.next
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println("排序前: $head")
    println("排序后: ${Solution().sortList(head)}")
}