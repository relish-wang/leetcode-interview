package wang.relish.leetcode.daily._2713

import struct.int2d
import java.util.TreeMap

/**
 * 这个解法会超时(193/566)
 */
class Solution1 {
    fun maxIncreasingCells(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                dfs(mat, i, j, 0)
            }
        }
        return ans
    }


    var ans = 1

    fun dfs(mat: Array<IntArray>, i: Int, j: Int, count: Int, pre: Int = Int.MIN_VALUE) {
        val m = mat.size
        val n = mat[0].size
        val v = mat[i][j]
        TreeMap<Int, IntArray>().apply {
            computeIfAbsent(1){ intArrayOf(1, 1) }
        }
        if (pre < v) {
            if (count + 1 > ans) ans = count + 1

            // 行
            for (x in 0 until m) {
                if (x == i) continue
                if (mat[x][j] <= v) continue
                dfs(mat, x, j, count + 1, v)
            }
            // 列
            for (y in 0 until n) {
                if (y == j) continue
                if (mat[i][y] <= v) continue
                dfs(mat, i, y, count + 1, v)
            }
        }
    }
}

fun main() {
    println(Solution1().maxIncreasingCells(int2d("[[3,1],[3,4]]"))) // 2
    println(Solution1().maxIncreasingCells(int2d("[[1,1],[1,1]]"))) // 1
    println(Solution1().maxIncreasingCells(int2d("[[3,1,6],[-9,5,7]]"))) // 4
}