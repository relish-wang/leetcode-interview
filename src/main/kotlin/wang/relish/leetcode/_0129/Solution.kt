package wang.relish.leetcode._0129

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
    fun sumNumbers(root: TreeNode?): Int {
        return 0
    }
}

fun main() {
    println(Solution().sumNumbers(TreeNode.createTestData("[0,1]")))
//    println(Solution().sumNumbers(TreeNode.createTestData("[1,2,3]")))
//    println(Solution().sumNumbers(TreeNode.createTestData("[4,9,0,5,1]")))
}