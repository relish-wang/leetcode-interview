package wang.relish.leetcode.second._0283

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 空间复杂度O(1)
     * 正统解法: 双指针
     */
    fun moveZeroes(nums: IntArray): Unit {
        val n = nums.size
        var l = 0
        var r = 0
        while (r < n) {
            if (nums[r] != 0) {
                val t = nums[l]
                nums[l] = nums[r]
                nums[r] = t
                l++
            }
            r++
        }
    }

    /**
     * 冒泡变种解法
     */
    fun moveZeroes2(nums: IntArray): Unit {
        val n = nums.size
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                if (nums[i] != nums[j] && nums[i] == 0) {
                    val t = nums[i]
                    nums[i] = nums[j]
                    nums[j] = t
                }
            }
        }
    }

    /**
     * 数0的数量
     */
    fun moveZeroes1(nums: IntArray): Unit {
        var count = 0
        val n = nums.size
        for (num in nums) {
            if (num == 0) {
                count++
            }
        }
        if (count == 0) return
        val last = n - count
        var i = 0
        var j = 0
        while (i < n) {
            if (i < last) {
                while (nums[j] == 0) {
                    j++
                }
                swap(nums, i, j)
                j++
            } else {
                nums[i] = 0
            }
            i++
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        if (i == j) return
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
    }
}

fun main() {
    val arr = intArrayOf(0, 1, 0, 3, 12) // [1,3,12,0,0]
//    val arr = intArrayOf(1, 0, 2) // [1,1,0]
    println(arr.contentToString())
    Solution().moveZeroes(arr)
    println(arr.contentToString())
}