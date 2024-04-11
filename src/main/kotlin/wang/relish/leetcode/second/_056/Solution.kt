package wang.relish.leetcode.second._056

import struct.int2d
import struct.printSquare

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(object : Comparator<IntArray> {
            // 起始小的排前面, 相同则结束大的排期面
            override fun compare(o1: IntArray?, o2: IntArray?): Int {
                if (o1 == null && o2 == null) {
                    return 0
                }
                if (o1 == null) {
                    return 1
                }
                if (o2 == null) {
                    return -1
                }
                return if (o1[0] > o2[0]) {
                    1
                } else if (o1[0] == o2[0]) {
                    return if (o1[1] > o2[1]) {
                        -1
                    } else if (o1[1] == o2[1]) {
                        0
                    } else {
                        1
                    }
                } else {
                    -1
                }
            }
        })
        val ans = mutableListOf<IntArray>()
        val n = intervals.size
        // var i = 1
        var start = intervals[0][0]
        var end = intervals[0][1]

        for (i in 1 until n) {
            if (intervals[i][0] in start..end && intervals[i][1] in start..end) {
                continue
            }
            if (intervals[i][0] < start && intervals[i][1] in start..end) {
                start = intervals[i][0]
            }
            if (intervals[i][1] > end && intervals[i][0] in start..end) {
                end = intervals[i][1]
            }
            if (intervals[i][0] > end || intervals[i][1] < start) {
                ans.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
            }
        }
        ans.add(intArrayOf(start, end))
        return ans.toTypedArray()
//        return intervals
    }
}

fun main() {
//    val intervals = int2d("[[1,3],[2,6],[8,10],[15,18]]")
//    val intervals = int2d("[[1,4],[1,4]]")
//    val intervals = int2d("[[1,4],[2,3]]")
    val intervals = int2d("[[2,3],[4,5],[6,7],[8,9],[1,10]]")
    Solution().merge(intervals).printSquare()
}