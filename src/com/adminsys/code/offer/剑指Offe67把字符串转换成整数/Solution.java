package com.adminsys.code.offer.剑指Offe67把字符串转换成整数;

class Solution {
    public int strToInt(String str) {
        char[] ch = str.trim().toCharArray();
        if (ch.length == 0) return 0;
        int i = 1, flag = 1;
        int res = 0, max = Integer.MAX_VALUE / 10;
        if (ch[0] == '-') flag = -1;
        else if (ch[0] != '+') i = 0;
        for (int j = i; j < ch.length; j++) {
            if (ch[j] < '0' || ch[j] > '9') break;
            if (res > max || res == max && ch[j] > '7') return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (ch[j] - '0');
        }
        return flag * res;
    }
}