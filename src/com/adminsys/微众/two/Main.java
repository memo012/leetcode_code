package com.adminsys.微众.two;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 19-28
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            System.out.println(whoWin(str));
        }
    }

    private static String whoWin(String str) {
        String p1 = "Cassidy", p2 = "Eleanore"; // p1先手
        // 判断奇数次字符的个数
        // 若该个数为 奇数次，则无论如何都是 Cassidy 赢
        // 若该个数为 偶数次，则无论如何都是 Eleanore 赢
        return ((oddCharNum(str) & 1) != 0) ? p1 : p2;
    }

    // 判断一个字符串的出现奇数次字符的个数
    private static int oddCharNum(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a'] += 1;
        int oddNum = 0; // 奇数次字符的个数
        for (int num : arr) {
            if ((num & 1) != 0) oddNum++; // 该字符出现了奇次
        }
        return oddNum;
    }
}