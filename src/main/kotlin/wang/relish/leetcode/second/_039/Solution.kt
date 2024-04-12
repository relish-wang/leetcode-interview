package wang.relish.leetcode.second._039

class Solution {

    val ans = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val n = candidates.size
        if (n == 0) return ans
        candidates.sort()
        f(candidates, target, 0, mutableListOf())
        return ans
    }

    fun f(a: IntArray, t: Int, l: Int, q: MutableList<Int>) {
        if (t == 0) {
            ans.add(q.toList())
            return
        }
        for (i in l until a.size) {
            if (a[i] > t) break
            q.add(a[i])
            f(a, t - a[i], i, q)
            q.removeLast()
        }
    }
}

fun main() {
    println(Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7).toTypedArray().contentToString()) // [[2,2,3],[7]]
    println(
        Solution().combinationSum(intArrayOf(2, 3, 5), 8).toTypedArray().contentToString()
    ) // [[2,2,2,2],[2,3,3],[3,5]]
    println(Solution().combinationSum(intArrayOf(2), 1).toTypedArray().contentToString()) // []
    println(Solution().combinationSum(intArrayOf(8,7,4,3), 11).toTypedArray().contentToString()) // []
}