package wang.relish.leetcode.first._646

import struct.int2d

/**
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 * @see _482.Solution
 */
class Solution {
    /**
     * TODO 用动态规划也可以做
     */
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith { o1, o2 ->
            if (o1!![1] == o2!![1]) {
                if (o1[1] - o1[0] < o2[1] - o2[0]) {
                    -1
                } else if (o1[1] - o1[0] > o2[1] - o2[0]) {
                    1
                } else {
                    0
                }
            } else if (o1[1] > o2[1]) {
                1
            } else {
                -1
            }
        }
        var ans = 1
        var end = pairs[0][1]
        for (p in pairs) {
            if (p[0] > end) {
                end = p[1]
                ans++
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().findLongestChain(int2d("[[1,2], [2,3], [3,4]]"))) // 2
    println(Solution().findLongestChain(int2d("[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]"))) // 3
}