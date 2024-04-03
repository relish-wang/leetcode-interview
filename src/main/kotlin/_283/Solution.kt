package _283

import java.util.*

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 空间复杂度O(1), 可以用双指针
     */
    fun moveZeroes(nums: IntArray): Unit {
        val queue = LinkedList<Int>()
        for (num in nums) {
            if (num != 0) {
                queue.offer(num)
            }
        }
        val n = nums.size
        var i = 0
        while (i < n) {
            if (queue.isEmpty()) {
                nums[i] = 0
            } else {
                nums[i] = queue.poll()
            }
            i++
        }
    }
}

fun main() {
    val arr = intArrayOf(0,1,0,3,12)
    println(arr.contentToString())
    Solution().moveZeroes(arr)
    println(arr.contentToString())
}