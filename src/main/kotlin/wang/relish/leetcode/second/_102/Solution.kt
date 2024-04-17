package wang.relish.leetcode.second._102

import struct.TreeNode
import java.util.LinkedList
import java.util.Queue

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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        if(root == null)return ans
        val q = LinkedList<TreeNode>()
        q.offer(root)
        while (q.isNotEmpty()) {
            val n = q.size
            val l = mutableListOf<Int>()
            for (i in 0 until n) {
                val t = q.poll()
                l.add(t.`val`)
                t.left?.let { q.offer(it) }
                t.right?.let { q.offer(it) }
            }
            ans.add(l)
        }
        return ans
    }
}