package wang.relish.leetcode.weakness2._0209

import kotlin.math.min

class Solution {
    /**
     * https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return if (nums[0] >= target) 1 else 0
        }
        var min = Int.MAX_VALUE
        var left = 0
        var right = 1
        var sum = nums[0]
        while (left < right && right < n) { // 闭区间
            while (right < n && sum < target) {
                sum += nums[right]
                right++
            }
            if (sum >= target) {
                min = minOf(right - left, min)
            }
            while (left < right && sum >= target) {
                sum -= nums[left]
                left++
            }
            if (left - 1 >= 0 && sum + nums[left - 1] >= target) {
                min = minOf(right - left + 1, min)
            }
        }
        return min.takeIf { it != Int.MAX_VALUE } ?: 0
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) // 2
//    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
//    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
}