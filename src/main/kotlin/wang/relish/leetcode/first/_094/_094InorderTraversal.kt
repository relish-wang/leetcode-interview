package wang.relish.leetcode.first._094

import struct.TreeNode

fun main() {
    var node = TreeNode.createTestData("[1,2,3,4,5,6,7]")
    TreeNode.print(node)

    println(inorderTraversal(node).toTypedArray().contentToString())
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val ans = mutableListOf<Int>()
    dfs(root, ans)
    return ans
}

fun dfs(node: TreeNode?, list: MutableList<Int>) {
    if (node == null) {
        return
    }
    dfs(node.left, list)
    list.add(node.`val`)
    dfs(node.right, list)
}