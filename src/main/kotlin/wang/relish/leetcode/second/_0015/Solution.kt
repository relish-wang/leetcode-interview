package wang.relish.leetcode.second._0015


class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until n - 2) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1 until n - 1) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue
                var k = n - 1
                while (k > j && nums[i] + nums[j] + nums[k] > 0) {
                    k--
                }
                if (j == k) {
                    break
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return ans
    }
}

fun main() {
//    println(Solution().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
//    println(Solution().threeSum(intArrayOf(0, 0, 0)))
    println(Solution().threeSum(intArrayOf(-1, 0, 1, 0)))
}