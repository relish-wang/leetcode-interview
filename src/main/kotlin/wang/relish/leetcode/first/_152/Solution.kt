package wang.relish.leetcode.first._152

import kotlin.math.max
import kotlin.math.min

class Solution {
    /**
     *  max(i) 来表示以第 i 个元素结尾的乘积最大子数组的乘积
     */
    fun maxProduct(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }
        val min = IntArray(n) { 0 }
        min[0] = nums[0]
        val max = IntArray(n) { 0 }
        max[0] = nums[0]
        var ans = nums[0]
        for (i in 1 until n) {
            val mayMax = max[i - 1] * nums[i]
            val mayMin = min[i - 1] * nums[i]
            max[i] = max(max(mayMax, nums[i]), mayMin)
            min[i] = min(min(mayMin, nums[i]), mayMax)
            ans = max(ans, max[i])
        }
        return ans
    }
}

fun main() {
//    println(Solution().maxProduct(intArrayOf(2, 3, -2, 4)))
    println(Solution().maxProduct(intArrayOf(2,-1,1,1)))
}