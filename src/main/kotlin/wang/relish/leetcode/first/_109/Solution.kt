package wang.relish.leetcode.first._109

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
    val list = mutableListOf<Int>()

    /**
     * 用时: 50%
     * 内存: 50%
     */
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) {
            return null
        }
        var c = head
        while (c != null) {
            list.add(c.`val`)
            c = c.next
        }
        return bt(0, list.size)
    }

    fun bt(left: Int, right: Int): TreeNode? {
        if (left == right) {
            return null
        }
        val mid = mid(left, right)
        val root = TreeNode(list[mid])
        root.left = bt(left, mid)
        root.right = bt(mid + 1, right)
        return root
    }

    fun mid(left: Int, right: Int): Int {
        return (left + right) / 2
    }
}

fun main() {
    val list = ListNode.newInstance(intArrayOf(-10, -3, 0, 5, 9))
    val tree = Solution().sortedListToBST(list)
    tree?.print()
}