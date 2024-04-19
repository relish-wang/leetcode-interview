package wang.relish.leetcode.second._111

import struct.TreeNode
import java.util.LinkedList

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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val q = LinkedList<TreeNode>()
        q.offer(root)
        var depth = 1
        while (q.isNotEmpty()) {
            val n = q.size
            for (i in 0 until n) {
                val node = q.poll()
                val left = node.left?.also { q.offer(it) }
                val right = node.right?.also { q.offer(it) }
                if (left == null && right == null) {
                    return depth
                }
            }
            depth++
        }
        return depth
    }
}

fun main() {
    println(Solution().minDepth(TreeNode.createTestData("[2,null,3,null,4,null,5,null,6]")?.also { it.print() }))
}