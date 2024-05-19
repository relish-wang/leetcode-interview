package wang.relish.leetcode.interview._0083

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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        var pre: ListNode = head
        var cur = head?.next
        while (cur != null) {
            if (cur.`val` == pre.`val`) {
                pre.next = cur.next
            } else {
                pre = cur
            }
            cur = cur.next
        }
        return head
    }
}