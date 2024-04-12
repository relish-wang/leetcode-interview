package wang.relish.leetcode.second._072

import kotlin.math.min

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val l1 = word1.length
        val l2 = word2.length
        if (l1 == 0) return l2
        if (l2 == 0) return l1
        val dp = Array(l1 + 1) { i -> IntArray(l2 + 1) { j -> if (i == 0) j else if (j == 0) i else 0 } }
        for (i in 1 .. l1) {
            for (j in 1 .. l2) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = min(min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1
                }
            }
        }
        return dp[l1][l2]
    }
}

fun main() {
    println(Solution().minDistance("horse", "ros")) // 3
}