package wang.relish.leetcode.daily._3115

class Solution {
    fun maximumPrimeDifference(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        while (i < n) {
            if (isPrime(nums[i])) {
                break
            }
            i++
        }
        val start = i
        i = n - 1
        while (i >= start) {
            if (isPrime(nums[i])) {
                break
            }
            i--
        }
        return if (i <= start) {
            0
        } else {
            i - start
        }
    }

    fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        var i = 2
        while (i * i <= num) {
            if (num % i == 0) {
                return false
            }
            i++
        }
        return true
    }
}