package com.adminsys.动态规划.最长公共子序列;

import java.util.Arrays;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/5 下午6:01
 **/
public class Solution {
    public int go(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int lena = ca.length;
        int lenb = cb.length;
        int[][] dp = new int[lena + 1][lenb + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (ca[i - 1] == cb[j - 1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[lena][lenb];
    }
}
