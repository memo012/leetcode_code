package com.adminsys.leetcode.无重复字符的最长子串3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-07 09-22
 **/

public class Main {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }
                res = Math.max(res, j - i + 1);
                set.add(s.charAt(j));
            }
        }
        return res;
    }
}
