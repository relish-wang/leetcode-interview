package LCR115

import struct.Node
import struct.NodeUtils
import java.util.*

class SolutionKt {
    /**
     * 双向链表排序
     * @param root 链表
     * @return 从小到大排序后的链表
     */
    fun treeToDoublyList(root: Node?): Node? {
        if (root == null) return null
        var i: Node? = covertToChain(root)
        var head: Node? = i
        while (i != null) {
            var j = head
            while (j?.right != null) {
                val jv = j.`val`
                val j1 = j.right!!
                val j1v = j1.`val`
                if (jv > j1v) {
                    if (head == null) {
                        head = j1
                    }
                    swap(j, j1)
                } else {
                    if (head == null) {
                        head = j
                    }
                }
                j = j.right
            }
            if (i.right == null) {
                head?.left = i
                i.right = head
                break
            }
            i = i.right
        }
        return head
    }

    private fun swap(n1: Node, n2: Node) {
        val t = n1.`val`
        n1.`val` = n2.`val`
        n2.`val` = t
    }

    private fun covertToChain(root: Node?): Node? {
        if (root == null) return null
        val queue = LinkedList<Node>()
        queue.add(root)
        var pre: Node? = null
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val node = queue.poll()
                val left = node.left
                val right = node.right
                if (pre == null) {
                    pre = node
                    pre?.left = null
                } else {
                    pre.right = node
                    node.left = pre
                    pre = pre.right
                }
                if (left != null) {
                    queue.offer(left)
                }
                if (right != null) {
                    queue.offer(right)
                }
            }
        }
        pre?.right = null
        return root
    }
}

fun main() {
    println(SolutionKt().treeToDoublyList(NodeUtils.createTestData("[4,2,5,1,3]"))?.apply { isLoopNode = true })
}