package wang.relish.leetcode.daily._2779

import kotlin.math.max

class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val n = nums.size
        nums.sort()
        var l = 0
        var ans = 1
        for (r in 0 until n) {
            while (nums[r] - nums[l] > k + k) {
                l++
            }
            ans = max(ans, r - l + 1)
        }
        return ans
    }
}