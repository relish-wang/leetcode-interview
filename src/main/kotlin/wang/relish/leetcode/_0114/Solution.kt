package wang.relish.leetcode._0114

import struct.TreeNode
import java.util.*

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
    fun flatten(root: TreeNode?): Unit {

    }
}

fun main() {
    val root = TreeNode.createTestData("[1,2,5,3,4,null,6]").also { it?.print() }
    Solution().flatten(root)
    root?.print()
}