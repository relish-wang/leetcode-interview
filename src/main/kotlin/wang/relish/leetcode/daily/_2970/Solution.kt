package wang.relish.leetcode.daily._2970

class Solution {
    /**
     * O(n)灵神解法
     */
    fun incremovableSubarrayCount(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++
        }
        if (i == n - 1) return n * (n + 1) / 2
        var ans = i + 2
        var j = n - 1
        while (j == n - 1 || nums[j] < nums[j + 1]) {
            while (i >= 0 && nums[i] >= nums[j]) i--
            ans += i + 2
            j--
        }
        return ans
    }

    /**
     * O(n^3)太暴力了
     */
    fun incremovableSubarrayCount1(nums: IntArray): Int {
        val n = nums.size
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until n - i) {
                if (isIncreaseArr(nums, i, i + j)) {
                    count++
                }
            }
        }
        return count
    }

    fun isIncreaseArr(nums: IntArray, start: Int, end: Int): Boolean {
        val n = nums.size
        var i = if (start == 0) end + 2 else 1
        var pre = if (start == 0) {
            if (end + 1 < n) {
                nums[end + 1]
            } else {
                return true
            }
        } else nums[0]
        while (i < n) {
            if (i == start) {
                i = end + 1
            } else {
                if (pre < nums[i]) {
                    pre = nums[i]
                    i++
                    continue
                } else {
                    return false
                }
            }
        }
        return true
    }
}