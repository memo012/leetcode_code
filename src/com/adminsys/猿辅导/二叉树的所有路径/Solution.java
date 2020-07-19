package com.adminsys.猿辅导.二叉树的所有路径;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        return list;
    }
    public void dfs(TreeNode root, List<String> list, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) list.add(path);
            else {
                path += "->";
                dfs(root.left, list, path);
                dfs(root.right, list, path);
            }
        }
    }
}