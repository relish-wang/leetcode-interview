package wang.relish.leetcode.second._142

import struct.ListNode
import java.util.Stack

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
     * 3 -> 2 -> 0 -> -4
     *       |_________|
     */
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        var has = false
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast) {
                has = true
                break
            }
        }
        if (has.not()) return null
        var l1 = head
        while (l1 != slow) {
            l1 = l1?.next
            slow = slow?.next
        }
        return slow
    }
}