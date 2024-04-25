package wang.relish.leetcode.weakness2._0300

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        return 0
    }
}

fun main() {
    println(Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) // 4 [2,3,7,101]
    println(Solution().lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))) // 4 [0,1,2,3]
    println(Solution().lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))) // 1 [7]
    println(Solution().lengthOfLIS(intArrayOf(4, 10, 4, 3, 8, 9))) // 3 [4,8,9]
    println(Solution().lengthOfLIS(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6))) // 6 [1,3,6,7,9,10]
}