package wang.relish.leetcode.first._160.kt

/**
 * 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null。
 *
 * 注意：
 * 1. 整个链式结构中不存在环。
 * 2. 函数返回结果后，链表必须保持其原始结构。
 *
 * 示例 1：listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 -> Intersected at '8'
 * 示例 2：listA = [1,9,1,2,4], listB = [3,2,4],       skipA = 3, skipB = 1 -> Intersected at '2'
 * 示例 3：listA = [2,6,4],     listB = [1,5],          不相交                 -> No intersection
 */

/** 单链表节点定义 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /**
     * 找出两个单链表相交的起始节点；若不相交返回 null。
     *
     * @param headA 链表 A 的头节点
     * @param headB 链表 B 的头节点
     * @return 相交的起始节点，不相交则返回 null
     */
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        // TODO: 请在此实现你的算法
        return null
    }
}

/* ===================== 以下为输入输出框架代码，无需修改 ===================== */

/** 根据整数数组创建链表，返回头节点 */
private fun buildList(values: IntArray): ListNode? {
    val dummy = ListNode(0)
    var cur = dummy
    for (v in values) {
        cur.next = ListNode(v)
        cur = cur.next!!
    }
    return dummy.next
}

/**
 * 按力扣评测系统的方式构造两个链表（相交或不相交）。
 *
 * @param intersectVal 相交节点的值，为 0 表示两链表不相交
 * @param listA        链表 A 的全部节点值
 * @param listB        链表 B 的全部节点值
 * @param skipA        在 A 中（从头开始）到达相交节点前的节点数
 * @param skipB        在 B 中（从头开始）到达相交节点前的节点数
 * @return Pair(headA, headB)
 */
private fun buildIntersection(
    intersectVal: Int,
    listA: IntArray,
    listB: IntArray,
    skipA: Int,
    skipB: Int,
): Pair<ListNode?, ListNode?> {
    val headA = buildList(listA)
    // 不相交：A、B 两条链表完全独立
    if (intersectVal == 0) {
        return headA to buildList(listB)
    }
    // 定位 A 中的相交节点
    var intersection = headA
    repeat(skipA) { intersection = intersection?.next }
    // B 的前 skipB 个节点是独立的，其后共享 A 的相交节点（保证两链表指向同一物理节点）
    val headB = buildList(listB.copyOfRange(0, skipB)) ?: return headA to intersection
    var tailB: ListNode? = headB
    while (tailB?.next != null) {
        tailB = tailB.next
    }
    tailB?.next = intersection
    return headA to headB
}

/** 按力扣输出格式打印结果 */
private fun printResult(node: ListNode?) {
    if (node == null) {
        println("No intersection")
    } else {
        println("Intersected at '${node.`val`}'")
    }
}

fun main() {
    // 示例 1：期望输出 Intersected at '8'
    val (a1, b1) = buildIntersection(
        intersectVal = 8,
        listA = intArrayOf(4, 1, 8, 4, 5),
        listB = intArrayOf(5, 6, 1, 8, 4, 5),
        skipA = 2,
        skipB = 3,
    )
    printResult(Solution().getIntersectionNode(a1, b1))

    // 示例 2：期望输出 Intersected at '2'
    val (a2, b2) = buildIntersection(
        intersectVal = 2,
        listA = intArrayOf(1, 9, 1, 2, 4),
        listB = intArrayOf(3, 2, 4),
        skipA = 3,
        skipB = 1,
    )
    printResult(Solution().getIntersectionNode(a2, b2))

    // 示例 3：期望输出 No intersection
    val (a3, b3) = buildIntersection(
        intersectVal = 0,
        listA = intArrayOf(2, 6, 4),
        listB = intArrayOf(1, 5),
        skipA = 3,
        skipB = 2,
    )
    printResult(Solution().getIntersectionNode(a3, b3))
}
