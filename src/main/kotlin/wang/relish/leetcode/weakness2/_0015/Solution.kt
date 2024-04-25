package wang.relish.leetcode.weakness2._0015


class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until n - 2) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1 until n - 1) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue
                val k = findK(nums, j + 1, n - 1, -nums[i] - nums[j])
                if (k in j + 1 until n) {
                    ans.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return ans
    }

    fun findK(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (left > right) return -1
        if (nums[left] == target) return left
        if (nums[right] == target) return right
        val mid = left + ((right - left) shr 1)
        return if (nums[mid] > target) {
            findK(nums, left + 1, mid - 1, target)
        } else if (nums[mid] < target) {
            findK(nums, mid + 1, right - 1, target)
        } else {
            mid
        }
    }

    fun threeSum1(nums: IntArray): List<List<Int>> {
        val n = nums.size
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until n - 2) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1 until n - 1) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue
                var k = n - 1
                while (k > j && nums[k] > -nums[i] - nums[j]) k--
                if (k > j && nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))) // [[-1,-1,2],[-1,0,1]]
    println(Solution().threeSum(intArrayOf(0, 0, 0))) // [[0,0,0]]
    println(
        Solution().threeSum(
            intArrayOf(
                -1,
                0,
                1,
                2,
                -1,
                -4,
                -2,
                -3,
                3,
                0,
                4
            )
        )
    ) // [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
}