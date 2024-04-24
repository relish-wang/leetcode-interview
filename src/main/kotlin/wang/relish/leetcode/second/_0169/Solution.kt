package wang.relish.leetcode.second._0169

class Solution {
    /**
     * 这个位运算真没看懂
     */
    fun majorityElement1(nums: IntArray): Int {
        val a = IntArray(32) { 0 }
        val n = nums.size shr 1
        for (i in nums) {
            for (j in 0 until 32) {
                a[j] += (i shr j) and 1
            }
        }
        var ans = 0
        for (i in 0 until 32) {
            ans += if (a[i] <= n) 0 else (1 shl i)
        }
        return ans
    }

    /**
     * 一个数组里存在超过半数的数, 那么随机消掉2个不同的数, 超过半数的数不变
     * 这个解法最优
     */
    fun majorityElement(nums: IntArray): Int {
        var ans = 0
        var count = 0
        for (n in nums) {
            if (count == 0) {
                ans = n
            }
            count = if (ans == n) {
                count + 1
            } else {
                count - 1
            }
        }
        return ans
    }

    /**
     * 消消乐写得心累
     * 时间空间击败5%
     */
    fun majorityElement2(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) {
            return nums[0]
        }
        val first = nums[0]
        var index2 = -1
        for (i in 1 until n) {
            if (nums[i] != first) {
                index2 = i
                break
            }
        }
        if (index2 == -1) {
            return first
        } else {
            if (index2 == 1) {
                val arr = IntArray(n - 2)
                System.arraycopy(nums, 2, arr, 0, n - 2)
                return majorityElement(arr)
            } else if (index2 == n - 1) {
                val arr = IntArray(n - 2)
                System.arraycopy(nums, 1, arr, 0, n - 2)
                return majorityElement(arr)
            } else {
                val arr1 = IntArray(index2 - 1)
                System.arraycopy(nums, 1, arr1, 0, index2 - 1)
                val l2 = n - index2 - 1
                if (l2 == 0) {
                    return majorityElement(arr1)
                } else {
                    val arr2 = IntArray(l2)
                    System.arraycopy(nums, index2 + 1, arr2, 0, l2)
                    return majorityElement(arr1.plus(arr2))
                }
            }
        }
    }
}

fun main() {
//    println(Solution().majorityElement(intArrayOf(2, 3, 2)))
    println(Solution().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}