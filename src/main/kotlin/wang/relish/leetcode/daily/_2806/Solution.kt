package wang.relish.leetcode.daily._2806

class Solution {
    fun accountBalanceAfterPurchase(purchaseAmount: Int): Int {
        return 100 - (purchaseAmount + 5) / 10 * 10
    }
}