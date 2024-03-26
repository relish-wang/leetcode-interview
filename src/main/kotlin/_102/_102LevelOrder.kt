package _102

import _094.TreeNode

fun main() {
    val node = TreeNode.createTestData("[3,9,20,null,null,15,7]")
    levelOrder(node).print()
}

private val ans = mutableListOf<MutableList<Int>>()
fun levelOrder(root: TreeNode?): List<List<Int>> {
    lo(root, 0)
    return ans
}

/**
 * 下次试试迭代, 不要用递归
 */
fun lo(root: TreeNode?, level: Int) {
    if (root == null) return
    if (ans.getOrNull(level) == null) {
        ans.add(mutableListOf())
    }
    ans[level].add(root.`val`)
    lo(root.left, level + 1)
    lo(root.right, level + 1)
}

fun List<List<Int>>.print() {
    val c = this.size
    //println(Array<IntArray>(c) { IntArray(this[it].size) { y -> this[it][y] } }.contentToString())
    for (i in 0 until c) {
        for (j in 0 until this[i].size) {
            print("${this[i][j]} ")
        }
        println()
    }
}