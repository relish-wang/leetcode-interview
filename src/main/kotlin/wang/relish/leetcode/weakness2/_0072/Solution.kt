package wang.relish.leetcode.weakness2._0072

import kotlin.math.min

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val l1 = word1.length
        val l2 = word2.length
        val dp = Array(l1 + 1) { IntArray(l2 + 1) }
        for (i in 0..l1) {
            dp[i][0] = i
        }
        for (i in 0..l2) {
            dp[0][i] = i
        }
        for (i in 1..l1) {
            for (j in 1..l2) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = min(min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1
                }
            }
        }
        return dp[l1][l2]
    }
}

fun main() {
    println(Solution().minDistance("horse", "ros")) // 3
}