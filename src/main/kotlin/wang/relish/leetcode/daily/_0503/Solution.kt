package wang.relish.leetcode.daily._0503

import java.util.*

class Solution {

    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n) { -1 }
        val stack = LinkedList<Int>()
        for (i in 0 until n * 2) {
            val index = i % n
            val x = nums[index]
            while (stack.isNotEmpty() && x > nums[stack.peek()]) {
                ans[stack.pop()] = x
            }
            stack.push(index)
        }
        return ans
    }
}

fun main() {
    println(Solution().nextGreaterElements(intArrayOf(1, 2, 1)).contentToString()) // [2,-1,2]
    println(Solution().nextGreaterElements(intArrayOf(1, 2, 3, 4, 3)).contentToString()) // [2,3,4,-1,4]
}