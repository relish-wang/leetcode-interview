fun main() {
    println(numTrees(2))
}

/**
 * 动态规划 笛卡尔积
 * ![](https://leetcode.cn/problems/unique-binary-search-trees/solutions/329807/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM)
 * 以[1,2,3,4,5]为例子
 * 以3为根节点的二叉搜索树的数量为它左子树的数量x它右子树的数量
 *
 * G(n): n 个节点存在二叉排序树的个数
 * f(i): 以 i 为根的二叉搜索树的个数
 *
 * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 *
 * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i 个，则
 *
 * f(i)=G(i−1)∗G(n−i)
 *
 * G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
 */
fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1) { if (it <= 1) 1 else 0 }
    for (i in 2..n) {
        for (j in 1..i) {
            dp[i] += dp[j - 1] * dp[i - j]
        }
    }
    return dp[n]
}