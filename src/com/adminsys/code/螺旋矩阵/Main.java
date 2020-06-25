package com.adminsys.code.螺旋矩阵;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 12-55
 **/

public class Main {
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 0, count = n * n;
        while (num < count) {
            // left to right
            for (int i = l; i <= r; i++) {
                arr[t][i] = ++num;
            }
            t++;
            // top to bottom
            for (int i = t; i <= b; i++) {
                arr[i][r] = ++num;
            }
            r--;
            // right to left
            for (int i = r; i >= l; i--) {
                arr[b][i] = ++num;
            }
            b--;
            // bottom to top
            for (int i = b; i >= t; i--) {
                arr[i][l] = ++num;
            }
            l++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}