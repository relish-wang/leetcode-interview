package wang.relish.leetcode._0048

import struct.int2d
import struct.printSquare

class Solution {
    fun rotate(matrix: Array<IntArray>) {
    }
}

fun main() {
//    val matrix = int2d("[[1,2,3],[4,5,6],[7,8,9]]")
    val matrix = int2d("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]")
    matrix.printSquare()
    Solution().rotate(matrix)
    matrix.printSquare()
}