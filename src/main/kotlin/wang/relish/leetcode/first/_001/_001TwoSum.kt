package wang.relish.leetcode.first._001

fun twoSum(nums: IntArray, target: Int): IntArray {
    val size = nums.size
    for (i in 0 until size - 1) {
        for (j in i + 1 until size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(-1, -1)
}