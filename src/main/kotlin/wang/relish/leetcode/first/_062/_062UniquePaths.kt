package wang.relish.leetcode.first._062

fun main() {
    println(uniquePaths(3, 2))
    println(uniquePaths(3, 7))
}

/**
 * 动态规划
 * 解决从(0,0)到(m,n)的路径条数。对该问题进行分解:
 * 到达(m,n)前有两个节点(m-1,n)和(m,n-1), 而这两个节点到达(m,n)分别只有一条。那么:
 * 状态转义方程: dp[m][n] = dp[m-1][n]+dp[m][n-1]
 * 最小解就是dp[0][0]=1, dp[0][1]=1, dp[1][0]=1,由此可以推断出dp[1][1]=2...
 * @param m 列数
 * @param n 行数
 */
fun uniquePaths(m: Int, n: Int): Int {
    if (m == 0 || n == 0) {
        return 0
    }
    if (m == 1 || n == 1) {
        return 1
    }
    val dp = Array(n) { ni -> IntArray(m) { mi -> if (ni == 0 || mi == 0) 1 else 0 } }
    for (r in 1 until n) {
        for (c in 1 until m) {
            dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
        }
    }
    return dp[n - 1][m - 1]
}