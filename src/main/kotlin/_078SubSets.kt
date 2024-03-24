fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
}

/**
 * 看了题目提示(位运算), 我想到了二进制。比如[1,2,3], 那么它的所有子数组共有2^(nums.length) = 8种。那么每一种的组合方式可以用二进制表示。比如010就表示, 只有取下标为2的元素=>[2]。需要注意010只会被表示为10。所以我是用倒序添加, 再反序的。可能不反序也能AC。可以试一下。
 *
 * 看完题解:
 * 1 位运算可以替换pow方法(1<<nums.size), 以及判断某一位是否是1(用来表示选中): (i>>j) & 1 == 1
 * 2 还有一种思路是回溯dfs, 满二叉状态树, 左子树是选择;右子树不选
 */
fun subsets(nums: IntArray): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    val n = nums.size
    val pow = Math.pow(2.0, n.toDouble()).toInt()
    for (i in 0 until pow) {
        val b = i.toString(2)
        val l = mutableListOf<Int>()
        var j = b.length - 1
        var x = n - 1
        while (j >= 0) {
            if (b[j] == '1') {
                l.add(nums[x])
            }
            j--
            x--
        }
        ans.add(l.reversed())
    }
    return ans
}

fun List<List<Int>>.toStr() {
    Array(this.size) { r -> IntArray(this[r].size) { this[r][it] } }.toStr()
}