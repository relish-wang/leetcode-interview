package wang.relish.leetcode.second._033

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return f(nums, 0, nums.size - 1, target)
    }

    fun f(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (nums[left] == target) {
            return left
        }
        if (nums[right] == target) {
            return right
        }
        if (left == right) {
            if (nums[left] == target) {
                return left
            }
        }
        if (left > right) {
            return -1
        }
        if (nums[left] > nums[right]) { // 旋转坐标一定在其中
            val len = (right - left) / 2
            val l = f(nums, left + 1, right - len, target)
            val r = f(nums, left + len, right - 1, target)
            if (l != -1) {
                return l
            }
            if (r != -1) {
                return r
            }
            return -1
        } else { // 旋转坐标一定不在其中, 纯递增
            if (nums[left] > target || nums[right] < target) {
                return -1
            }
            val mid = (left + right) / 2
            return if (nums[mid] == target) {
                mid
            } else if (nums[mid] > target) {
                f(nums, left + 1, mid - 1, target)
            } else {
                f(nums, mid + 1, right - 1, target)
            }
        }
    }
}

fun main() {
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -1
    println(Solution().search(intArrayOf(1), 0)) // -1
    println(Solution().search(intArrayOf(1, 3), 3)) // 1
}