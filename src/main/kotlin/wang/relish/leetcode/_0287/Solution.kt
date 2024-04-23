package wang.relish.leetcode._0287

/**
 * @see _136.Solution
 */
class Solution {
    /**
     * 双指针
     * 快慢指针判断是否有环。
     * 为什么成了一道链表是否有环的题目? 题目说了nums数组的里数只可能是1~n(nums.length = n+1)的数字。每个数字就是一个节点。出现相同的数字表示出现了相同的节点
     *
     * value 1 4 6 6 6 2 3
     * index 0 1 2 3 4 5 6
     *
     * 链表: 1 -> 4 -> 6 -> 3
     *                ↑    │
     *                └────┘
     */
    fun findDuplicate(nums: IntArray): Int {
        return 0
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