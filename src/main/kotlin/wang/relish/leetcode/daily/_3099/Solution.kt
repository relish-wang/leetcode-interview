package wang.relish.leetcode.daily._3099

class Solution {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        val n = x.toString()
        var sum = 0
        for(i in 0 until n.length) {
            sum += n[i].code - '0'.code
        }
        return if(x % sum == 0) sum else -1
    }
}