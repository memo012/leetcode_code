package com.adminsys.sort.字典树;

import java.util.*;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/1 下午7:33
 **/
public class TrieTree {

    class TreeNode {
        char ch;
        int count;
        Map<Character, TreeNode> nodeMap;
        public TreeNode(char ch, int count, Map<Character, TreeNode> nodeMap) {
            this.ch = ch;
            this.count = count;
            this.nodeMap = nodeMap;
        }
    }

    TreeNode root;

    public TrieTree() {
        root = new TreeNode(' ', 0, new HashMap<>());
    }

    public void add(String str) {
        TreeNode cur = root;
        if (root == null) return;
        for (int i = 0; i < str.length(); i++) {
            TreeNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null) {
                TreeNode node = new TreeNode(str.charAt(i), 0, new HashMap<>());
                cur.nodeMap.put(str.charAt(i), node);
                cur = cur.nodeMap.get(str.charAt(i));
            }else {
                cur = child;
            }
        }
        cur.count++;
    }

    public int query(String str) {
        TreeNode node = root;
        if (node == null) return 0;
        for (int i = 0; i < str.length(); i++) {
            TreeNode child = node.nodeMap.get(str.charAt(i));
            if (child == null) return 0;
            else node = child;
        }
        return node.count;
    }



}
