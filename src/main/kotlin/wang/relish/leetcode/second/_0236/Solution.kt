package wang.relish.leetcode.second._0236

import struct.TreeNode
import struct.TreeNode.Companion.findChildTree

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */

class Solution {
    /**
     * 用时: 100%
     * 内存: 83.10%
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return null
    }
}


fun main() {
    val root = TreeNode.createTestData("[-1,0,3,-2,4,null,null,8]")
    root?.print()
    val p = root?.findChildTree(8)
    val q = root?.findChildTree(4)
    println("${p?.`val`} 和 ${q?.`val`} 的最近公共父节点是: " + Solution().lowestCommonAncestor(root, p, q)?.`val`)
}