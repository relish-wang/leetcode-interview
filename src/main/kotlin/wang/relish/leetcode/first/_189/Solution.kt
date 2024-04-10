package wang.relish.leetcode.first._189

import java.lang.Integer.max

/**
 * https://leetcode.cn/problems/house-robber/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * 动态规划
 */
class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }
        val dp = IntArray(n) { 0 }
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for (i in 2 until n) {
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[n - 1]
    }
}

fun main() {
    println(Solution().rob(intArrayOf(1, 2, 3, 1)))
}