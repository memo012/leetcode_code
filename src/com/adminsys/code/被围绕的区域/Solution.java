package com.adminsys.code.被围绕的区域;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean edge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (edge && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int start, int end) {
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        Queue<Node> queue = new LinkedList<>();
        board[start][end] = '#';
        queue.add(new Node(start, end));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                if (board[tx][ty] == 'O') {
                    board[tx][ty] = '#';
                    queue.add(new Node(tx, ty));
                }
            }
        }
    }

}