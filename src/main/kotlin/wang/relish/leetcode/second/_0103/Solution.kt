package wang.relish.leetcode.second._0103

import struct.TreeNode
import wang.relish.leetcode.first._102.print

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
        val ans = mutableListOf<MutableList<Int>>()
        if (root == null) return ans
        val l = mutableListOf<TreeNode>()
        l.add(root)
        var odd = true
        while (l.isNotEmpty()) {
            if (odd) {
                val n = l.size
                val list = mutableListOf<Int>()
                for (i in 0 until n) {
                    val t = l.removeFirst()
                    list.add(t.`val`)
                    t.left?.let { l.add(it) }
                    t.right?.let { l.add(it) }
                }
                ans.add(list)
            } else {
                val n = l.size
                val list = mutableListOf<Int>()
                for (i in 0 until n) {
                    val t = l.removeLast()
                    list.add(t.`val`)
                    t.right?.let { l.add(0, it) }
                    t.left?.let { l.add(0, it) }
                }
                ans.add(list)
            }
            odd = !odd
        }
        return ans
    }
}

fun main() {
    Solution().zigzagLevelOrder(TreeNode.createTestData("[3,9,20,null,null,15,7]")?.also { it.print() }).print()
}