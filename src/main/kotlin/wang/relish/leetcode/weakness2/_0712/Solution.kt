package wang.relish.leetcode.weakness2._0712

import kotlin.math.min

class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val l1 = s1.length
        val l2 = s2.length
        val dp = Array(l1+1){IntArray(l2+1)}
        dp[0][0]=0
        for(i in 0 until l1) {
            dp[i+1][0] = dp[i][0]+s1[i].code
        }
        if(l2==0){
            return dp[l1][0]
        }
        for(i in 0 until l2) {
            dp[0][i+1] = dp[0][i]+s2[i].code
        }
        if(l1==0){
            return dp[l2][0]
        }
        for(i in 1..l1) {
            for(j in 1..l2) {
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[i][j] = min(dp[i-1][j]+s1[i-1].code, dp[i][j-1]+s2[j-1].code)
                }
            }
        }
        return dp[l1][l2]
    }
}

fun main() {
    println(Solution().minimumDeleteSum("sea", "eat")) // 231
}