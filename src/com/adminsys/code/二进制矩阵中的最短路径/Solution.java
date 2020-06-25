package com.adminsys.code.二进制矩阵中的最短路径;

import java.util.PriorityQueue;

class Solution {
    int[][] next = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rl = grid.length;
        int dl = grid[0].length;
        if (grid[0][0] == 1 || grid[rl-1][dl-1] == 1) return -1;
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.step - o2.step);
        queue.add(new Node(0, 0, 1));

        int[][] flag = new int[rl][dl];
        flag[0][0] = 1;

        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                Node pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                int step = pair.step;
                if (x == rl - 1 && y == dl - 1) return step;
                for (int j = 0; j < 8; j++) {
                    int tx = x + next[j][0];
                    int ty = y + next[j][1];
                    if (tx < 0 || tx >= rl || ty < 0 || ty >= dl) continue;
                    if (flag[tx][ty] == 0 && grid[tx][ty] == 0) {
                        flag[tx][ty] = 1;
                        queue.add(new Node(tx, ty, step + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}