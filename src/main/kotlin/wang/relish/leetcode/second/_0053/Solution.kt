package wang.relish.leetcode.second._0053

import kotlin.math.max


class Solution {

    fun maxSubArray(nums: IntArray): Int {
        val n = nums.size
        if(n==0)return 0
        var max = nums[0]
        var pre = max
        for (i in 1 until n){
            pre = max(pre+nums[i], nums[i])
            max = max(pre, max)
        }
        return max
    }
}

fun main() {
    println(Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))) // 6
}