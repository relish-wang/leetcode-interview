package wang.relish.leetcode.daily._2589

import struct.int2d
import struct.printSquare
import kotlin.math.max

class Solution {
    fun findMinimumTime(tasks: Array<IntArray>): Int {
        tasks.sortWith(object : Comparator<IntArray> {
            override fun compare(o1: IntArray?, o2: IntArray?): Int {
                if (o1 == null || o2 == null) return 0
                return o1[1] - o2[1]
            }
        })
        //tasks.printSquare()
        val mx = IntArray(tasks.last()[1] + 1) { 0 }
        var ans = 0
        for (t in tasks) {
            val start = t[0]
            val end = t[1]
            var duration = t[2]
            for (j in start..end) {
                duration -= mx[j]
            }
            ans += max(duration, 0)
            var j = end
            while (j >= 0 && duration > 0) {
                if (mx[j] == 0) {
                    duration--
                    mx[j] = 1
                }
                j--
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().findMinimumTime(int2d("[[2,3,1],[4,5,1],[1,5,2]]"))) // 2
    println(Solution().findMinimumTime(int2d("[[1,3,2],[2,5,3],[5,6,2]]"))) // 4
    println(Solution().findMinimumTime(int2d("[[2,13,2],[6,18,5],[2,13,3]]"))) // 5
}