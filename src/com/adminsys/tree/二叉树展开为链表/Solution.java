package com.adminsys.tree.二叉树展开为链表;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 18-05
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        LinkedList<TreeNode> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }

        TreeNode head = list.removeFirst();
        head.left = null;
        while(list.size() > 0) {
            TreeNode tmp = list.removeFirst();
            tmp.left = null;
            head.right = tmp;
            head = head.right;
        }
    }

    /**
     *  递归
     * @param root
     */
    public void flattenTwo(TreeNode root) {
        if (root == null) return;
        //先将二叉树转换成左展开链表
        flattenHelper(root);
        //再将左展开转换成右展开链表
        TreeNode tempNode =root;
        while(tempNode.left!=null){
            tempNode.right = tempNode.left;
            tempNode.left = null;
            tempNode= tempNode.right;
        }
    }
    private TreeNode flattenHelper(TreeNode root){
        if (root.left == null && root.right == null) return root;
        if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            return flattenHelper(root.left);
        }
        if (root.left != null && root.right == null) return flattenHelper(root.left);
        //如果左右都不为空则把左边归过来的末节点的左节点赋值为当前节点的右节点，然后继续递归；
        TreeNode nullLeftNode= flattenHelper(root.left);
        nullLeftNode.left = root.right;
        root.right=null;
        return flattenHelper(nullLeftNode.left);
    }
}
