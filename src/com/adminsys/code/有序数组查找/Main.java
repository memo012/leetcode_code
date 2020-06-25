package com.adminsys.code.有序数组查找;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 13-31
 **/

public class Main {
    /**
     * @param arr
     * @param n   行
     * @param m   列
     * @param x   查找值
     * @return
     */
    public static boolean findX(int[][] arr, int n, int m, int x) {
        int j = m - 1;
        int i = 0;
        while (i < n && j >= 0) {
            if (arr[i][j] == x) {
                return true;
            } else if (arr[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findX(arr, n, m, 89));
    }
}
