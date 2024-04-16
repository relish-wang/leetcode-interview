package wang.relish.leetcode.second._098

import struct.TreeNode
import kotlin.math.max
import kotlin.math.min

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
    fun isValidBST(root: TreeNode?): Boolean {
//        return preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE)
//        return inOrder(root)
        return postOrder(root)[1] != Long.MAX_VALUE
    }

    /**
     * 前序遍历解法
     * 02:28
     */
    fun preOrder(root: TreeNode?, lower: Long, upper: Long): Boolean {
        if (root == null) return true
        val v = root.`val`.toLong()
        if (v <= lower || v >= upper) return false
        return preOrder(root.left, lower, v) && preOrder(root.right, v, upper)
    }


    var pre: Long = Long.MIN_VALUE

    /**
     * 中序遍历解法
     * 01:38
     */
    fun inOrder(root: TreeNode?): Boolean {
        if (root == null) return true
        if (inOrder(root.left).not()) return false
        val v = root.`val`.toLong()
        if (v <= pre) return false
        pre = v
        return inOrder(root.right)
    }

    /**
     * 后序遍历解法
     * 4:12
     */
    fun postOrder(root: TreeNode?): LongArray {
        if (root == null) return longArrayOf(Long.MAX_VALUE, Long.MIN_VALUE)
        val l = postOrder(root.left)
        val r = postOrder(root.right)
        val v = root.`val`.toLong()
        if (v <= l[1] || v >= r[0]) return longArrayOf(Long.MIN_VALUE, Long.MAX_VALUE)
        return longArrayOf(min(v, l[0]), max(v, r[1]))
    }

    /**
     * 层序遍历解法
     */
}

fun main() {
    println(Solution().isValidBST(TreeNode.createTestData("[2,1,3]"))) // true
    println(Solution().isValidBST(TreeNode.createTestData("[5,4,6,null,null,3,7]").also { it?.print() })) // false
    println(Solution().isValidBST(TreeNode.createTestData("[3,1,5,0,2,4,6]").also { it?.print() })) // true
}