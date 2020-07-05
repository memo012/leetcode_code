package com.adminsys.动态规划.最长重复子数组;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/5 下午6:16
 **/
public class Solution {
    public int findLength(int[] a, int[] b) {
        int lena = a.length;
        int lenb = b.length;
        int[][] dp = new int[lena][lenb];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lena; i++) {
            for (int j = 0; j < lenb; j++) {
                if (a[i] == b[j]) {
                    if (i - 1 < 0 || j - 1 < 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
