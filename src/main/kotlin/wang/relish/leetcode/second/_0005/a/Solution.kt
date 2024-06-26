package wang.relish.leetcode.second._0005.a

import kotlin.math.max

class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length
        var max = 1
        var maxStr = s.substring(0, 1)
        for (i in 0 until n - 1) {
            val l1 = expand(s, i, i)
            val l2 = expand(s, i, i + 1)
            val l = max(l1, l2)
            if (l > max) {
                max = l
                val start = i - (l - 1) / 2
                maxStr = s.substring(start, start + l)
            }
        }
        return maxStr
    }

    fun expand(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        if (s[l] != s[r]) {
            return r - l
        }
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}

fun main() {
    println(Solution().longestPalindrome("babad")) // aba
}