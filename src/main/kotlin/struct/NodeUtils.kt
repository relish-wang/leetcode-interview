package struct

import java.util.*


object NodeUtils {
    /**
     * 创建测试数据
     *
     * @param str [XX,XX,null,xx]
     * @return [Node1]
     */
    @JvmStatic
    fun createTestData(str: String): Node? {
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
        val qHigh = LinkedList<Node?>()
        if (qLow.isEmpty()) {
            return null
        }
        val rv = qLow.poll() ?: return null
        val root = Node(rv)
        qHigh.offer(root)
        while (qHigh.isNotEmpty()) {
            val r = qHigh.poll() ?: continue
            val left = (qLow.poll()?.let { Node(it) }).also { qHigh.offer(it) }
            val right = (qLow.poll()?.let { Node(it) }).also { qHigh.offer(it) }
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
    fun print(root: Node?) {
        print(root, 0)
    }

    private fun print(node: Node?, deep: Int) {
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

    /**
     * 要求每个节点的值都不一样
     */
    fun Node?.findChildTree(target: Int): Node? {
        if (this == null) {
            return null
        }
        if (this.`val` == target) {
            return this
        }
        return left?.findChildTree(target) ?: right?.findChildTree(target)
    }

    fun toString(node: Node?): String {
        val r = mutableListOf<Int>()
        var n: Node? = node
        var meetloop = 0
        var i = 0
        var loopValue = -1
        var loopIndex = -1
        while (n != null) {
            if (n.isLoopNode) {
                meetloop++
                if (meetloop == 1) {
                    loopValue = n.`val`
                    loopIndex = i
                } else if (meetloop >= 2) {
                    break
                }
            }
            r.add(n.`val`)
            n = n.right
            i++
        }
        val ans = r.toIntArray().contentToString()
        return if (loopIndex == -1) {
            ans
        } else {
            "$ans, 环入口在第【${loopIndex}】个节点其值为【${loopValue}】"
        }
    }
}
