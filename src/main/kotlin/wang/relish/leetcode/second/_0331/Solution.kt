package wang.relish.leetcode.second._0331

/**
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {

    /**
     * 计数法(不用split)
     * 03:21
     */
    fun isValidSerialization(preorder: String): Boolean {
        if (preorder == "#") return true
        val n = preorder.length
        var i = 0
        var c = 1
        while (i < n && c > 0) {
            if (preorder[i] == ',') {
                i++
                continue
            }
            if (preorder[i] == '#') {
                c--
                i++
                continue
            }
            while (i < n && preorder[i] != ',') i++
            if (i == n) return false
            c++
            i++
        }
        return c == 0 && i == n
    }

    /**
     * 计数法
     * 2:09
     */
    fun isValidSerialization2(preorder: String): Boolean {
        if (preorder == "#") return true
        val arr = preorder.split(",")
        val n = arr.size
        var c = 1
        var i = 0
        while (i < n && c > 0) {
            if (arr[i++] == "#") {
                c--
            } else {
                c++
            }
        }
        return i == n && c == 0
    }

    fun isValidSerialization1(preorder: String): Boolean {
        if (preorder == "#") return true
        val arr = ArrayList(preorder.split(","))
        while (arr.size > 1) {
            val n = arr.size
            if (n >= 3) {
                var i = n - 1
                while (i >= 0 && arr[i] == "#") {
                    i--
                }
                if (i < 0) return false
                if (arr[i] != "#" && i <= n - 3) {
                    arr[i] = "#"
                    arr.removeAt(i)
                    arr.removeAt(i)
                } else {
                    return false
                }
            } else {
                return false
            }
        }
        return arr.size == 1 && arr[0] == "#"
    }
}

fun main() {
    println(Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")) // true
    println(Solution().isValidSerialization("1,#")) // false
    println(Solution().isValidSerialization("9,#,#,1")) // false
    println(Solution().isValidSerialization("1,#,#,#,#")) // false
}