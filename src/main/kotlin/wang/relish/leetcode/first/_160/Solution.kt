package wang.relish.leetcode.first._160

import struct.ListNode
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 题解牛逼, 指针A走链表A,走完接着走B;指针B走链表B,走完接着走A。以此消除长度差, 当二者都走完时, 如果两者相交此时两个指针都指向了交点; 否则都指向了null。如果两者长度相同, 则提前返回交点。
     */
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val stackA = fillStack(headA)
        val stackB = fillStack(headB)
        if (stackA.isEmpty() || stackB.isEmpty()) {
            return null
        }
        var pre: ListNode? = null
        while (stackB.isNotEmpty() && stackA.isNotEmpty()) {
            val nodeA = stackA.pop()
            val nodeB = stackB.pop()
            if (nodeA != nodeB) {
                break
            }
            pre = nodeA
        }
        return pre
    }

    private fun fillStack(head: ListNode?): Stack<ListNode> {
        val stack = Stack<ListNode>()
        var a = head
        while (a != null) {
            stack.push(a)
            a = a.next
        }
        return stack
    }
}

fun main() {
    val headC = ListNode.newInstance(intArrayOf(8, 4, 5))
    val headA = ListNode.newInstanceWithTail(intArrayOf(4, 1, 2), headC)
    val headB = ListNode.newInstanceWithTail(intArrayOf(5, 6, 1), headC)
    println(Solution().getIntersectionNode(headA, headB))
}

