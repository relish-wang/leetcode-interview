package wang.relish.leetcode.second._0452

import struct.int2d

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
     */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortWith(object : Comparator<IntArray> {
            override fun compare(p0: IntArray?, p1: IntArray?): Int {
                if (p0 == null || p1 == null) return 0
                return if (p0[1] > p1[1]) {
                    1
                } else if (p0[1] == p1[1]) {
                    if (p0[0] > p1[0]) {
                        1
                    } else if (p0[0] == p1[0]) {
                        0
                    } else {
                        -1
                    }
                } else {
                    -1
                }
            }
        })
        var right = points[0][1]
        var ans = 1
        for (i in 1 until points.size) {
            if(points[i].inArea(right)) continue
            ans++
            right = points[i][1]
        }
        return ans
    }

    fun IntArray.inArea(index:Int):Boolean{
        return index in this[0]..this[1]
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
    println(Solution().findMinArrowShots(int2d("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]"))) // 2 [6,6]和[9,9]
}

