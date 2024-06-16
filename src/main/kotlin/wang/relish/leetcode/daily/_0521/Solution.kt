package wang.relish.leetcode.daily._0521

class Solution {
    fun findLUSlength(a: String, b: String): Int {
        val l1 = a.length
        val l2 = b.length
        return if (l1 == l2) {
            if (a.equals(b)) {
                -1
            } else {
                l1
            }
        } else {
            max(l1, l2)
        }
    }
}