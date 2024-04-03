package _238

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n) { 0 }
        ans[0] = 1
        for (i in 1 until n) {
            // 此时: ans[i]的值为nums[0]~nums[i-1]的乘积。同理, ans[i-1]的值为nums[0]~nums[i-2]的乘积。故ans[i] = ans[i-1]*nums[i-1]
            ans[i] = ans[i - 1] * nums[i - 1]
        }
        // 从数组最后一个数一直往前乘
        var m = nums[n - 1]
        for (i in n - 2 downTo 0) {
            ans[i] = ans[i] * m
            m *= nums[i]
        }
        return ans
    }

    /**
     * 时间: O(2n)
     * 空间: O(2n)
     */
    fun productExceptSelf1(nums: IntArray): IntArray {
        val n = nums.size
        val mul = IntArray(n) { 1 }
        mul[0] = nums[0]
        for (i in 1 until n) {
            mul[i] = mul[i - 1] * nums[i]
        }
        val reverse = IntArray(n) { 1 }
        reverse[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            reverse[i] = reverse[i + 1] * nums[i]
        }
        return IntArray(n) {
            when (it) {
                0 -> reverse[1]
                n - 1 -> mul[n - 2]
                else -> mul[it - 1] * reverse[it + 1]
            }
        }
    }
}

fun main() {
    println(Solution().productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString()) // [24,12,8,6]
    println(Solution().productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentToString()) // [0,0,9,0,0]
}