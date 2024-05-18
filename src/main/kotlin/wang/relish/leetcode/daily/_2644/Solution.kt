package wang.relish.leetcode.daily._2644

import kotlin.math.min

class Solution {
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var maxV = Int.MAX_VALUE
        var maxCount = 0
        for (d in divisors) {
            var count = 0
            for (n in nums) {
                if (n % d == 0) {
                    count++
                }
            }
            if (count > maxCount) {
                maxCount = count
                maxV = d
            } else if (count == maxCount) {
                maxV = min(maxV, d)
            }
        }
        return maxV
    }
}

fun main() {
    println(Solution().maxDivScore(intArrayOf(4, 7, 9, 3, 9), intArrayOf(5, 2, 3))) // 3
    println(Solution().maxDivScore(intArrayOf(20, 14, 21, 10), intArrayOf(5, 7, 5))) // 5
    println(Solution().maxDivScore(intArrayOf(12), intArrayOf(10, 16))) // 10
    println(
        Solution().maxDivScore(
            intArrayOf(
                56,
                22,
                79,
                41,
                8,
                39,
                81,
                59,
                74,
                14,
                45,
                49,
                15,
                10,
                28,
                16,
                77,
                22,
                65,
                8,
                36,
                79,
                94,
                44,
                80,
                72,
                8,
                96,
                78
            ),
            intArrayOf(
                39,
                92,
                69,
                55,
                9,
                44,
                26,
                76,
                40,
                77,
                16,
                69,
                40,
                64,
                12,
                48,
                66,
                7,
                59,
                10,
                33,
                72,
                97,
                60,
                79,
                68,
                25,
                63
            )
        )
    ) // 7
}