package wang.relish.leetcode.second._053

import kotlin.math.max

class Solution {

    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n) { 0 } // dp[i]以nums[i]结尾的最大和子序列
        dp[0] = nums[0]
        var max = nums[0]
        for (i in 1 until n) {
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
            max = max(max, dp[i])
        }
        return max
    }
}

fun main() {
    println(Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))) // 6
}