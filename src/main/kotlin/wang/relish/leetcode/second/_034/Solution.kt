package wang.relish.leetcode.second._034

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        var l = 0
        var r = n - 1
        while (l <= r) {
            val m = (l + r) / 2
            if (nums[m] == target) {
                return f(nums, m)
            } else if (nums[m] > target) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return intArrayOf(-1, -1)
    }

    fun f(nums: IntArray, index: Int): IntArray {
        val target = nums[index]
        var l = index
        var r = index
        while (l >= 0 && nums[l] == target) {
            l--
        }
        while (r < nums.size && nums[r] == target) {
            r++
        }
        return intArrayOf(l + 1, r - 1)
    }
}

fun main() {
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString()) // [3,4]
    println(Solution().searchRange(intArrayOf(1), 1).contentToString()) // [0,0]
}