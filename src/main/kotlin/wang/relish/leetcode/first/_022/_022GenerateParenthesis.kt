package wang.relish.leetcode.first._022

fun main() {
    println(generateParenthesis(3))
    println(generateParenthesis(4))
}

/**
 * 太暴力了, 建议重写
 */
fun generateParenthesis(n: Int): List<String> {
    var ans = linkedSetOf("()")
    for (i in 1..n) {
        ans = f(i, ans)
    }
    return ans.toList()
}

fun f(n: Int, list: LinkedHashSet<String>): LinkedHashSet<String> {
    if (n == 1) {
        return linkedSetOf("()")
    }
    val result = linkedSetOf<String>()
    for (l in list) {
        for (i in l.indices) {
            result.add(l.substring(0, i + 1) + "()" + l.substring(i + 1))
        }
    }
    return result
}