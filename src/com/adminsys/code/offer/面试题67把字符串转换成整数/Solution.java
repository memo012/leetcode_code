package com.adminsys.code.offer.面试题67把字符串转换成整数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int strToInt(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((char) i);
        }
        boolean flag = false;
        String newStr = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newStr.length(); i++) {
            if (i == 0 && newStr.charAt(i) == '-') {
                flag = true;
                continue;
            }
            if (Character.isDigit(newStr.charAt(i))) {
                stringBuilder.append(newStr.charAt(i));
            } else {
                if (i == 0) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        String string = stringBuilder.toString();
        long res = Long.parseLong(string);
        if (res >= Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res <= Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return flag ? (int) -res : (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("-123"));
    }
}