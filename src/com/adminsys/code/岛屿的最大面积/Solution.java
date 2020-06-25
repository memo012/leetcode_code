package com.adminsys.code.岛屿的最大面积;

class Solution {
    private int sum;
    private int max = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1},
                {1, 1}
        };
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum = 1;
                    grid[i][j] = 0;
                    dfs(i, j, grid);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    public void dfs(int x, int y, int[][] grid) {
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        for (int i = 0; i < 4; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length) {
                continue;
            }
            if (grid[tx][ty] == 1) {
                grid[tx][ty] = 0;
                sum++;
                dfs(tx, ty, grid);
            }
        }
    }
}