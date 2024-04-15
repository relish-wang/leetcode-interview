package wang.relish.leetcode.second._098

import struct.TreeNode
import java.lang.Long.max
import java.lang.Long.min

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
//        return preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE) // 前序遍历解法
//        return inOrder(root) // 中序遍历解法
        return postOrder(root)[1]!= Long.MAX_VALUE // 后序遍历解法
    }

    /**
     * 04:58
     */
    fun preOrder(root: TreeNode?, lower: Long, upper: Long): Boolean {
        if (root == null) return true
        val v = root.`val`.toLong()
        if (v !in lower + 1..<upper) return false
        return preOrder(root.left, lower, v) && preOrder(root.right, v, upper)
    }


    var pre: Long? = null

    /**
     * 中序遍历解法
     * 04:00
     */
    fun inOrder(root: TreeNode?): Boolean {
        if (root == null) return true
        if (inOrder(root.left).not()) return false
        val v = root.`val`.toLong()
        if (pre == null) {
            pre = v
        } else {
            if (v <= pre!!) {
                return false
            }
            pre = v
        }
        return inOrder(root.right)
    }

    fun postOrder(root: TreeNode?): LongArray {
        if (root == null) {
            return longArrayOf(Long.MAX_VALUE, Long.MIN_VALUE)
        }
        val left = postOrder(root.left)
        val right = postOrder(root.right)
        val v = root.`val`.toLong()
        if (v <= left[1] || v >= right[0]) return longArrayOf(Long.MIN_VALUE, Long.MAX_VALUE)
        return longArrayOf(min(left[0], v), max(right[1], v))
    }
}

fun main() {
    println(Solution().isValidBST(TreeNode.createTestData("[2,1,3]"))) // true
    println(Solution().isValidBST(TreeNode.createTestData("[5,4,6,null,null,3,7]").also { it?.print() })) // false
    println(Solution().isValidBST(TreeNode.createTestData("[3,1,5,0,2,4,6]").also { it?.print() })) // true
}