package com.adminsys.code.电话号码的字母组合;

import java.util.LinkedList;
import java.util.List;

class Solution {

    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new LinkedList();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        dfs(digits, 0, "");
        return list;
    }

    public void dfs(String digits, int pops, String res) {
        if (pops == digits.length()) {
            list.add(res);
        } else {
            int num = digits.charAt(pops) - '0';
            String mapStr = mapping[num];
            for (int i = 0; i < mapStr.length(); i++) {
                char c = mapStr.charAt(i);
                dfs(digits, pops + 1, res + c);
            }
        }
    }
}