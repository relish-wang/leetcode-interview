/**
 * 快手电商杭州一面原题240620
 */
fun main() {
    // case 1
    runCase("[1,2,4]", "[1,3,4]")

    // case 2
    runCase("[]", "[]")

    // case 3
    runCase("[]", "[0]")
}

fun runCase(s1: String, s2: String) {
    val l1 = createNode(s1)
    val l2 = createNode(s2)
    merge(l1, l2).print()
}


fun merge(n1: Node?, n2: Node?): Node? {
    if (n1 == null) return n2
    if (n2 == null) return n1
    val dummy = Node(0)
    var cur: Node? = dummy
    var l1: Node? = n1
    var l2: Node? = n2
    while (l1 != null && l2 != null) {
        val v1 = l1.v
        val v2 = l2.v
        if (v1 > v2) {
            cur?.next = l2
            l2 = l2.next
        } else {
            cur?.next = l1
            l1 = l1.next
        }
        cur = cur?.next
    }
    cur?.next = l1 ?: l2
    return dummy.next
}

class Node(var v: Int = 0) {
    var next: Node? = null
}

fun createNode(str: String): Node? {
    val arr = str.replace(Regex("\\[|\\]"), "")
        ?.takeIf { it.isNotBlank() }
        ?.split(",")
        ?: return null
    val dummy = Node(0)
    var cur: Node? = dummy
    for (a in arr) {
        cur?.next = Node(a.toInt())
        cur = cur?.next
    }
    return dummy.next
}

fun Node?.print() {
    val head = this
    if (head == null) {
        println("[]")
        return
    }
    var cur: Node? = head
    val list = ArrayList<Int>()
    while (cur != null) {
        list.add(cur.v)
        cur = cur.next
    }
    println(list.toIntArray().contentToString())
}