package wang.relish.leetcode._0160

import struct.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        return null
    }
}

fun main() {
    val headC = ListNode.newInstance(intArrayOf(8, 4, 5))
    val headA = ListNode.newInstanceWithTail(intArrayOf(4, 1, 2), headC)
    val headB = ListNode.newInstanceWithTail(intArrayOf(5, 6, 1), headC)
    println(Solution().getIntersectionNode(headA, headB))
}

