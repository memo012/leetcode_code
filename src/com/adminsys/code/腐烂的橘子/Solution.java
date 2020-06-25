package com.adminsys.code.腐烂的橘子;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] next = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rl = grid.length;
        int dl = grid[0].length;

        boolean[][] use = new boolean[rl][dl];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int remain = 0;
        for (int i = 0; i < rl; i++)
            for (int j = 0; j < dl; j++)
                if (grid[i][j] == 2){
                    queue.add(new Pair<Integer, Integer>(i, j));
                    use[i][j] = true;
                }else if(grid[i][j] == 1) {
                    remain++;
                }

        if (remain == 0) {
            return 0;
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int width = queue.size();
            if (remain == 0) {
                return count;
            }
            for (int j = 0; j < width; j++) {
                Pair<Integer, Integer> pair = queue.poll();
                int key = pair.getKey();
                int value = pair.getValue();
                for (int i = 0; i < 4; i++) {
                    int tx = key + next[i][0];
                    int ty = value + next[i][1];
                    if (tx < 0 || tx >= rl || ty < 0 || ty >= dl)
                        continue;
                    if (!use[tx][ty] && grid[tx][ty] == 1) {
                        grid[tx][ty] = 2;
                        use[tx][ty] = true;
                        queue.add(new Pair<Integer, Integer>(tx, ty));
                        remain--;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}