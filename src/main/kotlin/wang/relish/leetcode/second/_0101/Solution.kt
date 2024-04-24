package wang.relish.leetcode.second._0101

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
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return f(root.left, root.right)
    }

    fun f(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null) return false
        if (right == null) return false
        val l = left.`val`
        val r = right.`val`
        return l == r && f(left.left, right.right) && f(left.right, right.left)
    }
}