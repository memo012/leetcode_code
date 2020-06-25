package com.adminsys.code.岛屿的周长;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int lines = 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        lines--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        lines--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        lines--;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        lines--;
                    }
                    sum += lines;
                }
            }
        }
        return sum;
    }
}