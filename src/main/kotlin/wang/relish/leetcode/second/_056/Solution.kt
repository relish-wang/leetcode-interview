package wang.relish.leetcode.second._056

import struct.int2d
import struct.printSquare

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(object : Comparator<IntArray> {
            override fun compare(p0: IntArray?, p1: IntArray?): Int {
                if (p0 == null || p1 == null) return 0
                return if (p0[0] > p1[0]) {
                    1
                } else if (p0[0] == p1[0]) {
                    0
                } else {
                    -1
                }
            }
        })
        val n = intervals.size
        if (n == 0) return arrayOf()
        var start = intervals[0][0]
        var end = intervals[0][1]
        val ans = mutableListOf<IntArray>()
        for (i in 1 until n) {
            if (intervals[i][0] in start..end) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1]
                }
            } else if (intervals[i][1] in start..end) {
                if (intervals[i][0] < start) {
                    start = intervals[i][0]
                }
            } else {
                ans.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
            }
        }
        ans.add(intArrayOf(start, end))
        return ans.toTypedArray()
    }
}

fun main() {
//    val intervals = int2d("[[1,3],[2,6],[8,10],[15,18]]")
//    val intervals = int2d("[[1,4],[1,4]]") // [1,4]
//    val intervals = int2d("[[1,4],[2,3]]") // [1,4]
    val intervals = int2d("[[2,3],[4,5],[6,7],[8,9],[1,10]]") // [1,10]
    Solution().merge(intervals).printSquare()
}