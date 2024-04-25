package wang.relish.leetcode.weakness2._0075

class Solution {
    fun sortColors(nums: IntArray): Unit {
    }
}

fun main() {
    val nums = intArrayOf(2, 0, 2, 1, 1, 0)
//    val nums = intArrayOf(2, 0, 1)
//    val nums = intArrayOf(2, 1, 2)
//    val nums = intArrayOf(2)
//    val nums = intArrayOf(0, 2)
//    val nums = intArrayOf(0, 2, 2, 2, 0, 2, 1, 1)

    println(nums.contentToString())
    Solution().sortColors(nums)
    println(nums.contentToString())
}