package com.adminsys.code.offer.面试题68II二叉树的最近公共祖先;

import java.util.ArrayList;
import java.util.Collections;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        getNodePathp(root, p, listP);
        getNodePathp(root, q, listQ);
        Collections.reverse(listP);
        Collections.reverse(listQ);
        int min = Math.min(listP.size(), listQ.size());
        TreeNode n = null;
        for(int i = 0; i < min; i++){
            if(listP.get(i) == listQ.get(i)){
                n = listP.get(i);
            }
        }
        return n;
    }

    private boolean getNodePathp(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if(root == p){
            list.add(p);
            return true;
        }
        if(getNodePathp(root.left, p, list) || getNodePathp(root.right, p, list)){
            list.add(p);
            return true;
        }
        return false;
    }
}