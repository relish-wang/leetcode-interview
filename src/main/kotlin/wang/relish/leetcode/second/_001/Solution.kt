package wang.relish.leetcode.second._001

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(index, map[target - num]!!)
            }
            map[num] = index
        }
        return intArrayOf(-1, -1)
    }
}

fun main() {
    println(Solution().twoSum(intArrayOf(), 0).contentToString()) //
}