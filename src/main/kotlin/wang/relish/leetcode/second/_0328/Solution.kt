package wang.relish.leetcode.second._0328

import struct.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.cn/problems/odd-even-linked-list/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        var cur = head
        var lastOdd: ListNode? = dummy
        var lastEven: ListNode? = null
        var i = 1
        while (cur != null) {
            val next = cur.next
            if (i % 2 == 0) {
                if (lastEven == null) {
                    lastOdd?.next = cur
                    cur.next = null
                    lastEven = lastOdd?.next
                } else {
                    val n = lastEven.next
                    lastEven.next = cur
                    cur.next = n
                    lastEven = lastEven.next
                }
            } else {
                val n = lastOdd?.next
                lastOdd?.next = cur
                cur.next = n
                lastOdd = lastOdd?.next
            }
            cur = next
            i++
        }
        return dummy.next
    }
}

fun main() {
    runCase(intArrayOf(1, 2, 3, 4, 5)) // 1 3 5 2 4
    runCase(intArrayOf(2, 1, 3, 5, 6, 4, 7)) // 2,3,6,7,1,5,4
}

private fun runCase(arr: IntArray) {
    println("整理后: " + Solution().oddEvenList(ListNode.newInstance(arr).also { println("整理前: $it") }) + "\n")
}