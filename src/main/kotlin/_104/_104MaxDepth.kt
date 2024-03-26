package _104

import _094.TreeNode
import java.util.*
import kotlin.math.max

fun main() {
    println(maxDepth(TreeNode.createTestData("[3,9,20,null,null,15,7]")))
    println(maxDepth(TreeNode.createTestData("[1,null,2]")))
}

/**
 * 用时: 94.8%
 * 内存: 29.48%
 */
fun maxDepth(root: TreeNode?): Int {
//    return dfs(root, 0)
    return bfs(root)
}

/**
 * 深度优先搜索
 */
fun dfs(root: TreeNode?, level: Int): Int {
    if (root == null) return level
    return max(dfs(root.left, level + 1), dfs(root.right, level + 1))
}


/**
 * 广度优先搜索
 */
fun bfs(root: TreeNode?): Int {
    var ans = 0
    if (root == null) return 0
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (queue.isEmpty().not()) {
        for (i in 0 until queue.size) {
            val node = queue.poll()
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        ans++
    }
    return ans
}
