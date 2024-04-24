package wang.relish.leetcode.second._0022.b

class Solution {

    val res = mutableListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        dfs(n, 0, 0, "")
        return res
    }

    fun dfs(n: Int, left: Int, right: Int, curStr: String) {
        if (left == n && right == n) {
            res.add(curStr)
            return
        }
        if (left > right) {
            if (left < n) {
                dfs(n, left + 1, right, "$curStr(")
            }
            dfs(n, left, right + 1, "$curStr)")
        } else if (left == right) {
            dfs(n, left + 1, right, "$curStr(")
        }
    }
}

fun main() {
    println(Solution().generateParenthesis(3))
}