package com.adminsys.code.最短的桥;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[][] next = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;

        boolean flag = false;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        // 将第一岛屿进行染色
        for (int i = 0; i < m; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(queue, A, i, j);
                    flag = true;
                    break;
                }
            }
        }

        // BFS 遍历查找
        int level = 0;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int j = 0; j < k; j++){
                Pair<Integer, Integer> pair = queue.poll();
                int key = pair.getKey();
                int value = pair.getValue();
                for (int i = 0; i < 4; i++){
                    int tx = key + next[i][0];
                    int ty = value + next[i][1];
                    if (tx < 0 || tx >= A.length || ty < 0 || ty >= A[0].length){
                        continue;
                    }
                    if (A[tx][ty] == 2){
                        continue;
                    }
                    if (A[tx][ty] == 1){
                        return level;
                    }
                    A[tx][ty] = 2;
                    queue.add(new Pair<>(tx, ty));
                }
            }
            level++;
        }
        return level;
    }

    // DFS 深度查找
    public void dfs(Queue<Pair<Integer, Integer>> queue, int[][] A, int x, int y) {
        queue.add(new Pair<Integer, Integer>(x, y));
        A[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int tx = next[i][0] + x;
            int ty = next[i][1] + y;
            if (tx < 0 || tx >= A.length || ty < 0 || ty >= A[0].length) {
                continue;
            }
            if (A[tx][ty] == 1) {
                dfs(queue, A, tx, ty);
            }
        }
    }

}