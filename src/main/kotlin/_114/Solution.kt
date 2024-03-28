package _114

import TreeNode
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
        if (root == null) {
            return
        }
        var c = root
        var newRoot: TreeNode? = TreeNode(root.`val`)
        val newHead = newRoot
        val stack = Stack<TreeNode>()
        while (c != null) {
            stack.push(c)
            if (c.left == null) {
                break
            }
            c = c.left
            newRoot?.left = null
            newRoot?.right = TreeNode(c!!.`val`)
            newRoot = newRoot?.right
        }

        while (stack.isNotEmpty()) {
            val n = stack.pop()
            val nr = n.right
            if (nr != null) {
                flatten(nr)
                newRoot?.right = nr
                var n2 = nr
                while (n2 != null) {
                    if (n2.right == null) {
                        break
                    }
                    n2 = n2.right
                }
                newRoot = n2
            }
        }
        root.left = null
        root.right = newHead?.right
    }



    var pre: TreeNode? = null

    /**
     * 利用后续遍历, 达成前序遍历的顺序
     */
    fun f(root: TreeNode?) {
        if (root == null) return
        f(root.right)
        f(root.left)
        root.right = pre
        root.left = null
        pre = root
    }
}

fun main() {
    val root = TreeNode.createTestData("[1,2,5,3,4,null,6]").also { it?.print() }
    Solution().f(root)
    root?.print()
}