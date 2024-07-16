package wang.relish.leetcode.daily._2956

class Solution {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
        val n = nums1.size
        val m = nums2.size
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        var cnt1 = 0
        for (n1 in nums1) {
            if (set2.contains(n1)) cnt1++
        }
        var cnt2 = 0
        for (n2 in nums2) {
            if (set1.contains(n2)) cnt2++
        }
        return IntArray(2) {
            if (it == 0) cnt1 else cnt2
        }
    }
}