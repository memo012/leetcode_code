package com.adminsys.猿辅导.二叉树是否对称;

import java.util.Stack;

/**
 * @Author: qiang
 * @Description: 二叉树是否对称
 * @Create: 2020-06-02 21-13
 **/
class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public boolean isSymmetric(Node root) {
        if (root == null) {
            return false;
        }
        Node node = root;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node node1 = node.left;
        Node node2 = node.right;
        while (node1 != null || !stack1.isEmpty()
                || node2 != null || !stack2.isEmpty()) {
            while (node1 != null && node2 != null) {
                stack1.push(node1);
                stack2.push(node2);
                node1 = node1.left;
                node2 = node2.right;
            }

            if (node1 != null || node2 != null) {
                return false;
            }
            node1 = stack1.pop();
            node2 = stack2.pop();
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.right;
            node2 = node2.left;
        }
        return true;
    }


}
