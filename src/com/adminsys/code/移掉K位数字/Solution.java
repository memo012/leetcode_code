package com.adminsys.code.移掉K位数字;

import java.util.Stack;
/**
 * 思路：
 * 等价于最高位的值尽量最小，若最高相等时，次高位最小 使用栈维护
 * 若栈顶元素大于插入元素 && k > 0 栈顶元素出栈 插入元素入栈
 * 若栈顶元素小于插入元素  插入元素入栈
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return 0 + "";
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (Character c : chars) {
            while (!stack.empty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        String s = stringBuilder.reverse().toString();
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        if (index == s.length()) {
            return "0";
        }
        return s.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("12345", 2));
    }
}