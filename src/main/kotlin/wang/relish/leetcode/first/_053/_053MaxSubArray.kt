package wang.relish.leetcode.first._053

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

/**
 * 1 分情况讨论的动态规划
 * 2 分治(看上去并不快)
 */
fun maxSubArray(nums: IntArray): Int {
    val n = nums.size
    if (n <= 0) {
        return 0
    }
    if (n == 1) {
        return nums[0]
    }
    var pre = nums[0]
    var max = nums[0]
    for (i in 1 until n) {
        if (pre < 0) {
            pre = nums[i]
        } else {
            pre += nums[i]
        }
        if (pre > max) {
            max = pre
        }
    }
    return max
}