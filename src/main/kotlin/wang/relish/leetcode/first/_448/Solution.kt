package wang.relish.leetcode.first._448

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 官解: 把对应位置的数减成负数, 最后看值大于0的下标+1就是答案
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        for (i in 0 until n) {
            val index = (nums[i] - 1).let { if (it >= 0) it else it + n }
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
     * 这种方式看上去还是额外申请内存了
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
//    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
//    println(Solution().findDisappearedNumbers(intArrayOf(1, 1)))
    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 7, 2, 3, 1)))
}