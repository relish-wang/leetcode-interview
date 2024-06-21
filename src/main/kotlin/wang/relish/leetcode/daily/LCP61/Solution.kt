package wang.relish.leetcode.daily.LCP61

class Solution {
    fun temperatureTrend(temperatureA: IntArray, temperatureB: IntArray): Int {
        val n = temperatureA.size
        var count = 0
        var ans = 0
        for(i in 0 until n - 1) {
            if(f(temperatureA[i], temperatureA[i+1]) == f(temperatureB[i], temperatureB[i+1])) {
                count++
                if(count > ans) {
                    ans = count
                }
            } else {
                count = 0
            }
        }
        return ans
    }

    fun f(a: Int, b: Int): Int {
        return if(a > b) 1 else if(a == b) 0 else -1
    }
}