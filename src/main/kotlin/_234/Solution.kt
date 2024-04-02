package _234

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
 */
class Solution {
    /**
     * 双指针或者哈希法
     * 时间O(n), 空间O(1)
     */
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var p1 = head
        var p2 = reverse(slow?.next)
        while (p2 != null) {
            if (p1?.`val` != p2.`val`) {
                return false
            }
            p1 = p1.next
            p2 = p2.next
        }
        return true
    }

    fun reverse(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val t = cur.next
            cur.next = pre
            pre = cur
            cur = t
        }
        return pre
    }

    fun isPalindrome1(head: ListNode?): Boolean {
        val s = Stack<Int>()
        val size = size(head)
        val mid = size / 2
        var c = head
        var i = 0
        while (c != null) {
            if (i < mid) {
                s.push(c.`val`)
            } else if (i == mid && size % 2 == 1) {
            } else {
                if (s.pop() != c.`val`) {
                    return false
                }
            }
            i++
            c = c.next
        }
        return s.isEmpty()
    }

    fun size(head: ListNode?): Int {
        var count = 0
        var c = head
        while (c != null) {
            count++
            c = c.next
        }
        return count
    }
}

fun main() {
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 1))))
    println(Solution().isPalindrome(ListNode.newInstance(intArrayOf(1, 2, 2, 3, 1))))
}