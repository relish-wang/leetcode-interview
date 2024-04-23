package wang.relish.leetcode._0124

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
    fun maxPathSum(root: TreeNode?): Int {
        return 0
    }
}

fun main() {
//    val tree = TreeNode.createTestData("[1,2,3]") // 6
//    val tree = TreeNode.createTestData("[-10,9,20,null,null,15,7]") //42
//    val tree = TreeNode.createTestData("[-3]") //-3
//    val tree = TreeNode.createTestData("[1,-2,-3,1,3,-2,null,-1]") // 3
    val tree = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]") // 48
    tree?.print()
    println(Solution().maxPathSum(tree))
}