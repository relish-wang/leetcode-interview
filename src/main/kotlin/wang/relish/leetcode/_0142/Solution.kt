package wang.relish.leetcode._0142

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
    fun detectCycle(head: ListNode?): ListNode? {
        return null
    }
}

fun main() {
//    val head = ListNode.withLoop(intArrayOf(3, 2, 0, -4), 1)
    val head = ListNode.withLoop(intArrayOf(0, 1), 0)
    println(head)
    val node = Solution().detectCycle(head)
    println(node)
}