package wang.relish.leetcode.daily._2831

import kotlin.math.max

class Solution {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {

        val n = nums.size
        val posList = Array(n + 1) { mutableListOf<Int>() }
        for (i in 0 until nums.size) {
            val num = nums[i]
            posList[num].add(i)
        }
        var max = 0
        for (pos in posList) {
            val size = pos.size
            if (size <= max) continue
            var l = 0
            for (r in 0 until size) {
                while (pos[r] - pos[l] - r + l > k) {
                    l++
                }
                max = max(max, r - l + 1)
            }
        }
        return max
    }
}

fun main() {
    println(Solution().longestEqualSubarray(listOf(1, 3, 2, 3, 1, 3), 3)) // 3
    println(Solution().longestEqualSubarray(listOf(1, 1, 2, 2, 1, 1), 2)) // 4
    println(Solution().longestEqualSubarray(listOf(4, 2, 7, 2, 1, 7, 2), 1)) // 2
}