package wang.relish.leetcode.daily._3040

import kotlin.math.max

class Solution2 {
    fun maxOperations(nums: IntArray): Int {
        val n = nums.size
        println("n = $n")
        if (n < 2) return 0
        val ff = nums[0] + nums[1]
        val tt = nums[n - 1] + nums[n - 2]
        val ft = nums[0] + nums[n - 1]
        if (ff == tt) {
            return max(dfs(nums, 2, n - 1, ff, 1, true), dfs(nums, 1, n - 2, ft, 1))
        }
        if (ff == ft) {
            return max(dfs(nums, 2, n - 1, ff, 1, true), dfs(nums, 0, n - 3, tt, 1))
        }
        if (tt == ft) {
            return max(dfs(nums, 2, n - 1, ff, 1, true), dfs(nums, 0, n - 3, tt, 1))
        }
        val sff = dfs(nums, 2, n - 1, ff, 1, true)
        val stt = dfs(nums, 0, n - 3, tt, 1)
        val sft = dfs(nums, 1, n - 2, ft, 1)
        return max(max(sff, stt), sft)
    }

    @JvmOverloads
    fun dfs(nums: IntArray, l: Int, r: Int, sum: Int, count: Int, needPrint: Boolean = false): Int {
        if (l > r || r !in nums.indices && l !in nums.indices) return count
        // 1 头两个
        val f1 = nums[l]
        val f2 = nums[l + 1]
        if (f1 + f2 == sum) {
            if (needPrint) {
                println("$f1($l) + $f2(${l + 1}) = $sum")
            }
            return dfs(nums, l + 2, r, sum, count + 1, needPrint)
        }
        // 2 尾两个
        val t1 = nums[r]
        val t2 = nums[r - 1]
        if (t1 + t2 == sum) {
            if (needPrint) {
                println("$t1($r) + $t2(${r - 1}) = $sum")
            }
            return dfs(nums, l, r - 2, sum, count + 1, needPrint)
        }
        // 3 头+尾
        if (f1 + t1 == sum) {
            if (needPrint) {
                println("$f1($l) + $t1(${r}) = $sum")
            }
            return dfs(nums, l + 1, r - 1, sum, count + 1, needPrint)
        }
        return count
    }
}

fun main() {
//    println(Solution().maxOperations(intArrayOf(3, 2, 1, 2, 3, 4))) // 3
//    println(Solution().maxOperations(intArrayOf(3, 2, 6, 1, 4))) // 2
    println(Solution2().maxOperations(intArrayOf(
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