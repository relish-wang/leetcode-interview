package wang.relish.leetcode._0337

import struct.TreeNode
import kotlin.math.max

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

    fun rob(root: TreeNode?): Int {
        return 0
    }
}

fun main() {
    println(Solution().rob(TreeNode.createTestData("[3,2,3,null,3,null,1]")?.also { it.print() })) // 7
}