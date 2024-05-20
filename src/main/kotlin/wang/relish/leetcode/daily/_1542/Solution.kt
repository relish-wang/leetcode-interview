package wang.relish.leetcode.daily._1542

class Solution {
    fun longestAwesome(s: String): Int {
        val n = s.length
        var ans = 0
        var pre = 0
        val pos = IntArray(1 shl 10) { n } // 2^10 = 1024
        pos[0] = -1
        for (i in 0 until n) {
            pre = pre xor (1 shl (s[i] - '0')) // 用历史记录数字出现了奇偶次数。比如仅有3出现了5次(其余数字0次), 则pre = 0000001000(二进制)
            for (d in 0 until 10) {
                ans = Math.max(ans, i - pos[pre xor (1 shl d)]) // 奇数
            }
            ans = Math.max(ans, i - pos[pre]) // 偶数
            if (pos[pre] == n) { // 首次遇到值为 pre 的前缀异或和，记录其下标 i
                pos[pre] = i
//                println("pre = $pre, i = $i")
            }
            println("pos: ${pos.mapIndexed { index, p -> (index.toString(2) to p).takeIf { p != n } }.filterNotNull()}")
        }
        return ans
    }
}

fun main() {
    println(Solution().longestAwesome("3242415")) // 5 "24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
//    println(Solution().longestAwesome("12345678")) // 1
//    println(Solution().longestAwesome("213123")) // 6 "231132"
}