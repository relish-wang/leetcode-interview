package wang.relish.leetcode._0002

import struct.ListNode
import struct.toIntArray

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return null
    }
}

fun main() {
    runCase("[2,4,3]", "[5,6,4]") // [7,0,8]
    runCase("[0]", "[0]") // [0]
    runCase("[9,9,9,9,9,9,9]", "[9,9,9,9]") // [8,9,9,9,0,0,0,1]
}

private fun runCase(s1: String, s2: String) {
    val l1 = ListNode.newInstance(s1.toIntArray()).also { print("l1 = $it, ") }
    val l2 = ListNode.newInstance(s2.toIntArray()).also { println("l2 = $it") }
    println(Solution().addTwoNumbers(l1, l2)) // [7,0,8]
    println()
}