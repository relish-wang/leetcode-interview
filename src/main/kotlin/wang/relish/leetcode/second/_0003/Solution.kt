package wang.relish.leetcode.second._0003

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n <= 1) {
            return n
        }
        var l = 0
        var r = 1
        var max = 1
        val map = hashMapOf<Char, Int>()
        map[s[0]] = 0
        while (l <= r && r < n) {
            if (map.contains(s[r])) {
                max = max(r - l, max)
                val index = map[s[r]]!!
                for (i in l..index) {
                    map.remove(s[i])
                }
                l = index + 1
            }
            map[s[r]] = r
            r++
        }
        max = max(r - l, max)
        return max
    }
}

fun main() {
//    println(Solution().lengthOfLongestSubstring("abcabcbb"))//3
//    println(Solution().lengthOfLongestSubstring("pwwkew"))//3
    println(Solution().lengthOfLongestSubstring("au"))//2
}