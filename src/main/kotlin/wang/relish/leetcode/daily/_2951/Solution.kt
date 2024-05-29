package wang.relish.leetcode.daily._2951

class Solution {
    fun findPeaks(mountain: IntArray): List<Int> {
        var min = mountain[0]
        val ans = mutableListOf<Int>()
        var i = 1
        val l = mountain.size
        while(i<l-1) {
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                ans.add(i)
            }
            i++
        }
        return ans
    }
}