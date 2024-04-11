package wang.relish.leetcode.second._048

import struct.int2d
import struct.printSquare

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        val maxLevel = n / 2
        for (l in 0..maxLevel) {
            f(matrix, l)
        }
    }

    fun f(matrix: Array<IntArray>, level: Int) {
        val n = matrix.size - level * 2
        // 4个数互换
        for (i in 0 until n - 1) {
            val t = matrix[level][level + i]
            // 第一个数
            matrix[level][level + i] = matrix[level + n - 1 - i][level]
            // 第二个数
            matrix[level + n - 1 - i][level] = matrix[level + n - 1][n - 1 - i + level]
            // 第三个数
            matrix[level + n - 1][n - 1 - i + level] = matrix[level + i][level + n - 1]
            // 第四个数
            matrix[level + i][level + n - 1] = t
            println()
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