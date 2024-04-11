package wang.relish.leetcode.second._011

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        val n = height.size
        var l = 0
        var r = n - 1
        var max = 0
        while (l < r) {
            val h = min(height[l], height[r])
            max = max(max, h * (r - l))
            if (height[l] > height[r]) {
                r--
            } else {
                l++
            }
        }
        return max
    }
}
fun main() {
    println(Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}
