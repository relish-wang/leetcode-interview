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
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var l1: ListNode? = list1
        var l2: ListNode? = list2
        val dummy = ListNode(0)
        var c = dummy
        while (l1 != null && l2 != null) {
            val v1 = l1.`val`
            val v2 = l2.`val`
            if (v1 < v2) {
                c.next = l1
                c = c.next!!
                l1 = l1.next
            } else {
                c.next = l2
                c = c.next!!
                l2 = l2.next
            }
        }
        return dummy.next
    }
}