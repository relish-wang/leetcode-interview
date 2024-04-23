package wang.relish.leetcode._0103

import struct.TreeNode
import struct.print

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        return listOf()
    }
}

fun main() {
    Solution().zigzagLevelOrder(TreeNode.createTestData("[3,9,20,null,null,15,7]")?.also { it.print() }).print()
}