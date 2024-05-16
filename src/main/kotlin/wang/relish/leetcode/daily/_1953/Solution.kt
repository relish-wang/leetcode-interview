package wang.relish.leetcode.daily._1953

class Solution {
    fun numberOfWeeks(milestones: IntArray): Long {
        var max = 0
        var sum = 0L
        for (m in milestones) {
            max = maxOf(max, m)
            sum += m
        }
        return if (max > sum / 2) {
            (sum - max) * 2 + 1
        } else {
            sum
        }
    }
}

fun main() {
    println(Solution().numberOfWeeks(intArrayOf(1, 2, 3))) // 6
    println(Solution().numberOfWeeks(intArrayOf(5, 2, 1))) // 7
    println(Solution().numberOfWeeks(intArrayOf(9, 3, 6, 8, 2, 1))) // 29
    println(Solution().numberOfWeeks(intArrayOf(5, 7, 5, 7, 9, 7))) // 40
}