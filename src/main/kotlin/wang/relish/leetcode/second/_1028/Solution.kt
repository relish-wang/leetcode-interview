package wang.relish.leetcode.second._1028

import struct.TreeNode
import java.util.*
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
        val list = f(traversal)
        val root = TreeNode(list[0].first)
        var i = 1
        val s = Stack<Pair<TreeNode, Int>>()
        s.push(root to 0)
        while (i < list.size) {
            val (value, level) = list[i]
            val (p, pLevel) = s.peek()
            if (pLevel + 1 == level) {
                val n = TreeNode(value)
                if (p.left == null) {
                    p.left = n
                    s.push(n to level)
                    i++
                } else if (p.right == null) {
                    p.right = n
                    s.push(n to level)
                    i++
                } else {
                    s.pop()
                }
            } else if (pLevel == level) {
                s.pop()
            } else {
                s.pop()
            }
        }
        return root
    }

    fun f(traversal: String): List<Pair<Int, Int>> { // value to level
        val compile = Pattern.compile("-*\\d+")
        val m = compile.matcher(traversal)
        val ans = mutableListOf<Pair<Int, Int>>()
        while (m.find()) {
            val group = m.group()
            var i = 0
            while (group[i] == '-') i++
            ans.add(group.substring(i).toInt() to i)
        }
        return ans
    }
}

fun main() {
    Solution().recoverFromPreorder("1-2--3--4-5--6--7")?.print()
    Solution().recoverFromPreorder("1-2--3---4-5--6---7")?.print()
    Solution().recoverFromPreorder("1-401--349---90--88")?.print()
}