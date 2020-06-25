package com.adminsys.美团.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 12-26
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long k = 1;
        for (int j = 1; j < n; j++) {
            long max = arr[j - 1];
            long min = arr[j - 1];
            for (int i = j; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } else if (arr[i] < max) {
                    min = arr[i];
                }
                if (i == 1) {
                    k = max ^ min;
                } else {
                    k ^= max ^ min;
                }
            }
        }
        System.out.println(k);
    }
}