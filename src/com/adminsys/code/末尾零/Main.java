package com.adminsys.code.末尾零;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-29 08-44
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 5;
        int sum = 0;
        while (i <= n) {
            int md = n / i;
            sum += md;
            i *= 5;
        }
        System.out.println(sum);
    }
}