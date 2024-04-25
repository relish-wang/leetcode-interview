package wang.relish.leetcode.weakness2._0109

import struct.ListNode
import struct.TreeNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 */
class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return null
    }
}

fun main() {
    val list = ListNode.newInstance(intArrayOf(-10, -3, 0, 5, 9))
    val tree = Solution().sortedListToBST(list)
    tree?.print()
}