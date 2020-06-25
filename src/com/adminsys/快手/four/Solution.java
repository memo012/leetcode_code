package com.adminsys.快手.four;

public class Solution {
    /**
     * 获取最大可同事办公员工数
     * @param pos char字符型二维数组 工位分布
     * @return int整型
     */
    private int count = 0;
    public int GetMaxStaffs (char[][] pos) {
        // write code here
        char[][] chars = pos;
        for(int i = 0; i < pos.length; i++){
            for (int j = 0; j < pos[i].length; j++){
                if (chars[i][j] == '*') {
                    count++;
                    dfs(chars, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] chars, int start, int end){
        int[][] next = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        for (int i = 0; i < 4; i++) {
            int tx = start + next[i][0];
            int ty = end + next[i][1];
            if (tx < 0 || ty < 0 || tx >= chars.length || ty >= chars[0].length) {
                continue;
            }
            if(chars[tx][ty] == '.'){
                chars[tx][ty] = '*';
            }
        }
    }
}