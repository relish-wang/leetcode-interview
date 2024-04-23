package wang.relish.leetcode._0056

import struct.int2d
import struct.printSquare

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        return arrayOf()
    }
}

fun main() {
//    val intervals = int2d("[[1,3],[2,6],[8,10],[15,18]]")
//    val intervals = int2d("[[1,4],[1,4]]") // [1,4]
//    val intervals = int2d("[[1,4],[2,3]]") // [1,4]
    val intervals = int2d("[[2,3],[4,5],[6,7],[8,9],[1,10]]") // [1,10]
    Solution().merge(intervals).printSquare()
}