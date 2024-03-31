package _148

import ListNode

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
    /**
     * 垃圾冒泡会超时
     */
    fun sortList1(head: ListNode?): ListNode? {
        if (head == null) return null
        while (head.next != null) {
            var pre = head
            var cur = head.next
            var swap = false
            while (cur != null) {
                val vPre = pre!!.`val`
                val vCur = cur.`val`
                if (vPre > vCur) {
                    swap(pre, cur)
                    swap = true
                }
                pre = pre.next
                cur = cur.next
            }
            if (swap.not()) {
                break
            }
        }
        return head
    }

    /**
     * 自底向上的归并排序(非递归)
     * 链表长度小于等于1必然有序, 合并两个有序链表。合并后的链表也有序, 直到合并到只剩下一个链表
     */
    fun sortList(head: ListNode?): ListNode? {
        val len = listSize(head)
        var subLen = 1
        val dummy = ListNode(0).apply { next = head }
        while (subLen < len) {
            var prev = dummy
            var curr = dummy.next
            while (curr != null) {
                // 被拆分的待合并链表1
                val h1 = curr
                var i = 1
                while (i < subLen && curr != null && curr.next != null) {
                    curr = curr.next
                    i++
                }
                // 被拆分的待合并链表2
                val h2 = curr?.next
                curr?.next = null/* 切断链表1的尾部 */
                curr = h2
                var j = 1
                while (j < subLen && curr != null && curr.next != null) {
                    curr = curr.next
                    j++
                }
                // 切断链表2的尾部(切剩下的后面需要拆分的链表对)
                var next: ListNode? = null
                if (curr != null) {
                    next = curr.next
                    curr.next = null
                }
                // 合并链表
                print("链表对(${subLen}/${len}): $h1 + $h2 = ")
                val merged = mergeSortedList(h1, h2)?.also {
                    println("$it")
                }
                prev.next = merged
                // 把prev指针移动到链表尾部
                while (prev.next != null) {
                    prev = prev.next!!
                }
                curr = next
            }
            println()
            subLen = subLen shl 1
        }
        return dummy.next
    }


    fun listSize(head: ListNode?): Int {
        var count = 0
        var cur = head
        while (cur != null) {
            cur = cur.next
            count++
        }
        return count
    }

    /**
     * 合并两个有序链表
     */
    fun mergeSortedList(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var cur: ListNode? = dummyHead
        var p1 = l1
        var p2 = l2
        while (p1 != null && p2 != null) {
            val v1 = p1.`val`
            val v2 = p2.`val`
            if (v1 > v2) {
                cur?.next = p2
                p2 = p2.next
            } else {
                cur?.next = p1
                p1 = p1.next
            }
            cur = cur?.next
        }
        cur?.next = p1 ?: p2
        return dummyHead.next
    }

    private fun swap(n1: ListNode, n2: ListNode) {
        val v1 = n1.`val`
        n1.`val` = n2.`val`
        n2.`val` = v1
    }
}

fun main() {
//    println(
//        Solution().mergeSortedList(
//            ListNode.newInstance(intArrayOf(4, 5, 14, 19)),
//            ListNode.newInstance(intArrayOf(-3, 1, 5, 8))
//        )
//    )
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println(head)
    println(Solution().sortList(head))
}