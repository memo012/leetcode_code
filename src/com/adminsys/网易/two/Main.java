package com.adminsys.网易.two;

import java.util.*;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-11 19-21
 **/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int i = 0;
        int[] nums = new int[n];
        while (i < n) {
            for (Integer in : arr) {
                if (in > min) {
                    for (int k = 1; k < min && i < m; k++)
                        nums[i++] = k;
                }
            }
        }

    }
}