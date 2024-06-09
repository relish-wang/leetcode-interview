package wang.relish.leetcode.daily._0312

class Solution2 {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val arr = IntArray(n + 2)
        arr[0] = 1
        arr[n + 1] = 1
        System.arraycopy(nums, 0, arr, 1, n)
        val dp = Array(n + 1) { IntArray(n + 2) }
        for (i in n downTo 0) {
            for (j in i + 2 until n + 2) {
                for (k in i + 1 until j) {
                    dp[i][j] = maxOf(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j])
                }
            }
        }
        return dp[0][n + 1]
    }
}

fun main() {
    println(Solution2().maxCoins(intArrayOf(3, 1, 5, 8))) // 167
    println(Solution2().maxCoins(intArrayOf(1, 5))) // 10
    println(Solution2().maxCoins(intArrayOf(7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3))) // 1717
}