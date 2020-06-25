package com.adminsys.code.二叉树的直径;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 *  思路：
 *  求二叉树直径 等价于求路径经过节点的最大值减一
 *  又等价于(根节点到左子树最深度+根节点到右字数最深度+1)-1
 *  所以只需求出左子树最深度和右字数最深度 即可解决问题
 */
class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }
    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}