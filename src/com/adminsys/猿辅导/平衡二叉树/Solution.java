package com.adminsys.猿辅导.平衡二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}