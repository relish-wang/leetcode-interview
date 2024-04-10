package wang.relish.leetcode.first._647

class Solution {
    /**
     * 求回文子串的数量
     */
    fun countSubstrings(s: String): Int {
        val n = s.length
        var ans = n
        for (i in 0 until n) {
            ans += f(s, i)
        }
        return ans
    }

    fun f(s: String, index: Int): Int {
        // 偶数长度回文子串(eg: abbc中的bb)
        var ans = 0
        var l = index - 1
        var r = index
        while (l >= 0 && r < s.length) {
            if (s[l] == s[r]) {
                ans++
                l--
                r++
                continue
            }
            break
        }
        // 奇数长度回文子串(eg: abxbc中的bxb)
        l = index - 1
        r = index + 1
        while (l >= 0 && r < s.length) {
            if (s[l] == s[r]) {
                ans++
                l--
                r++
                continue
            }
            break
        }
        return ans
    }
}

fun main() {
    println(Solution().countSubstrings("abbc")) //3
}