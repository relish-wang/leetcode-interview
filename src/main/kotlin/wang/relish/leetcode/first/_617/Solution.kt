package wang.relish.leetcode.first._617

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
        if (root1 == null && root2 == null) {
            return null
        }
        val rv = if (root1 == null) {
            root2!!.`val`
        } else if (root2 == null) {
            root1.`val`
        } else {
            root1.`val` + root2.`val`
        }
        val root = TreeNode(rv)
        merge(root, root1, root2)
        return root
    }

    fun merge(root: TreeNode?, root1: TreeNode?, root2: TreeNode?): TreeNode? {
        root?.left = merge(value(root1?.left, root2?.left)?.let { TreeNode(it) }, root1?.left, root2?.left)
        root?.right = merge(value(root1?.right, root2?.right)?.let { TreeNode(it) }, root1?.right, root2?.right)
        return root
    }

    private fun value(root1: TreeNode?, root2: TreeNode?): Int? {
        return if (root1 == null && root2 == null) {
            null
        } else if (root1 == null) {
            root2!!.`val`
        } else if (root2 == null) {
            root1.`val`
        } else {
            root1.`val` + root2.`val`
        }
    }
}

fun main() {
    val r1 = TreeNode.createTestData("[1,3,2,5]")?.also { it.print() }
    val r2 = TreeNode.createTestData("[2,1,3,null,4,null,7]")?.also { it.print() }
    Solution().mergeTrees(r1, r2)?.also { it.print() }
}