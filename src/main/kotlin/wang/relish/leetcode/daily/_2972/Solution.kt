package wang.relish.leetcode.daily._2972

class Solution {
    fun incremovableSubarrayCount(nums: IntArray): Long {
        val n = nums.size
        var i = 0
        while(i < n - 1 && nums[i] < nums[i + 1]) i++
        if(i == n - 1) return n * (n + 1) / 2.toLong()
        var ans:Long = i + 2L
        var j = n - 1
        while(j == n - 1 || nums[j] < nums[j + 1]) {
            while(i >= 0 && nums[i] >= nums[j]) i--
            ans += i + 2
            j--
        }
        return ans
    }
}