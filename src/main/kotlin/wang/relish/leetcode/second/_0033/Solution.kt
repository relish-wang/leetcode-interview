package wang.relish.leetcode.second._0033

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return s(nums, 0, nums.size - 1, target)
    }

    fun s(nums: IntArray, l: Int, r: Int, target: Int): Int {
        if (l < 0 || l > nums.size - 1 || r < 0 || r > nums.size - 1) return -1
        if (nums[l] == target) return l
        if (nums[r] == target) return r
        if (l > r) return -1
        val mid = (l + r) / 2
        val lv = nums[l]
        val mv = nums[mid]
        val rv = nums[r]
        if (mv == target) return mid
        return if (lv > rv) { // 不递增
            s(nums, l + 1, mid - 1, target).takeIf { it != -1 } ?: s(nums, mid + 1, r - 1, target)
        } else {
            if (mv > target) {
                s(nums, l + 1, mid - 1, target)
            } else {
                s(nums, mid + 1, r - 1, target)
            }
        }
    }
}

fun main() {
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -1
    println(Solution().search(intArrayOf(1), 0)) // -1
    println(Solution().search(intArrayOf(1, 3), 3)) // 1
    println(Solution().search(intArrayOf(4,5,6,7,0,1,2), 5)) // 1
}