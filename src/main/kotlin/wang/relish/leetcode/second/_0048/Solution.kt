package wang.relish.leetcode.second._0048

import struct.int2d
import struct.printSquare

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n / 2) {
            f(matrix, i)
        }
    }

    fun f(a: Array<IntArray>, d: Int) {
        val n = a.size - d * 2
        for (i in 0 until n - 1) {
            val t = a[d][d + i]
            a[d][d + i] = a[d + n - 1 - i][d]
            a[d + n - 1 - i][d] = a[d + n - 1][d + n - 1 - i]
            a[d + n - 1][d + n - 1 - i] = a[d + i][d + n - 1]
            a[d + i][d + n - 1] = t
        }
    }
}

fun main() {
//    val matrix = int2d("[[1,2,3],[4,5,6],[7,8,9]]")
    val matrix = int2d("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]")
    matrix.printSquare()
    Solution().rotate(matrix)
    matrix.printSquare()
}