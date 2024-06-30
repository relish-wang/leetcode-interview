package wang.relish.leetcode.daily._0494

class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val n = nums.size
        val kind = 1 shl n
        var count = 0
        for (i in 0 until kind) {
            var sum = 0
            for (j in 0 until n) {
                sum += (if ((1 shl j) and i == 0) -1 else 1) * nums[j]
            }
            if (sum == target) {
                count++
            }
        }
        return count
    }
}

fun main() {
    println(Solution().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
}