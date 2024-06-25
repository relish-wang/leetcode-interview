package wang.relish.leetcode.daily._2732

class Solution {

    /**
     * 灵神的解法
     */
    fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
        val row = grid.size
        val col = grid[0].size
        val maskToIdx = hashMapOf<Int, Int>()
        for (i in 0 until row) {
            var mask = 0
            for (j in 0 until col) {
                mask = mask or (grid[i][j] shl j)
            }
            if (mask == 0) {
                return listOf(i)
            }
            maskToIdx[mask] = i
        }

        for (e1 in maskToIdx) {
            for (e2 in maskToIdx) {
                if (e1.key and e2.key == 0) {
                    val i = e1.value
                    val j = e2.value
                    return if (i > j) {
                        listOf(j, i)
                    } else {
                        listOf(i, j)
                    }
                }
            }
        }
        return listOf()
    }

    /**
     * 自己看了题目提示, 想到的解法
     */
    fun goodSubsetofBinaryMatrix1(grid: Array<IntArray>): List<Int> {
        val row = grid.size
        if (row == 1) {
            if (fit(grid, 0, 0)) {
                return listOf(0)
            } else {
                return listOf()
            }
        }
        for (i in 0 until row) {
            for (j in i + 1 until row) {
                if (fit(grid, i, j)) {
                    return listOf(i, j)
                }
            }
        }
        return listOf()
    }

    fun fit(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        val s1 = grid[i]
        val s2 = grid[j]
        val n = s1.size
        for (i in 0 until n) {
            if (s1[i] + s2[i] == 2) {
                return false
            }
        }
        return true
    }
}