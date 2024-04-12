package wang.relish.leetcode.second._055

import kotlin.math.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var f = 0
        for (i in nums.indices) {
            if (i > f) return false
            f = max(i+nums[i], f)
        }
        return true
    }
}

fun main() {
    println(Solution().canJump(intArrayOf(2, 3, 1, 1, 4))) // true
    println(Solution().canJump(intArrayOf(3, 2, 1, 0, 4))) // false
}