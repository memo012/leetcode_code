package com.adminsys.猿辅导.二维数组回行打印;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description: 二维数组回行打印
 * @Create: 2020-06-02 20-23
 **/

public class Travel {

    public static int[][] travel(int n, int m) {
        int[][] arr = new int[n][m];
        int l = 0;
        int r = m - 1;
        int t = 0;
        int b = n - 1;
        int num = 0, count = n * m;
        while (num < count) {
            for (int i = l; i <= r; i++){
                arr[t][i] = ++num;
            }
            t++;
            for (int i = t; i <= b; i++) {
                arr[i][r] = ++num;
            }
            r--;
            for (int i = r; i >= l; i--) {
                arr[b][i] = ++num;
            }
            b--;
            for (int i = b; i >= t; i--) {
                arr[i][l] = ++num;
            }
            l++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = travel(4, 5);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
