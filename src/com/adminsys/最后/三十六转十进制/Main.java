package com.adminsys.最后.三十六转十进制;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/10 下午7:39
 **/

import java.util.*;

public class Main {
    public static String s36 = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if ("".equals(str)) {
            System.out.println(0);
            return;
        }
        int flag = 1, res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Character> toThirtySix = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') flag = 0;
            else if (!s36.contains(str.charAt(i) + "")) {
                res = 0;
                break;
            } else {
                map.put(str.charAt(i), i);
                toThirtySix.put(i, str.charAt(i));
            }
        }

        if (res == 0) {
            System.out.println(0);
            return;
        }

        if (flag == 1) {
            long rs = 0;
            int power = str.length() - 1;
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 && str.charAt(i) == '-') continue;
                long value = toThirtySix.get(i);
                rs = (long) (rs + value * Math.pow(36, power));
                power--;
            }
            System.out.println(rs);
        } else {

        }


    }
}
