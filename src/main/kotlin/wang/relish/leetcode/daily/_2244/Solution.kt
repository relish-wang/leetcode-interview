package wang.relish.leetcode.daily._2244

class Solution {
    fun minimumRounds(tasks: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        for (task in tasks) {
            map[task] = (map[task] ?: 0) + 1

        }
        var ans = 0
        for (key in map) {
            if (key.value == 1) {
                return -1
            } else {
                ans += deal(key.value)
            }
        }
        return ans
    }

    val memo = hashMapOf<Int, Int>()
    fun deal(n: Int): Int {
        if (n == 0) {
            return 0
        } else if (n == 2 || n == 3) {
            return 1
        } else if (n == 4 || n == 5 || n == 6) {
            return 2
        }
        val q = memo[n]
        if (q != null) {
            return q
        }
        return (1 + deal(n - 3)).also { memo[n] = it }
    }
}

fun main() {
    println(Solution().minimumRounds(intArrayOf(2, 2, 3, 3, 2, 4, 4, 4, 4, 4))) // 4
    println(Solution().minimumRounds(intArrayOf(2, 3, 3))) // -1
}