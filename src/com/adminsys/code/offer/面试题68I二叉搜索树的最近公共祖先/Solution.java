package com.adminsys.code.offer.面试题68I二叉搜索树的最近公共祖先;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            if(node.val > p.val && node.val > q.val){
                node = node.left;
            }else if(node.val < p.val && node.val < q.val){
                node = node.right;
            }else {
                return node;
            }
        }
        return null;
    }
}