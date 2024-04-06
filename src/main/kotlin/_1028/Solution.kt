package _1028

import TreeNode
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
        val m = Pattern.compile("-*\\d+").matcher(traversal) // 正则匹配【0~多个"-"拼接1到多个数字】的字符串
        var root: TreeNode? = null
        val stack = Stack<Pair<Int, TreeNode>>() // 节点 和 它的深度
        while (m.find()) {
            val (level, value) = parseLevelAndValue(m.group()) // 解析出当前节点和节点深度
            val node = TreeNode(value)
            if (level == 0 && root == null) {
                root = node // 获得根结点
                stack.push(level to node) // 根节点入栈
                continue
            }
            // 持续出栈到栈顶节点的深度是当前节点深度-1
            while (level <= stack.peek().first) {
                stack.pop()
            }
            val (l, p) = stack.peek() // 此时的栈顶节点就是当前节点的父节点
            if (level == l + 1) {
                if (p.left == null) { // 父节点的左孩子为空, 则成为它的左孩子
                    p.left = node
                } else { // 左孩子已经有节点占据了, 则成为父节点的右孩子
                    p.right = node
                }
                stack.push(level to node) // 自己入栈
            }
        }
        return root
    }

    private fun parseLevelAndValue(lv: String): Pair<Int, Int> {
        var i = 0 // -的数量, 即节点的深度
        while (lv[i] == '-') {
            i++
        }
        return i to lv.substring(i).toInt()
    }
}

fun main() {
//    Solution().recoverFromPreorder("1-2--3--4-5--6--7")?.print()
//    Solution().recoverFromPreorder("1-2--3---4-5--6---7")?.print()
    Solution().recoverFromPreorder("1-401--349---90--88")?.print()
}