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
    /**
     * 层序遍历
     */
    fun serialize(root: TreeNode?): String {
        return ""
    }

    private fun level(root: TreeNode?): MutableList<Int?> {
        return mutableListOf()
    }

    // Decodes your encoded data to tree.
    /**
     * @see TreeNode.createTestData
     */
    fun deserialize(data: String): TreeNode? {
        return null
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