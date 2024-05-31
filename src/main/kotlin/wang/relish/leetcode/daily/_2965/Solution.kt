package wang.relish.leetcode.daily._2965

class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        var d = 1
        var d1 = 0 // a(重复的) - b(缺少的) = d1
        var d2 = 0 // a*a - b*b = d2 => (a+b)(a-b) = d2 => a-b = d2/d1
        for (g in grid) {
            for (x in g) {
                d1 += x - d
                d2 += x * x - d * d
                d++
            }
        }
        val a = (d2 / d1 + d1) / 2
        val b = (d2 / d1 - d1) / 2
        return intArrayOf(a, b)
    }
}