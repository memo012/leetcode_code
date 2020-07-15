package com.adminsys.code.offer.有效的数独;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] low = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (row[i][num] == 1) return false;
                if (low[j][num] == 1) return false;
                if (box[(i/3)*3+j/3][num] == 1) return false;
                row[i][num] = 1;
                low[j][num] = 1;
                box[(i/3)*3+j/3][num] = 1;
            }
        }
        return true;
    }
}