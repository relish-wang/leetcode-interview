package wang.relish.leetcode.first._160.jv;

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
public class Main {

    /**
     * 单链表节点定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 找出两个单链表相交的起始节点；若不相交返回 null。
     *
     * @param headA 链表 A 的头节点
     * @param headB 链表 B 的头节点
     * @return 相交的起始节点，不相交则返回 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // TODO: 请在此实现你的算法
        return null;
    }

    /* ===================== 以下为输入输出框架代码，无需修改 ===================== */

    /** 根据整数数组创建链表，返回头节点 */
    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 按力扣评测系统的方式构造两个链表（相交或不相交）。
     *
     * @param intersectVal 相交节点的值，为 0 表示两链表不相交
     * @param listA        链表 A 的全部节点值
     * @param listB        链表 B 的全部节点值
     * @param skipA        在 A 中（从头开始）到达相交节点前的节点数
     * @param skipB        在 B 中（从头开始）到达相交节点前的节点数
     * @return 长度为 2 的数组：[headA, headB]
     */
    private static ListNode[] buildIntersection(int intersectVal, int[] listA, int[] listB, int skipA, int skipB) {
        ListNode headA = buildList(listA);
        // 不相交：A、B 两条链表完全独立
        if (intersectVal == 0) {
            return new ListNode[]{headA, buildList(listB)};
        }
        // 定位 A 中的相交节点
        ListNode intersection = headA;
        for (int i = 0; i < skipA; i++) {
            intersection = intersection.next;
        }
        // B 的前 skipB 个节点是独立的，其后共享 A 的相交节点（保证两链表指向同一物理节点）
        if (skipB == 0) {
            return new ListNode[]{headA, intersection};
        }
        int[] prefix = new int[skipB];
        System.arraycopy(listB, 0, prefix, 0, skipB);
        ListNode headB = buildList(prefix);
        ListNode tailB = headB;
        while (tailB.next != null) {
            tailB = tailB.next;
        }
        tailB.next = intersection;
        return new ListNode[]{headA, headB};
    }

    /** 按力扣输出格式打印结果 */
    private static void printResult(ListNode node) {
        if (node == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersected at '" + node.val + "'");
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // 示例 1：期望输出 Intersected at '8'
        ListNode[] case1 = buildIntersection(8, new int[]{4, 1, 8, 4, 5}, new int[]{5, 6, 1, 8, 4, 5}, 2, 3);
        printResult(solution.getIntersectionNode(case1[0], case1[1]));

        // 示例 2：期望输出 Intersected at '2'
        ListNode[] case2 = buildIntersection(2, new int[]{1, 9, 1, 2, 4}, new int[]{3, 2, 4}, 3, 1);
        printResult(solution.getIntersectionNode(case2[0], case2[1]));

        // 示例 3：期望输出 No intersection
        ListNode[] case3 = buildIntersection(0, new int[]{2, 6, 4}, new int[]{1, 5}, 3, 2);
        printResult(solution.getIntersectionNode(case3[0], case3[1]));
    }
}
