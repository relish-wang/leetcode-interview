package wang.relish.leetcode.second._0543

import struct.TreeNode
import kotlin.math.max

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
    var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        f(root)
        return max - 1
    }

    fun f(root: TreeNode?): Int {
        if (root == null) return 0
        val left = root.left
        val right = root.right
        val l = f(left)
        val r = f(right)
        max = max(l + 1 + r, max)
        return max(l, r) + 1
    }
}

fun main() {
    println(Solution().diameterOfBinaryTree(TreeNode.createTestData("[1,2,3,4,5]"))) // 3
    println(Solution().diameterOfBinaryTree(TreeNode.createTestData("[1,2]"))) // 1
}