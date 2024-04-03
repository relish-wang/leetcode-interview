package _287

/**
 * @see _136.Solution
 */
class Solution {
    /**
     * 双指针
     * 快慢指针判断是否有环。
     * 为什么成了一道链表是否有环的题目? 题目说了nums数组的里数只可能是1~n(nums.length = n+1)的数字。每个数字就是一个节点。出现相同的数字表示出现了相同的节点
     *
     * value 1 4 6 6 6 2 3
     * index 0 1 2 3 4 5 6
     *
     * 链表: 1 -> 4 -> 6 -> 3
     *                ↑    │
     *                └────┘
     */
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)
        // 到这里的时候在相同节点相遇了
        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }

    /**
     * 虽然空间占用少, 但是用时长
     * 用时: 9.52%
     * 内存: 97.62%
     */
    fun findDuplicate1(nums: IntArray): Int {
        nums.sort()
        return find(nums, 0, nums.size - 1)
    }

    fun find(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) {
            return -1
        }
        if (l + 1 == r) {
            val lv = nums[l]
            val rv = nums[r]
            if (lv == rv) {
                return lv
            }
            return -1
        }
        val mid = (r + l) / 2
        return if (nums[mid] >= mid + 1) {
            find(nums, mid, r)
        } else {
            find(nums, l, mid)
        }
    }
}

/**
 * a xor a = 0
 * a xor 0 = a
 * a xor b = b xor a
 */
fun main() {
    println(Solution().findDuplicate(intArrayOf(1, 3, 4, 2, 2))) // 2
    println(Solution().findDuplicate(intArrayOf(3, 3, 3, 3, 3))) // 3
    println(Solution().findDuplicate(intArrayOf(1, 4, 4, 2, 4))) // 4
}
/*
┌──────────┬─────┬────────┬─────────────────────┐
│          │胜诉率│判决件数 │胜诉件数              │
│          │（％）│        ├────┬──┬────┤
│          │     │        │合计  │胜诉│胜败互见│
├──┬──┼───┼────┼───┼──┼────┤
│民事│合计│20.53 │548     │112.5 │53  │119     │
│    ├──┼───┼────┼───┼──┼────┤
│诉讼│著作│33.04 │112     │37.0  │17  │40      │
│    ├──┼───┼────┼───┼──┼────┤
│    │专利│11.60 │332     │38.5  │16  │45      │
│    ├──┼───┼────┼───┼──┼────┤
│    │商标│36.36 │88      │32.0  │17  │30      │
│    ├──┼───┼────┼───┼──┼────┤
│    │其他│31.25 │16      │5.0   │3   │4       │
├──┴──┴───┴────┴───┴──┴────┤
│注：1．胜诉件数一胜诉＋胜败互见／2                  │
├──────────────────────────┤
│2.胜诉率＝胜诉件数／终结件数×100％                 │
└──────────────────────────┘

 */