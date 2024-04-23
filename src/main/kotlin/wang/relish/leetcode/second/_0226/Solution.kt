package wang.relish.leetcode.second._0226

import struct.TreeNode

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
    fun invertTree(root: TreeNode?): TreeNode? {
        return null
    }
}

fun main() {
    val tree = TreeNode.createTestData("[4,2,7,1,3,6,9]")
    tree?.print()
    Solution().invertTree(tree)?.print()
}