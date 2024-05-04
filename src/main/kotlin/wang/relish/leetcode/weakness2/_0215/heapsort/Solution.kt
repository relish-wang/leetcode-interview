package wang.relish.leetcode.weakness2._0215.heapsort

class Solution {
    /**
     * 堆排序解法
     * 1 <= k <= nums.length <= 105
     *
     * -10<sup>4</sup> <= nums\[i] <= 10<sup>4</sup>
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val n = nums.size
        for (i in n / 2 downTo 0) {
            heapSort(nums, i, n)
        }
        for (i in n - 1 downTo n - k + 1) {
            swap(nums, 0, i)
            heapSort(nums, 0, i)
        }
        return nums[0]
    }

    fun heapSort(nums: IntArray, index: Int, size: Int) {
        val left = (index shl 1) + 1
        var s = index
        if (left < size && nums[left] > nums[s]) {
            s = left
        }
        val right = left + 1
        if (right < size && nums[right] > nums[s]) {
            s = right
        }
        if (s == index) return
        swap(nums, index, s)
        heapSort(nums, s, size)
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[i] xor nums[j]
        nums[j] = nums[j] xor nums[i]
        nums[i] = nums[i] xor nums[j]
    }
}

fun main() {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 5
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // 4
    println(Solution().findKthLargest(intArrayOf(1), 1)) // 1
    println(Solution().findKthLargest(intArrayOf(2, 1), 1)) // 2
    println(Solution().findKthLargest(intArrayOf(2, 1), 2)) // 1
}