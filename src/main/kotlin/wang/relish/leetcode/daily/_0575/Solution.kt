package wang.relish.leetcode.daily._0575

class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        val set = hashSetOf<Int>()
        val n = candyType.size
        for (t in candyType) {
            set.add(t)
            if (set.size >= n / 2) {
                return n / 2
            }
        }
        return set.size
    }
}