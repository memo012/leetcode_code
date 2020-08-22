package com.adminsys.京东.two;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        for (int i = m; i <= n; i++)
            if (isHuiWen(i)) count++;
        System.out.println(count);
    }

    public static boolean isHuiWen(int num) {
        String s = String.valueOf(num);
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        while (i <= s.length() - 1) {
            sb.deleteCharAt(i);
//            for (int j = 0; j < s.length(); j++) {
//                if (i != j) {
//                    sb.append(s.charAt(j));
//                }
//            }
            i++;
            if (isHWen(sb.toString())) return true;
            sb = new StringBuilder(s);
        }
        return false;
    }

    public static boolean isHWen(String nums) {
        int num = Integer.parseInt(nums);
        String ns = nums;
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) return false;

        if (num < 10) return true;
        for (int i = 0, j = ns.length() - 1; i < ns.length() / 2 && j >= ns.length() / 2; i++, j--)
            if (ns.charAt(i) != ns.charAt(j)) return false;
        return true;
    }
}