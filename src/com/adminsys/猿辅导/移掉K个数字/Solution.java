package com.adminsys.猿辅导.移掉K个数字;

import java.util.Stack;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-03 20-16
 **/

public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return 0 + "";
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();

        for (Character character : chars) {
            while (!stack.isEmpty() && stack.peek() > character && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(character);
        }

        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder stringBuffer = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }

        String reverse = stringBuffer.reverse().toString();
        int index = 0;
        while (index < reverse.length() && reverse.charAt(index) == '0') {
            index++;
        }

        if (index == reverse.length()) {
            return "0";
        }
        return reverse.substring(index);
    }

}
