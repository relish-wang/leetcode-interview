import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        val r = mutableListOf<Int>()
        var n: ListNode? = this
        while (n != null) {
            r.add(n.`val`)
            n = n.next
        }
        return r.toIntArray().contentToString()
    }

    companion object {
        fun newInstance(arr: IntArray): ListNode? {
            var n: ListNode? = null
            var h: ListNode? = null
            for (i in arr) {
                val t = ListNode(i)
                if (h == null) {
                    h = t
                }
                if (n == null) {
                    n = t
                } else {
                    n.next = t
                    n = t
                }
            }
            return h
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun print() {
        print(this)
    }

    companion object {
        /**
         * 创建测试数据
         *
         * @param str [XX,XX,null,xx]
         * @return [TreeNode]
         */
        fun createTestData(str: String): TreeNode? {
            var data = str
            if (data == "[]") return null
            data = data.substring(1, data.length - 1)
            val split = data.split(",")
            val qLow = LinkedList<Int?>()
            for (i in split.indices) {
                split[i].let {
                    qLow.offer(
                        if (it == "null") {
                            null
                        } else {
                            it.toInt()
                        }
                    )
                }
            }
            val qHigh = LinkedList<TreeNode?>()
            if (qLow.isEmpty()) {
                return null
            }
            val rv = qLow.poll() ?: return null
            val root = TreeNode(rv)
            qHigh.offer(root)
            while (qHigh.isNotEmpty()) {
                val r = qHigh.poll() ?: continue
                val left = (qLow.poll()?.let { TreeNode(it) }).also { qHigh.offer(it) }
                val right = (qLow.poll()?.let { TreeNode(it) }).also { qHigh.offer(it) }
                r.left = left
                r.right = right
            }
            return root
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