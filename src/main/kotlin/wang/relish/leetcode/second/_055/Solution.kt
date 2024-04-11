package wang.relish.leetcode.second._055

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val map = Array<Boolean?>(nums.size) { null }
        return canJump(nums, 0, map)
    }


    fun canJump(nums: IntArray, index: Int, cache: Array<Boolean?>): Boolean {
        val n = nums.size
        if (index == n - 1) {
            return true
        }
        if (cache[index] == false) {
            return false
        }
        val step = nums[index]
        for (i in 1..step) {
            val t = canJump(nums, index + i, cache)
            if (t) {
                return true
            } else {
                if (cache[index + i] == null) {
                    cache[index + i] = false
                }
            }
        }
        return false
    }
}

fun main() {
    println(Solution().canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(Solution().canJump(intArrayOf(3, 2, 1, 0, 4)))
}