package wang.relish.leetcode.second._003

import kotlin.math.max
import kotlin.math.min

class Solution {
    /**
     * 滑动窗口
     * 用上set就够了左指针右移删一个set.remove(s[l])
     * 用上set就够了右指针右移加一个set.add(s[r])
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        if (n == 0) {
            return 0
        }
        var max = 1
        var l = 0
        var r = 1
        val map = linkedMapOf<Char, Int>()
        map[s[0]] = 0
        while (r in l..<n) {
            while (r < n && map.contains(s[r]).not()) {
                map[s[r]] = r
                r++
            }
            max = max(r - l, max)
            val end = min(map[s[min(r, n - 1)]]!! + 1, n - 1)
            for (i in l until end) {
                map.remove(s[i])
            }
            l = end
        }
        return max
    }
}

fun main() {
    println(Solution().lengthOfLongestSubstring("abcabcbb")) //3
    println(Solution().lengthOfLongestSubstring("dvdf")) // 3
    println(Solution().lengthOfLongestSubstring("pwwkew")) // 3
    println(Solution().lengthOfLongestSubstring("bbbbb")) // 1
}