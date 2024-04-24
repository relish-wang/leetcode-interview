package wang.relish.leetcode.second._0106

import struct.TreeNode

class Solution {
    var n = 0
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        n = inorder.size
        if (n == 0) {
            return null
        }
        return bt(inorder, 0, n - 1, postorder, 0, n - 1)
    }

    fun bt(inorder: IntArray, il: Int, ir: Int, postorder: IntArray, pl: Int, pr: Int): TreeNode? {
        if (il<0||il>=n||il > ir || pl<0||pl>=n||pl > pr) {
            return null
        }
        val rootValue = postorder[pr]
        val root = TreeNode(rootValue)
        val indexOfRootInInorder = inorder.indexOf(rootValue)
        val leftLen = indexOfRootInInorder-il
        root.left = bt(inorder,il,indexOfRootInInorder-1,postorder,pl,pl+leftLen-1)
        root.right = bt(inorder,indexOfRootInInorder+1,ir,postorder,pl+leftLen,pr-1)
        return root
    }
}