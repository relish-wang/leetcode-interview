package wang.relish.leetcode.daily._0807

import kotlin.math.min

class Solution {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        val rowMax = IntArray(row) { grid[it].max() }
        val colMax = IntArray(col)
        for (i in 0 until col) {
            var max = grid[0][i]
            for (j in 0 until row) {
                max = maxOf(max, grid[j][i])
            }
            colMax[i] = max
        }
        var count = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                count += min(rowMax[i], colMax[j]) - grid[i][j]
            }
        }
        return count
    }
}