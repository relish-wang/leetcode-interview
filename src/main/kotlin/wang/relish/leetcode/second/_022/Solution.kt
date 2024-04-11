package wang.relish.leetcode.second._022

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 1) {
            return listOf("()")
        }
        var list: List<String> = listOf("()")
        for (i in 2..n) {
            list = g(n, list)
        }
        return list
    }

    fun g(n: Int, list: List<String>): List<String> {
        if (n == 1) {
            return listOf("()")
        }
        val ans = hashSetOf<String>()
        for (s in list) {
            for (i in s.indices) {
                ans.add(s.substring(0, i) + "()" + s.substring(i))
            }
        }
        return ArrayList(ans)
    }
}

fun main() {
    println(Solution().generateParenthesis(3).toTypedArray().contentToString())
}