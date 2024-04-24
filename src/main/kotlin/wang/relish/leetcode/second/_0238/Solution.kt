package wang.relish.leetcode.second._0238

class Solution {
    /**
     * 官解解法一, 空间可以再优化掉一个数组
     */
    fun productExceptSelf1(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n) { 1 }
        for (i in 1 until n) {
            ans[i] = ans[i - 1] * nums[i - 1]
        }
        val ans2 = IntArray(n) { 1 }
        for (i in n - 2 downTo 0) {
            ans2[i] = ans2[i + 1] * nums[i + 1]
        }
        for (i in 0 until n) {
            ans[i] *= ans2[i]
        }
        return ans
    }

    /**
     * 双指针解法(前缀和 * 后缀和)
     * 时间O(n), 空间O(1) // 返回值的ans不算空间
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n) { 1 }
        var (i, j) = 0 to n - 1
        var (beforeSum, afterSum) = 1 to 1
        while (i < n && j >= 0) {
            ans[i] *= beforeSum
            ans[j] *= afterSum
            beforeSum *= nums[i]
            afterSum *= nums[j]
            i++;j--
        }
        return ans
    }
}

fun main() {
    println(Solution().productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString()) // [24,12,8,6]
    println(Solution().productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentToString()) // [0,0,9,0,0]
}