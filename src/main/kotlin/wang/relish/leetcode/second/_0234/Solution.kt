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
            fast = fast?.next?.next
        }
        var p1 = head
        var p2 = reverse(slow?.next)
        while (p2 != null) {
            if (p1?.`val` != p2.`val`) {
                return false
            }
            p1 = p1.next
            p2 = p2.next
        }
        return true
    }

    fun reverse(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val t = cur.next
            cur.next = pre
            pre = cur
            cur = t
        }
        return pre
    }
}

fun main() {
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 1)))) //  true
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 3, 1)))) // false
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 2, 1)))) // true
}