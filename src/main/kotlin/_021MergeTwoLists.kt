fun main() {
    println(mergeTwoLists(ListNode.newInstance(intArrayOf(1, 2, 4)), ListNode.newInstance(intArrayOf(1, 3, 4))))
    println(mergeTwoLists(ListNode.newInstance(intArrayOf()), ListNode.newInstance(intArrayOf())))
}

/**
 * 也可以用递归, 递归的空间复杂度高(n+m, 即两个链表的长度)
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    var h: ListNode? = null
    var c: ListNode? = null

    var n1: ListNode? = list1
    var n2: ListNode? = list2
    while (n1 != null || n2 != null) {
        val n = if (n1 == null) {
            n2.also { n2 = n2?.next }
        } else if (n2 == null) {
            n1.also { n1 = n1?.next }
        } else {
            if (n1!!.`val` > n2!!.`val`) {
                n2.also { n2 = n2?.next }
            } else {
                n1.also { n1 = n1?.next }
            }
        }
        if (h == null) {
            h = n
        }
        if (c == null) {
            c = n
        } else {
            c.next = n
            c = c.next
        }
    }
    return h
}