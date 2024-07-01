package wang.relish.leetcode.interview._0143

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
    /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * 
        * @param head ListNode类 
        * @return 无
    */
    fun reorderList(head: ListNode?): Unit {
        if(head == null) return
        if(head.next == null) return
        var slow: ListNode? = head
        var fast: ListNode? = head.next
        var pre: ListNode? = null
        while(fast != null) {
            pre = slow
            slow = slow?.next
            fast = fast?.next?.next
        }
        pre?.next = null

        val n0 = head
        var n1 = head.next
        var n2 = reverse(slow)
        var cur = n0

        while(n1 != null && n2 != null) {
            val next1 = n1.next
            val next2 = n2.next

            cur?.next = n2
            cur = cur?.next
            cur?.next = n1
            cur = cur?.next

            n1 = next1
            n2 = next2
        }
        cur?.next = n1 ?: n2
    }

    fun reverse(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }
        var cur = head
        var pre: ListNode? = null
        while(cur != null) {
            val next = cur.next

            cur.next = pre
            pre = cur

            cur = next
        }
        return pre
    }
}