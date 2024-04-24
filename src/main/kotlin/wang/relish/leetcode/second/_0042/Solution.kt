package wang.relish.leetcode.second._0042

import kotlin.math.max
import kotlin.math.min

/**
 *
 * [接雨水](https://leetcode.cn/problems/trapping-rain-water/)
 */
class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        var ans = 0
        val lmax = IntArray(n)
        lmax[0] = height[0]
        val rmax = IntArray(n)
        rmax[n - 1] = height[n - 1]
        for (i in 1 until n) {
            lmax[i] = max(lmax[i - 1], height[i])
        }
        for (i in n - 2 downTo 0) {
            rmax[i] = max(rmax[i + 1], height[i])
        }
        for (i in 1 until n - 1) {
            ans += min(lmax[i], rmax[i]) - height[i]
        }
        return ans
    }
}

fun main() {
    println(Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))) //6
    println(Solution().trap(intArrayOf(4, 2, 0, 3, 2, 5))) // 9
}