package _300

import kotlin.math.max

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * dp[i] 前i个数里的最长子序列, 且nums[i]必定被选取
     * dp[j] 前j个数里的最长子序列, 且nums[j]必定被选取
     *
     * 状态转移方程: dp[i] = max(dp[j]) + 1
     * 关键在于i和j的关系
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = Array(n) { mutableListOf<Int>() }
        dp[0].add(nums[0])
        var max = 1
        for (i in 1 until n) {
            val last = dp[i - 1].last()
            val lastArr = ArrayList(dp[i - 1])
            val curr = nums[i]
            dp[i] = if (last < curr) {
                lastArr.apply { add(curr) }
            } else if (last == curr) {
                lastArr
            } else {
                lastArr.apply {
                    val len = this.size
                    var j = len - 1
                    while (j >= 0 && this[j] > curr) {
                        j--
                    }
                    if (j != len - 1) {
                        this[j + 1] = curr
                        for (x in j + 2 until len) {
                            removeLast()
                        }
                    }
                }
            }
            max = max(dp[i].size, max)
        }
        return max
    }
}

fun main() {
//    println(Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) // 4 [2,3,7,101]
//    println(Solution().lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))) // 4 [0,1,2,3]
//    println(Solution().lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))) // 1 [7]
//    println(Solution().lengthOfLIS(intArrayOf(4, 10, 4, 3, 8, 9))) // 3 [4,8,9]
    println(Solution().lengthOfLIS(intArrayOf(1,3,6,7,9,4,10,5,6))) // 6 [1,3,6,7,9,10]
}