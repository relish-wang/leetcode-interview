package wang.relish.leetcode.second._003.a

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n == 0) return 0
        val map = hashMapOf<Char, Int>()
        var max = 1
        var i = 0
        var start = 0
        while (i < n) {
            if (map.containsKey(s[i])) {
                val l = i - start
                if (l > max) {
                    max = l
                }
                val index = map[s[i]]!! + 1
                for (j in start until index) {
                    map.remove(s[j])
                }
                start = index
            }
            map[s[i]] = i
            i++
        }
        max = max(max, i - start)
        return max
    }
}

fun main() {
//    println(Solution().lengthOfLongestSubstring("abcabcbb"))//3
//    println(Solution().lengthOfLongestSubstring("bbbbb"))//1
//    println(Solution().lengthOfLongestSubstring("pwwkew"))//3
    println(Solution().lengthOfLongestSubstring("au"))//2
}