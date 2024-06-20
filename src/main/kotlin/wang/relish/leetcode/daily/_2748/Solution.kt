package wang.relish.leetcode.daily._2748

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun countBeautifulPairs(nums: IntArray): Int {
        val n = nums.size
        var count = 0
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                val n1 = nums[i].toString().first() - '0'
                val n2 = nums[j].toString().last() - '0'
                if (gcd(n1, n2)) {
//                    println("${min(n1, n2)}, ${max(n1, n2)}")
                    count++
                }
            }
        }
        return count
    }

    fun gcd(n1: Int, n2: Int): Boolean {
        if (n1 == 1 || n2 == 1) {
            return true
        }
        if (n1 == n2) {
            return false
        }
        val big = max(n1, n2)
        val small = min(n1, n2)
        if (big % small == 0) {
            return false
        }
        var i = 2
        while (i + i <= small) {
            if (big % i == 0 && small % i == 0) {
                return false
            }
            i++
        }
        return true
    }
}

fun main() {
    println(Solution().countBeautifulPairs(intArrayOf(2, 5, 1, 4))) // 5
    println(Solution().countBeautifulPairs(intArrayOf(11, 21, 12))) // 2
    println(Solution().countBeautifulPairs(intArrayOf(31, 25, 72, 79, 74))) // 7
    println(Solution().countBeautifulPairs(intArrayOf(64, 23, 99, 83, 5, 21, 76, 34, 99, 63))) // 25
}