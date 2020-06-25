package com.adminsys.code.最好一样;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-25 01-25
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int max = 0;
        int y = 0;
        int[] arr = new int[n];
        int[] count = new int[1000000];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
            if (count[arr[i]] > max) {
                max = count[arr[i]];
            }
            y = arr[i] | x;
            if (y != arr[i]) {
                count[y]++;
                if (count[y] > max)
                    max = count[y];
            }
        }
        System.out.println(max);
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[4];
        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt();
        }
        int pow = (int) Math.pow(n[3] - n[2] + 1, n[0]);
        int res = pow / n[1] % 1000000007;
        System.out.println(res);
    }

}
