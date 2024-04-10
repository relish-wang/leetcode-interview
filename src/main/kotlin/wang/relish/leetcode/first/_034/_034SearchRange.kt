package wang.relish.leetcode.first._034

fun main() {
//    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
//    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
//    println(searchRange(intArrayOf(1, 4), 4).contentToString())
//    println(searchRange(intArrayOf(1, 5), 4).contentToString())
    println(searchRange(intArrayOf(2, 2), 2).contentToString())
}

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        if (nums.size == 1) {
            if (nums[0] == target) {
                return intArrayOf(0, 0)
            } else {
                return intArrayOf(-1, -1)
            }
        }
        return find(nums, target, 0, nums.size - 1)
    }

    fun find(a: IntArray, t: Int, l: Int, r: Int): IntArray {
        if (a[l] > t || a[r] < t) {
            return intArrayOf(-1, -1)
        }
        if (l == r) {
            return if (a[l] == t) {
                intArrayOf(l, l)
            } else {
                intArrayOf(-1, -1)
            }
        } else if (l + 1 == r) {
            if (a[l] != t && a[r] != t) {
                return intArrayOf(-1, -1)
            } else if (a[l] == t && a[r] == t) {
                return intArrayOf(l, r)
            } else if (a[r] == t) {
                return intArrayOf(r, r)
            } else {
                return intArrayOf(l, l)
            }
        }
        return if (a[l] == t) {
            f(a, t, l)
        } else if (a[l] < t) {
            if (a[r] == t) {
                f(a, t, r)
            } else if (a[r] > t) {
                find(a, t, l + Math.min((r - l) / 2, 1), r)
            } else {
                intArrayOf(-1, -1)
            }
        } else {
            intArrayOf(-1, -1)
        }
    }

    fun f(a: IntArray, t: Int, i: Int): IntArray {
        var left = i
        while (left >= 0 && a[left] == t) {
            left--
        }
        var right = i
        while (right < a.size && a[right] == t) {
            right++
        }
        return intArrayOf(left + 1, right - 1)
    }