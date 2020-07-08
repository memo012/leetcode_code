package com.adminsys.code.字符串转换整数;

class Solution {
    public int myAtoi(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int flag = 1;
        int start = 1;
        if (c[0] == '-') flag = -1;
        else if (c[0] != '+') start = 0;
        long ans = 0;
        while (start < c.length) {
            if (c[start] < '0' || c[start] > '9') break;
            int num = c[start] - '0';
            ans = ans * 10 + num;
            if (flag * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (flag * ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            start++;
        }
        return (int) (ans * flag);
    }

    public static void main(String[] args) {
        new Solution().myAtoi("2147483646");
    }
}