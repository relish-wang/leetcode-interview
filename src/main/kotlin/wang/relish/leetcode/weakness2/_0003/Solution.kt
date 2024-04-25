package wang.relish.leetcode.weakness2._0003

import kotlin.math.max

class Solution {
    /**
     * 这个代码更简洁
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n <= 1) return n
        val map = hashMapOf<Char, Int>()
        var left = 0
        var ans = 0
        for (right in 0 until n) {
            val index = map[s[right]] ?: -1
            if (index != -1) {
                left = max(left, index + 1)
            }
            map[s[right]] = right
            ans = max(ans, right - left + 1)
        }
        return ans
    }

    /**
     * 还是我这个效率高
     */
    fun lengthOfLongestSubstring1(s: String): Int {
        val n = s.length
        if (n <= 1) return n
        val map = hashMapOf<Char, Int>()
        var left = 0
        var right = 0
        var max = 1
        while (right in left..<n) {
            val index = map[s[right]] ?: -1
            if (index >= 0) {
                var j = left
                while (j <= index) map.remove(s[j++])
                left = index + 1
            } else {
                max = max(max, right - left + 1)
            }
            map[s[right]] = right
            right++
        }
        return max
    }
}

fun main() {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))//3
    println(Solution().lengthOfLongestSubstring("pwwkew"))//3
    println(Solution().lengthOfLongestSubstring("au"))//2
    println(Solution().lengthOfLongestSubstring("abba"))//2
    println(Solution().lengthOfLongestSubstring("tmmzuxt"))//5
}