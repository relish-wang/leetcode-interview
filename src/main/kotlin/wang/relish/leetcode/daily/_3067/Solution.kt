package wang.relish.leetcode.daily._3067

import struct.int2d


class Solution {
    fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
        val n = edges.size + 1
        val g = Array<ArrayList<Pair<Int, Int>>>(n) { arrayListOf() }
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            val w = edge[2]
            g[a].add(b to w)
            g[b].add(a to w)
        }
        val ans = IntArray(n)
        for (i in 0 until n) {
            var sum = 0
            for (e in g[i]) {
                val cnt: Int = dfs(e.first, i, e.second, g, signalSpeed)
                ans[i] += sum * cnt
                sum += cnt
            }
        }
        return ans
    }


    fun dfs(
        a: Int,
        i: Int,
        sum: Int,
        g: Array<ArrayList<Pair<Int, Int>>>,
        signalSpeed: Int
    ): Int {
        var cnt = if (sum % signalSpeed == 0) 1 else 0
        for (e in g[a]) {
            val b = e.first // b
            if (b != i) {
                cnt += dfs(b, a, sum + e.second, g, signalSpeed);
            }
        }
        return cnt
    }
}

fun main() {
    t("[[0,1,1],[1,2,5],[2,3,13],[3,4,9],[4,5,2]]", 1) // [0,4,6,6,4,0]
    t("[[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]]", 3) // [2,0,0,0,0,0,2]
}

private fun t(int2d: String, signalSpeed: Int) {
    println(Solution().countPairsOfConnectableServers(int2d(int2d), signalSpeed).contentToString())
}