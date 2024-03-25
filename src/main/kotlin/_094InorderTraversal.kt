
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

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        /**
         * 创建测试数据
         *
         * @param data [XX,XX,null,xx]
         * @return [TreeNode]
         */
        fun createTestData(data: String): TreeNode? {
            var data = data
            if (data == "[]") return null
            data = data.substring(1, data.length - 1)
            val split = data.split(",")
            val len = split.size
            val treeNodes = arrayOfNulls<TreeNode>(len)
            for (i in 0 until len) {
                if (split[i] != "null") {
                    treeNodes[i] = TreeNode(split[i].toInt())
                }
            }
            for (i in 0 until len) {
                if (treeNodes[i] != null) {
                    val leftIndex = i * 2 + 1
                    if (leftIndex < len) {
                        treeNodes[i]!!.left = treeNodes[leftIndex]
                    }
                    val rightIndex = leftIndex + 1
                    if (rightIndex < len) {
                        treeNodes[i]!!.right = treeNodes[rightIndex]
                    }
                }
            }
            return treeNodes[0]
        }

        private const val space = "      "

        /**
         * 竖向打印二叉树
         *
         * @param root 二叉树根节点
         */
        fun print(root: TreeNode?) {
            print(root, 0)
        }

        private fun print(node: TreeNode?, deep: Int) {
            if (node == null) {
                printSpace(deep)
                println("#")
                return
            }
            print(node.right, deep + 1)
            printSpace(deep)
            printNode(node.`val`)
            print(node.left, deep + 1)
        }

        private fun printSpace(count: Int) {
            for (i in 0 until count) {
                System.out.printf(space)
            }
        }

        private fun printNode(`val`: Int) {
            val res = StringBuilder("$`val`<")
            val spaceNum = space.length - res.length
            for (i in 0 until spaceNum) {
                res.append(" ")
            }
            println(res)
        }
    }
}