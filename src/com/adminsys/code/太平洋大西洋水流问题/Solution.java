package com.adminsys.code.太平洋大西洋水流问题;

import java.util.*;

class Solution {
    private int[][] next = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        if (matrix == null || matrix.length <= 0) {
            return lists;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, a);
            dfs(matrix, i, n - 1, b);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, a);
            dfs(matrix, m - 1, i, b);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && b[i][j] == 1)
                    lists.add(Arrays.asList(i, j));
            }
        }
        return lists;
    }

    public void dfs(int[][] matrix, int x, int y, int[][] array) {
        array[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int tx = next[i][0] + x;
            int ty = next[i][1] + y;
            if (tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {
                continue;
            }
            if (array[tx][ty] != 1 && matrix[tx][ty] >= matrix[x][y]) {
                dfs(matrix, tx, ty, array);
            }
        }
    }
}