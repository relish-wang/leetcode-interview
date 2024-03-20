fun main() {
    println(removeNthFromEnd(ListNode.newInstance(intArrayOf(1,2,3,4,5)), 5))
    println(removeNthFromEnd(ListNode.newInstance(intArrayOf(1,2,3,4,5)), 2))
    println(removeNthFromEnd(ListNode.newInstance(intArrayOf(1)), 1))
}

/**
 * 方法一: 先算出链表的长度l,再次遍历的时候就遍历到l-n的位置执行删除链表节点的操作
 * 方法二: 先入栈, 再出栈, 出栈的第n个节点就是需要被删除的节点
 * 方法三: 双指针(first, second), second比first快n个节点, 当first到底的时候, second就是要被删除的节点
 */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var i = 0
        val h = ListNode(0).apply { next = head }
        var c: ListNode? = h.next
        var l = 0
        while (c != null) {
            c = c.next
            l++
        }
        if (n == l) {
            return head?.next
        }
        var d = head
        while (d != null) {
            if (i == l-n-1) {
                d.next = d.next?.next
            }
            d = d.next
            i++
        }
        return h.next
    }