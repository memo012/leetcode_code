package com.adminsys.美团.one;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n <= 10) System.out.println(0);
        int count = 0;
        List<Long> list = new LinkedList<>();
        for (int i = 11; i <= n; i++) {
            String str = String.valueOf(i);
            long nu = Long.parseLong(new StringBuilder(str).reverse().toString());
            if (nu > n || i * 4 > n) break;
            if (!list.contains(nu) && !list.contains(i) && i * 4 == nu) {
                count++;
                list.add(Long.parseLong(i + ""));
                list.add(nu);
            }
        }
        System.out.println(count);
        for (int i = 0, j = 0; i < count; i++, j += 2) {
            System.out.print(list.get(j) + " " + list.get(j + 1));
            System.out.println();
        }
    }
}
