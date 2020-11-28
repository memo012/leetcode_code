package com.adminsys.去哪儿.需求;

import java.util.Scanner;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/23 下午8:03
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] c1 = new String[m];
        String[] c2 = new String[m];
        for (int i = 0; i < m; i++) c1[i] = sc.next();
        for (int i = 0; i < m; i++) c2[i] = sc.next();
        int[][] dp = new int[m+1][m+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (c1[i-1].equals(c2[j-1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[m][m]);
    }
}
