package com.adminsys.code.offer.机器人的运动范围;

import java.util.*;

class Solution {
    int[][] next = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int movingCount(int m, int n, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        int count = 0;
        boolean[][] flag = new boolean[m][n];
        flag[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                if (!flag[tx][ty] && sum(tx, ty, k)) {
                    flag[tx][ty] = true;
                    queue.add(new Node(tx, ty));
                }
            }
        }
        return count;

    }

    public boolean sum(int x, int y, int k) {
        int count = 0;
        while (x != 0) {
            count += (x % 10);
            x /= 10;
        }
        while (y != 0) {
            count += (y % 10);
            y /= 10;
        }
        return count <= k;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new Solution().movingCount(1, 2, 1);
    }
}