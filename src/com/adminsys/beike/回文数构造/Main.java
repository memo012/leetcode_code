package com.adminsys.beike.回文数构造;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/11 下午7:26
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] ch = s.toCharArray();
        int count = 0;
        for (int i = 0, j = n - 1; i < n / 2 && j >= n / 2; i++, j--) {
            if (ch[i] != ch[j]) count++;
        }
        System.out.println(count);
    }
}
