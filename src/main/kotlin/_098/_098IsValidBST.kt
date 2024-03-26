package _098

import _094.TreeNode

fun main() {
//    val root = TreeNode.createTestData("[2,1,3]")
    val root = TreeNode.createTestData("[5,4,6,null,null,3,7]")
    TreeNode.print(root)
    println(isValidBST(root))
}

fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return isValidBST(root, LongArray(1) { Long.MIN_VALUE })
//    return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE)
}


/**
 * 1 递归解法
 */
fun isValidBST1(root: TreeNode?, lower: Long = Long.MIN_VALUE, upper: Long = Long.MAX_VALUE): Boolean {
    if (root == null) {
        return true
    }
    val v = root.`val`
    if (v <= lower || v >= upper) {
        return false
    }
    return isValidBST1(root.left, lower, v.toLong()) && isValidBST1(root?.right, v.toLong(), upper)
}

/**
 * 2 中序遍历
 * 便利出来的顺序应该是升序(从左到右, 从小到大), 否则就不是一个二叉搜索树
 * 优化点: 可以把pre做成全局变量
 */
fun isValidBST(root: TreeNode?, pre: LongArray): Boolean {
    if (root == null) {
        return true
    }
    if (isValidBST(root.left, pre).not()) {
        return false
    }
    if (root.`val` <= pre.first()) {
        return false
    } else {
        pre[0] = root.`val`.toLong()
    }
    if (isValidBST(root.right, pre).not()) {
        return false
    }
    return true
}

/**
 *     /* 精妙的中序遍历代码 */
 *
 *     var lastNumber: Int? = null
 *     fun isValidBST(root: TreeNode?): Boolean {
 *         return root == null || (isValidBST(root.left) && checkNode(root) && isValidBST(root.right))
 *     }
 *
 *     private fun checkNode(node:TreeNode): Boolean {
 *         if (lastNumber?.let { it < node.`val` } == false) {
 *             return false
 *         }
 *         lastNumber = node.`val`
 *         return true
 *     }
 */