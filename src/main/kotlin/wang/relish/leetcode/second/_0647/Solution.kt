package wang.relish.leetcode.second._0647

class Solution {
    /**
     * 求回文子串的数量
     * ![用时内存双百截图](https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/35493131848/1944/d4c2/b1df/c6421a6f15d4925a5c1aac042b84ec0c.png)
     */
    fun countSubstrings(s: String): Int {
        for (i in 0 until s.length) {
            expand(s, i, i)
            if (i < s.length - 1) {
                expand(s, i, i + 1)
            }
        }
        return ans
    }

    var ans = 0
    fun expand(s: String, left: Int, right: Int) {
        var l = left
        var r = right
        while (l >= 0 && l <= r && r < s.length) {
            if (s[l] == s[r]) {
                ans++
                l--
                r++
            } else {
                return
            }
        }
    }
}

fun main() {
//    println(Solution().countSubstrings("abc")) //3
    println(Solution().countSubstrings("aaa")) //6
}