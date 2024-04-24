package wang.relish.leetcode.second._0148.quicksort

import struct.ListNode

/**
 * 快排解法
 */
class Solution {

    /**
     * TODO 有时间再练
     */
    fun sortList(head: ListNode?): ListNode? {
        return null
    }
}

fun main() {
    val head = ListNode.newInstance(intArrayOf(4, 19, 14, 5, -3, 1, 8, 5, 11, 15))
    println(head)
    println(Solution().sortList(head))
}