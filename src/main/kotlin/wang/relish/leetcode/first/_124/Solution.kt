package wang.relish.leetcode.first._124

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
    var max = Int.MIN_VALUE
    /**
     * 困难题
     * 树、深度优先搜索、动态规划、二叉树
     *
     * 以root为根节点的最大最路径和:
     * - 左子树的最大路径和
     * - 右子树的最大路径和
     * 递归注意: 只能选择【根+左】 或者 【根+右】, 其中【根+左+右】的组合只有在取最值的时候判断用, 不能用于结果递归
     * 用时: 63.04%
     * 用时: 89.13%
     */
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        mps(root)
        return max
    }

    fun mps(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val rv = root.`val`
        val left = mps(root.left)
        val right = mps(root.right)
        return max(max(left + rv, right + rv), rv).also {
            max = max(max(max, it), (left + rv + right))
        }
    }
}

fun main() {
//    val tree = TreeNode.createTestData("[1,2,3]") // 6
//    val tree = TreeNode.createTestData("[-10,9,20,null,null,15,7]") //42
//    val tree = TreeNode.createTestData("[-3]") //-3
//    val tree = TreeNode.createTestData("[1,-2,-3,1,3,-2,null,-1]") // 3
    val tree = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]") // 48
    tree?.print()
    println(Solution().maxPathSum(tree))
}