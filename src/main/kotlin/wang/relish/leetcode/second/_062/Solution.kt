package wang.relish.leetcode.second._062

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 0 } }
        for (i in 0 until m) {
            dp[i][0] = 1
        }
        for (i in 0 until n) {
            dp[0][i] = 1
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
            }
        }
        return dp[m - 1][n - 1]
    }
}