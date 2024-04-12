package wang.relish.leetcode.second._712

import kotlin.math.min

class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val l1 = s1.length
        val l2 = s2.length
        val asc1 = IntArray(l1 + 1) { 0 }
        for (i in 0 until l1) {
            asc1[i + 1] = asc1[i] + s1[i].code
        }
        val asc2 = IntArray(l2 + 1) { 0 }
        for (i in 0 until l2) {
            asc2[i + 1] = asc2[i] + s2[i].code
        }
        if (l1 == 0) {
            return asc1[l1]
        }
        if (l2 == 0) {
            return asc2[l2]
        }
        val dp = Array(l1 + 1) { i ->
            IntArray(l2 + 1) { j ->
                if (i == 0) asc2[j] else if (j == 0) asc1[i] else 0
            }
        }
        for (i in 1..l1) {
            for (j in 1..l2) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    val del1 = dp[i - 1][j] + s1[i - 1].code
                    val del2 = dp[i][j - 1] + s2[j - 1].code
                    val delBoth = dp[i - 1][j - 1] + s1[i - 1].code + s2[j - 1].code
                    dp[i][j] = min(min(del1, del2), delBoth)
                }
            }
        }
        return dp[l1][l2]
    }
}

fun main() {
    println(Solution().minimumDeleteSum("sea", "eat"))
}