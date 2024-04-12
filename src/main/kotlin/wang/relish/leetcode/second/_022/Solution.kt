package wang.relish.leetcode.second._022

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var ans = mutableListOf("()")
        if (n == 1) {
            return ans
        }
        for (i in 2..n) {
            ans = g(ans)
        }
        return ans
    }

    fun g(list: List<String>): MutableList<String> {
        val set = hashSetOf<String>()
        for (s in list) {
            for (i in s.indices) {
                set.add(s.substring(0, i) + "()" + s.substring(i))
            }
        }
        return ArrayList(set)
    }
}

fun main() {
    println(Solution().generateParenthesis(3).toTypedArray().contentToString())
}