package wang.relish.leetcode._0448

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 官解: 把对应位置的数减成负数, 最后看值大于0的下标+1就是答案
     */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        return listOf()
    }
}

fun main() {
//    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
//    println(Solution().findDisappearedNumbers(intArrayOf(1, 1)))
    println(Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 7, 2, 3, 1)))
}