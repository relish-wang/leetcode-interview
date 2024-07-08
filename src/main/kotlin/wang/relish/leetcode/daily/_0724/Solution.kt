package wang.relish.leetcode.daily._0724

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var sum = 0
        for(num in nums) {
            sum += num
        }
        var lSum = 0
        var rSum = sum - nums[0]
        for(i in 0 until nums.size) {
            if(lSum == rSum) {
                return i
            }
            lSum += nums[i]
            if(i == nums.size - 1) {
                rSum = 0
            } else {
                rSum -= nums[i + 1]
            }
        }
        return -1
    }
}