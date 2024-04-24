package wang.relish.leetcode.second._0448

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {

    /**
     * 辣鸡解法, 时间和空间都拉胯
     * 耗时: 7.69%
     * 内存: 7.69%
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        val ans = IntArray(n) { it + 1 }.toMutableList()
        for (num in nums) {
            ans.remove(num)
        }
        return ans
    }
}

fun main() {
    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))) // [5,6]
    println(Solution().findDisappearedNumbers(intArrayOf(1, 1))) // [2]
}