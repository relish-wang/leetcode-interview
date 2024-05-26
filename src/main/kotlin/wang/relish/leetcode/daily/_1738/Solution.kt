package wang.relish.leetcode.daily._1738

import struct.int2d
import java.util.*

class Solution {
    /**
     * 二维前缀和
     */
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        val preSum = Array(m) { IntArray(n) }
        val p = PriorityQueue<Int>(k) { a, b -> b - a }
        preSum[0][0] = matrix[0][0].also { p.offer(it) }
        for (i in 1 until m) {
            preSum[i][0] = (preSum[i - 1][0] xor matrix[i][0]).also { p.offer(it) }
        }
        for (i in 1 until n) {
            preSum[0][i] = (preSum[0][i - 1] xor matrix[0][i]).also { p.offer(it) }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                preSum[i][j] =
                    (preSum[i - 1][j] xor preSum[i][j - 1] xor preSum[i - 1][j - 1] xor matrix[i][j]).also { p.offer(it) }
            }
        }
        for (i in 0 until k - 1) {
            p.poll()
        }
        return p.poll()
    }
}

fun main() {
    println(Solution().kthLargestValue(int2d("[[5,2],[1,6]]"), 1)) // 7
    println(Solution().kthLargestValue(int2d("[[5,2],[1,6]]"), 2)) // 5
    println(Solution().kthLargestValue(int2d("[[5,2],[1,6]]"), 3)) // 4
    println(Solution().kthLargestValue(int2d("[[5,2],[1,6]]"), 4)) // 0
}

//1 2 3
//4 5 6
//7 8 9