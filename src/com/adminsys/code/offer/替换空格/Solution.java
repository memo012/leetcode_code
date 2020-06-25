package com.adminsys.code.offer.替换空格;

class Solution {
    public String replaceSpace(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int length = chars.length;
        int numBlank = 0;
        int index = 0;
        while (chars[index] != '\0') {
            if (chars[index] == ' ') numBlank++;
            index++;
        }
        int newLength = length + 2 * numBlank;
        int indexOfNew = newLength;
        int indexOfOriginal = length;
        while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (chars[indexOfOriginal] == ' ') {
                chars[indexOfNew--] = '0';
                chars[indexOfNew--] = '2';
                chars[indexOfNew--] = '%';
            }else
                chars[indexOfNew--] = chars[indexOfOriginal];
            indexOfOriginal--;
        }
        return chars.toString();
    }
}