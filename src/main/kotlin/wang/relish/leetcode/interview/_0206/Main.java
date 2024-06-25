package wang.relish.leetcode.interview._0206;

import struct.ListNode;

/**
 * 来自小红书上海技术一面。20240624
 * https://leetcode.cn/problems/reverse-linked-list/description/
 */
class Main {

    public ListNode revserse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;

            cur = next;
        }
        return pre;
    }
}