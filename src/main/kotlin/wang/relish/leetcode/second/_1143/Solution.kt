package wang.relish.leetcode.second._1143


/**
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
class Solution {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        return 0
    }
}

fun main() {
    println(Solution().longestCommonSubsequence("abcde", "ace")) // 3 ace
    println(Solution().longestCommonSubsequence("abc", "abc")) // 3
    println(Solution().longestCommonSubsequence("abc", "def")) // 0
}