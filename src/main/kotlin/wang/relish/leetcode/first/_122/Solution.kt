package wang.relish.leetcode.first._122

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var p = 0
        val n = prices.size
        var i = 1
        while (i < n) {
            // 1 找到递减序列里的最小值
            while (i < n && prices[i - 1] >= prices[i]) i++
            val min = prices[i - 1]
            // 2 找到这次递增序列里的最大值
            while (i < n && prices[i - 1] <= prices[i]) i++
            p += prices[i - 1] - min
            if (i == n) {
                break
            }
            i++
        }
        return p
    }
}

fun main() {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}