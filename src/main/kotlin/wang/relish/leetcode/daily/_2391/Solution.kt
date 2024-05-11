package wang.relish.leetcode.daily._2391

class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        var sum = 0
        var lastG = 0
        var lastP = 0
        var lastM = 0
        for (i in garbage.indices) {
            while (garbage[i].isNotEmpty()) {
                val gb = garbage[i]
                if (gb.contains('G')) {
                    for (j in lastG until i) {
                        sum += travel[j]
                    }
                    lastG = i
                    sum += gb.count { it == 'G' }
                    garbage[i] = gb.replace("G", "")
                } else if (gb.contains('P')) {
                    for (j in lastP until i) {
                        sum += travel[j]
                    }
                    lastP = i
                    sum += gb.count { it == 'P' }
                    garbage[i] = gb.replace("P", "")
                } else if (gb.contains('M')) {
                    for (j in lastM until i) {
                        sum += travel[j]
                    }
                    lastM = i
                    sum += gb.count { it == 'M' }
                    garbage[i] = gb.replace("M", "")
                }
            }
        }
        return sum
    }
}

fun main() {
    println(Solution().garbageCollection(arrayOf("G", "P", "GP", "GG"), intArrayOf(2, 4, 3))) // 21
    println(Solution().garbageCollection(arrayOf("MMM", "PGM", "GP"), intArrayOf(3, 10))) // 37
}