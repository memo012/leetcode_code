package com.adminsys.美团.two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 11-28
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        int[] arr = new int[n];
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        long k1 = m / sum;
        long k2 = m % sum;
        for (int i = 0; i < n; i++) {
            if (k2 >= arr[i]) {
                k2 -= arr[i];
                count++;
            }
        }
        System.out.println(count + k1 * n);
    }
}
