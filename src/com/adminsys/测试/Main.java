package com.adminsys.测试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t1 = 0;
        for (int i = n - 1; i >= 2; i--) {
            int k = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    k = 1;
                    break;
                }
            }
            if (k == 0) {
                t1 = i;
                break;
            }
        }
        System.out.println(Math.abs(t1 - n));
    }

    public static void test(String str, int start, String res, List<String> list, int[] book) {
        if (start == str.length()) {
            list.add(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (book[i] == 0) {
                book[i] = 1;
                test(str, start + 1, res + str.charAt(i), list, book);
                book[i] = 0;
            }
        }
    }
}