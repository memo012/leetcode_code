package com.adminsys.滴滴.two;

import java.util.*;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/21 下午8:13
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] data = new long[n * n];
        if (n == 1) {
            System.out.print(1);
            return;
        }
        data[0] = 1;
        data[1] = 1;
        for (int i = 2; i < n * n; i++) data[i] = data[i - 1] + data[i - 2];


        int size = data.length - 1;
        long[][] arr = new long[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (size >= 0) {
            for (int i = l; i <= r; i++) arr[t][i] = data[size--];
            t++;
            for (int i = t; i <= b; i++) arr[i][r] = data[size--];
            r--;
            for (int i = r; i >= l; i--) arr[b][i] = data[size--];
            b--;
            for (int i = b; i >= t; i--) arr[i][l] = data[size--];
            l++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) System.out.println(arr[i][j]);
                else System.out.print(arr[i][j] + " ");
            }
        }

    }
}
