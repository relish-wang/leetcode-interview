package wang.relish.leetcode.second._105

import struct.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return bt(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
    }

    fun bt(preorder: IntArray, pl: Int, pr: Int, inorder: IntArray, il: Int, ir: Int): TreeNode? {
        val n = preorder.size
        if (pl < 0 || pl >= n || pr < 0 || pr >= n || il < 0 || il >= n || ir < 0 || ir >= n || pl > pr || il > ir) return null
        val rootValue = preorder[pl]
        val root = TreeNode(rootValue)
        val indexOfRootInInOrder = inorder.indexOf(rootValue) // root的位置
        if (indexOfRootInInOrder == -1) return null
        val leftLen = indexOfRootInInOrder - il
        root.left = bt(preorder, pl + 1, pl + 1 + leftLen - 1, inorder, il, indexOfRootInInOrder - 1)
        root.right = bt(preorder, pl + 1 + leftLen - 1 + 1, pr, inorder, indexOfRootInInOrder + 1, ir)
        return root
    }
}

fun main() {
    Solution().buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))?.print()
}