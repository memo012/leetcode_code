package com.adminsys.code.飞地的数量;

class Solution {
    int[][] next = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    int rl, dl, count = 0;
    boolean[][] flag;
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) return 0;
        rl = A.length;
        dl = A[0].length;
        flag = new boolean[rl][dl];
        for (int i = 0; i < rl; i++) {
            if (A[i][0] == 1) dfs(A, i, 0, false);
            if (A[i][dl-1] == 1) dfs(A, i, dl-1, false);
        }
        for (int i = 0; i < dl; i++) {
            if (A[0][i] == 1) dfs(A, 0, i, false);
            if (A[rl-1][i] == 1) dfs(A, rl-1, i, false);
        }
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < dl; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, true);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] A, int x, int y, boolean look) {
        if (look) count++;
        A[x][y] = 0;
        flag[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            if (tx < 0 || tx >= rl || ty < 0 || ty >= dl) continue;
            if (!flag[tx][ty] && A[tx][ty] == 1) dfs(A, tx, ty, look);
        }
    }
}