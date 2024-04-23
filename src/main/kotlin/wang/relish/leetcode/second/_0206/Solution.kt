package wang.relish.leetcode._0206

import struct.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/reverse-linked-list/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 题目要求迭代和递归各来一种解法
     */
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head?.next
        var pre = head?.apply { next = null }
        while (cur != null) {
            val next = cur.next

            cur.next = pre
            pre = cur

            cur = next
        }
        return pre
    }
}

fun main() {
    println(Solution().reverseList(ListNode.newInstance(intArrayOf(1, 2, 3, 4, 5)))) // [5,4,3,2,1]
}