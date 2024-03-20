import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var head: ListNode? = null
    var cursor: ListNode? = null
    var mod = 0
    var newL1 = l1
    var newL2 = l2
    while (newL1 != null || newL2 != null) {
        val n1 = newL1?.`val` ?: 0
        val n2 = newL2?.`val` ?: 0
        val sum = n1 + n2 + mod
        val n = sum % 10
        mod = sum / 10
        val t = ListNode(n)
        if (head == null) {
            head = t
        }
        if (cursor == null) {
            cursor = t
        } else {
            cursor.next = t
            cursor = t
        }
        newL1 = newL1?.next
        newL2 = newL2?.next
    }
    if (mod > 0) {
        cursor?.next = ListNode(mod)
    }
    return head
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val r = mutableListOf<Int>()
        var n: ListNode? = this
        while (n != null) {
            r.add(n.`val`)
            n = n.next
        }
        return r.toIntArray().contentToString()
    }

    companion object {
        fun newInstance(arr: IntArray): ListNode? {
            var n: ListNode? = null
            var h: ListNode? = null
            for (i in arr) {
                val t = ListNode(i)
                if (h == null) {
                    h = t
                }
                if (n == null) {
                    n = t
                } else {
                    n.next = t
                    n = t
                }
            }
            return h
        }
    }
}

fun main() {
    val node = addTwoNumbers(ListNode.newInstance(intArrayOf(2, 4, 3)), ListNode.newInstance(intArrayOf(5, 6, 4)))
    println(node.toString())
}