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
        return false
    }
}

fun main() {
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 1))))
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 3, 1))))
}