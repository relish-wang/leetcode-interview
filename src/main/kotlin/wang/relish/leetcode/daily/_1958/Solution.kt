package wang.relish.leetcode.daily._1958

import struct.char2d
import struct.printSquare

class Solution {
    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        // board.printSquare()
        board[rMove][cMove] = color
        // board.printSquare()
        return hasGoodLine(board, rMove, cMove)
    }

    fun hasGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        if (hasUpGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasDownGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasLeftGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasRightGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasLeftUpGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasLeftDownGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasRightUpGoodLine(board, rMove, cMove)) {
            return true
        }
        if (hasRightDownGoodLine(board, rMove, cMove)) {
            return true
        }
        return false
    }

    fun hasUpGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        var r = rMove - 1
        while (r >= 0 && board[r][cMove] == mid) {
            r--
        }
        if (r < 0) return false
        return board[r][cMove] == end && rMove - r + 1 >= 3
    }

    fun hasDownGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        val maxRow = board.size
        var r = rMove + 1
        while (r < maxRow && board[r][cMove] == mid) {
            r++
        }
        if (r >= maxRow) return false
        return board[r][cMove] == end && r - rMove + 1 >= 3
    }

    fun hasLeftGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        var c = cMove - 1
        while (c >= 0 && board[rMove][c] == mid) {
            c--
        }
        if (c < 0) return false
        return board[rMove][c] == end && cMove - c + 1 >= 3
    }

    fun hasRightGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        val maxCol = board[0].size
        var c = cMove + 1
        while (c < maxCol && board[rMove][c] == mid) {
            c++
        }
        if (c >= maxCol) return false
        return board[rMove][c] == end && c - cMove + 1 >= 3
    }

    fun hasLeftUpGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        var r = rMove - 1
        var c = cMove - 1
        while (r >= 0 && c >= 0 && board[r][c] == mid) {
            r--
            c--
        }
        if (c < 0 || r < 0) return false
        return board[r][c] == end && cMove - c + 1 >= 3
    }

    fun hasLeftDownGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        val maxRow = board.size
        var r = rMove + 1
        var c = cMove - 1
        while (r < maxRow && c >= 0 && board[r][c] == mid) {
            r++
            c--
        }
        if (c < 0 || r >= maxRow) return false
        return board[r][c] == end && cMove - c + 1 >= 3
    }

    fun hasRightUpGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        var r = rMove - 1
        var c = cMove + 1
        val maxCol = board[0].size
        while (r >= 0 && c < maxCol && board[r][c] == mid) {
            r--
            c++
        }
        if (c >= maxCol || r < 0) return false
        return board[r][c] == end && c - cMove + 1 >= 3
    }

    fun hasRightDownGoodLine(board: Array<CharArray>, rMove: Int, cMove: Int): Boolean {
        val end = board[rMove][cMove]
        val mid = if (end == 'B') 'W' else 'B'
        var r = rMove + 1
        var c = cMove + 1
        val maxCol = board[0].size
        val maxRow = board.size
        while (r < maxRow && c < maxCol && board[r][c] == mid) {
            r++
            c++
        }
        if (c >= maxCol || r >= maxRow) return false
        return board[r][c] == end && c - cMove + 1 >= 3
    }
}

fun main() {
    println(
        Solution().checkMove(
            char2d("[[\"W\",\"W\",\".\",\"B\",\".\",\"B\",\"B\",\".\"],[\"W\",\"B\",\".\",\".\",\"W\",\"B\",\".\",\".\"],[\"B\",\"B\",\"B\",\"B\",\"W\",\"W\",\"B\",\".\"],[\"W\",\"B\",\".\",\".\",\"B\",\"B\",\"B\",\".\"],[\"W\",\"W\",\"B\",\".\",\"W\",\".\",\"B\",\"B\"],[\"B\",\".\",\"B\",\"W\",\".\",\"B\",\".\",\".\"],[\".\",\"B\",\"B\",\"W\",\"B\",\"B\",\".\",\".\"],[\"B\",\"B\",\"W\",\".\",\".\",\"B\",\".\",\".\"]]"),
            7, 4, 'B'
        )
    )
}