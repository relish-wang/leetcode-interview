package wang.relish.leetcode.daily._2960

class Solution {
    fun countTestedDevices(batteryPercentages: IntArray): Int {
        val n = batteryPercentages.size
        var x = 0
        for(i in 0 until n) {
            val item = batteryPercentages[i]
            if(item-x>0){
                x++
            }
        }
        return x
    }
}