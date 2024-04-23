package wang.relish.leetcode.second._0209

import kotlin.math.min

class Solution {
    /**
     * [jump](https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM)
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var r = 1
        var win = nums[0]
        val n = nums.size
        var ans = Int.MAX_VALUE
        var able = false
        while (/*l < r &&*/ r < n) { // 左闭右开区间写法
            if (l == r) {
                win = nums[r]
                r++
            }
            while (r < n && win < target) {
                win += nums[r]
                r++
            }
            if (win >= target) {
                able = true
                ans = min(ans, r - l)
            }
            while (l < r && win >= target) {
                win -= nums[l]
                l++
            }
            if (able && win <= target) {
                ans = min(ans, r - l + 1)
            }
        }
        if (win >= target) {
            able = true
            ans = min(ans, r - l)
        }
        return if (able) ans else 0
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) // 2
    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
    println(Solution().minSubArrayLen(7, intArrayOf(8))) // 1
}