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
        if (root == null) return null
        if (p == null || find(q, p.`val`)) return q
        if (q == null || find(p, q.`val`)) return p
        val pv = p.`val`
        val qv = q.`val`
        var c = root
        while (c != null) {
            val l = find(c.left, pv) && find(c.left, qv)
            if (l) {
                c = c.left
                continue
            }
            val r = find(c.right, pv) && find(c.right, qv)
            if (r) {
                c = c.right
                continue
            }
            return c
        }
        return null
    }
    fun find(a: TreeNode?, k: Int): Boolean {
        if (a == null) return false
        if (a.`val` == k) {
            return true
        }
        return find(a.left, k) || find(a.right, k)
    }
}


fun main() {
    val root = TreeNode.createTestData("[-1,0,3,-2,4,null,null,8]")
    root?.print()
    val p = root?.findChildTree(8)
    val q = root?.findChildTree(4)
    println("${p?.`val`} 和 ${q?.`val`} 的最近公共父节点是: " + Solution().lowestCommonAncestor(root, p, q)?.`val`) // 0
}