package com.adminsys.code.offer.面试题28对称的二叉树;


import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isSymmetric(TreeNode root) {
        TreeNode head = root;
        if (head == null) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode leftNode = head.left;
        TreeNode rightNode = head.right;
        while (leftNode != null || rightNode != null || !leftStack.isEmpty() || !rightStack.isEmpty()) {
            while (leftNode != null && rightNode != null) {
                leftStack.push(leftNode);
                rightStack.push(rightNode);
                leftNode = leftNode.left;
                rightNode = rightNode.right;
            }
            if (leftNode != null || rightNode != null) {
                return false;
            }
            leftNode = leftStack.pop();
            rightNode = rightStack.pop();
            if (leftNode.val != rightNode.val) {
                return false;
            }
            leftNode = leftNode.right;
            rightNode = rightNode.left;
        }
        return true;
    }
}