package wang.relish.leetcode.first._111

import struct.TreeNode
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
    /**
     * bfs(广度优先遍历)更好,可以在找到第一个叶子节点的时候return, 而不需要遍历完整个树
     */
    fun minDepth(root: TreeNode?): Int {
        return md(root, 0)
    }

    fun md(root: TreeNode?, level: Int): Int {
        if (root == null) return level
        val l = root.left
        val r = root.right
        return if (l == null && r == null) {
            level + 1
        } else if (l == null || r == null) {
            if (l == null) {
                md(r, level + 1)
            } else {
                md(l, level + 1)
            }
        } else {
            min(md(root.left, level + 1), md(root.right, level + 1))
        }
    }
}

fun main() {
//    val tree = TreeNode.createTestData("[3,9,20,null,null,15,7]")
    val tree = TreeNode.createTestData("[2,null,3,null,4,null,5,null,6]")
//    val tree = TreeNode.createTestData("[1,null,2,3]")
    tree?.print()
    println(Solution().minDepth(tree))
}