package wang.relish.leetcode.second._122

import kotlin.math.max
import kotlin.math.min


class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        var sum = 0
        var minIndex = 0
        var maxIndex = -1
        var i = 1
        while (i < n) {
            while (i < n && prices[i] <= prices[minIndex]) {
                minIndex = i
                i++
            }
            maxIndex = minIndex
            while (i < n && prices[i] >= prices[maxIndex]) {
                maxIndex = i
                i++
            }
            if (maxIndex > minIndex) {
                sum += prices[maxIndex] - prices[minIndex]
            }
            minIndex = i
            i++
        }
        return sum
    }
}

fun main() {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))) //7
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1))) //0
}