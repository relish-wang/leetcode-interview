fun main() {
    val tree = buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
    TreeNode.print(tree)
}


val indexMap = hashMapOf<Int, Int>()
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val n = preorder.size
    if (n == 0) {
        return null
    }
    for (i in inorder.indices) {
        indexMap[inorder[i]] = i
    }
    return bt(preorder, inorder, 0, n - 1, 0, n - 1)
}

/**
 * @param preorder 前序遍历
 * @param inorder 中序遍历
 * @param preorderLeft 前序遍历左边界
 * @param preorderRight 前序遍历右边界
 * @param inorderLeft 中序遍历左边界
 * @param inorderRight 中序遍历右边界
 */
fun bt(
    preorder: IntArray,
    inorder: IntArray,
    preorderLeft: Int,
    preorderRight: Int,
    inorderLeft: Int,
    inorderRight: Int
): TreeNode? {
    if (preorderLeft > preorderRight) {
        return null
    }
    val rootVal = preorder[preorderLeft] // 根节点值
    val inOrderRootIndex = indexMap[rootVal]!! // 中序遍历的根节点索引
    val root = TreeNode(rootVal) // 根节点
    val leftSubTreeSize = inOrderRootIndex - inorderLeft // 左子树节点数量
    // 先序遍历中「从 左边界+1 开始的 leftSubTreeSize」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    root.left = bt(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubTreeSize, inorderLeft, inOrderRootIndex - 1)
    // 先序遍历中「从 左边界+1+左子树节点数量 开始到 右边界」的元素就对应了中序遍历中「从 根节点+1 开始到 右边界」的元素
    root.right = bt(preorder, inorder, preorderLeft + 1 + leftSubTreeSize, preorderRight, inOrderRootIndex + 1, inorderRight)
    return root
}

/*
    if (preorder_left > preorder_right) {
        return null;
    }
    // 前序遍历中的第一个节点就是根节点
    int preorder_root = preorder_left;
    // 在中序遍历中定位根节点
    int inorder_root = indexMap.get(preorder[preorder_root]);

    // 先把根节点建立出来
    TreeNode root = new TreeNode(preorder[preorder_root]);
    // 得到左子树中的节点数目
    int size_left_subtree = inorder_root - inorder_left;
    // 递归地构造左子树，并连接到根节点
    // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
    // 递归地构造右子树，并连接到根节点
    // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
    root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
    return root;
 */