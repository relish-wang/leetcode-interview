package wang.relish.leetcode.daily._2786

import kotlin.math.max

class Solution {
    fun maxScore(nums: IntArray, x: Int): Long {
        val n = nums.size
        val f = LongArray(2)
        for (i in n - 1 downTo 0) {
            val v = nums[i]
            val r = v % 2
            f[r] = max(f[r], f[r xor 1] - x) + v
        }
        return f[nums[0] % 2]
    }
}

fun main() {
    println(Solution().maxScore(intArrayOf(2, 3, 6, 1, 9, 2), 5)) // 13
    println(Solution().maxScore(intArrayOf(2, 4, 6, 8), 3)) // 20
    println(
        Solution().maxScore(
            intArrayOf(
                9,
                58,
                17,
                54,
                91,
                90,
                32,
                6,
                13,
                67,
                24,
                80,
                8,
                56,
                29,
                66,
                85,
                38,
                45,
                13,
                20,
                73,
                16,
                98,
                28,
                56,
                23,
                2,
                47,
                85,
                11,
                97,
                72,
                2,
                28,
                52,
                3
            ), 90
        )
    ) // 886
}