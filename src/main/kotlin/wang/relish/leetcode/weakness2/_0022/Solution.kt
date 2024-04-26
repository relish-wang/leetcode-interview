package wang.relish.leetcode.weakness2._0022

class Solution {
    /**
     * dp解法
     * 09:21
     */
    fun generateParenthesis2(n: Int): List<String> {
        val dp = mutableListOf<MutableList<String>>()
        if (n == 0) return listOf("")
        if (n == 1) return listOf("()")
        dp.add(mutableListOf(""))
        dp.add(mutableListOf("()"))
        for (i in 2 .. n) {
            val t = mutableListOf<String>()
            for (j in 0 until i) {
                val l1 = dp[j]
                val l2 = dp[i-j-1]
                for (k1 in l1){
                    for (k2 in l2){
                        t.add("$k1($k2)")
                    }
                }
            }
            dp.add(t)
        }
        return dp[n]
    }

    /**
     * 02:03
     * 用时83.33%
     * 耗时86.70%
     */
    fun generateParenthesis(n: Int): List<String> {
        f("",n,n)
        return ans
    }
    val ans = mutableListOf<String>()
    fun f(s:String,l:Int,r:Int){
        if(l<0||l>r)return
        if(l==0&&r==0) {
            ans.add(s)
            return
        }
        f("$s(",l-1,r)
        f("$s)",l,r-1)
    }

    /**
     * 04:48
     */
    fun generateParenthesis1(n: Int): List<String> {
        if (n == 1) return listOf("()")
        var set = hashSetOf<String>()
        set.add("()")
        for (i in 1 until n) {
            set = f(set)
        }
        return set.toList()
    }

    fun f(set: Set<String>): HashSet<String> {
        val ans = hashSetOf<String>()
        for (s in set) {
            for (i in 0 until s.length) {
                ans.add(s.substring(0, i) + "()" + s.substring(i))
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().generateParenthesis(3).toTypedArray().contentToString())
}