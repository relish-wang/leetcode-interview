package wang.relish.leetcode.first._331

/**
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 思路: 从末尾开始, 一个数字+两个#变成一个#, 直到整个列表只剩一个#说明是正确的前序遍历
     */
    fun isValidSerialization(preorder: String): Boolean {
        val arr: ArrayList<Int?> = ArrayList(preorder.split(",").map {
            if (it == "#") {
                null
            } else {
                try {
                    it.toInt()
                } catch (e: NumberFormatException) {
                    return false
                }
            }
        })
        return isPreorder(arr)
    }

    fun isPreorder(arr: ArrayList<Int?>): Boolean {
        val n = arr.size
        if (n < 3) {
            return n == 1 && arr[0] == null
        }
        var i = n - 1
        while (i >= 0 && arr[i] == null) {
            i--
        }
        if (i >= 0 && i <= n - 3 && arr[i] != null && arr[i + 1] == null && arr[i + 2] == null) {
            arr.removeAt(i)
            arr.removeAt(i)
            return isPreorder(arr)
        } else {
            return false
        }
    }
}

fun main() {
//    println(Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")) // true
//    println(Solution().isValidSerialization("1,#")) // false
//    println(Solution().isValidSerialization("9,#,#,1")) // false
    println(Solution().isValidSerialization("1,#,#,#,#")) // false
}