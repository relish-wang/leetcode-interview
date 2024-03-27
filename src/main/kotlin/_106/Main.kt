package _106

import _094.TreeNode

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
    val indexMap = mutableMapOf<Int, Int>()

    /**
     * 在看了中序和前序遍历生成树的题解后, 把这题做出来了
     * 用时: 96.74%
     * 内存: 94.56%
     */
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val n = inorder.size
        for (i in 0 until n) {
            indexMap[inorder[i]] = i
        }
        return bt(inorder, postorder, 0, n - 1, 0, n - 1)
    }

    fun bt(inorder: IntArray, postorder: IntArray, il: Int, ir: Int, pl: Int, pr: Int): TreeNode? {
        if (pl > pr) return null
        val rv = postorder[pr] // RootValue: 根节点值
        val riio = indexMap[rv]!! // rootIndexInInOrder: 根节点在中序遍历中的索引
        val root = TreeNode(rv) // 构建根节点
        val solst = riio - il // sizeOfLeftSubTree: 左子树的节点个数
        root.left = bt(inorder, postorder, il, riio - 1, pl, pl + solst - 1)
        root.right = bt(inorder, postorder, riio + 1, ir, pl + solst, pr - 1)
        return root
    }
}


fun main() {
    // 中序: 9 |3| 15 20 7
    // 后序: 9 15 7 20 |3
    val tree = Solution().buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
    TreeNode.print(tree)
}