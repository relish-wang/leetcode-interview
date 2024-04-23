package wang.relish.leetcode._0543

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
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return 0
    }
}

fun main() {
//    println(Solution().diameterOfBinaryTree(TreeNode.createTestData("[1,2,3,4,5]").also { it?.print() }))
    println(
        Solution().diameterOfBinaryTree(
            TreeNode.createTestData("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]")
                .also { it?.print() })
    )
}