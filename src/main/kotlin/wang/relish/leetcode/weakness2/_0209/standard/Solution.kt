package wang.relish.leetcode.weakness2._0209.standard

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var r = 0
        var min = Int.MAX_VALUE
        var sum = 0
        while (r < nums.size) {
            sum += nums[r++]
            while (sum >= target) {
                min = minOf(min, r - l)
                sum -= nums[l++]
            }
        }
        return min.takeIf { it != Int.MAX_VALUE } ?: 0
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) // 2
//    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) // 0
//    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
}