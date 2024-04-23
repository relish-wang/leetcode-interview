package wang.relish.leetcode._1028

import struct.TreeNode
import java.util.Stack
import java.util.regex.Pattern

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
    fun recoverFromPreorder(traversal: String): TreeNode? {
        return null
    }
}

fun main() {
//    Solution().recoverFromPreorder("1-2--3--4-5--6--7")?.print()
//    Solution().recoverFromPreorder("1-2--3---4-5--6---7")?.print()
    Solution().recoverFromPreorder("1-401--349---90--88")?.print()
}