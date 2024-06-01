package wang.relish.leetcode.daily._2928;

class Solution {
    fun distributeCandies(n: Int, limit: Int): Int {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1)
    }

    fun c2(n: Int): Int {
        return if (n > 1) {
            n * (n - 1) / 2
        } else {
            0
        }
    }
}

fun main() {
    println(Solution().distributeCandies(5, 2)) // 3
    println(Solution().distributeCandies(3, 3)) // 10
}