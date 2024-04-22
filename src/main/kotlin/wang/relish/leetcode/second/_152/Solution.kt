package wang.relish.leetcode.second._152

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var maxP = nums[0]
        val n = nums.size
        val max = IntArray(n) { 1 }
        max[0] = nums[0]
        val min = IntArray(n) { 1 }
        min[0] = nums[0]
        for (i in 1 until n) {
            if (nums[i] > 0) {
                max[i] = max(max[i - 1] * nums[i], nums[i])
                min[i] = min(min[i - 1] * nums[i], nums[i])
            } else {
                max[i] = max(min[i - 1] * nums[i], nums[i])
                min[i] = min(max[i - 1] * nums[i], nums[i])
            }
            maxP = max(maxP, max[i])
        }
        return maxP
    }
}

fun main() {
    println(Solution().maxProduct(intArrayOf(2, 3, -2, 4)))//6
}
