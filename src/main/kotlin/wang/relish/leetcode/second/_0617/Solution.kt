package wang.relish.leetcode.second._0617

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
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null) return root2
        if (root2 == null) return root1
        val root = TreeNode(root1.`val` + root2.`val`)
        root.left = mergeTrees(root1.left, root2.left)
        root.right = mergeTrees(root1.right, root2.right)
        return root
    }
}

fun main() {
    val r1 = TreeNode.createTestData("[1,3,2,5]")?.also { it.print() }
    val r2 = TreeNode.createTestData("[2,1,3,null,4,null,7]")?.also { it.print() }
    Solution().mergeTrees(r1, r2)?.also { it.print() } //
}