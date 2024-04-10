package wang.relish.leetcode.first._070

fun main() {
    println(climbStairs(2))
    println(climbStairs(3))
}

/**
 * 啥都想动态规划, 魔怔了
 */
fun climbStairs1(n: Int): Int {
    val dp = IntArray(n) {
        if (it == 0) {
            1
        } else if (it == 1) {
            2
        } else {
            0
        }
    }
    for (i in 2 until n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n - 1]
}

fun climbStairs(n: Int): Int {
    if (n == 1) {
        return 1
    }
    if (n == 2) {
        return 2
    }
    var a = 1
    var b = 2
    var sum = 0
    for (i in 2 until n) {
        sum = a + b
        a = b
        b = sum
    }
    return sum
}