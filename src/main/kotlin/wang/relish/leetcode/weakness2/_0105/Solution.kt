package wang.relish.leetcode.weakness2._0105

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
        val n = preorder.size
        if (n == 0) return null
        return bt(preorder, inorder, 0, n - 1, 0, n - 1)
    }

    fun bt(preorder: IntArray, inorder: IntArray, preLeft: Int, preRight: Int, inLeft: Int, inRight: Int): TreeNode? {
        val n = preorder.size
        val range = 0..<n
        if (preLeft > preRight || inLeft > inRight || preLeft !in range || preRight !in range || inLeft !in range || inRight !in range) return null
        val rootValue = preorder[preLeft]
        val root = TreeNode(rootValue)
        val indexOfRootInInorder = inorder.indexOf(rootValue)
        if (indexOfRootInInorder == -1) return root
        val lenOfLeft = indexOfRootInInorder - inLeft - 1
        root.left = bt(preorder, inorder, preLeft + 1, preLeft + 1 + lenOfLeft, inLeft, inLeft + lenOfLeft)
        root.right = bt(preorder, inorder, preLeft + 1 + lenOfLeft + 1, preRight, indexOfRootInInorder + 1, inRight)
        return root
    }
}

fun main() {
    Solution().buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))?.print()/*
                  #
            7<
                  #
      20<
                  #
            15<
                  #
3<
            #
      9<
            #
*/
}