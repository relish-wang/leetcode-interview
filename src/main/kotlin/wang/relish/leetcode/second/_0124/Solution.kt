package wang.relish.leetcode.second._0124

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
        mps(root)
        return ans
    }

    fun mps(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val l = mps(root.left).takeIf { it > 0 } ?: 0
        val r = mps(root.right).takeIf { it > 0 } ?: 0
        ans = max(l + root.`val` + r, ans)
        return max(l, r) + root.`val`
    }
}

fun main() {
//    println(Solution().maxPathSum(TreeNode.createTestData("[-10,9,20,null,null,15,7]")?.also { it.print() })) // 42
//    println(
//        Solution().maxPathSum(
//            TreeNode.createTestData("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]")?.also { it.print() })
//    ) // 16
//    println(Solution().maxPathSum(TreeNode.createTestData("[-10]")?.also { it.print() })) // -10
    println(Solution().maxPathSum(TreeNode.createTestData("[2,-1]")?.also { it.print() })) // -10
}