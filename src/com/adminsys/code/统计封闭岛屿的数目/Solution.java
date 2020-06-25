package com.adminsys.code.统计封闭岛屿的数目;

class Solution {
    int[][] next = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    boolean[][] flag;
    int rl, dl;
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        rl = grid.length;
        dl = grid[0].length;
        flag = new boolean[rl][dl];
        for (int i = 0; i < rl; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][dl-1] == 0) dfs(grid, i, dl-1);
        }
        for (int i = 0; i < dl; i++) {
            if (grid[0][i] == 0) dfs(grid, 0, i);
            if (grid[rl-1][i] == 0) dfs(grid, rl-1, i);
        }
        int count = 0;
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < dl; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int start, int end) {
        grid[start][end] = 1;
        flag[start][end] = true;
        for (int i = 0; i < 4; i++) {
            int tx = start + next[i][0];
            int ty = end + next[i][1];
            if (tx < 0 || tx >= rl || ty < 0 || ty >= dl) continue;
            if (!flag[tx][ty] && grid[tx][ty] == 0) dfs(grid, tx, ty);
        }
    }
}