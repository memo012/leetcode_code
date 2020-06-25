package com.adminsys.code.实现捡水果;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-26 08-52
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                if (i == n) {
                    max = Math.max(arr[i][j], max);
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            max = 0;
        }
        System.out.println(max);
    }
}