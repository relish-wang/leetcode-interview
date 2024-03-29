package _129

import TreeNode

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
        if (root == null) {
            return 0
        }
        return sm(root, 0)
    }

    fun sm(root: TreeNode?, s: Int): Int {
        if (root == null) {
            return s
        }
        val sum = s * 10 + root.`val`
        val l = root.left
        val r = root.right
        return if (l == null && r == null) {
            sum
        } else if (l == null || r == null) {
            if (l != null) {
                sm(l, sum)
            } else
                sm(r, sum)
        } else {
            sm(l, sum) + sm(r, sum)
        }
    }
}

fun main() {
    println(Solution().sumNumbers(TreeNode.createTestData("[0,1]")))
//    println(Solution().sumNumbers(TreeNode.createTestData("[1,2,3]")))
//    println(Solution().sumNumbers(TreeNode.createTestData("[4,9,0,5,1]")))
}