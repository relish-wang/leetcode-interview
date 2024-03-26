package _011

import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
}


fun maxArea(height: IntArray): Int {
    if (height.size < 2) {
        return 0
    }
    var l = 0
    var r = height.size - 1
    var max = 0
    while (l < r) {
        val h = min(height[l], height[r])
        if (h * (r - l) > max) {
            max = h * (r - l)
        }
        if (height[l] > height[r]) {
            r--
        } else {
            l++
        }
    }
    return max
}
