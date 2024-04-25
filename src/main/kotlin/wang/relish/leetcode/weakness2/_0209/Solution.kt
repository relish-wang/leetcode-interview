package wang.relish.leetcode.weakness2._0209

import kotlin.math.min

class Solution {
    /**
     * https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        return 0
    }
}

fun main() {
    println(Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    println(Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))) // 3
}