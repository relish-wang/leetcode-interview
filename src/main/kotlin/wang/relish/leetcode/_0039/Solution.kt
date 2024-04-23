package wang.relish.leetcode._0039

class Solution {

    val ans = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return listOf()
    }
}

fun main() {
    val s = Solution()
    println(s.combinationSum(intArrayOf(2, 3, 6, 7), 7).toTypedArray().contentToString()) // [[2,2,3],[7]]
    println(s.combinationSum(intArrayOf(2, 3, 5), 8).toTypedArray().contentToString()) // [[2,2,2,2],[2,3,3],[3,5]]
    println(s.combinationSum(intArrayOf(2), 1).toTypedArray().contentToString()) // []
    println(s.combinationSum(intArrayOf(8, 7, 4, 3), 11).toTypedArray().contentToString()) // []
}