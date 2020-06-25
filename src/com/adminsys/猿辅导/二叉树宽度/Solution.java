package com.adminsys.猿辅导.二叉树宽度;

import com.adminsys.queue.Stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-02 21-23
 **/
class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public int maxWidth(Node node) {
        if (node == null) {
            return 0;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int width = queue.size();
            max = Math.max(max, width);
            for (int i = 0; i < width; i++) {
                Node mid = queue.poll();
                if (mid.left != null) {
                    queue.add(mid.left);
                }
                if (mid.right != null) {
                    queue.add(mid.right);
                }
            }
        }
        return max;
    }

}
