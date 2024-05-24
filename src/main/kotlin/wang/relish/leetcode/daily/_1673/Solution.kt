package wang.relish.leetcode.daily._1673

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val ans = IntArray(k)
        var m = 0
        for (i in 0 until n) {
            val x = nums[i]
            // 栈不为空 || 栈顶比x大 || 剩下的数字还足够挥霍、选择
            while (m > 0 && ans[m - 1] > x && m + n - i > k) {
                m-- // 出栈
            }
            if (m < k) ans[m++] = x
        }
        return ans
    }
}

fun main() {
    println(Solution().mostCompetitive(intArrayOf(3, 5, 2, 6), 2).contentToString()) // [2, 6]
    println(Solution().mostCompetitive(intArrayOf(2, 4, 3, 3, 5, 4, 9, 6), 4).contentToString()) // [2,3,3,4]
}