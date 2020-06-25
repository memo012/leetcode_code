package com.adminsys.code.矩阵中的路径;

import java.util.Objects;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || word.isEmpty()) {
            return false;
        }
        int row = board.length;
        int cols = board[0].length;
        int[][] book = new int[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, book, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int[][] book, int i, int j, int k) {
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        if (k >= word.length() || board[i][j] != word.charAt(k)) {
            return false;
        }
        book[i][j] = 1;
        k++;
        for (int l = 0; l < 4; l++) {
            int tx = next[l][0] + i;
            int ty = next[l][1] + j;
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[i].length || book[tx][ty] == 1) {
                continue;
            } else {
                if (dfs(board, word, book, tx, ty, k)) {
                    return true;
                }
            }
        }
        book[i][j] = 0;
        if (k == word.length()) {
            return true;
        }
        return false;
    }
}