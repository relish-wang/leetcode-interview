package wang.relish.leetcode.first._141

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
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var s = head
        var f = head
        while (s != null && f != null) {
            s = s.next
            f = f.next?.next ?: return false
            if (s != null && s == f) {
                return true
            }
        }
        return false
    }
}