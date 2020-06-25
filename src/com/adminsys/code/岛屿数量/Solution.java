package com.adminsys.code.岛屿数量;

class Solution {
    private int sum;
    public int numIslands(char[][] grid) {
        if(grid.length < 0){
            return -1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    sum++;
                    grid[i][j] = '3';
                    dfs(i, j, grid);
                }
            }
        }
        return sum;
    }

    public void dfs(int x, int y, char[][] grid){
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        for (int i = 0; i < 4; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            if(tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length){
                continue;
            }
            if(grid[tx][ty] == '1'){
                grid[tx][ty] = '3';
                dfs(tx, ty, grid);
            }
        }
    }
}