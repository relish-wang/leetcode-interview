package _206

import ListNode
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/reverse-linked-list/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 题目要求迭代和递归各来一种解法, 这算迭代吧
     */
    fun reverseList1(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val s = Stack<ListNode>()
        var c = head
        while (c != null) {
            s.push(c)
            c = c.next
        }
        val h = s.pop()
        var pre = h
        while (s.isNotEmpty()) {
            val p = s.pop()
            pre.next = p
            p.next = null
            pre = pre.next
        }
        return h
    }

    fun reverseList2(head: ListNode?): ListNode? {
        return reverseList(head, null)
    }

    /**
     * [1,2,3,4,5] null
     * [2,3,4,5] [1]
     * [3,4,5] [2,1]
     * [4,5] [3,2,1]
     * [5] [4,3,2,1]
     */
    fun reverseList(head: ListNode?, tail: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            head.next = tail
            return head
        }
        val next = head.next // 提前取出来
        head.next = tail
        return reverseList(next, head)
    }

    /**
     * 用什么栈呐 庸俗
     */
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var cur = head
        var pre: ListNode? = null
        while (cur != null) {
            val nex = cur.next
            cur.next = pre
            pre = cur
            cur = nex
        }
        return pre
    }
}

fun main() {
    println(Solution().reverseList(ListNode.newInstance(intArrayOf(1, 2, 3, 4, 5))))
}