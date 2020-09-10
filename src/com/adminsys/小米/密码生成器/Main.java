package com.adminsys.小米.密码生成器;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/8 下午6:32
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] sr = str.split(" ");
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < sr.length; i++) {
            boolean digit = false, fh = false, lower = false, upper = false;
            char[] chars = sr[i].toCharArray();
            if (chars.length < 8 || chars.length > 120) {
                list.add(1);
                continue;
            }
            for (int j = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) digit = true;
                else if (Character.isLowerCase(chars[j])) lower = true;
                else if (Character.isUpperCase(chars[j])) upper = true;
                else fh = true;
            }
            if (digit && fh && lower && upper) list.add(0);
            else list.add(2);
        }
        for (Integer in : list) System.out.println(in);
    }
}
