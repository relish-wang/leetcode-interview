package wang.relish.leetcode.second._0209

import java.util.*
import kotlin.math.min

class Solution {
    /**
     * [jump](https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM)
     * 滑动窗口, 时间O(n), 空间(1)。
     * 但进阶要求时间复杂度O(n log(n))。啊？劣化性能？
     */
    fun minSubArrayLen1(target: Int, nums: IntArray): Int {
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
        Arrays.binarySearch(nums, 10)
        return if (able) ans else 0
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        var ans = Int.MAX_VALUE
        val sum = IntArray(n + 1) { 0 }
        for (i in 1..n) {
            sum[i] = sum[i - 1] + nums[i - 1]
        }
        for (i in 1..n) {
            val t = target + sum[i - 1]
            var bound = Arrays.binarySearch(sum, t)
            if (bound < 0) { // 没找到返回了-(low+1)
                bound = -bound - 1
            }
            if (bound <= n) {
                ans = min(ans, bound - i + 1)
            }
        }
        return ans.takeIf { it != Int.MAX_VALUE } ?: 0
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) // 2
    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
    println(Solution().minSubArrayLen(7, intArrayOf(8))) // 1
}