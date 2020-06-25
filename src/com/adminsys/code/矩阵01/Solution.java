package com.adminsys.code.矩阵01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离.
 * 两个相邻元素间的距离为 1.
 * 思路：
 * 统计1到0之间的距离等价于0到1之间的距离
 * 定义一个结果集，遍历把数组值为0的存入结果集中 并标记为true
 */
class Solution {

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] next = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<Node> queue = new LinkedList<>();
        boolean[][] book = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    book[i][j] = true;
                    queue.add(new Node(i, j));
                }
            }
        }
        bfs(res, queue, book);
        return res;
    }

    public void bfs(int[][] matrix, Queue<Node> queue, boolean[][] book) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int tx = x + next[i][0];
                int ty = y + next[i][1];
                if (tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {
                    continue;
                }
                if (!book[tx][ty]) {
                    matrix[tx][ty] = matrix[x][y] + 1;
                    book[tx][ty] = true;
                    queue.add(new Node(tx, ty));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        new Solution().updateMatrix(arr);
    }
}