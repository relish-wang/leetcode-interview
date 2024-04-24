package wang.relish.leetcode.second._0448

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {

    /**
     * 正统解法: 先把nums[nums[i]-1]上的值-n, 再遍历nums, 值大于0的对应的index+1添加到ans里。
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        for (i in 0 until n) {
            val index = nums[i].let { if (it > 0) it else it + n } - 1
            if (nums[index] > 0) {
                nums[index] -= n
            }
        }
        val ans = mutableListOf<Int>()
        for (i in 0 until n) {
            if (nums[i] > 0) {
                ans.add(i + 1)
            }
        }
        return ans
    }

    /**
     * 辣鸡解法, 时间和空间都拉胯
     * 耗时: 7.69%
     * 内存: 7.69%
     */
    fun findDisappearedNumbers1(nums: IntArray): List<Int> {
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