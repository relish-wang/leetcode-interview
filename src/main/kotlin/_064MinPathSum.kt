import kotlin.math.min

fun main() {
    println(minPathSum(grid("[1,3,1],[1,5,1],[4,2,1]")))
    println(minPathSum(grid("[1,2,3],[4,5,6]")))
}

/**
 * 动态规划
 * 跟「64UniquePaths」很像
 */
fun minPathSum(grid: Array<IntArray>): Int {
    val n = grid.size // 行数
    val m = grid[0].size // 列数
    val dp = Array(n) { IntArray(m) { 0 } }
    dp[0][0] = grid[0][0]
    // 初始化最上面那行
    for (i in 1 until m) dp[0][i] = dp[0][i - 1] + grid[0][i]
    // 初始化最左边那列
    for (i in 1 until n) dp[i][0] = dp[i - 1][0] + grid[i][0]
    for (r in 1 until n) {
        for (c in 1 until m) {
            dp[r][c] = min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c]
        }
    }
    return dp[n - 1][m - 1]
}


/**
 * [1,3,1],[1,5,1],[4,2,1]
 */
fun grid(s: String): Array<IntArray> {
    val arr = s.substring(1, s.length - 1).split("],[")
    val n = arr.size
    return Array(n) { i ->
        arr[i].split(",").map {
            it.trim().toInt()
        }.toIntArray()
    }
}