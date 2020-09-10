package com.adminsys.微盟.two;

import java.util.Stack;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/6 下午4:52
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWord("There is a dog. fdg"));
        System.out.println(isHash("There"));
    }
    public static boolean isHash(String str) {
        return str.toLowerCase() == "there";
    }
    public String reverseWord (String str) {
        // write code here
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'A' && chars[i] <= 'Z') ||
                    (chars[i] >= 'a' && chars[i] <= 'z')) {
                stack.push(chars[i]);
            }else {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(chars[i]);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
}
