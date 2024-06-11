package wang.relish.leetcode.daily._0419


class Solution {
    fun countBattleships(board: Array<CharArray>): Int {
        var count = 0
        val row = board.size
        val col = board[0].size

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (board[i][j] == 'X') {
                    count += countIfNoeCounted(board, i, j)
                }
            }
        }
        return count
    }

    /**
     * 已经前置判断i,j所在位置是'X'
     */
    fun countIfNoeCounted(board: Array<CharArray>, i: Int, j: Int): Int {
        // 左边或上边有没有X
        if (i - 1 >= 0 && board[i - 1][j] == 'X' || j - 1 >= 0 && board[i][j - 1] == 'X') {
            return 0
        }
        return 1
    }
}

fun main() {
    // [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
    println(
        Solution().countBattleships(
            arrayOf(
                charArrayOf('X', '.', '.', 'X'),
                charArrayOf('.', '.', '.', 'X'),
                charArrayOf('.', '.', '.', 'X')
            )
        )
    ) // 2
    println(Solution().countBattleships(arrayOf(charArrayOf('.')))) // 0
}