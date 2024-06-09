package wang.relish.leetcode.daily._0312

class Solution {
    fun maxCoins(nums: IntArray): Int {
        dfs(nums, 0)
        return ans
    }

    fun arr(nums: IntArray, remove: Int): IntArray {
        val n = nums.size
        val arr = IntArray(n - 1)
        var j = 0
        for (i in 0 until n) {
            if (i == remove) continue
            arr[j++] = nums[i]
        }
        return arr
    }

    var ans = 0

    fun dfs(nums: IntArray, sum: Int) {
        val n = nums.size
        if (n == 0) {
            ans = maxOf(ans, sum)
        }
        for (i in 0 until n) {
            val x = nums.getOrElse(i - 1) { 1 } * nums[i] * nums.getOrElse(i + 1) { 1 }
            dfs(arr(nums, i), sum + x)
        }
    }
}

fun main() {
    println(Solution().maxCoins(intArrayOf(3, 1, 5, 8))) // 167
    println(Solution().maxCoins(intArrayOf(1, 5))) // 10
    println(Solution().maxCoins(intArrayOf(7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3))) // 1717
}