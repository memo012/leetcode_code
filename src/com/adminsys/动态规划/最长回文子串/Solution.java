package com.adminsys.动态规划.最长回文子串;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLen = 1;
        int begin = 0;
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && varity(c, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public boolean varity(char[] c, int left, int right) {
        while (left < right) {
            if (c[left] != c[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}