package _482

import int2d
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/?envType=featured-list&envId=Fw9n57OM?envType=featured-list&envId=Fw9n57OM
 */
class Solution {
    /**
     * 先把题目看明白
     * [[10,16],[2,8],[1,6],[7,12]]
     * [10,16] 表示的是一个球心在x=13位置, 直径为6的球形气球。
     * 弓箭只要射在直径范围内就算破, 包含边界
     * 这是例1给的解答
     * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
     * -在x = 10处发射箭，击破气球[10,16]和[7,12]。
     *
     * 贪心。
     */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        Arrays.sort(points) { o1, o2 ->
            if (o1!![1] > o2!![1]) {
                1
            } else if (o1[1] == o2[1]) {
                0
            } else {
                -1
            }
        }
        var ans = 1
        var pos = points[0][1]
        for (p in points) {
            if (p[0] > pos) {
                ans++
                pos = p[1]
            }
        }
        return ans
    }
}

fun main() {
    /*
    -在x = 6处射出箭，击破气球[2,8]和[1,6]。
    -在x = 11处发射箭，击破气球[10,16]和[7,12]。
     */
    println(Solution().findMinArrowShots(int2d("[[10,16],[2,8],[1,6],[7,12]]"))) // 2
    println(Solution().findMinArrowShots(int2d("[[1,2],[3,4],[5,6],[7,8]]"))) // 4
    println(Solution().findMinArrowShots(int2d("[[1,2],[2,3],[3,4],[4,5]]"))) // 2
    println(Solution().findMinArrowShots(int2d("[[-2147483646,-2147483645],[2147483646,2147483647]]"))) // 2
    // 6     9      6    6     9      6     6     6     6      6
    println(Solution().findMinArrowShots(int2d("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]"))) // 2 [6,6]和[9,9]

    // [[0 1 [[2 [[[3 4 5 [6] [7 8]]] [9]]]] 10] 11 12]
}

