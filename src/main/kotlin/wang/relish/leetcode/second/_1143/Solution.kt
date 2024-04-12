package wang.relish.leetcode.second._1143

import kotlin.math.max


/**
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
class Solution {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val l1 = text1.length
        val l2 = text2.length
        if (l1 == 0 || l2 == 0) return 0
        val dp = Array(l1 + 1) { IntArray(l2 + 1) { 0 } }
        var max = 0
        for (i in 1..l1) {
            for (j in 1..l2) {
                dp[i][j] = if (text1[i - 1] == text2[j - 1]) {
                    dp[i - 1][j - 1] + 1
                } else {
                    max(max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
                }
                max = max(max, dp[i][j])
            }
        }
        return max
    }
}

fun main() {
    println(Solution().longestCommonSubsequence("abcde", "ace")) // 3 ace
    println(Solution().longestCommonSubsequence("abc", "abc")) // 3
    println(Solution().longestCommonSubsequence("abc", "def")) // 0
    println(Solution().longestCommonSubsequence("psnw", "vozsh")) // 1
}