package wang.relish.leetcode._0200

/**
 * https://leetcode.cn/problems/number-of-islands/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        return 0
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