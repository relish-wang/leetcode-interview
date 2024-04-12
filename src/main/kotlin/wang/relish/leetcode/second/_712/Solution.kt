package wang.relish.leetcode.second._712

import kotlin.math.min

class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val l1 = s1.length
        val l2 = s2.length
        val a1 = IntArray(l1 + 1) { 0 }
        for (i in 0 until l1) {
            a1[i + 1] = a1[i] + s1[i].code
        }
        val a2 = IntArray(l2 + 1) { 0 }
        for (i in 0 until l2) {
            a2[i + 1] = a2[i] + s2[i].code
        }
        if (l1 == 0) {
            return a2[l2]
        }
        if (l2 == 0) {
            return a1[l1]
        }
        val dp = Array(l1 + 1) { i -> IntArray(l2 + 1) { j -> if (i == 0) a2[j] else if (j == 0) a1[i] else 0 } }
        for (i in 1..l1) {
            for (j in 1..l2) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] =
                        min(dp[i - 1][j] + s1[i - 1].code, dp[i][j - 1] + s2[j - 1].code)


                }
            }
        }
        return dp[l1][l2]
    }
}

fun main() {
    println(Solution().minimumDeleteSum("sea", "eat")) // 231
//    println(Solution().minimumDeleteSum("s", "t")) // 231
}