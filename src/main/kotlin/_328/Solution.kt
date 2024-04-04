package _328

import ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/odd-even-linked-list/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 用时: 93.33%
     * 内存: 100%
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        var curr = head
        var oddHead: ListNode? = null
        var oddPre: ListNode? = null
        var evenHead: ListNode? = null
        var evenPre: ListNode? = null
        var i = 0
        while (curr != null) {
            if (i % 2 == 0) {
                if (oddHead == null) {
                    oddHead = curr
                }
                if (oddPre == null) {
                    oddPre = curr
                } else {
                    oddPre.next = curr
                    oddPre = oddPre.next
                }
            } else {
                if (evenHead == null) {
                    evenHead = curr
                }
                if (evenPre == null) {
                    evenPre = curr
                } else {
                    evenPre.next = curr
                    evenPre = evenPre.next
                }
            }
            i++
            curr = curr.next
        }
        evenPre?.next = null
        if (oddHead == null || evenHead == null) {
            // 只有全是偶数 或 只有偶数
            return head
        }
        oddPre?.next = evenHead
        return oddHead
    }
}

fun main() {
    println(
        Solution().oddEvenList(
            ListNode.newInstance(intArrayOf(1, 2, 3, 4, 5)).also { println(it?.toString()) })
    ) // 1 3 5 2 4
    println(
        Solution().oddEvenList(
            ListNode.newInstance(intArrayOf(2,1,3,5,6,4,7)).also { println(it?.toString()) })
    ) // 2,3,6,7,1,5,4
}