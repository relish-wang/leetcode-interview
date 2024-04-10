package wang.relish.leetcode.first._042

import kotlin.math.max
import kotlin.math.min

/**
 * 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        if (n < 3) {
            return 0
        }
        val lmax = IntArray(n) { 0 }
        lmax[0] = height[0]
        for (i in 1 until n) {
            lmax[i] = max(lmax[i - 1], height[i])
        }
        val rmax = IntArray(n) { 0 }
        rmax[n - 1] = height[n - 1]
        for (i in n - 2 downTo 0) {
            rmax[i] = max(rmax[i + 1], height[i])
        }
        var sum = 0
        for (i in 1 until n - 1) {
            sum += min(lmax[i], rmax[i]) - height[i]
        }
        return sum
    }
}

fun main() {
    println(Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))) //6
    println(Solution().trap(intArrayOf(4, 2, 0, 3, 2, 5))) // 9
}