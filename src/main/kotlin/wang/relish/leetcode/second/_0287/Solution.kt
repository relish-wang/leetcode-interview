package wang.relish.leetcode.second._0287

/**
 * @see wang.relish.leetcode.second._0136.Solution
 */
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)
        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }
}

/**
 * a xor a = 0
 * a xor 0 = a
 * a xor b = b xor a
 */
fun main() {
    println(Solution().findDuplicate(intArrayOf(1, 3, 4, 2, 2))) // 2
    println(Solution().findDuplicate(intArrayOf(3, 3, 3, 3, 3))) // 3
    println(Solution().findDuplicate(intArrayOf(1, 4, 4, 2, 4))) // 4
}