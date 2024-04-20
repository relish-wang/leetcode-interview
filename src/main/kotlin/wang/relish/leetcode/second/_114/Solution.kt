package wang.relish.leetcode.second._114

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
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        val t = root.right
        flatten(t)
        val left = root.left
        flatten(left)
        val last = getLast(left)
        last?.right = t
        root.left = null
        root.right = left ?: t
    }

    fun getLast(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }
        var c = node
        while (c?.right != null) {
            c = c?.right
        }
        return c
    }
}

fun main() {
    val r = TreeNode.createTestData("[1,2,5,3,4,null,6]")?.also { it.print() }
    Solution().flatten(r)
    r?.print()
}