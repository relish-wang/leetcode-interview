package wang.relish.leetcode.second._0695

import struct.int2d
import kotlin.math.max

/**
 * [岛屿最大面积](https://leetcode.cn/problems/max-area-of-island/description/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM)
 */
class Solution {
    var ans = 0

    // 岛屿最大面积
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        for (r in 0 until row) {
            for (c in 0 until col) {
                if (grid[r][c] == 1) {
                    ans = max(ans, dfs(grid, r, c))
                }
            }
        }
        return ans
    }

    fun dfs(grid: Array<IntArray>, r: Int, c: Int): Int {
        val row = grid.size
        val col = grid[0].size
        if (r !in 0 until row || c !in 0 until col) return 0
        if (grid[r][c] != 1) return 0
        grid[r][c] = 2
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r, c + 1) + dfs(grid, r - 1, c) + dfs(grid, r, c - 1)
    }
}

fun main() {
    println(Solution().maxAreaOfIsland(int2d("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]"))) // 6
    println(Solution().maxAreaOfIsland(int2d("[[0,0,0,0,0,0,0,0]]"))) // 0
}