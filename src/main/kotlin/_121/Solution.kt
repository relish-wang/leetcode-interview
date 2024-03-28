package _121

import kotlin.math.max
import kotlin.math.min

class Solution {

    /**
     * 动态规划
     * dp[i] 表示到第i天的最小值
     * dp[i] = min(dp[i-1], prices[i])
     *
     * 日了狗: 用一个变量存当前最小值就行了, 不需要开辟dp[]数组存第0~第i天的最小值
     */
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        if (n == 0) {
            return 0
        }
        val dp = Array(n) { Int.MIN_VALUE }
        dp[0] = prices[0]
        var max = 0
        for (i in 1 until n) {
            max = max(prices[i] - dp[i - 1], max)
            dp[i] = min(dp[i - 1], prices[i])
        }
        return max
    }

    /**
     * 暴力会超时
     */
    fun maxProfit1(prices: IntArray): Int {
        val n = prices.size
        if (n == 0) {
            return 0
        }
        var max = 0
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                max = max(prices[j] - prices[i], max)
            }
        }
        return max
    }
}

fun main() {
//    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(2, 100, 1, 5, 6, 4, 3)))
}