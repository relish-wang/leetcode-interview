package wang.relish.leetcode.first._209

import kotlin.math.min

class Solution {
    /**
     * 滑动窗口解决
     * https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return if (target <= nums[0]) 1 else 0
        }
        var l = 0
        var r = 1
        var sum = nums[l]
        var min = Int.MAX_VALUE
        while (r in (l + 1)..<n) {
            while (r < n && sum < target) {
                sum += nums[r]
                r++
            }
            if (sum < target) {
                return if (r == n && l == 0) {
                    0
                } else {
                    min
                }
            }
            min = min(min, r - l)
            while (l < r && sum >= target) {
                if (sum - nums[l] < target) {
                    min = min(min, r - l)
                    sum -= nums[l]
                    l++
                    break
                }
                sum -= nums[l]
                l++
            }
            if (l < r) {
                min = min(min, r - l + 1)
            }
        }
        return min
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
}