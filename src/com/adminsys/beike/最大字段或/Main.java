package com.adminsys.beike.最大字段或;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/11 下午7:54
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) System.out.println(1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        long count = Long.MAX_VALUE, sum = arr[0], max = Long.MIN_VALUE, start = 0;
        for (int i = 1; i < n; i++) {
            if ((sum | arr[i]) == max) {
                sum |= arr[i];
                count = Math.min(count, i - start + 1);
            } else if ((sum | arr[i]) > max) {
                sum |= arr[i];
                max = sum;
                start = i;
                count = 1;
            } else {
                sum = arr[i];
                start = i;
                count = 1;
            }
        }
        System.out.println(count);
    }

}



