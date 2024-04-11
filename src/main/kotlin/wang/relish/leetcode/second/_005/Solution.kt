package wang.relish.leetcode.second._005

import kotlin.math.max

class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length
        var max = 1
        var ans: String = s.substring(0, 1)
        for (i in 0 until n-1) {
            val l1 = expand(s, i, i)
            val l2 = expand(s, i, i + 1)
            val l = max(l1, l2)
            if (l <= max) continue
            max = l
            ans = if (l1 > l2) {
                val b = (l1 - 1) / 2
                s.substring(i - b, i + b + 1)
            } else {
                val b = l2 / 2
                s.substring(i - b + 1, i + b + 1)
            }
        }
        return ans
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
//    println(Solution().longestPalindrome("babad"))
//    println(Solution().longestPalindrome("cbbd"))
    println(Solution().longestPalindrome("bb"))
}