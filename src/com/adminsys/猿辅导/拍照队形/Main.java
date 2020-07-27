package com.adminsys.猿辅导.拍照队形;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = (n - 1) / 3;
        int line = 2 * k;
        String strs = sc.next();
        char[] str = strs.toCharArray();
        int index = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            for (int j = 0; j <= line; j++) {
                if (i < k) {
                    if (i == j) System.out.print(str[index++]);
                    else if (j + i == line) System.out.print(str[index++]);
                    else System.out.print(" ");
                } else {
                    if (j == k) System.out.print(str[index++]);
                    else System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}