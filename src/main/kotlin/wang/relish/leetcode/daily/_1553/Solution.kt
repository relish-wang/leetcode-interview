package wang.relish.leetcode.daily._1553

class Solution {

    val memo = mutableMapOf<Int, Int>()
    fun minDays(n: Int): Int {
        if (n in 0..2) {
            return n
        }
        if (n == 3) {
            return 2
        }
        val m = memo[n]
        if (m != null) {
            return m
        }
        return (1 + minOf((n % 2) + minDays(n / 2), (n % 3) + minDays(n / 3))).also { memo[n] = it }
    }
}

fun main() {
    println(Solution().minDays(10))// 4 1+3+2+1
    println(Solution().minDays(6))// 3 4+1+1
    println(Solution().minDays(1))// 1 1
    println(Solution().minDays(56))// 6 28+1+18+6+2+1
    println(Solution().minDays(16))// 5 8+4+2+1+1
}