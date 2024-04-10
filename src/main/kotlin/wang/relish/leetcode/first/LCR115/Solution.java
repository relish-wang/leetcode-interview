package wang.relish.leetcode.first.LCR115;


import struct.Node;
import struct.NodeUtils;

import java.util.LinkedList;

/*
// Definition for a struct.Node.
class struct.Node {
    public int val;
    public struct.Node left;
    public struct.Node right;

    public struct.Node() {}

    public struct.Node(int _val) {
        val = _val;
    }

    public struct.Node(int _val,struct.Node _left,struct.Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    /**
     * 双向链表排序 x
     *
     * @param root 链表
     * @return 从小到大排序后的链表 x ; 应该用中序遍历秒解(二叉搜索树的特性, 它的中序遍历就是排好序的)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node i = covertToChain(root);
        Node head = i;
        while (i != null) {
            var j = head;
            while (j.right != null) {
                int jv = j.val;
                Node j1 = j.right;
                int j1v = j1.val;
                if (jv > j1v) {
                    if (head == null) {
                        head = j1;
                    }
                    swap(j, j1);
                } else {
                    if (head == null) {
                        head = j;
                    }
                }
                j = j.right;
            }
            if (i.right == null) {
                head.left = (i);
                i.right = (head);
                break;
            }
            i = i.right;
        }
        return head;
    }

    private void swap(Node n1, Node n2) {
        int t = n1.val;
        n1.val = (n2.val);
        n2.val = (t);
    }

    private Node covertToChain(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                Node left = node.left;
                Node right = node.right;
                if (pre == null) {
                    pre = node;
                    pre.left = (null);
                } else {
                    pre.right = (node);
                    node.left = (pre);
                    pre = pre.right;
                }
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        if (pre != null) {
            pre.right = (null);
        }
        return root;
    }

    public static void main(String[] args) {
        Node node = new SolutionKt().treeToDoublyList(NodeUtils.createTestData("[4,2,5,1,3]"));
        if (node != null) {
            node.isLoopNode = true;
        }
        System.out.println(node);
    }
}