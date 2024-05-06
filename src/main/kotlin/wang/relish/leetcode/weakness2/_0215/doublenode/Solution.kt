package wang.relish.leetcode.weakness2._0215.doublenode

class Solution {
    /**
     * 双链表解法会超时卡在35 / 41
     * 1 <= k <= nums.length <= 105
     *
     * -10<sup>4</sup> <= nums\[i] <= 10<sup>4</sup>
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val dummyHead = Node(10001)
        val dummyTail = Node(-10001)
        dummyHead.next = dummyTail
        dummyTail.prev = dummyHead
        for (num in nums) {
            insertOrReplace(dummyHead, dummyTail, num, k)
        }
        return dummyTail.prev!!.`val`
    }

    fun insertOrReplace(dummyHead: Node,dummyTail:Node, x: Int, k: Int) {
        var prev = dummyHead
        var curr = dummyHead.next
        val node = Node(x)
        var i = 0
        var inserted = false
        // 问题出在这个循环, 它没有堆排序「直接i*2+1定位左子树」的方式高效
        while (curr != null) {
            if (inserted.not() && x in curr.`val`..prev.`val`) {
                node.prev = prev
                node.next = curr

                prev.next = node
                curr.prev = node
                inserted = true
            }
            prev = curr
            curr = curr.next
            i++
        }
        if (i > k) {
            val p = dummyTail.prev?.prev
            dummyTail.prev = p
            p?.next = dummyTail
        }
    }

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null

        override fun toString(): String {
            var c: Node? = this
            val sb = StringBuilder("${c!!.`val`}")
            c = c?.next
            while (c != null) {
                sb.append("->${c.`val`}")
                c = c.next
            }
            return sb.toString()
        }
    }

    fun findKthLargest1(nums: IntArray, k: Int): Int {
        val n = nums.size
        for (i in n / 2 downTo 0) {
            heapSort(nums, i, n)
        }
        for (i in n - 1 downTo n - k + 1) {
            swap(nums, 0, i)
            heapSort(nums, 0, i)
        }
        return nums[0]
    }

    fun heapSort(nums: IntArray, index: Int, size: Int) {
        var s = index
        val left = (index shl 1) + 1
        if (left < size && nums[left] > nums[s]) {
            s = left
        }
        val right = left + 1
        if (right < size && nums[right] > nums[s]) {
            s = right
        }
        if (s == index) return
        swap(nums, s, index)
        heapSort(nums, s, size)
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[i] xor nums[j]
        nums[j] = nums[j] xor nums[i]
        nums[i] = nums[i] xor nums[j]
    }
}

fun main() {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 5
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // 4
    println(Solution().findKthLargest(intArrayOf(1), 1)) // 1
    println(Solution().findKthLargest(intArrayOf(2, 1), 1)) // 2
    println(Solution().findKthLargest(intArrayOf(2, 1), 2)) // 1
}