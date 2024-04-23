package wang.relish.leetcode._0889

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

    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        return null
    }
}

fun main() {
    // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    val s = Solution()
    s.constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1))?.also { it.print() }
}