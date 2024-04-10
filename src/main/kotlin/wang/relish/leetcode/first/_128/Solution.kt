package wang.relish.leetcode.first._128

import kotlin.math.max

class Solution {

    /**
     * 看了题解, 基本都是这么做的
     * 优化点: 可以不去重, 遇到相等的时候count不+1,i++,continue就行
     */
    fun longestConsecutive(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) {
            return 0
        }
        val set = mutableSetOf<Int>()
        for(e in nums){
            set.add(e)
        }
        val l = ArrayList(set)
        l.sort()
        val len = l.size
        var i = 1
        var max = 1
        while (i < len) {
            var count = 1
            while (i < len && l[i - 1] + 1 == l[i]) {
                i++
                count++
            }
            max = max(max, count)
            i++
        }
        return max
    }
}

fun main() {
    println(Solution().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(Solution().longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    println(Solution().longestConsecutive(intArrayOf(1,2,0,1)))
}