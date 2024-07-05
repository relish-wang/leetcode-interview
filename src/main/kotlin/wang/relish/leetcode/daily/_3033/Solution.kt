package wang.relish.leetcode.daily._3033

import kotlin.math.max

class Solution {
    fun modifiedMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val m = matrix.size
        val n = matrix[0].size
        val maxArr = IntArray(n)
        for (j in 0 until n) {
            var max = matrix[0][j]
            for (i in 1 until m) {
                max = max(max, matrix[i][j])
            }
            maxArr[j] = max
        }
        return Array(m) { r ->
            IntArray(n) { c ->
                if (matrix[r][c] == -1) {
                    maxArr[c]
                } else {
                    matrix[r][c]
                }
            }
        }
    }
}