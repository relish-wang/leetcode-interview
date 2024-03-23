fun main() {
    println(minDistance("horse", "ros"))
    println(minDistance("intention", "execution"))
    println(minDistance("a", "a"))
    println(minDistance("a", "ab"))
    println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"))
}

/**
 * 动态规划
 * 对每个字符的操作都会被计数一次
 * 增删改
 *
 */
fun minDistance(word1: String, word2: String): Int {
    val l2 = word2.length
    if (word1.isEmpty()) {
        return l2
    }
    val l1 = word1.length
    if (word2.isEmpty()) {
        return word1.length
    }
    if (word1 == word2) {
        return 0
    }
    val dp = Array(l1 + 1) { IntArray(l2 + 1) { 0 } }//对word1的前i个字符和word2的前j个字符的最小编辑距离
    // 初始化上边界
    for (i in 0 .. l1) dp[i][0] = i
    // 初始化左边界
    for (j in 0 .. l2) dp[0][j] = j
    // 开始处理子问题
    for (row in 1..l1) {
        for (col in 1..l2) {
            dp[row][col] = if (word1[row - 1] == word2[col - 1]) {
                min(dp[row - 1][col] + 1, dp[row][col - 1] + 1, dp[row - 1][col - 1])
            } else {
                1 + min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1])
            }
        }
    }
    return dp[l1][l2]
}

fun min(a: Int, b: Int, c: Int): Int {
    return if (a > b) {
        if (b > c) c else b
    } else {
        if (a > c) c else a
    }
}