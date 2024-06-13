package wang.relish.leetcode.daily._2813

import struct.int2d
import java.util.Stack
import kotlin.math.max

class Solution {
    fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
        items.sortWith(object : Comparator<IntArray> {
            override fun compare(o1: IntArray?, o2: IntArray?): Int {
                if (o1 == null || o2 == null) return 0
                return o2[0] - o1[0]
            }
        })
        val vis = hashSetOf<Int>()
        val duplicate = Stack<Int>()
        var totalProfit = 0L
        var ans = 0L
        for (i in items.indices) {
            val profit = items[i][0]
            val category = items[i][1]
            if (i < k) {
                totalProfit += profit
                if (!vis.add(category)) {
                    duplicate.push(profit)
                }
            } else if (!duplicate.isEmpty() && vis.add(category)) { // 之前没有的类别
                totalProfit += profit - duplicate.pop() // 选一个重复类别中的最小利润替换
            } // else：比前面的利润小，而且类别还重复了，选它只会让 totalProfit 变小，vis.size() 不变，优雅度不会变大
            val size = vis.size.toLong()
            ans = max(ans, (totalProfit + (size * size))) // 注意 1e5*1e5 会溢出
        }
        //list.toTypedArray().printSquare()
        return ans
    }
}

fun main() {
    println(Solution().findMaximumElegance(int2d("[[3,2],[5,1],[10,1]]"), 2)) // 17
    println(Solution().findMaximumElegance(int2d("[[3,1],[3,1],[2,2],[5,3]]"), 3)) // 19
    println(Solution().findMaximumElegance(int2d("[[1,1],[2,1],[3,1]]"), 3)) // 7
    println(Solution().findMaximumElegance(int2d("[[2,2],[8,3],[8,3]]"), 2)) // 17
    println(Solution().findMaximumElegance(int2d("[[10,1],[6,1],[5,3],[5,2]]"), 3)) // 29
    println(Solution().findMaximumElegance(int2d("[[5,4],[6,6],[8,4],[6,6],[7,6],[1,6],[4,2]]"), 5)) // 40
}