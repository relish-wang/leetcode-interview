package _055

import kotlin.math.max

fun main() {

    println(canJump(intArrayOf(2, 3, 1, 1, 4))) // true
    println(canJump(intArrayOf(3, 2, 1, 0, 4))) // false
    println(canJump(intArrayOf(0))) // true
    println(canJump(intArrayOf(1))) // true
    println(canJump(intArrayOf(2, 0, 0))) // true
    println(canJump(intArrayOf(0, 2, 3))) // false
    println(canJump(intArrayOf(2, 5, 0, 0))) // true
    println(canJump(intArrayOf(3, 0, 8, 2, 0, 0, 1))) // true
//    val now = System.currentTimeMillis()
//    println("耗时: ${System.currentTimeMillis() - now}ms")
}

/**
 * 自己解的。
 * 动态规划
 * dp[i]表示能否从0跳到i, 最终要解决的问题是dp[length-1]
 * 对于dp[length-1]的子问题变成 dp[n] && nums[n]+n>=length-1
 * step
 * 状态转移方程: dp[i] = dp[i-step] && nums[i-step] + i - step >= i
 */
fun canJump1(nums: IntArray): Boolean {
    var length = nums.size
    if (length <= 1) {
        return true
    }
    val dp = IntArray(length) { if (it == 0) 1 else -1 }
    for (i in 1 until nums.size) {
        val step = nums[i - 1]// 前一个
        if (step == 0) {
            if (dp[i] == -1) {
                dp[i] = 0
            }
            continue
        }
        for (j in 1..step) {
            val index = i + j - 1
            if (index < nums.size) {
                if (dp[index] != -1) {
                    continue
                }
                dp[index] = if (dp[i - 1] == 1) 1 else 0
            } else {
                break
            }
        }

    }
    return dp[length - 1] == 1
}

fun canJump(nums: IntArray): Boolean {
    var k = nums[0]
    for (i in nums.indices) {
        if (i > k) return false
        k = max(k, i + nums[i])
    }
    return true
}