package wang.relish.leetcode.daily._2713

import struct.int2d
import java.util.ArrayList
import java.util.TreeMap
import kotlin.math.max

class Solution {
    fun maxIncreasingCells(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        /*
         * 以[[3,1],[3,4]]为例
         * g里面变成
         * 1->[[1,0]]
         * 3->[[0,0],[0,1]]
         * 4->[[1,1]]
         * TreeMap的key是按字母序排序的
         */
        val g = TreeMap<Int, ArrayList<Pair<Int, Int>>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                g.computeIfAbsent(mat[i][j]) {
                    ArrayList<Pair<Int, Int>>()
                }.add(i to j)
            }
        }
        var ans = 0
        val rowMax = IntArray(m)
        val colMax = IntArray(n)
        for (pos in g.values) {
            val mx = IntArray(pos.size)
            for (k in 0 until pos.size) {
                val (i, j) = pos[k]
                mx[k] = max(rowMax[i], colMax[j]) + 1
                ans = max(ans, mx[k])
            }
            for (k in 0 until pos.size) {
                val (i, j) = pos[k]
                rowMax[i] = max(rowMax[i], mx[k]); // 更新第 i 行的最大 f 值
                colMax[j] = max(colMax[j], mx[k]); // 更新第 j 列的最大 f 值
            }
        }
        return ans
    }
}


fun main() {
    println(Solution().maxIncreasingCells(int2d("[[3,1],[3,4]]"))) // 2
    println(Solution().maxIncreasingCells(int2d("[[1,1],[1,1]]"))) // 1
    println(Solution().maxIncreasingCells(int2d("[[3,1,6],[-9,5,7]]"))) // 4
}