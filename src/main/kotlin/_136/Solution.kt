package _136

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        for (n in nums) ans = ans xor n
        return ans
    }
}

fun main() {
    println(Solution().singleNumber(intArrayOf(2, 2, 1)))
    println(Solution().singleNumber(intArrayOf(4,1,2,1,2)))
}