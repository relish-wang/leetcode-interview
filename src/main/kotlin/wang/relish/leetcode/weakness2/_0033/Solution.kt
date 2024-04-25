package wang.relish.leetcode.weakness2._0033

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return 0
    }
}

fun main() {
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -1
    println(Solution().search(intArrayOf(1), 0)) // -1
    println(Solution().search(intArrayOf(1, 3), 3)) // 1
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5)) // 1
}