package com.adminsys.code.offer.剑指Offer48最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        if (ch.length == 0) return 0;
        int head = 0, tail, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (tail = 0; tail < ch.length; tail++){
            if (map.containsKey(ch[tail])) head = Math.max(map.get(ch[tail]), head);
            map.put(ch[tail], tail+1);
            res = Math.max(res, tail - head + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("bbbbbb");
    }
}