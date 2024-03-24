fun main() {
    var nums = intArrayOf(2, 0, 2, 1, 1, 0)
    sortColors(nums)
    println(nums.contentToString())
}

/**
 * 双指针
 * 一共就三种数字012, 用两个指针用来交换其中两个数字, 另一个数字自然就排序好了
 * 比较容易理解的是0和1的指针, 都从左向右, p0++的时候p1也需要++(还有一种是02的双指针, 从两边向中间)
 */
fun sortColors2(nums: IntArray): Unit {
    val n = nums.size
    var p0 = 0
    var p1 = 0
    for (i in 0 until n) {
        if (nums[i] == 0) {
            val t = nums[p0]
            nums[p0] = nums[i]
            nums[i] = t
            if (nums[i] == 1) {
                val k = nums[p1]
                nums[p1] = nums[i]
                nums[i] = k
            }
            p0++
            p1++
        } else if (nums[i] == 1) {
            val t = nums[p1]
            nums[p1] = nums[i]
            nums[i] = t
            p1++
        }
    }
}

/**
 * 计数
 * 用时: 77.78%
 * 内存: 61.11%
 */
fun sortColors(nums: IntArray): Unit {
    var c0 = 0
    var c1 = 0
    for (num in nums) {
        when (num) {
            0 -> c0++
            1 -> c1++
            else -> {}
        }
    }
    var i = 0
    while (i < c0) nums[i++] = 0
    while (i < c0 + c1) nums[i++] = 1
    while (i < nums.size) nums[i++] = 2
}


/**
 * 无情的API选手
 */
fun sortColors1(nums: IntArray): Unit {
    nums.sort()
}