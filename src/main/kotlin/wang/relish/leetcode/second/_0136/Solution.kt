package wang.relish.leetcode.second._0136

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        for (num in nums){
            ans = ans xor num
        }
        return ans
    }
}