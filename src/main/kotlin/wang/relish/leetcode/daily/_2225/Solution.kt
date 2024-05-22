package wang.relish.leetcode.daily._2225


class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val map = hashMapOf<Int, Int>()
        for (m in matches) {
            map.put(m[1], (map.get(m[1]) ?: 0) + 1)
            if (map[m[0]] == null) {
                map[m[0]] = 0
            }

        }
        val zeros = mutableListOf<Int>()
        val ones = mutableListOf<Int>()
        for (entry in map) {
            if (entry.value == null || entry.value == 0) {
                zeros.add(entry.key)
            } else if (entry.value == 1) {
                ones.add(entry.key)
            }
        }
        zeros.sort()
        ones.sort()
        return listOf(zeros, ones)
    }
}