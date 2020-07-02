package com.adminsys.code.动态规划.捡水果;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/2 下午10:52
 **/
public class Solution {
    public int takeFruit(int n) {
        int[][] f = new int[100][100];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] += Math.max(f[i-1][j], f[i-1][j-1]);
                if ( i == n) max = Math.max(max, f[i][j]);
            }
        }
        if (max == Integer.MIN_VALUE) max = 0;
        return max;
    }
}
