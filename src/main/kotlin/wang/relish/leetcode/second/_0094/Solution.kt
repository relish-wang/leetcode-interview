package wang.relish.leetcode.second._0094

import struct.TreeNode

class Solution {
    val ans = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        f(root)
        return ans
    }

    fun f(root: TreeNode?) {
        if (root == null) return
        f(root.left)
        ans.add(root.`val`)
        f(root.right)
    }
}

fun main() {
    println(Solution().inorderTraversal(TreeNode.createTestData("[1,null,2,3]")))
}