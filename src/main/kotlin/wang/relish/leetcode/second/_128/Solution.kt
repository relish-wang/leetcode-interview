package wang.relish.leetcode.second._128

import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        for (i in nums) {
            set.add(i)
        }
        var max = 0
        for (i in set) {
            if(!set.contains(i-1)) {
                var j = i
                while (set.contains(j)) {
                    j++
                }
                max = max(j - i, max)
            }
        }
        return max
    }
}

fun main() {
    println(Solution().longestConsecutive(intArrayOf(1, 2, 3, 4, 100, 200)))
}