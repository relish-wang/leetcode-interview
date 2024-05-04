package wang.relish.leetcode.weakness2._0215.priorityqueue

import java.util.*

class Solution {
    /**
     * PriorityQueue解法
     * 1 <= k <= nums.length <= 105
     *
     * -10<sup>4</sup> <= nums\[i] <= 10<sup>4</sup>
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = PriorityQueue<Int>()
        for (n in nums) {
            q.offer(n)
            if (q.size > k) {
                q.poll()
            }
        }
        return q.peek()
    }
}

fun main() {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 5
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // 4
    println(Solution().findKthLargest(intArrayOf(1), 1)) // 1
    println(Solution().findKthLargest(intArrayOf(2, 1), 1)) // 2
    println(Solution().findKthLargest(intArrayOf(2, 1), 2)) // 1
}