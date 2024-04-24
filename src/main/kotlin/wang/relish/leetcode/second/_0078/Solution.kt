package wang.relish.leetcode.second._0078


class Solution {
    val ans = mutableListOf<MutableList<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        ans.add(mutableListOf())
        dfs(nums, 0, mutableListOf())
        return ans
    }

    fun dfs(nums: IntArray, i: Int, list: MutableList<Int>) {
        if (i >= nums.size) return
        dfs(nums, i + 1, ArrayList(list))
        ans.add(ArrayList(list).apply { add(nums[i]) })
        dfs(nums, i + 1, ArrayList(list).apply { add(nums[i]) })
    }
}

fun main() {
    println(Solution().subsets(intArrayOf(1, 2, 3)))
}