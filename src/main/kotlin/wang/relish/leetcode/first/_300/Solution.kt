package wang.relish.leetcode.first._300

import kotlin.math.max

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * dp[i] 前i个数里的最长子序列, 且nums[i]必定被选取
     *
     * 状态转移方程: dp[i] = max(dp[0~j])+1 (0≤j<i且num[j]<num[i])
     * 关键在于i和j的关系
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n) { 0 }
        var max = 1
        dp[0] = 1
        for (i in 1 until n) {
            dp[i] = 1
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[j] + 1, dp[i])
                }
            }
            max = max(max, dp[i])
        }
        return max
    }

    /**
     * 我的解法像官解的贪心 + 二分查找
     */
    fun lengthOfLIS1(nums: IntArray): Int {
        val n = nums.size
        val dp = mutableListOf<Int>()
        dp.add(nums[0])
        for (i in 1 until n) {
            val last = dp.last()
            val curr = nums[i]
            if (last < curr) {
                dp.add(curr)
            } else if (last == curr) {
                // do nothing
            } else {
                val len = dp.size
                var j = len - 1
                while (j >= 0 && dp[j] >= curr) {
                    j--
                }
                if (j != len - 1) {
                    dp[j + 1] = curr
                }
            }
        }
        return dp.size
    }
}

fun main() {
    println(Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) // 4 [2,3,7,101]
    println(Solution().lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))) // 4 [0,1,2,3]
    println(Solution().lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))) // 1 [7]
    println(Solution().lengthOfLIS(intArrayOf(4, 10, 4, 3, 8, 9))) // 3 [4,8,9]
    println(Solution().lengthOfLIS(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6))) // 6 [1,3,6,7,9,10]
}