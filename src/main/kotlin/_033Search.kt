fun main() {
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    println(search(intArrayOf(1), 0))
}

fun search(nums: IntArray, target: Int): Int {
    return f(nums, target, 0, nums.size - 1)
}

fun f(a: IntArray, t: Int, left: Int, right: Int): Int {
    var l = left
    var r = right
    if (a[l] == t) {
        return l
    }
    if (a[r] == t) {
        return r
    }
    if (r - l <= 1) {
        return -1
    }
    val h = (r - l) / 2

    val r1 = f(a, t, l + h, r)
    val r2 = f(a, t, l, r - h)
    if (r1 >= 0) {
        return r1
    }
    if (r2 >= 0) {
        return r2
    }
    return -1
}