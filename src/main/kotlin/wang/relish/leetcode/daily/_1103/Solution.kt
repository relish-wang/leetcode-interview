package wang.relish.leetcode.daily._1103

class Solution {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        var c = candies
        var turn = 0
        val ans = IntArray(num_people) { 0 }
        while (c > 0) {
            for (i in 0 until num_people) {
                val num = num_people * turn + i + 1
                if (c > num) {
                    ans[i] += num
                    c -= num
                } else {
                    ans[i] += c
                    return ans
                }
            }
            turn++
        }
        return ans
    }
}