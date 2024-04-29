package wang.relish.leetcode.weakness2._0096

class Solution {
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        if (n == 0) return 1
        dp[1] = 1
        for (i in 2..n) {
            for (j in 0 until i) {
                dp[i] += dp[j] * dp[i - j - 1]
            }
        }
        return dp[n]
    }
}

fun main() {
    println(Solution().numTrees(1)) // 1
    println(Solution().numTrees(2)) // 2
    println(Solution().numTrees(3)) // 5
    println(Solution().numTrees(4)) // 14
    println(Solution().numTrees(5)) // 42
    println(Solution().numTrees(19)) // 1767263190
}