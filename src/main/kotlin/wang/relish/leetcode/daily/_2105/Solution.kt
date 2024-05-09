package wang.relish.leetcode.daily._2105

class Solution {
    fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
        val n = plants.size
        var l = 0
        var r = n - 1
        var ca = capacityA
        var cb = capacityB
        var reload = 0
        while (l <= r) {
            if (l == r) {
                if (ca >= cb) {
                    if (ca < plants[l]) {
                        reload++
                    }
                } else {
                    if (cb < plants[r]) {
                        reload++
                    }
                }
                break
            }
            if (ca >= plants[l]) {
                ca -= plants[l]
            } else {
                reload++
                ca = capacityA - plants[l]
            }
            l++

            if (cb >= plants[r]) {
                cb -= plants[r]
            } else {
                reload++
                cb = capacityB - plants[r]
            }
            r--

        }
        return reload
    }
}

fun main() {
    println(Solution().minimumRefill(intArrayOf(2, 2, 3, 3), 5, 5)) // 1
    println(Solution().minimumRefill(intArrayOf(2, 2, 3, 3), 3, 4)) // 2
    println(Solution().minimumRefill(intArrayOf(5), 10, 8)) // 0
    println(Solution().minimumRefill(intArrayOf(1, 10, 1), 10, 11)) // 0
}