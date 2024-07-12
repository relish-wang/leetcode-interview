package wang.relish.leetcode.daily._2974

class Solution {
    fun numberGame(nums: IntArray): IntArray {
        nums.sort()
        for (i in nums.indices step 2) {
            nums[i] = nums[i] xor nums[i + 1]
            nums[i + 1] = nums[i + 1] xor nums[i]
            nums[i] = nums[i] xor nums[i + 1]
        }
        return nums
    }
}
