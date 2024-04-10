package wang.relish.leetcode.first._169

class Solution {
    /**
     * 1 题解说排序后返回nums[nums.size/2]即可
     * 2 最好的解法是Boyer-Moore 算法
     */
    fun majorityElement1(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var maxCount = 1
        var maxElement = nums[0]
        for (num in nums) {
            map[num] = ((map[num] ?: 0) + 1).also {
                if (it >= nums.size / 2) {
                    return num
                }
                if (it > maxCount) {
                    maxCount = it
                    maxElement = num
                }
            }
        }
        return maxElement
    }

    fun majorityElement(nums: IntArray): Int {
        var ans = nums[0]
        var count = 0
        for (num in nums) {
            if (count == 0) {
                ans = num
            }
            count += if (ans == num) 1 else -1
        }
        return ans
    }
}

fun main() {
    println(Solution().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}