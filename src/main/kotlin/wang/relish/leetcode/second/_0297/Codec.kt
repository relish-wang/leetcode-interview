package wang.relish.leetcode.second._0297

import struct.TreeNode
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
    fun serialize(root: TreeNode?): String {
        if (root == null) return "#"
        val sb = StringBuilder()
        val q = LinkedList<TreeNode>()
        q.offer(root)
        sb.append(root.`val`)
        while (q.isNotEmpty()) {
            val n = q.size
            for (i in 0 until n) {
                val t = q.poll()
                val l = t.left?.also { q.offer(it) }
                val r = t.right?.also { q.offer(it) }
                sb.append("_").append(l?.`val` ?: "#")
                sb.append("_").append(r?.`val` ?: "#")
            }
        }
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    /**
     * @see TreeNode.createTestData
     */
    fun deserialize(data: String): TreeNode? {
        if (data == "#") return null
        val arr = data.split("_").map {
            if (it == "#" || it.isEmpty()) null else it.toInt()
        }
        val root = TreeNode(arr[0]!!)

        val q = LinkedList<TreeNode?>()
        q.offer(root)
        var index = 1
        while (q.isNotEmpty()) {
            val n = q.size
            for (i in 0 until n) {
                val t = q.poll() ?: continue
                if (index >= arr.size) return root
                val lv = arr[index++]
                val rv = arr[index++]
                t.left = lv?.let { TreeNode(it) }.also { q.offer(it) }
                t.right = rv?.let { TreeNode(it) }.also { q.offer(it) }
            }
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
    //val tree = codec.deserialize("[1,2,3,null,null,4,5]")
    val tree = codec.deserialize("1-2-3-#-#-4-5")
    tree?.print()
    println("====================")
    val s = codec.serialize(tree)
    println(s)
    println("====================")
    val newTree = codec.deserialize(s)
    newTree?.print()
}