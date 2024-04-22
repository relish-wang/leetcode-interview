package wang.relish.leetcode.second._337

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

    fun rob(root: TreeNode?): Int {
        if (root == null) return 0
        return r(root).let { max(it[0], it[1]) }
    }

    fun r(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf(0, 0)
        val v = root.`val`
        val l = root.left
        val r = root.right
        val res = IntArray(2)
        val lv = r(l)
        val rv = r(r)
        res[0] = max(lv[0], lv[1]) + max(rv[0], rv[1])
        res[1] = lv[0] + rv[0] + v
        return res
    }
}

fun main() {
    println(Solution().rob(TreeNode.createTestData("[3,2,3,null,3,null,1]")?.also { it.print() })) // 7
}