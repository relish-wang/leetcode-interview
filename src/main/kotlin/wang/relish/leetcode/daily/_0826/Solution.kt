package wang.relish.leetcode.daily._0826

class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val n = difficulty.size
        val tasks = Array(n) { Task(difficulty[it], profit[it]) }
        tasks.sort()

        worker.sort()

        var j = 0
        var ans = 0
        var maxProfit = 0
        for (w in worker){
            while (j < n && tasks[j].difficulty <= w) {
                maxProfit = Math.max(maxProfit, tasks[j++].profit)
            }
            ans += maxProfit
        }
        return ans
    }

    class Task(
        val difficulty: Int,
        val profit: Int
    ) : Comparable<Task> {
        override fun compareTo(other: Task): Int {
            return if (difficulty > other.difficulty) {
                1
            } else if (difficulty == other.difficulty) {
                if (profit > other.profit) {
                    1
                } else if (profit == other.profit) {
                    0
                } else {
                    -1
                }
            } else {
                -1
            }
        }

        override fun toString(): String {
            return "[ $difficulty, $profit ]"
        }
    }
}

fun main() {
    println(
        Solution().maxProfitAssignment(
            intArrayOf(2, 4, 6, 8, 10),
            intArrayOf(10, 20, 30, 40, 50),
            intArrayOf(4, 5, 6, 7)
        )
    ) // 100
    println(
        Solution().maxProfitAssignment(
            intArrayOf(85, 47, 57),
            intArrayOf(24, 66, 99),
            intArrayOf(40, 25, 25)
        )
    ) // 0
}