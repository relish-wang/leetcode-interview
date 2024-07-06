package wang.relish.leetcode.daily._3101

class Solution {

    fun countAlternatingSubarrays(nums: IntArray): Long {
        val n = nums.size
        if (n == 1) return 1
        var count = 0L
        var i = 0
        while (i < n) {
            val end = count(nums, i)
            val l = end - i
            count += l.toLong() * (l + 1) / 2
            i = end
        }
        return count
    }

    fun count(nums: IntArray, start: Int): Int {
        val n = nums.size
        var i = start + 1
        while (i < n && nums[i] xor nums[i - 1] == 1) {
            i++
        }
        return i
    }
}

fun main() {
    println(Solution().countAlternatingSubarrays(intArrayOf(0, 1, 1, 1))) // 5
    println(Solution().countAlternatingSubarrays(intArrayOf(1, 0, 1, 0))) // 10
    println(Solution().countAlternatingSubarrays(intArrayOf(0, 1, 1, 1, 0))) // 7
}