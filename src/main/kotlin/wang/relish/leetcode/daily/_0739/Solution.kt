package wang.relish.leetcode.daily._0739

import java.util.*

class Solution {
    /**
     * 从右往左
     */
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val ans = IntArray(n) { 0 }
        val s = Stack<Int>()
        for (i in n - 1 downTo 0) {
            val x = temperatures[i]
            while (s.isNotEmpty() && x >= temperatures[s.peek()]) {
                s.pop()
            }
            if (s.isNotEmpty()) {
                ans[i] = s.peek() - i
            }
            s.push(i)
        }
        return ans
    }

    /**
     * 从左往右
     */
    fun dailyTemperatures1(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val ans = IntArray(n) { 0 }
        val s = Stack<Int>()
        for (i in 0 until n) {
            val x = temperatures[i]
            while (s.isNotEmpty() && x > temperatures[s.peek()]) {
                val j = s.pop()
                ans[j] = i - j
            }
            s.push(i)
        }
        return ans
    }
}