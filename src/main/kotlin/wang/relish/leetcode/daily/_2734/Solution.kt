package wang.relish.leetcode.daily._2734

class Solution {
    fun smallestString(s: String): String {
        val n = s.length
        var start = -1
        var end = -1
        for(i in 0 until n) {
            if(s[i] in 'b'..'z') {
                if(start == -1) {
                    start = i
                }
                end = i
            } else {
                if(start == -1) {
                    continue
                } else {
                    break
                }
            }
        }
        if(start == -1) {
            return s.substring(0, n - 1) + 'z'
        }
        return s.substring(0, start)+replace(s.substring(start, end + 1)) + s.substring(end+1)
    }

    fun replace(s: String): String {
        val sb = StringBuffer()
        for(i in 0 until s.length) {
            sb.append((s[i].code - 1).toChar())
        }
        return sb.toString()
    }
}