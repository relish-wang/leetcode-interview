package wang.relish.leetcode.weakness2._0741

import struct.int2d
import struct.maxValue

class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        val dp = Array(n + 1) { IntArray(n + 1) { Int.MIN_VALUE } }
        dp[1][1] = grid[0][0]
        // step: 步数
        // j: 第一个人的x坐标
        // k: 第二个人的x坐标
        for (step in 1 until (n shl 1) - 1) {
            for (j in minOf(step, n - 1) downTo maxOf(step - n + 1, 0)) {
                for (k in minOf(step, n - 1) downTo j) {
                    dp[j + 1][k + 1] = if (grid[step - j][j] < 0 || grid[step - k][k] < 0) {
                        Int.MIN_VALUE
                    } else {
                        maxValue(
                            dp[j + 1][k + 1],
                            dp[j + 1][k],
                            dp[j][k + 1],
                            dp[j][k]
                        ) + grid[step - j][j] + if (k == j) 0 else grid[step - k][k]
                    }
                }
            }
        }
        return maxOf(dp[n][n], 0)
    }
}

fun main() {
//    println(Solution().cherryPickup(int2d("[[0,1,-1],[1,0,-1],[1,1,1]]"))) // 5
//    println(Solution().cherryPickup(int2d("[[1,1,-1],[1,-1,1],[-1,1,1]]"))) // 0
    /*
  1   1   1   1   0   0   0
  0   0   0   1   0   0   0
  0   0   0   1   0   0   1
  1   0   0   1   0   0   0
  0   0   0   1   0   0   0
  0   0   0   1   0   0   0
  0   0   0   1   1   1   1
     */
    println(Solution().cherryPickup(int2d("[[1,1,1,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,1],[1,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,1,1,1]]"))) // 15
}