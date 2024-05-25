package wang.relish.leetcode.daily._2903


class Solution {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        val n = nums.size
        var minIndex = 0
        var maxIndex = 0
        for (j in indexDifference until n) {
            val i = j - indexDifference
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            } else if (nums[i] < nums[minIndex]) {
                minIndex = i
            }
            if (nums[maxIndex] - nums[j] >= valueDifference) {
                return intArrayOf(maxIndex, j)
            }
            if (nums[j] - nums[minIndex] >= valueDifference) {
                return intArrayOf(minIndex, j)
            }
        }
        return intArrayOf(-1, -1)
    }
}