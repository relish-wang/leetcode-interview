package wang.relish.leetcode.second._053

import kotlin.math.max

class Solution {

    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val dp = IntArray(n) { 0 }
        dp[0] = nums[0]
        var max = dp[0]
        for (i in 1 until n) {
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
            max = max(dp[i], max)
        }
        return max
    }
}

fun main() {
    println(Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))) // 6
}