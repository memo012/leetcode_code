package com.adminsys.code.判断二分图;

import java.util.Arrays;
import java.util.Stack;

/**
 *  思路：
 *      如果节点属于第一个集合，将其染为蓝色，否则染为红色。若为二分图情况下，可以使用贪心
 *      思想给图染色，一个节点为蓝色，说明它的所有邻接节点为红色，以此类推
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] color = new int[size];
        Arrays.fill(color, -1);

        for (int i = 0; i < size; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;
                while (!stack.isEmpty()) {
                    int mid = stack.pop();
                    for (int in : graph[mid]) {
                        if (color[in] == -1) {
                            color[in] = color[mid] ^ 1;
                            stack.push(in);
                        }else if (color[in] == color[mid]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}