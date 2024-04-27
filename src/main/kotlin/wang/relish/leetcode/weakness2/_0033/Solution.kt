package wang.relish.leetcode.weakness2._0033

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return f(nums, 0, nums.size - 1, target)
    }

    fun f(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (left > right) return -1
        if (nums[left] == target) return left
        if (nums[right] == target) return right
        val mid = left + ((right - left) shr 1)
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            return f(nums, mid + 1, right - 1, target).takeIf { it != -1 } ?: f(nums, left + 1, mid - 1, target)
        } else {
            return f(nums, left + 1, mid - 1, target).takeIf { it != -1 } ?: f(nums, mid + 1, right - 1, target)
        }
    }
}

fun main() {
//    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
//    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -1
//    println(Solution().search(intArrayOf(1), 0)) // -1
//    println(Solution().search(intArrayOf(1, 3), 3)) // 1
//    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5)) // 1
    println(Solution().search(intArrayOf(4, 5, 6, 7, 8, 1, 2, 3), 8)) // 4
}