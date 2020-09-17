package com.adminsys.code.进制转换;

import java.util.*;


public class Solution {
    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        // write code here
        String str = "0123456789ABCDEF";
        Stack<Character> stack = new Stack<>();
        int flag = 0;
        if (M < 0) {
            flag = 1;
            M = -M;
        }
        while (M != 0) {
            int t = M % N;
            stack.push(str.charAt(t));
            M /= N;
        }
        StringBuilder sbd = new StringBuilder();
        while (!stack.isEmpty()) {
            sbd.append(stack.pop());
        }
        if (flag == 1) sbd.insert(0, '-');
        return sbd.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(-7, 2));
    }
}