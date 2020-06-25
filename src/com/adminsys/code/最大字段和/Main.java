package com.adminsys.code.最大字段和;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-27 12-49
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, num[i]);
        }
        if (ans <= 0) {
            System.out.println(ans);
        } else {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + num[i] < 0) {
                    sum = 0;
                } else {
                    sum += num[i];
                }
                ans = Math.max(ans, sum);
            }
            System.out.println(ans);
        }
    }
}
