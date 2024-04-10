package wang.relish.leetcode.second._001

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                return intArrayOf(map[target - nums[i]]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}

fun main() {
    println(Solution().twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString()) // [0,1]
    println(Solution().twoSum(intArrayOf(3, 2, 4), 6).contentToString()) // [1,2]
}