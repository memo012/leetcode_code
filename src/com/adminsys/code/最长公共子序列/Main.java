package com.adminsys.code.最长公共子序列;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-27 13-32
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int lena = a.length();
        int lenb = b.length();
        int[][] dp = new int[lena + 1][lenb + 1];
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lena][lenb]);
    }
}