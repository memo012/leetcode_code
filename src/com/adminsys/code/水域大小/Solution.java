package com.adminsys.code.水域大小;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int[][] next = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    private int count;

    public int[] pondSizes(int[][] land) {

        if (land == null || land[0].length == 0){
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    count = 1;
                    dfs(land, i, j);
                    list.add(count);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public void dfs(int[][] land, int x, int y) {
        land[x][y] = -1;
        for (int i = 0; i < 8; i++) {
            int tx = next[i][0] + x;
            int ty = next[i][1] + y;
            if (tx < 0 || tx >= land.length || ty < 0 || ty >= land[0].length) {
                continue;
            }
            if (land[tx][ty] == 0) {
                count++;
                dfs(land, tx, ty);
            }
        }
    }

}