package com.adminsys.code.最长上升子序列;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-27 13-08
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int[] num = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i - 1; j++) {
                if(num[j] < num[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}