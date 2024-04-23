package wang.relish.leetcode.second._0215

import java.util.*


class Solution {

    /**
     * 优先队列(其实就是小顶堆)
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = PriorityQueue<Int>()
        for (n in nums) {
            if (q.size < k) {
                q.offer(n) // 队列里先塞满k个元素
            } else if (n > q.peek()) { // 当出现一个比队头(也就是堆里的最小的数, 当前的第k大的数)更大的数字时
                q.poll() // 移出队头数字
                q.offer(n) // 把这个新数字加入队列(自动排序)
            }
        }
        return q.peek()
    }

    /**
     * 快排
     */
    fun findKthLargest3(nums: IntArray, k: Int): Int {
        return qs(nums, 0, nums.size - 1, k)
    }

    fun qs(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if (left == right) {
            return nums[k - 1]
        }
        val p = nums[left]
        var l = left - 1
        var r = right + 1
        while (l < r) {
            do {
                l++
            } while (nums[l] > p)
            do {
                r--
            } while (nums[r] < p)
            if (l < r) {
                swap(nums, l, r)
            }
        }
        return if (k - 1 <= r) {
            qs(nums, left, r, k)
        } else {
            qs(nums, r + 1, right, k)
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
    }


    /**
     * 桶排序
     * 03:17
     */
    fun findKthLargest2(nums: IntArray, k: Int): Int {
        val b = IntArray(2_0001) { 0 }
        for (n in nums) {
            b[n + 10000]++
        }
        var x = k
        for (i in b.size - 1 downTo 0) {
            if (b[i] == 0) continue
            x -= b[i]
            if (x <= 0) {
                return i - 10000
            }
        }
        return 0
    }

    /**
     * 00:22
     */
    fun findKthLargest1(nums: IntArray, k: Int): Int {
        Arrays.sort(nums) // 快排实现
        return nums[nums.size - k]
    }
}

fun main() {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 5
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // 4
    println(Solution().findKthLargest(intArrayOf(3, 1, 2, 4), 2)) // 3
}