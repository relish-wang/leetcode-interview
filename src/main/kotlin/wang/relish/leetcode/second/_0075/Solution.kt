package wang.relish.leetcode.second._0075

class Solution {
    fun sortColors(nums: IntArray): Unit {
        val n = nums.size
        var p0 = 0
        var p1 = 0
        for (i in 0 until n) {
            if (nums[i] == 0) {
                swap(nums, i, p0)
                if (nums[i] == 1) {
                    swap(nums, i, p1)
                }
                p0++
                p1++
            } else if (nums[i] == 1) {
                swap(nums, i, p1)
                p1++
            }
        }
    }

    fun swap(a: IntArray, i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
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