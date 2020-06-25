package com.adminsys.code.马路过河卒;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-26 09-50
 **/

public class Main {
    public static void main(String[] args) {

    }

    public static void test(int[][] arr, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i != 0){
                    dp[i][j] += dp[i-1][j];
                }
                if(j != 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
    }
}