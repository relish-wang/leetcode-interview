package wang.relish.leetcode.daily._2981

class Solution {
    fun maximumLength(s: String): Int {
        val map = hashMapOf<String, Int>()
        val len = s.length
        var max = -1
        for (i in 0 until len) {
            val sp = s[i]
            var p = i
            while (p < len && s[p] == sp) {
                val subs = s.substring(i, p + 1)
                val c = map[subs] ?: 0
                map[subs] = c + 1
                if (c + 1 >= 3 && p - i + 1 > max) {
                    max = p - i + 1
                }
                p++
            }
        }
        return max
    }
}

fun main() {
    println(Solution().maximumLength("aaaa")) // 2
    println(Solution().maximumLength("abcdef")) // -1
    println(Solution().maximumLength("abcaba")) // 1
}