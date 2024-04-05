package _695

import int2d
import kotlin.math.max

class Solution {
    // 岛屿最大面积
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == 1) {
                    val s = IntArray(1) { 0 }
                    s(grid, r, c, s)
                    max = max(max, s[0])
                }
            }
        }
        return max
    }

    fun s(grid: Array<IntArray>, r: Int, c: Int, s: IntArray) {
        val maxRow = grid.size
        val maxCol = grid[0].size
        if (r < 0 || r > maxRow - 1) {
            return
        }
        if (c < 0 || c > maxCol - 1) {
            return
        }
        if (grid[r][c] == 0) {
            // 陆地沉没法
            return
        }
        grid[r][c] = 0
        s[0]++
        s(grid, r + 1, c, s)
        s(grid, r, c + 1, s)
        s(grid, r - 1, c, s)
        s(grid, r, c - 1, s)
    }
}

fun main() {
    println(Solution().maxAreaOfIsland(int2d("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]"))) // 6
}