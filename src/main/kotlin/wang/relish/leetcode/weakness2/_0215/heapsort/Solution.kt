package wang.relish.leetcode.weakness2._0215.heapsort

class Solution {

      fun findKthLargest(nums: IntArray, k: Int): Int {
        val n = nums.size
        for (i in n / 2 downTo 0) {
            heapSort(nums, i, n) // 建堆
        }
        for (i in n - 1 downTo n - k + 1) {
            swap(nums, 0, i) // 把第i个节点换到堆顶？
            heapSort(nums, 0, i)// 排序
        }
        return nums[0]
    }

    fun heapSort(arr: IntArray, index: Int, size: Int) {
        val left = (index shl 1) + 1 // 左子树节点index
        var s = index // 当前父节点值index
        if (left < size && arr[left] > arr[s]) {
            s = left // 左子树节点值更大
        }
        val right = left + 1 // 右子树节点index
        if (right < size && arr[right] > arr[s]) {
            s = right // 右子树节点值更大
        }
        if (s == index) return // 当前父节点值最大
        swap(arr, index, s) // 把最大值换到父节点位置
        heapSort(arr, s, size) // 持续把刚才被换的子节点进行交换, 直到s==index
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val t = nums[a]
        nums[a] = nums[b]
        nums[b] = t
    }
}
fun main() {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 5
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // 4
    println(Solution().findKthLargest(intArrayOf(1), 1)) // 1
    println(Solution().findKthLargest(intArrayOf(2, 1), 1)) // 2
    println(Solution().findKthLargest(intArrayOf(2, 1), 2)) // 1
}