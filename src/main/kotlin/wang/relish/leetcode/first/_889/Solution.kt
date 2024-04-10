package wang.relish.leetcode.first._889

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
    val indexMap = mutableMapOf<Int, Int>()

    /**
     * 前序遍历(根-左-右)的特点: 第一个节点一定是根节点
     * 后序遍历的特点(左-右-根): 最后一个节点一定是根节点
     * 前序用于还原树, 后序用于定位结构
     */
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        val n = preorder.size
        for (i in 0 until n) {
            indexMap[postorder[i]] = i
        }
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
        if (preLeft > preRight) {
            return null
        }
        val rootValue = preorder[preLeft]
        val root = TreeNode(rootValue)
        if (preLeft == preRight) {
            return root
        }
        val lv = preorder[preLeft + 1]
        val leftSubTreeRootIndexInPostOrder = indexMap[lv]!! // 左子树节点在后序遍历数组下标
        val leftSubTreeLen = leftSubTreeRootIndexInPostOrder - postLeft + 1
        root.left = bt(
            preorder,
            postorder,
            preLeft + 1,
            preLeft + leftSubTreeLen,
            postLeft,
            leftSubTreeRootIndexInPostOrder
        )
        root.right = bt(
            preorder,
            postorder,
            preLeft + leftSubTreeLen + 1,
            preRight,
            leftSubTreeRootIndexInPostOrder + 1,
            postRight - 1
        )
        return root
    }
}

fun main() {
    // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    Solution().constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1))
        ?.also { it.print() }
}