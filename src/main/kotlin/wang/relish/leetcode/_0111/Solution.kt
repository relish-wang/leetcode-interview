package wang.relish.leetcode._0111

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
    fun minDepth(root: TreeNode?): Int {
        return 0
    }
}

fun main() {
//    val tree = TreeNode.createTestData("[3,9,20,null,null,15,7]")
    val tree = TreeNode.createTestData("[2,null,3,null,4,null,5,null,6]")
//    val tree = TreeNode.createTestData("[1,null,2,3]")
    tree?.print()
    println(Solution().minDepth(tree))
}