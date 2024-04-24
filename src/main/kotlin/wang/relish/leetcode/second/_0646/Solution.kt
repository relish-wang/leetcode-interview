package wang.relish.leetcode.second._0646

import struct.int2d

/**
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * @see wang.relish.leetcode.second._0452.Solution
 */
class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith(object : Comparator<IntArray> {
            override fun compare(p0: IntArray?, p1: IntArray?): Int {
                p0 ?: return 0
                p1 ?: return 0
                return if (p0[1] > p1[1]) {
                    1
                } else if (p0[1] == p1[1]) {
                    if (p0[0] > p1[0]) {
                        1
                    } else if (p0[0] == p1[0]) {
                        0
                    } else {
                        -1
                    }
                } else {
                    -1
                }
            }
        })
        var ans = 1
        var t = pairs[0][1]
        for (i in 1 until pairs.size) {
            if (pairs[i].f(t)) continue
            ans++
            t = pairs[i][1]
        }
        return ans
    }

    fun IntArray.f(i: Int): Boolean = i in this[0]..this[1]
}

fun main() {
    println(Solution().findLongestChain(int2d("[[1,2], [2,3], [3,4]]"))) // 2
    println(Solution().findLongestChain(int2d("[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]"))) // 3
}