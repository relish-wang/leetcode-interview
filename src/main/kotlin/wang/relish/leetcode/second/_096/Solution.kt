package wang.relish.leetcode.second._096

class Solution {
    /**
     * 二叉搜索树的梳理(节点数值为[1-n])
     */
    fun numTrees1(n: Int): Int {
        if (n <= 1) {
            return 1
        }
        val dp = IntArray(n + 1) { 0 }
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            for (j in 1..i) {
                dp[i] += dp[i - j] * dp[j - 1]
            }
        }
        return dp[n]
    }

    /**
     * 最优, 卡特兰数
     * ans = ans * 2 * (2 * i + 1) / (i + 2) // i属于[0,n)
     */
    fun numTrees(n: Int): Int {
        var ans = 1
        for (i in 1 until n) {
            ans = ans * 2 * (2 * i + 1) / (i + 2)
        }
        return ans
    }
}

fun main() {
    println(Solution().numTrees(1)) // 1
    println(Solution().numTrees(2)) // 2
    println(Solution().numTrees(3)) // 5
    println(Solution().numTrees(4)) // 14
    println(Solution().numTrees(5)) // 42
}