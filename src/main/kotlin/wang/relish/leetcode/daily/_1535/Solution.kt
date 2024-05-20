package wang.relish.leetcode.daily._1535

class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        val n = arr.size
        var p = 1
        val kk = k
        var turn = 0
        while (turn < k) {
            val n1 = arr[0]
            val n2 = arr[p]
            if (n1 < n2) {
                swap(arr, 0, p)
                turn = 1
            } else {
                turn++
            }
            if (turn == k) {
                break
            }
            p++
            if (p >= n) {
                break
            }
        }
        return arr[0]
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        arr[i] = arr[i] xor arr[j]
        arr[j] = arr[j] xor arr[i]
        arr[i] = arr[i] xor arr[j]
    }
}