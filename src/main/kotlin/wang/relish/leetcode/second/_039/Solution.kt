package wang.relish.leetcode.second._039

class Solution {

    val ans = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val n = candidates.size
        if (n == 0) {
            return ans
        }
        candidates.sort()
        dfs(candidates, target, 0, n, ArrayDeque<Int>())
        return ans
    }

    fun dfs(arr: IntArray, target: Int, left: Int, right: Int, path: ArrayDeque<Int>) {
        if (target == 0) {
            ans.add(path.toList())
            return
        }
        for (i in left until right) {
            if (target - arr[i] < 0) { // 剪枝: arr是升序, 比arr[i]这个更大的数字, 更加小于0
                break
            }
            path.addLast(arr[i])
            dfs(arr, target - arr[i], i, right, path)
            path.removeLast() // 回溯
        }
    }
}

fun main() {
    println(Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7).toTypedArray().contentToString()) // [[2,2,3],[7]]
    println(
        Solution().combinationSum(intArrayOf(2, 3, 5), 8).toTypedArray().contentToString()
    ) // [[2,2,2,2],[2,3,3],[3,5]]
    println(Solution().combinationSum(intArrayOf(2), 1).toTypedArray().contentToString()) // []
}