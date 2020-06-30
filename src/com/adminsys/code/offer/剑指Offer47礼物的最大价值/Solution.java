package com.adminsys.code.offer.剑指Offer47礼物的最大价值;

class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rl = grid.length;
        int dl = grid[0].length;
        for (int i = 0; i < rl; i++)
            for (int j = 0; j < dl; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        return grid[rl-1][dl-1];
    }
}