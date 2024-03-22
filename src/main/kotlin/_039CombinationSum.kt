fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
}

/**
 * 排序、剪枝
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    if (candidates.isEmpty()) {
        return ans
    }
    // 排序是剪枝的前提
    candidates.sort()
    val path = ArrayDeque<Int>()
    dfs(candidates, target, 0, candidates.size, path, ans)
    return ans
}

fun dfs(a: IntArray, t: Int, s: Int, e: Int, path: ArrayDeque<Int>, ans: MutableList<List<Int>>) {
    // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
    if (t == 0) {
        ans.add(path.toList())
        return
    }
    for (i in s until e) {
        // 重点理解这里剪枝，前提是候选数组已经有序，
        if (t - a[i] < 0) {
            break
        }
        path.addLast(a[i])
        dfs(a, t - a[i], i, e, path, ans)
        path.removeLast()
    }
}