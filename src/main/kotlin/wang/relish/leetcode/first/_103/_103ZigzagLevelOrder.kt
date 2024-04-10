package wang.relish.leetcode.first._103

import struct.TreeNode
import wang.relish.leetcode.first._102.print

fun main() {
//    val node = TreeNode.createTestData("[3,9,20,null,null,15,7]")
    val node = TreeNode.createTestData("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]")
//    val node = TreeNode.createTestData("[1,2,3,4,null,null,5]")
    TreeNode.print(node)
    zigzagLevelOrder(node).print()
}

/**
 * https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/34757348185/385d/c885/fac0/41f0bf9e559b0faf89bde283be5c2ce0.png
 * 用时: 94.44%
 * 内存: 80.56%
 */
fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val ret = mutableListOf<MutableList<Int>>()
    if (root == null) {
        return ret
    }
    val preLevel = mutableListOf<TreeNode>()
    preLevel.add(root)
    var level = 1
    while (preLevel.isNotEmpty()) {
        val line = mutableListOf<Int>()
//        print("level$level: ")
        val reverse = level % 2 == 1
        val thisLevel = mutableListOf<TreeNode>()
        val size = preLevel.size
        for (i in 0 until size) {
            val or = preLevel[i]
            val re = preLevel[size - 1 - i]
            line.add(or.`val`)
            val l = re.left
            val r = re.right
            if (reverse) {
                r?.let { n -> thisLevel.add(n) }//.also { print("${n.`val`} ") } }
                l?.let { n -> thisLevel.add(n) }//.also { print("${n.`val`} ") } }
            } else {
                l?.let { n -> thisLevel.add(n) }//.also { print("${n.`val`} ") } }
                r?.let { n -> thisLevel.add(n) }//.also { print("${n.`val`} ") } }
            }
        }
        println()
        ret.add(line)
        preLevel.clear()
        preLevel.addAll(thisLevel)
        level++
    }
    return ret
//     zlo1(root, 0)
//     return ans
}

/**
 * 下次试试递归, 广度优先搜索(bfs)和深度优先搜索(dfs)
 */
/*
private val ans = mutableListOf<MutableList<Int>>()
fun zlo1(root: TreeNode?, level: Int) {
    if (root == null) return
    if (ans.getOrNull(level) == null) {
        ans.add(mutableListOf())
    }
    ans[level].add(root.`val`)
    if (level % 2 == 0) {
        zlo1(root.right, level + 1)
        zlo1(root.left, level + 1)
    } else {
        zlo1(root.left, level + 1)
        zlo1(root.right, level + 1)
    }
}*/
