package wang.relish.leetcode.hot100._0560

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size
        var ans = 0
        for(i in 0 until n) {
            if(nums[i] == k) {
                ans++
            }
        }
        for(i in 0 until n) {
            var sum = nums[i]
            for(j in i+1 until n) {
                sum += nums[j]
                if(sum == k) {
                    ans++
                }
            }
        }
        return ans
    }
}