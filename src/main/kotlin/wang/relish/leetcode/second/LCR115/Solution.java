package wang.relish.leetcode.LCR115;


import struct.Node;
import struct.NodeUtils;

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
     * @return 从小到大排序后的链表 x
     */
    public Node treeToDoublyList(Node root) {
        return root;
    }

    public static void main(String[] args) {
        Node node = new Solution().treeToDoublyList(NodeUtils.createTestData("[4,2,5,1,3]"));
        if (node != null) {
            node.isLoopNode = true;
        }
        System.out.println(node);
    }
}