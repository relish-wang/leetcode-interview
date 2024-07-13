package wang.relish.leetcode.daily._3011

class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        val n = nums.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - 1 - i) {
                val n1 = nums[j]
                val n2 = nums[j + 1]
                val same1count = n1.toString(2).count { it == '1' } == n2.toString(2).count { it == '1' }
                if (n1 > n2) {
                    if (same1count) {
                        nums[j] = nums[j] xor nums[j + 1]
                        nums[j + 1] = nums[j + 1] xor nums[j]
                        nums[j] = nums[j] xor nums[j + 1]
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}