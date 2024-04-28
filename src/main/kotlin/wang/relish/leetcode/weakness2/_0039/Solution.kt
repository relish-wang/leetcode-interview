package wang.relish.leetcode.weakness2._0039

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        ff(candidates, target, 0, mutableListOf())
        return res
    }

    val res = mutableListOf<List<Int>>()

    fun ff(candidates: IntArray, target: Int, index: Int, list: MutableList<Int>) {
        if (target == 0) {
            res.add(list.toList())
            return
        }
        for (i in index until candidates.size) {
            if (candidates[i] > target) break
            list.add(candidates[i])
            ff(candidates, target - candidates[i], i, list)
            list.removeLast()
        }
    }


    val ans = hashSetOf<MutableList<Int>>()
    fun combinationSum1(candidates: IntArray, target: Int): List<List<Int>> {
        ans.clear()
        candidates.sort()
        f(candidates, target, 0, 0, mutableListOf())
        return ans.toList()
    }

    fun f(candidates: IntArray, target: Int, index: Int, sum: Int, list: MutableList<Int>) {
        if (index >= candidates.size) return
        val add = candidates[index]
        val newSum = add + sum
        if (newSum > target) {
            return
        }
        if (newSum == target) {
            ans.add(ArrayList(list).apply { add(add) })
            return
        }
        f(candidates, target, index, newSum, ArrayList(list).apply { add(add) }) // 加进sum, 但不加index
        f(candidates, target, index + 1, sum, ArrayList(list)) // 啥也不加就是玩
        f(candidates, target, index + 1, newSum, ArrayList(list).apply { add(add) }) // 加进sum, 也加index
    }
}

fun main() {
    val s = Solution()
    println(s.combinationSum(intArrayOf(2, 3, 6, 7), 7).toTypedArray().contentToString()) // [[2,2,3],[7]]
    println(s.combinationSum(intArrayOf(2, 3, 5), 8).toTypedArray().contentToString()) // [[2,2,2,2],[2,3,3],[3,5]]
    println(s.combinationSum(intArrayOf(2), 1).toTypedArray().contentToString()) // []
    println(s.combinationSum(intArrayOf(8, 7, 4, 3), 11).toTypedArray().contentToString()) // []
}