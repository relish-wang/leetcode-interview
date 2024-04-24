package wang.relish.leetcode.second._0109

import struct.ListNode
import struct.TreeNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return bt(head)
    }

    fun bt(head: ListNode?): TreeNode? {
        if (head == null) return null
        if (head.next == null) return TreeNode(head.`val`)
        if (head.next?.next == null) {
            return TreeNode(head.next!!.`val`).apply { left = TreeNode(head.`val`) }
        }
        var slow = head
        var fast = head.next
        var pre = head
        while (slow != null && fast?.next != null) {
            pre = slow
            slow = slow.next
            fast = fast.next?.next
        }
        pre?.next = null
        val root = slow?.`val`?.let { TreeNode(it) }
        root?.left = bt(head)
        root?.right = bt(slow?.next)
        return root
    }
}

fun main() {
    Solution().sortedListToBST(ListNode.newInstance(intArrayOf(-10, -3, 0, 5, 9)))?.also { it.print() }
}