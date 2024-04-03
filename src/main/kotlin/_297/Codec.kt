package _297

import TreeNode
import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */

class Codec() {
    // Encodes a URL to a shortened URL.
    /**
     * 层序遍历
     */
    fun serialize(root: TreeNode?): String {
        return level(root).toTypedArray().contentToString().replace(", ", ",")
    }

    private fun level(root: TreeNode?): MutableList<Int?> {
        val list = mutableListOf<Int?>()
        if (root == null) {
            return list
        }
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.poll()
                list.add(node?.`val`)
                if(node == null) continue
                queue.offer(node.left)
                queue.offer(node.right)
            }
        }
        return list
    }

    // Decodes your encoded data to tree.
    /**
     * @see TreeNode.createTestData
     */
    fun deserialize(data: String): TreeNode? {
        var str = data
        if (str == "[]") return null
        str = str.substring(1, str.length - 1)
        val split = str.split(",")
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
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */

fun main() {
    val codec = Codec()
    val tree = codec.deserialize("[1,2,3,null,null,4,5]")
    tree?.print()
    println("====================")
    val s = codec.serialize(tree)
    println(s)
    println("====================")
    val newTree = codec.deserialize(s)
    newTree?.print()
}