package com.adminsys.code.offer.面试题27二叉树的镜像;


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
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode head = root;
        if(head == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode leftNode = node.left;
            node.left = node.right;
            node.right = leftNode;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
        System.out.println(-Integer.MAX_VALUE);
    }
}