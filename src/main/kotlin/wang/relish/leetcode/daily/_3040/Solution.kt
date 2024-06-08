package wang.relish.leetcode.daily._3040;

import kotlin.math.max

class Solution {
    fun maxOperations(nums: IntArray): Int {
        val n = nums.size
        if (n < 2) return 0
        val ff = nums[0] + nums[1]
        val tt = nums[n - 1] + nums[n - 2]
        val ft = nums[0] + nums[n - 1]
        val res1 = helper(nums, 2, n - 1, ff)
        val res2 = helper(nums, 0, n - 3, tt)
        val res3 = helper(nums, 1, n - 2, ft)
        return max(max(res1, res2), res3) + 1
    }

    fun helper(nums: IntArray, start: Int, end: Int, target: Int): Int {
        val n = nums.size
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (i in end - 1 downTo start) {
            for (j in i + 1..end) {
                if (nums[i] + nums[i + 1] == target) {
                    dp[i][j + 1] = max(dp[i][j + 1], dp[i + 2][j + 1] + 1)
                }
                if (nums[j - 1] + nums[j] == target) {
                    dp[i][j + 1] = max(dp[i][j + 1], dp[i][j - 1] + 1)
                }
                if (nums[i] + nums[j] == target) {
                    dp[i][j + 1] = max(dp[i][j + 1], dp[i + 1][j] + 1)
                }
            }
        }
        return dp[start][end + 1]
    }
}

fun main() {
//    println(Solution().maxOperations(intArrayOf(3, 2, 1, 2, 3, 4))) // 3
//    println(Solution().maxOperations(intArrayOf(3, 2, 6, 1, 4))) // 2
    println(
        Solution().maxOperations(
            intArrayOf(
                298,
                258,
                242,
                18,
                538,
                363,
                193,
                535,
                21,
                357,
                473,
                470,
                227,
                465,
                91,
                374,
                182,
                457,
                99,
                414,
                448,
                422,
                134,
                218,
                338,
                473,
                83,
                23,
                533,
                150,
                304,
                252,
                479,
                77,
                273,
                283,
                196,
                525,
                31,
                99,
                457,
                398,
                158,
                357,
                199,
                256,
                300,
                402,
                154,
                326,
                230,
                15,
                364,
                313,
                458,
                500,
                56,
                522,
                34,
                98,
                492,
                490,
                66,
                392,
                431,
                479,
                77,
                88,
                263,
                293,
                354,
                202,
                338,
                456,
                100,
                254,
                490,
                107,
                449,
                309,
                247,
                896,
                976,
                320,
                471,
                436,
                411,
                267,
                614,
                576,
                233,
                669,
                243,
                444,
                112,
                533,
                23,
                496,
                60,
                66,
                302,
                420,
                136,
                524,
                32,
                251,
                305,
                215,
                341,
                280,
                276,
                218,
                468,
                429,
                127,
                125,
                164,
                64,
                464,
                92,
                458,
                98,
                243,
                192,
                541,
                86,
                470,
                450,
                106,
                132,
                424,
                541,
                15,
                41,
                515,
                494,
                62,
                538,
                18,
                132,
                424,
                109,
                447,
                406,
                150,
                360,
                484,
                72,
                83,
                473,
                541,
                15,
                297,
                259,
                232,
                324,
                406,
                395,
                161,
                453,
                103,
                280,
                276,
                55,
                501,
                108,
                142,
                374,
                182,
                295,
                261,
                329,
                377,
                179,
                263,
                293,
                86,
                83,
                219,
                337,
                42,
                514,
                199,
                347,
                209,
                314,
                38,
                518
            )
        )
    ) // 88
}