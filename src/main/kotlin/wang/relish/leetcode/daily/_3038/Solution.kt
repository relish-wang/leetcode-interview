package wang.relish.leetcode.daily._3038

class Solution {
    fun maxOperations(nums: IntArray): Int {
        var count = 1
        val sum = nums[0] + nums[1]
        var i = 2
        while (i + 1 < nums.size) {
            if (nums[i] + nums[i + 1] != sum) {
                break
            }
            i += 2
            count++
        }
        return count
    }
}