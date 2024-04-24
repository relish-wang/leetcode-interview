package wang.relish.leetcode.second._0070

class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) return 1
        if (n == 2) return 2
        var a = 1
        var b = 2
        for (i in 2 until n) {
            val t = a + b
            a = b
            b = t
        }
        return b
    }
}