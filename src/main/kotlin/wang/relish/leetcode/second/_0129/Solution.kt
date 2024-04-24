package wang.relish.leetcode.second._0129

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
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var sum = 0
        val q = LinkedList<Pair<TreeNode, Int>>()
        q.add(root to 0)
        while (q.isNotEmpty()) {
            val n = q.size
            for (i in 0 until n) {
                val pair = q.poll()
                val node = pair.first
                val num = pair.second
                val newNum = num * 10 + node.`val`
                val l = node.left?.let { q.offer(it to newNum) }
                val r = node.right?.let { q.offer(it to newNum) }
                if (l == null && r == null) {
                    sum += newNum
                }
            }
        }
        return sum
    }
}