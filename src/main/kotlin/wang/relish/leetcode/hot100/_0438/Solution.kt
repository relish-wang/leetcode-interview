package wang.relish.leetcode.hot100._0438

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans = mutableListOf<Int>()
        val pChar = IntArray(26)
        for (c in p) {
            pChar[c - 'a']++
        }
        val sChar = IntArray(26)
        var l = 0
        var r = 0
        val pLen = p.length
        val sLen = s.length
        while (r < sLen) {
            while (r < sLen && r - l < pLen) {
                sChar[s[r++] - 'a']++
            }
            if (sChar.contentEquals(pChar)) {
                ans.add(l)
            }
            sChar[s[l++] - 'a']--
            if (r == sLen - 1 && r - l + 1 < pLen) {
                break
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().findAnagrams("cbaebabacd", "abc")) // [0,6]
    println(Solution().findAnagrams("abab", "ab")) // [0,1,2]
}