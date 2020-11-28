package com.adminsys.动态规划.蒜头君回家;

import java.util.Scanner;
/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/2 下午10:43
 **/
public class Solution {
    public void maxValue(int[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        int[][] dp = new int[row][line];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = dp[i][j - 1] + matrix[i][j];
                else if (j == 0) dp[i][j] = dp[i - 1][j] + matrix[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println(dp[row - 1][line - 1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n < 1 || n > 200) {
            System.out.println("Error");
            return;
        }
        int arr[] = new int[4000];
        if (n != 0) arr[0] = 1;
        int c = 0;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            c = 0;
            for (int j = 0; j < arr.length; ++j) {
                temp = (i * arr[j] + c);
                arr[j] = temp % 10;
                c = temp / 10;
            }
        }
        int i = arr.length - 1;
        for (; i >= 0; --i) {
            if (arr[i] == 0)
                continue;
            else break;
        }
        for (int j = i; j >= 0; --j) {
            System.out.print(arr[j]);
        }
    }
}