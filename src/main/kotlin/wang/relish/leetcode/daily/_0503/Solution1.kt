package wang.relish.leetcode.daily._0503

class Solution1 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        var max = nums[0]
        val ans = IntArray(n)
        for (i in 0 until n) {
            ans[i] = findNextBigger(nums, i)
        }
        return ans
    }

    fun findNextBigger(nums: IntArray, index: Int): Int {
        val n = nums.size
        val std = nums[index]
        var i = (index + 1) % n
        while (i != index) {
            if (nums[i] > std) {
                return nums[i]
            }
            i = (i + 1) % n
        }
        return -1
    }
}