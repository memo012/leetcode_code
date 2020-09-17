package com.adminsys.动态规划.最长公共子序列;

import java.util.Arrays;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/5 下午6:01
 **/
import java.util.*;

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
                if (ca[i - 1] == cb[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lena][lenb];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.next();
        String l2 = sc.next();

        char[] c1 = l1.toCharArray();
        char[] c2 = l2.toCharArray();
        int s1 = c1.length;
        int s2 = c2.length;

        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (c1[i - 1] == c2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sbd = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1 && j < s2) {
            if (c1[i] == c2[j]) {
                sbd.append(c1[i]);
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) i++;
            else j++;
        }
        System.out.println(sbd.toString());
    }
}