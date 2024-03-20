fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(0, 0, 0)))
}


/**
 * 还可以用双指针(左指针初始位置在i+1, 右指针在n-1, 向中间靠拢(左指针右移, 右指针左移)), 速度会更快
 */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val r = mutableListOf<List<Int>>()
        nums.sort() // 先排序
        for (i in nums.indices) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1 until nums.size) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue
                var k = nums.size - 1
                while (k > j && nums[i] + nums[j] + nums[k] > 0) {
                    k--
                }
                if (j >= k) break
                if (nums[i] + nums[j] + nums[k] == 0) {
                    r.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return r
    }