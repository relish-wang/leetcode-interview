package wang.relish.leetcode.second._0328

import struct.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/odd-even-linked-list/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        return null
    }
}

fun main() {
    println(
        Solution().oddEvenList(
            ListNode.newInstance(intArrayOf(1, 2, 3, 4, 5)).also { println(it?.toString()) })
    ) // 1 3 5 2 4
    println(
        Solution().oddEvenList(
            ListNode.newInstance(intArrayOf(2, 1, 3, 5, 6, 4, 7)).also { println(it?.toString()) })
    ) // 2,3,6,7,1,5,4
}