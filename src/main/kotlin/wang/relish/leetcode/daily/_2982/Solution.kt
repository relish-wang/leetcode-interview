package wang.relish.leetcode.daily._2982

class Solution {
    fun maximumLength(s: String): Int {
        val groups = Array(26) { mutableListOf<Int>() }
        val n = s.length
        var cnt = 0
        for (i in 0 until n) {
            cnt++
            if (i + 1 == n || s[i] != s[i + 1]) {
                groups[s[i] - 'a'].add(cnt)
                cnt = 0
            }
        }
        var ans = 0
        for (a in groups) {
            if (a.isEmpty()) continue
            a.sortWith { o1, o2 -> o2 - o1 }
            a.add(0)
            a.add(0)
            ans = maxOf(ans, maxOf(a[0] - 2, maxOf(minOf(a[0] - 1, a[1]), maxOf(a[2]))))
        }
        return ans.takeIf { it > 0 } ?: -1
    }
}

fun main() {
    println(Solution().maximumLength("aaaa")) // 2
    println(Solution().maximumLength("abcdef")) // -1
    println(Solution().maximumLength("abcaba")) // 1
}