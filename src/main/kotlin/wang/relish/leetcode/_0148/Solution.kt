package wang.relish.leetcode._0148

import struct.ListNode

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        return null
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println("排序前: $head")
    println("排序后: ${Solution().sortList(head)}")
}