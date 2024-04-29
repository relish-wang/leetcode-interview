package wang.relish.leetcode.weakness2._0128

import kotlin.math.max

class Solution {

    /**
     * 这个解法没得快
     */
    fun longestConsecutive(nums: IntArray): Int {
        val n = nums.size
        val map = hashMapOf<Int, Int>()
        var ans = 0
        for (num in nums) {
            if (map[num] != null) continue
            val l = map[num - 1] ?: 0
            val r = map[num + 1] ?: 0
            val len = 1 + l + r
            if (len > ans) ans = len
            map[num] = len
            map[num - l] = len
            map[num + r] = len
        }
        return ans
    }

    fun longestConsecutive1(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            map[nums[i]] = i
        }
        var max = 1
        val newSet = hashSetOf<Int>()
        for (key in map.keys) {
            if (map.containsKey(key - 1) && !newSet.contains(key)) {
                var newKey = key + 1
                while (map[newKey] != null) {
                    newSet.add(newKey)
                    newKey++
                }
                max = max(max, newKey - key + 1)
            }
        }
        return max
    }
}

fun main() {
    println(Solution().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))) // 4
    println(Solution().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))) // 9
    println(Solution().longestConsecutive(intArrayOf(1, 2, 0, 1))) // 3
}