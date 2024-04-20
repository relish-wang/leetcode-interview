package wang.relish.leetcode.second._124

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

    var ans = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        root?.`val`?.let { ans = it }
        mps(root)
        return ans
    }

    fun mps(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val v = root.`val`
        val left = root.left
        val right = root.right
        val maxl = mps(left)
        val maxr = mps(right)
        val l = maxl.takeIf { it != 0 } ?: Int.MIN_VALUE
        val r = maxr.takeIf { it != 0 } ?: Int.MIN_VALUE
        val lv = maxl + v
        val vr = maxr + v
        val lvr = maxl + v + maxr
        val a = max(max(max(max(max(l, r), v), lv), vr), lvr)
        ans = max(a, ans)
//        println("【$ans】 a = $a, v = ${v}, l = $l, r = $r")
        return max(v + max(maxl, maxr), v)
    }
}

fun main() {
//    println(Solution().maxPathSum(TreeNode.createTestData("[-10,9,20,null,null,15,7]")?.also { it.print() })) // 42
    println(
        Solution().maxPathSum(
            TreeNode.createTestData("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]")?.also { it.print() })
    ) // 16
    //println(Solution().maxPathSum(TreeNode.createTestData("[-10]")?.also { it.print() })) // -10
}