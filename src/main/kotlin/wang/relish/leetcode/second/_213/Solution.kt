package wang.relish.leetcode.second._213

import kotlin.math.max

/**
 *  打家劫舍 II
 *  独立思考出了和官解一样的代码, 嘚瑟一下
 *  15:29
 */
class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]
        if (n == 2) return max(nums[0], nums[1])
        if (n == 3) return max(max(nums[0], nums[1]), nums[2])
        val dp1 = IntArray(n - 1)
        dp1[0] = nums[0]
        dp1[1] = max(dp1[0], nums[1])
        val dp2 = IntArray(n - 1)
        dp2[0] = nums[1]
        dp2[1] = max(dp2[0], nums[2])
        for (i in 2 until n) {
            if (i < n - 1) {
                dp1[i] = max(dp1[i - 1], dp1[i - 2] + nums[i])
            }
            if (i > 2) {
                dp2[i - 1] = max(dp2[i - 2], dp2[i - 3] + nums[i])
            }
        }
        return max(dp1[n - 2], dp2[n - 2])
    }
}

fun main() {
    println(Solution().rob(intArrayOf(2, 3, 2))) // 3
    println(Solution().rob(intArrayOf(1, 2, 3, 1))) // 4
    println(Solution().rob(intArrayOf(200, 3, 140, 20, 10))) // 340
    println(Solution().rob(intArrayOf(1, 7, 9, 2))) // 10
}