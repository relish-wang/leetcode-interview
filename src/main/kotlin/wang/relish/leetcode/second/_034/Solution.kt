package wang.relish.leetcode.second._034

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return f(nums, 0, nums.size - 1, target)
    }

    fun f(nums: IntArray, left: Int, right: Int, target: Int): IntArray {
        if (left > right) return intArrayOf(-1, -1)
        if (nums[left] == target) {
            return g(nums, left, target)
        }
        if (nums[right] == target) {
            return g(nums, right, target)
        }

        val mid = (left + right) / 2
        if (nums[mid] == target) {
            return g(nums, mid, target)
        }
        return if (nums[mid] > target) {
            f(nums, left + 1, mid - 1, target)
        } else {
            f(nums, mid + 1, right - 1, target)
        }
    }

    fun g(nums: IntArray, i: Int, target: Int): IntArray {
        var l = i
        while (l >= 0 && nums[l] == target) {
            if (l == 0 || nums[l - 1] != target) {
                break
            }
            l--
        }
        var r = i
        while (r < nums.size && nums[r] == target) {
            if (r == nums.size - 1 || nums[r + 1] != target) {
                break
            }
            r++
        }
        return intArrayOf(l, r)
    }
}

fun main() {
//    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString()) // [3,4]
//    println(Solution().searchRange(intArrayOf(1), 1).contentToString()) // [0,0]
    println(Solution().searchRange(intArrayOf(1, 4), 4).contentToString()) // [1,1]
}