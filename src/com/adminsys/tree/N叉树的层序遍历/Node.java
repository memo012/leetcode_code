package com.adminsys.tree.N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }  
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int width = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                Node mid = queue.poll();
                list.add(mid.val);
                for (Node no : mid.children) {
                    queue.add(no);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}