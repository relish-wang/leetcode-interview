package wang.relish.leetcode.daily._0520

class Solution {
    fun detectCapitalUse(word: String): Boolean {
        val n = word.length
        var cnt = 0
        for (i in 0 until n) {
            if (word[i].isUpperCase()) {
                cnt++
            }
        }
        return cnt == 0 || cnt == n || cnt == 1 && word[0].isUpperCase()
    }

    fun detectCapitalUse1(word: String): Boolean {
        return word.matches(Regex("^([A-Z]+)|([a-z]+)([A-Z][a-z]*)$"))
    }
}