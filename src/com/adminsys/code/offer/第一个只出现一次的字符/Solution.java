package com.adminsys.code.offer.第一个只出现一次的字符;

import java.util.*;

class Solution {
    public char firstUniqChar(String s) {
        char res = ' ';
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.contains(c)) continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) >= 2) {
                map.remove(c);
                list.add(c);
            }
        }
        if (map.isEmpty()) return res;
        for (Character cn : map.keySet()) {
            res = cn;
            break;
        }
        return res;
    }
}