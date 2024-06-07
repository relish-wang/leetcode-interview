package wang.relish.leetcode.interview._0014

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val n = strs.size
        val l = strs[0].length
        for (i in 0 until l) {
            val ch = strs[0][i]
            for (j in 0 until n) {
                if (strs[j].length <= i || strs[j][i] != ch) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}