package com.adminsys.code.动态规划.蒜头君回家;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/2 下午10:43
 **/
public class Solution {
    int[][] a;
    int[][] dp;

    public void goHome(int n) {
        a = new int[100][100];
        dp = new int[100][100];
        dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                else if (i == 1) dp[i][j] = dp[i][j - 1] + a[i][j];
                else if (j == 1) dp[i][j] = dp[i-1][j] + a[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + a[i][j];
            }
        }
    }
}
