package com.adminsys.code.字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> lists = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0);
        return lists;
    }

    public void dfs(char[] s, int start) {
        if (start == s.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for(Character c : s){
                stringBuilder.append(c);
            }
            lists.add(stringBuilder.toString());
            return;
        }
        dfs(s, start + 1);
        if (s[start] >= 'A') {
            s[start] ^= 32;
            dfs(s, start + 1);
        }
    }

    public static void main(String[] args) {
        new Solution().letterCasePermutation("a1b2");
    }

}