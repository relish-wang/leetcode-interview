package wang.relish.leetcode.first._200

/**
 * https://leetcode.cn/problems/number-of-islands/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 广度优先搜索
     */
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == '1') {
                    count++
                    dfs(grid, r, c)
                }
            }
        }
        return count
    }

    fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
        if (inArea(grid, r, c).not()) return
        if (grid[r][c] != '1') return
        grid[r][c] = '2'
        dfs(grid, r - 1, c)
        dfs(grid, r, c - 1)
        dfs(grid, r + 1, c)
        dfs(grid, r, c + 1)
    }

    fun inArea(grid: Array<CharArray>, r: Int, c: Int): Boolean {
        return r in grid.indices && c in grid[0].indices
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