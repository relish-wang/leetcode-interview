package wang.relish.leetcode.second._0889

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
 * @see wang.relish.leetcode.second._0105.Solution.bt
 */
class Solution {

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
        if (n == 0) return null
        if (preLeft !in 0 until n || preRight !in 0 until n || preLeft > preRight) return null
        if (postLeft !in 0 until n || postRight !in 0 until n || postLeft > postRight) return null
        val rootValue = preorder[preLeft]
        val root = TreeNode(rootValue)
        if(preLeft == preRight) return root
        val leftIndexInPreorder = preLeft + 1
        if (leftIndexInPreorder >= n) return root
        val leftIndexInPostorder = postorder.indexOf(preorder[leftIndexInPreorder]) //04:22
        val leftLen = leftIndexInPostorder - postLeft // 2-0
        root.left = bt(preorder, postorder, preLeft + 1, preLeft + 1 + leftLen, postLeft, postLeft + leftLen)
        root.right = bt(preorder, postorder, preLeft + 1 + leftLen + 1, preRight, postLeft + leftLen + 1, postRight - 1)
        return root
    }
}

fun main() {
    // preorder = [1,2,4,5,[3],6,7], postorder = [4,5,2,6,7,[3],1]
    val s = Solution()
    s.constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1))?.also { it.print() }
}