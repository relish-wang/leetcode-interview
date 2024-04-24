package wang.relish.leetcode.second._0121

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        var min = prices[0]
        var max = 0
        for (i in 1 until n) {
            max = max(max, prices[i] - min)
            if (prices[i] < min) {
                min = prices[i]
            }
        }
        return max
    }
}

fun main() {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))) //5
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1))) //0
}