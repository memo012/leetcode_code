package com.adminsys.code.完全平方数;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-26 09-54
 **/

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况及时每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}