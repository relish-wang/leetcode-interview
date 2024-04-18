package wang.relish.leetcode.second._049

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val n = strs.size
        if (n == 0) return mutableListOf<MutableList<String>>()
        strs.sortWith(object : Comparator<String> {
            override fun compare(o1: String?, o2: String?): Int {
                if (o1 == null || o2 == null) return 0
                val l1 = o1.length
                val l2 = o2.length
                return if (l1 > l2) {
                    1
                } else if (l1 == l2) {
                    o1.compareTo(o2)
                } else {
                    -1
                }
            }
        })
        val set = hashSetOf<String>()
        val map = hashMapOf<String, List<String>>()
        set.add(strs[0])
        map[strs[0]] = mutableListOf(strs[0])
        for (i in 1 until n ) {
            var solve = false
            for (e in set) {
                if (isYWC(e, strs[i])) {
                    map[e] = map[e]!!.let { ArrayList(it).apply { add(strs[i]) } }
                    solve = true
                    break
                }
            }
            if (solve.not()) {
                map[strs[i]] = mutableListOf(strs[i])
                set.add(strs[i])
            }
        }
        return ArrayList(map.values)
    }

    fun isYWC(s1: String, s2: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length
        if (l1 != l2) return false
        val map = hashMapOf<Char, Int>()
        for (c in s1) {
            if (map.containsKey(c)) {
                map[c] = map[c]!! + 1
            } else {
                map[c] = 1
            }
        }
        val map2 = hashMapOf<Char, Int>()
        for (c in s2) {
            if (map2.containsKey(c)) {
                map2[c] = map2[c]!! + 1
            } else {
                map2[c] = 1
            }
        }
        if (map.size != map2.size) {
            return false
        }
        for (key in map.keys) {
            if (map2.containsKey(key).not()) {
                return false
            }
            if (map2[key] != map[key]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(Solution().groupAnagrams(strs).toTypedArray().contentToString())

}