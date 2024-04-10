package wang.relish.leetcode.second._011

import kotlin.math.max

class Solution {
    fun maxArea(height: IntArray): Int {
        val n = height.size
        if (n <= 1) {
            return 0
        }
        var l = 0
        var r = n - 1
        var max = 0
        while (l <= r) {
            val h1 = height[l]
            val h2 = height[r]
            val s = if (h1 > h2) {
                h2 * (r - l).also { r-- }
            } else {
                h1 * (r - l).also { l++ }
            }
            max = max(max, s)
        }
        return max
    }
}

fun main() {
    println(Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) // 49
}