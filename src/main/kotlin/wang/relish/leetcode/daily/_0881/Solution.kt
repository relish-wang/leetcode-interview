package wang.relish.leetcode.daily._0881

class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val n = people.size
        people.sort()
        var l = 0
        var r = n - 1
        if (people[0] >= limit) {
            return n
        }
        var count = 0
        while (l < r) {
            while (l < r && people[l] + people[r] > limit) {
                r--
                count++
            }
            count++
            l++
            r--
        }
        if (l == r) count++
        return count
    }
}

fun main() {
    println(Solution().numRescueBoats(intArrayOf(1, 2), 3)) // 1
    println(Solution().numRescueBoats(intArrayOf(3, 2, 2, 1), 3)) // 3
    println(Solution().numRescueBoats(intArrayOf(3, 5, 3, 4), 5)) // 4
}