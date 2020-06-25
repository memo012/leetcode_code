package com.adminsys.微众.one;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 19-28
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, a, b;
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int count;
        int min;
        if (n < m) {
            if (n == 1) {
                count = n - 1;
            } else {
                count = m % n;
            }
        } else {
            if (m == 1) {
                count = n - 1;
            } else {
                count = n % m;
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            min = Math.min(a, b);
            System.out.println(min * count);
        }
    }
}
