package _101

import TreeNode

fun main() {
//    println(isSymmetric(TreeNode.createTestData("[1,2,2,3,4,4,3]").also { TreeNode.print(it) }))
//    println(isSymmetric(TreeNode.createTestData("[1,2,2,null,3,null,3]").also { TreeNode.print(it) }))
    println(isSymmetric(TreeNode.createTestData("[1,2,2,2,null,2]").also { TreeNode.print(it) }))
}

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return lr(root.left, root.right)
}

/**
 * 思路:
 * 前序遍历是: 根->左->右。为了对比对称搞出一种新的遍历方式, 就叫【对称前序遍历】吧: 根->右->左
 * 然后遍历的每个节点都进行对比, 只要有一个不一致就不是对称二叉树。
 *
 * 还有一种思路是用队列
 */
fun lr(l: TreeNode?, r: TreeNode?): Boolean {
    if (l == null && r != null) {
        return false
    }
    if (l != null && r == null) {
        return false
    }
    return (l == null || r == null) || lr(l.left, r.right) && l.`val` == r.`val` && lr(l.right, r.left)
}


