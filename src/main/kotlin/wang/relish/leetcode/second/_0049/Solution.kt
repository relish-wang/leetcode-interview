package wang.relish.leetcode.second._0049

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return ArrayList(strs.groupBy { it.toCharArray().sortedArray().contentToString() }.values)
    }
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(Solution().groupAnagrams(strs).toTypedArray().contentToString())

}