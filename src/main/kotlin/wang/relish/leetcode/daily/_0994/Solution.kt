package wang.relish.leetcode.daily._0994

import struct.int2d
import struct.printSquare
import java.util.*

class Solution {

    fun orangesRotting(grid: Array<IntArray>): Int {
        return tryInfect(grid, 0)
    }

    fun tryInfect(grid: Array<IntArray>, min: Int): Int {
        val row = grid.size
        val col = grid[0].size
        var newInfect = false
        val q = LinkedList<Pair<Int, Int>>()
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == 2) {
                    q.offer(i to j)
                }
            }
        }
        var hasFresh = false
        for (i in 0 until q.size) {
            val infected = infect4Orange(grid, q[i].first, q[i].second)
            if (infected) {
                newInfect = true
            }
        }
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == 1) {
                    hasFresh = true
                }
            }
        }
        return if (newInfect) {
//            println("min: $min")
//            grid.printSquare()
//            println()
            tryInfect(grid, min + 1)
        } else {
            if (hasFresh) {
                -1
            } else {
                min
            }
        }
    }

    fun infect4Orange(grid: Array<IntArray>, r: Int, c: Int): Boolean {
        val up = infect(grid, r - 1, c)
        val down = infect(grid, r + 1, c)
        val left = infect(grid, r, c - 1)
        val right = infect(grid, r, c + 1)
        return up || down || left || right
    }

    fun infect(grid: Array<IntArray>, r: Int, c: Int): Boolean {
        val row = grid.size
        val col = grid[0].size
        if (r !in 0 until row || c !in 0 until col) {
            return false
        }
        if (grid[r][c] == 1) {
            grid[r][c] = 2
            return true
        }
        return false
    }
}

fun main() {
    println(Solution().orangesRotting(int2d("[[2,1,1],[1,1,0],[0,1,1]]"))) // 4
    println(Solution().orangesRotting(int2d("[[2,1,1],[0,1,1],[1,0,1]]"))) // -1
    println(Solution().orangesRotting(int2d("[[0,2]]"))) // 0
    println(Solution().orangesRotting(int2d("[[2,1,1],[1,1,1],[0,1,2]]"))) // 2
    println(Solution().orangesRotting(int2d("[[1],[2],[1],[1]]").also { /*it.printSquare()*/ })) // 2
}