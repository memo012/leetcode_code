package com.adminsys.code.offer.面试题34二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        if (node == null) {
            return ans;
        }
        preOrder(node, sum, list, ans);
        return ans;
    }

    private void preOrder(TreeNode node, int sum, List<Integer> list, ArrayList<List<Integer>> ans) {
        list.add(node.val);
        sum -= node.val;
        if(sum == 0 && node.left == null && node.right == null){
            ans.add(new ArrayList<>(list));
        }
        if (node.left != null) {
            preOrder(node.left, sum, list, ans);
        }
        if (node.right != null) {
            preOrder(node.right, sum, list, ans);
        }
        list.remove(list.size() - 1);
    }

}