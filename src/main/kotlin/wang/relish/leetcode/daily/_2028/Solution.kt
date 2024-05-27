package wang.relish.leetcode.daily._2028

class Solution {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val m = rolls.size
        var sum = 0
        for (r in rolls) {
            sum += r
        }
        val total = mean * (m + n)
        val sumN = total - sum
        val ave = sumN / n
        val mod = sumN % n
        if (ave > 6 || ave >= 6 && mod != 0 || ave < 1) return intArrayOf()
        val ans = IntArray(n)
        var i = 0
        while (i < mod) {
            ans[i++] = ave + 1
        }
        while (i < n) {
            ans[i++] = ave
        }
        return ans
    }
}