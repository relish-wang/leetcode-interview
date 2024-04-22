package wang.relish.leetcode.second._160

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
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var a = headA
        var b = headB
        while (a != b) {
            a = if (a == null) headB else a.next
            b = if (b == null) headA else b.next
        }
        return a
    }
}

fun main() {
//    val headC = ListNode.newInstance(intArrayOf(8, 4, 5))
//    val headA = ListNode.newInstanceWithTail(intArrayOf(4, 1, 2), headC)
//    val headB = ListNode.newInstanceWithTail(intArrayOf(5, 6, 1), headC)
//    println(Solution().getIntersectionNode(headA, headB)) // [8,4,5]

    val headC = null//ListNode.newInstance(intArrayOf(8, 4, 5))
    val headA = ListNode.newInstanceWithTail(intArrayOf(2, 6, 4), headC)
    val headB = ListNode.newInstanceWithTail(intArrayOf(1, 5), headC)
    println(Solution().getIntersectionNode(headA, headB)) // null
}