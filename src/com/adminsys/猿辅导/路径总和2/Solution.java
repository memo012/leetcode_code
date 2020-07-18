package com.adminsys.猿辅导.路径总和2;


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
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), lists);
        return lists;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> lists) {
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
            lists.add(new ArrayList<>(list));
        if (root.left != null) dfs(root.left, sum, list, lists);
        if (root.right != null) dfs(root.right, sum, list, lists);
        list.remove(list.size() - 1);
    }
}