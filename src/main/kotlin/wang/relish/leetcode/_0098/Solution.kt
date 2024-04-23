package wang.relish.leetcode._0098

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
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return false
    }
}

fun main() {
    println(Solution().isValidBST(TreeNode.createTestData("[2,1,3]"))) // true
    println(Solution().isValidBST(TreeNode.createTestData("[5,4,6,null,null,3,7]").also { it?.print() })) // false
    println(Solution().isValidBST(TreeNode.createTestData("[3,1,5,0,2,4,6]").also { it?.print() })) // true
}