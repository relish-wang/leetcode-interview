package wang.relish.leetcode.daily._2710

class Solution {
    fun removeTrailingZeros(num: String): String {
        for(i in num.length - 1 downTo 0 ) {
            if(num[i] != '0') {
                return num.substring(0, i + 1)
            }
        }
        return "0"
    }
}