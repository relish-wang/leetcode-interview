package wang.relish.leetcode.second._021

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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var c = dummy
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            val v1 = l1.`val`
            val v2 = l2.`val`
            if (v1 < v2) {
                c.next = l1
                l1 = l1.next
            } else {
                c.next = l2
                l2 = l2.next
            }
            c = c.next!!
        }
        c.next = l1?:l2
        return dummy.next
    }
}