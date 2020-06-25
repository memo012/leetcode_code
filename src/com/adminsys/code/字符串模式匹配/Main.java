package com.adminsys.code.字符串模式匹配;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-24 13-10
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        String t = scanner.nextLine();
        if (Pattern.matches(p.replace("*",".*").replace("?","."),t)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
//
//    public static int test(String sc1, String sc2) {
//        for (int i = 0, j = 0; i < sc1.length() && j < sc2.length(); ) {
//            char c1 = sc1.charAt(i);
//            char c2 = sc2.charAt(j);
//            if (c1 == '*') {
//                while (i < sc1.length()) {
//                    c1 = sc1.charAt(++i);
//                }
//            }
//        }
//    }
}
