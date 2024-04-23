package wang.relish.leetcode.second._0200

/**
 * https://leetcode.cn/problems/number-of-islands/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j)
                    ans++
                }
            }
        }
        return ans
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        val m = grid.size
        val n = grid[0].size
        if (i !in 0 until m || j !in 0 until n) {
            return
        }
        if (grid[i][j] != '1') {
            return
        }
        grid[i][j] = '2'
        dfs(grid, i - 1, j)
        dfs(grid, i, j - 1)
        dfs(grid, i + 1, j)
        dfs(grid, i, j + 1)
    }
}

fun main() {
    // [['1','1','1','1','0'],['1','1','0','1','0'],['1','1','0','0','0'],['0','0','0','0','0']]
    println(
        Solution().numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    )
}