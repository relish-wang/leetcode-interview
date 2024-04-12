package wang.relish.leetcode.second._022.a

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) {
            return listOf()
        }
        val dp = mutableListOf<MutableList<String>>()
        dp.add(mutableListOf(""))
        dp.add(mutableListOf("()"))
        for (i in 2..n) {
            val l = mutableListOf<String>()
            for (j in 0 until i) {
                val l1 = dp[j]
                val l2 = dp[i - 1 - j]
                for (k1 in l1) {
                    for (k2 in l2) {
                        val el = "($k1)$k2"
                        l.add(el)
                    }
                }
            }
            dp.add(l)
        }
        return dp[n]
    }
}

/*
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        total_l = []
        total_l.append([None])    # 0组括号时记为None
        total_l.append(["()"])    # 1组括号只有一种情况
        for i in range(2,n+1):    # 开始计算i组括号时的括号组合
            l = []
            for j in range(i):    # 开始遍历 p q ，其中p+q=i-1 , j 作为索引
                now_list1 = total_l[j]    # p = j 时的括号组合情况
                now_list2 = total_l[i-1-j]    # q = (i-1) - j 时的括号组合情况
                for k1 in now_list1:
                    for k2 in now_list2:
                        if k1 == None:
                            k1 = ""
                        if k2 == None:
                            k2 = ""
                        el = "(" + k1 + ")" + k2
                        l.append(el)    # 把所有可能的情况添加到 l 中
            total_l.append(l)    # l这个list就是i组括号的所有情况，添加到total_l中，继续求解i=i+1的情况
        return total_l[n]

 */