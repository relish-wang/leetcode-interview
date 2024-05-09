package wang.relish.leetcode.daily._2079

class Solution {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var cur = capacity
        var step = 0
        var i = 0
        val n = plants.size
        while (i < n) {
            if (plants[i] <= cur) {
                step++
                cur -= plants[i]
                i++
            } else {
                step += i shl 1
                cur = capacity
            }
        }
        return step
    }
}

fun main() {
    println(Solution().wateringPlants(intArrayOf(2, 2, 3, 3), 5))//14
    println(Solution().wateringPlants(intArrayOf(1, 1, 1, 4, 2, 3), 4))//30
}