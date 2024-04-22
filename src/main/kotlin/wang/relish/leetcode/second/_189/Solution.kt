package wang.relish.leetcode.second._189

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]
        val dp = IntArray(n)
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for (i in 2 until n) {
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[n - 1]
    }
}

fun main() {
    println(Solution().rob(intArrayOf(1, 2, 3, 1))) //4
    println(Solution().rob(intArrayOf(2, 7, 9, 3, 1))) //12
    println(Solution().rob(intArrayOf(2, 1, 1, 2))) //4

}