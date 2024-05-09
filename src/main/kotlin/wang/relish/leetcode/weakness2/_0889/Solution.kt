package wang.relish.leetcode.weakness2._0889

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
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * @see _105.bt
 */
class Solution {
    /**
     * 应该整个indexMap提升效率
     */
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        val n = preorder.size
        return bt(preorder, postorder, 0, n - 1, 0, n - 1)
    }

    fun bt(
        preorder: IntArray,
        postorder: IntArray,
        preLeft: Int,
        preRight: Int,
        postLeft: Int,
        postRight: Int
    ): TreeNode? {
        val n = preorder.size
        val range = 0 until n
        if (preLeft !in range || preRight !in range || postLeft !in range || postRight !in range || preLeft > preRight || postLeft > postRight) {
            return null
        }
        val rootValue = preorder[preLeft]
        val root = TreeNode(rootValue)
        if (preLeft + 1 >= n || preLeft == preRight) return root
        val indexL = postorder.indexOf(preorder[preLeft + 1])
        if (indexL == -1) return root
        val lenL = indexL - postLeft
        root.left = bt(preorder, postorder, preLeft + 1, preLeft + 1 + lenL, postLeft, postLeft + lenL)
        root.right = bt(preorder, postorder, preLeft + 1 + lenL + 1, preRight, postLeft + lenL + 1, postRight - 1)
        return root
    }
}


fun main() {
    // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    val s = Solution()
    s.constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1))?.also { it.print() }
}