package _236

import TreeNode
import TreeNode.Companion.findChildTree

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * 我的题解: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/2721470/yong-shi-ji-bai-100de-kotlinxuan-shou-by-xsp7/
 */

class Solution {
    /**
     * 用时: 100%
     * 内存: 83.10%
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        val pv = p.`val`
        val qv = q.`val`
        // 判断p、q是否在root树内
        if (inTree(root, pv).not() || inTree(root, qv).not()) {
            return null
        }
        // 判断q是否在p树内
        if (inTree(p, qv)) {
            return p
        }
        // 判断p是否在q树内
        if (inTree(q, pv)) {
            return q
        }
        var cur = root // p、q的公共祖先
        while (cur != null) {
            // child不为空, 则表示child是p、q的公共祖先
            val child = cur.left?.takeIf {
                inTree(it, pv) && inTree(it, qv)
            } ?: cur.right?.takeIf {
                inTree(it, pv) && inTree(it, qv)
            }
            if (child == null) {
                // child为空则表示它已经不是p、q的公共祖先了, 那么它的parent, 也就是cur, 是p、q的【最近】公共祖先.
                return cur
            }
            cur = child
        }
        return null
    }

    fun inTree(root: TreeNode?, n: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.`val` == n) {
            return true
        }
        return inTree(root.left, n) || inTree(root.right, n)
    }
}


fun main() {
    val root = TreeNode.createTestData("[-1,0,3,-2,4,null,null,8]")
    root?.print()
    val p = root?.findChildTree(8)
    val q = root?.findChildTree(4)
    println("${p?.`val`} 和 ${q?.`val`} 的最近公共父节点是: " + Solution().lowestCommonAncestor(root, p, q)?.`val`)
}