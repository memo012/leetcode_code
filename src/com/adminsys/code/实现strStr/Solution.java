package com.adminsys.code.实现strStr;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/11 下午7:35
 **/
public class Solution {
    public int strStr1(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        for (int i = 0; i < h - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle))
                return i;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        int ph = 0;
        while (ph < h - n + 1) {
            while (ph < h - n + 1 && haystack.charAt(ph) != needle.charAt(0))
                ph++;
            int len = 0, pn = 0;
            while (pn < n && ph < h && haystack.charAt(ph) == needle.charAt(0)) {
                pn++;
                ph++;
                len++;
            }
            if (len == n) return ph - n;
            ph = ph - len + 1;
        }
        return -1;
    }
}
