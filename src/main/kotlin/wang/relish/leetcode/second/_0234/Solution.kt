package wang.relish.leetcode.second._0234

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
     * 时间O(n), 空间O(1)
     */
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var l2 = head
        var l1 = reverse(slow?.next)
        while (l1 != null) {
            if (l1.`val` != l2?.`val`) {
                return false
            }
            l1 = l1.next
            l2 = l2.next
        }
        return true
    }

    fun reverse(head: ListNode?): ListNode? {
        if (head == null) return null
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }
}

fun main() {
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 1)))) //  true
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 3, 1)))) // false
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 2, 1)))) // true
}