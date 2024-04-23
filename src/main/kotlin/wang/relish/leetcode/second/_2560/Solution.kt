package wang.relish.leetcode.second._2560

import kotlin.math.max

class Solution {
    fun minCapability(nums: IntArray, k: Int): Int {
        var right = nums.max()
        var left = 0
        while (left + 1 < right) { // 开区间写法
            val mid = (left + right) shr 1
            if (check(nums, k, mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        return right
    }

    fun check(nums: IntArray, k: Int, mx: Int): Boolean {
        var f0 = 0
        var f1 = 0
        for (x in nums) {
            if (x > mx) {
                f0 = f1
            } else {
                val t = f1
                f1 = max(f1, f0 + 1)
                f0 = t
            }
        }
        return f1 >= k
    }
}